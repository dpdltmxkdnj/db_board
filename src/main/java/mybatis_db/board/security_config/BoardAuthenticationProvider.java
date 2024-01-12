package mybatis_db.board.security_config;

import lombok.RequiredArgsConstructor;
import mybatis_db.board.domain.User;
import mybatis_db.board.exception.PassWordNotFoundException;
import mybatis_db.board.repository.UserRepository;
import mybatis_db.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BoardAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String loginId = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        User user = userService.findById(loginId);
        if (loginId.isBlank()) {
            throw new UsernameNotFoundException("아이디를 입력하시오.");
        }
        if (pwd.isBlank()) {
            throw new PassWordNotFoundException("비밀번호를 입력하시오.");
        }
        if (user!=null && passwordEncoder.matches(pwd, user.getPassword())) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("user"));
            return new UsernamePasswordAuthenticationToken(loginId, pwd, authorities);
        } else {
            throw new BadCredentialsException("아이디 또는 비밀번호가 맞지 않습니다. 다시 확인해 주세요.");
        }
    }
        @Override
        public boolean supports(Class<?> authentication) {
            return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
        }



}

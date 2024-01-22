package mybatis_db.board.service;

import lombok.RequiredArgsConstructor;
import mybatis_db.board.dto.PageRequestDto;
import mybatis_db.board.domain.User;
import mybatis_db.board.domain.BoardHomeTexts;
import mybatis_db.board.dto.UserLoginRegisterDto;
import mybatis_db.board.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User save(UserLoginRegisterDto userLoginRegisterDto) {
        String loginId = userLoginRegisterDto.getLoginId();
        String password = userLoginRegisterDto.getPassword();
        String username = userLoginRegisterDto.getUsername();

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(loginId,encodedPassword,username);

        return userRepository.save(user);
    }
    public User findById(String id) {
        return userRepository.findById(id);
    }

}

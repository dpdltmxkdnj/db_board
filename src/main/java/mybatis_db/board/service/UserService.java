package mybatis_db.board.service;

import lombok.RequiredArgsConstructor;
import mybatis_db.board.domain.Text;
import mybatis_db.board.domain.User;
import mybatis_db.board.dto.UserLoginRegisterDto;
import mybatis_db.board.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User save(UserLoginRegisterDto userLoginRegisterDto) {
        String loginId = userLoginRegisterDto.getLoginId();
        String password = userLoginRegisterDto.getPassword();
        String username = userLoginRegisterDto.getUsername();

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(loginId,encodedPassword,username);
        LocalDateTime now = LocalDateTime.now();
        String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        user.setDateCreated(formatedNow);

        return userRepository.save(user);
    }
    public User findById(String id) {
        return userRepository.findById(id);
    }
    public List<User> findAllUserText() {
        return userRepository.findAllUserText();
    }
    public User findUserText(Long id) {
        return userRepository.findUserText(id);
    }
    public List<User> findAllUserTextByTitle(String title) {
        return userRepository.findAllUserTextByTitle(title);
    }

    public List<User> findAllUserTextByUsername(String username) {
        return userRepository.findAllUserTextByUsername(username);
    }
    public List<User> findAllUserTextByUsernameAndTitle(String usernameAndTitle) {
        return userRepository.findAllUserTextByUsernameAndTitle(usernameAndTitle);
    }
}

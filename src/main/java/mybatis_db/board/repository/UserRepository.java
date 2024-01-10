package mybatis_db.board.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis_db.board.domain.PageRequest;
import mybatis_db.board.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UserMapper userMapper;

    public User save(User user) {
        userMapper.save(user);
        return user;
    }
    public User findById(String id) {
        return userMapper.findById(id);
    }
    public List<User> findAllUserText() {
        return userMapper.findAllUserText();
    }
    public User findUserText(Long id) {
        return userMapper.findUserText(id);
    }
    public List<User> findAllUserTextByTitle(String title) {
        return userMapper.findAllUserTextByTitle(title);
    }

    public List<User> findAllUserTextByUsername(String username) {
        return userMapper.findAllUserTextByUsername(username);
    }
    public List<User> findAllUserTextByUsernameAndTitle(String usernameAndTitle) {
        return userMapper.findAllUserTextByUsernameAndTitle(usernameAndTitle);
    }
    public List<User> selectWithPaging(PageRequest pageRequest) {
        return userMapper.selectWithPaging(pageRequest);
    }
}

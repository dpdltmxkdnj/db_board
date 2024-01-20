package mybatis_db.board.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis_db.board.dto.PageRequestDto;
import mybatis_db.board.domain.User;
import mybatis_db.board.domain.BoardHomeTexts;
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
    public List<BoardHomeTexts> findAllUserText() {
        return userMapper.findAllUserText();
    }
    public BoardHomeTexts findUserText(Long id) {
        return userMapper.findUserText(id);
    }
    public List<BoardHomeTexts> findAllUserTextByTitle(String title) {
        return userMapper.findAllUserTextByTitle(title);
    }

    public List<BoardHomeTexts> findAllUserTextByUsername(String username) {
        return userMapper.findAllUserTextByUsername(username);
    }
    public List<BoardHomeTexts> findAllUserTextByUsernameAndTitle(String usernameAndTitle) {
        return userMapper.findAllUserTextByUsernameAndTitle(usernameAndTitle);
    }
    public List<BoardHomeTexts> selectWithPaging(PageRequestDto pageRequestDto) {
        return userMapper.selectWithPaging(pageRequestDto);
    }
}

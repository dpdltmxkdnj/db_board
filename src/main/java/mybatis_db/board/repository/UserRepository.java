package mybatis_db.board.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis_db.board.domain.PageRequest;
import mybatis_db.board.domain.User;
import mybatis_db.board.dto.BoardHomeTextsDto;
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
    public List<BoardHomeTextsDto> findAllUserText() {
        return userMapper.findAllUserText();
    }
    public BoardHomeTextsDto findUserText(Long id) {
        return userMapper.findUserText(id);
    }
    public List<BoardHomeTextsDto> findAllUserTextByTitle(String title) {
        return userMapper.findAllUserTextByTitle(title);
    }

    public List<BoardHomeTextsDto> findAllUserTextByUsername(String username) {
        return userMapper.findAllUserTextByUsername(username);
    }
    public List<BoardHomeTextsDto> findAllUserTextByUsernameAndTitle(String usernameAndTitle) {
        return userMapper.findAllUserTextByUsernameAndTitle(usernameAndTitle);
    }
    public List<BoardHomeTextsDto> selectWithPaging(PageRequest pageRequest) {
        return userMapper.selectWithPaging(pageRequest);
    }
}

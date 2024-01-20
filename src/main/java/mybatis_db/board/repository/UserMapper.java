package mybatis_db.board.repository;

import mybatis_db.board.dto.PageRequestDto;
import mybatis_db.board.domain.User;
import mybatis_db.board.domain.BoardHomeTexts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findById(String id);

    void save(User user);
    List<BoardHomeTexts> findAllUserText();
    BoardHomeTexts findUserText(Long id);
    List<BoardHomeTexts> findAllUserTextByTitle(String title);

    List<BoardHomeTexts> findAllUserTextByUsername(String username);
    List<BoardHomeTexts> findAllUserTextByUsernameAndTitle(String usernameAndTitle);
    List<BoardHomeTexts> selectWithPaging(PageRequestDto pageRequestDto);
}

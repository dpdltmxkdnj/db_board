package mybatis_db.board.repository;

import mybatis_db.board.domain.PageRequest;
import mybatis_db.board.domain.Text;
import mybatis_db.board.domain.User;
import mybatis_db.board.dto.BoardHomeTextsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findById(String id);

    void save(User user);
    List<BoardHomeTextsDto> findAllUserText();
    BoardHomeTextsDto findUserText(Long id);
    List<BoardHomeTextsDto> findAllUserTextByTitle(String title);

    List<BoardHomeTextsDto> findAllUserTextByUsername(String username);
    List<BoardHomeTextsDto> findAllUserTextByUsernameAndTitle(String usernameAndTitle);
    List<BoardHomeTextsDto> selectWithPaging(PageRequest pageRequest);
}

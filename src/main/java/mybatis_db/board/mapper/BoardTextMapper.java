package mybatis_db.board.mapper;

import mybatis_db.board.domain.BoardHomeTexts;
import mybatis_db.board.dto.PageRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BoardTextMapper {

    List<BoardHomeTexts> findAllUserText();
    BoardHomeTexts findUserText(Long id);
    List<BoardHomeTexts> findAllUserTextByTitle(String title);

    List<BoardHomeTexts> findAllUserTextByUsername(String username);
    List<BoardHomeTexts> findAllUserTextByUsernameAndTitle(String usernameAndTitle);
    List<BoardHomeTexts> selectWithPaging(PageRequestDto pageRequestDto);
}

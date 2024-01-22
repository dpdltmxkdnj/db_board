package mybatis_db.board.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis_db.board.domain.BoardHomeTexts;
import mybatis_db.board.dto.PageRequestDto;
import mybatis_db.board.mapper.BoardTextMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
@RequiredArgsConstructor
public class BoardTextRepository {
    private final BoardTextMapper boardTextMapper;
    public List<BoardHomeTexts> findAllUserText() {
        return boardTextMapper.findAllUserText();
    }
    public BoardHomeTexts findUserText(Long id) {
        return boardTextMapper.findUserText(id);
    }
    public List<BoardHomeTexts> findAllUserTextByTitle(String title) {
        return boardTextMapper.findAllUserTextByTitle(title);
    }

    public List<BoardHomeTexts> findAllUserTextByUsername(String username) {
        return boardTextMapper.findAllUserTextByUsername(username);
    }
    public List<BoardHomeTexts> findAllUserTextByUsernameAndTitle(String usernameAndTitle) {
        return boardTextMapper.findAllUserTextByUsernameAndTitle(usernameAndTitle);
    }
    public List<BoardHomeTexts> selectWithPaging(PageRequestDto pageRequestDto) {
        return boardTextMapper.selectWithPaging(pageRequestDto);
    }
}

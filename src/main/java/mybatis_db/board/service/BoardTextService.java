package mybatis_db.board.service;

import lombok.RequiredArgsConstructor;
import mybatis_db.board.domain.BoardHomeTexts;
import mybatis_db.board.dto.PageRequestDto;
import mybatis_db.board.repository.BoardTextRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardTextService {
    private final BoardTextRepository boardTextRepository;
    private final PasswordEncoder passwordEncoder;
    public List<BoardHomeTexts> findAllUserText() {
        return boardTextRepository.findAllUserText();
    }
    public BoardHomeTexts findUserText(Long id) {
        return boardTextRepository.findUserText(id);
    }
    public List<BoardHomeTexts> findAllUserTextByTitle(String title) {
        return boardTextRepository.findAllUserTextByTitle(title);
    }

    public List<BoardHomeTexts> findAllUserTextByUsername(String username) {
        return boardTextRepository.findAllUserTextByUsername(username);
    }
    public List<BoardHomeTexts> findAllUserTextByUsernameAndTitle(String usernameAndTitle) {
        return boardTextRepository.findAllUserTextByUsernameAndTitle(usernameAndTitle);
    }
    public List<BoardHomeTexts> selectWithPaging(PageRequestDto pageRequestDto) {
        return boardTextRepository.selectWithPaging(pageRequestDto);
    }
}

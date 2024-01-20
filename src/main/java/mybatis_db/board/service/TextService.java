package mybatis_db.board.service;

import lombok.RequiredArgsConstructor;
import mybatis_db.board.domain.Comment;
import mybatis_db.board.domain.Text;
import mybatis_db.board.dto.TextUpdateDto;
import mybatis_db.board.repository.TextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class TextService {
    private final TextRepository textRepository;
    public Text save(Text text) {
        return textRepository.save(text);
    }
    public void delete(Long id) {
        textRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public Text findById(Long id) {
        return textRepository.findById(id);
    }

    public List<Text> findAll() {
        return textRepository.findAll();
    }


    public void update(Long id, TextUpdateDto textUpdateDto)             {
        textRepository.update(id,textUpdateDto);
    }
    @Transactional(readOnly = true)
    public int allTextCount() {
        return textRepository.allTextCount();
    }
    public void increaseViewCount(Long id) {
        textRepository.increaseViewCount(id);
    }
    public void increaseLikeCount(Long id) {
        textRepository.increaseLikeCount(id);
    }



}

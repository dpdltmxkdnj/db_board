package mybatis_db.board.service;

import lombok.RequiredArgsConstructor;
import mybatis_db.board.domain.Comment;
import mybatis_db.board.domain.Text;
import mybatis_db.board.dto.TextUpdateDto;
import mybatis_db.board.repository.TextRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TextService {
    private final TextRepository textRepository;
    public Text save(Text text) {
        LocalDateTime now = LocalDateTime.now();
        String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        text.setDateCreated(formatedNow);
        return textRepository.save(text);
    }


    public Text findById(Long id) {
        return textRepository.findById(id);
    }


    public List<Text> findAll() {
        return textRepository.findAll();
    }


    public void update(Long id, TextUpdateDto textUpdateDto)             {
        textRepository.update(id,textUpdateDto);
    }
    public int allTextCount() {
        return textRepository.allTextCount();
    }
    public void increaseViewCount(Long id) {
        textRepository.increaseViewCount(id);
    }
    public void increaseLikeCount(Long id) {
        textRepository.increaseLikeCount(id);
    }
    public void addComment(Comment comment) {
        textRepository.addComment(comment);
    }
    public List<Comment> findCommentById(Long id) {
        return textRepository.findCommentById(id);
    }
}

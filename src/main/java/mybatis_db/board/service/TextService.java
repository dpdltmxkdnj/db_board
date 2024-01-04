package mybatis_db.board.service;

import lombok.RequiredArgsConstructor;
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
}

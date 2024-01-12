package mybatis_db.board.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis_db.board.domain.Comment;
import mybatis_db.board.domain.Text;
import mybatis_db.board.dto.TextUpdateDto;
import java.util.List;
import org.springframework.stereotype.Repository;


@Slf4j
@Repository
@RequiredArgsConstructor
public class TextRepository{
    private final TextMapper textMapper;

    public Text save(Text text) {
        textMapper.save(text);
        return text;
    }

    public Text findById(Long id) {
        return textMapper.findById(id);
    }

    public List<Text> findAll() {
        return textMapper.findAll();
    }

    public void update(Long id, TextUpdateDto textUpdateDto) {
        textMapper.update(id,textUpdateDto);
    }

    public int allTextCount() {
        return textMapper.allTextCount();
    }
    public void increaseViewCount(Long id) {
         textMapper.increaseViewCount(id);
    }
    public void increaseLikeCount(Long id) {
        textMapper.increaseLikeCount(id);
    }


}

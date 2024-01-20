package mybatis_db.board;

import mybatis_db.board.domain.Comment;
import mybatis_db.board.domain.Text;
import mybatis_db.board.repository.CommentMapper;
import mybatis_db.board.service.TextService;
import mybatis_db.board.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MapperTest {
    @Autowired
    private UserService userService;
    @Autowired
    private TextService textService;
    @Autowired
    private CommentMapper commentMapper;
    @Test
    public void insertTextTest() {
        for (int i = 0; i < 30; i++) {
            textService.save(new Text("test", "test", Long.valueOf(1)));
        }
//        Comment comment = new Comment(Long.valueOf("242"), "1", "1", "1");
//        commentMapper.addParentComment(comment);
//
//        System.out.println(comment);
    }


}

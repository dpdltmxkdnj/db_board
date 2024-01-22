package mybatis_db.board;

import mybatis_db.board.domain.Text;
import mybatis_db.board.mapper.CommentMapper;
import mybatis_db.board.service.TextService;
import mybatis_db.board.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTest {
    private UserService userService;
    private TextService textService;
    private CommentMapper commentMapper;

    @Autowired
    public MapperTest(UserService userService, TextService textService, CommentMapper commentMapper) {
        this.userService = userService;
        this.textService = textService;
        this.commentMapper = commentMapper;
    }

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

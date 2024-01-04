package mybatis_db.board;

import mybatis_db.board.domain.Text;
import mybatis_db.board.domain.User;
import mybatis_db.board.repository.UserMapper;
import mybatis_db.board.repository.UserRepository;
import mybatis_db.board.service.TextService;
import mybatis_db.board.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
public class MapperTest {
    @Autowired
    private UserService userService;
    @Autowired
    private TextService textService;
    @Test
    public void test() {
        for (int i = 1; i < 300; i++) {
            textService.save(new Text("ㅇㅅㅇ", "ㅇㅅㅇ", Long.valueOf(14)));
        }
    }
}

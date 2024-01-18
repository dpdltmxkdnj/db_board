package mybatis_db.board;

import mybatis_db.board.domain.PageRequest;
import mybatis_db.board.domain.Text;
import mybatis_db.board.domain.User;
import mybatis_db.board.dto.BoardHomeTextsDto;
import mybatis_db.board.repository.UserMapper;
import mybatis_db.board.repository.UserRepository;
import mybatis_db.board.service.TextService;
import mybatis_db.board.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MapperTest {
    @Autowired
    private UserService userService;
    @Test
    public void test() {
        List<BoardHomeTextsDto> boardHomeTextsDtos = userService.selectWithPaging(new PageRequest(0, 10));
        String text = boardHomeTextsDtos.get(0).getText();
        System.out.println(text);

    }


}

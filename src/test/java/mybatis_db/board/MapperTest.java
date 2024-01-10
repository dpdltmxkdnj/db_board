package mybatis_db.board;

import mybatis_db.board.domain.PageRequest;
import mybatis_db.board.domain.Text;
import mybatis_db.board.domain.User;
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
    @Autowired
    private TextService textService;
    @Test
    public void test() {
        for (int i = 1; i < 178; i++) {
            textService.save(new Text("ㅇㅅㅇ", "ㅇㅅㅇ", Long.valueOf(14)));
        }
//        List<User> users = userService.selectWithPaging(new PageRequest(1, 10));
//        List<User> users = userService.findAllUserText();

//        int allTextCount = 51;
//
//        int pageSize=10;
//        int allPageButton=allTextCount%pageSize==0?allTextCount/pageSize:allTextCount/pageSize+1;
//
//        List<List<Integer>> groups = new ArrayList<>();
//        int buttonsInGroup = 5;
//        int remainingButtons = allPageButton;
//
//        while (remainingButtons > 0) {
//            int groupSize = Math.min(remainingButtons, buttonsInGroup);
//            ArrayList<Integer> pageNumber = new ArrayList<>();
//            for (int i = allPageButton- remainingButtons + 1; i <= allPageButton - remainingButtons + groupSize; i++) {
//                pageNumber.add(i);
//            }
//            groups.add(pageNumber);
//            remainingButtons -= groupSize;
//        }
//        System.out.println(groups);
    }
}

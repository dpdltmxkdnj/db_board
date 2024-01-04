package mybatis_db.board;

import jakarta.annotation.PostConstruct;
import mybatis_db.board.domain.Text;
import mybatis_db.board.domain.User;
import mybatis_db.board.dto.UserLoginRegisterDto;
import mybatis_db.board.service.TextService;
import mybatis_db.board.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class BoardApplication {



	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

//	@PostConstruct
//	public void initData() {
////		Text text = new Text("제목이다", "이건 내용이고", "2011-12-01");
////		Text text2 = new Text("제목이다2", "이건 내용이고", "2011-12-01");
////		textService.save(text);
////		textService.save(text2);
//		UserLoginRegisterDto user1 = new UserLoginRegisterDto("1", "1", "로모쿤");
//		UserLoginRegisterDto user2 = new UserLoginRegisterDto("2", "2", "무훈");
//
//		userService.save(user1);
//		userService.save(user2);
//	}
}

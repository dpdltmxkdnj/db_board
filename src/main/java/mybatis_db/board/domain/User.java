package mybatis_db.board.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Long userId;
    private String loginId;
    private String password;
    private String dateCreated;
    private String username;
    private List<Text> texts;
//    private Text text;

    public User() {

    }
    public User(String loginId,String password,String username) {
        this.loginId=loginId;
        this.password = password;
        this.username = username;
    }

}

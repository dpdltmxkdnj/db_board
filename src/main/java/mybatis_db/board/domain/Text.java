package mybatis_db.board.domain;

import lombok.Data;

@Data
public class Text {
    private Long contentId;
    private String title;
    private String text;
    private String dateCreated;
    private Integer viewCount;
    private Integer likeCount;
    private Integer unlikeCount;
    private Long userId;
    public Text() {
    }
    public Text(String title, String text) {
        this.title = title;
        this.text = text;
    }
    public Text(String title, String text,Long userId) {
        this.title = title;
        this.text = text;
        this.userId=userId;
    }
    public Text(String title, String text, String dateCreated) {
        this.title = title;
        this.text = text;
        this.dateCreated = dateCreated;
    }


}

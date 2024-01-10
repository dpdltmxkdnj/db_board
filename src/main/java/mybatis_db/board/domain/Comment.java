package mybatis_db.board.domain;

import lombok.Data;

@Data
public class Comment {
    private String commentId;
    private String contentId;
    private String text;
    private String dateCreated;
    private String username;

    public Comment() {

    }
    public Comment(String contentId, String text, String username,String dateCreated) {
        this.contentId = contentId;
        this.text = text;
        this.username = username;
        this.dateCreated = dateCreated;
    }
}

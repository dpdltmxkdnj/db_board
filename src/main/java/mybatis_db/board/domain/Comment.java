package mybatis_db.board.domain;

import lombok.Data;

import java.util.List;

@Data
public class Comment {
    private Long parentId;
    private Long commentId;
    private Long userId;
    private Long contentId;
    private Long level;
    private String text;
    private String dateCreated;
    private String username;
    List<Comment> commentList;

    public Comment() {

    }
    public Comment(Long contentId, String text, String username,Long userId) {
        this.contentId = contentId;
        this.text = text;
        this.username = username;
        this.userId=userId;
    }
    public Comment(Long contentId, String text, String username,Long commentId,Long level,Long userId) {
        this.contentId = contentId;
        this.text = text;
        this.username = username;
        this.commentId = commentId;
        this.level = level;
        this.userId=userId;
    }
}

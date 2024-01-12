package mybatis_db.board.domain;

import lombok.Data;

import java.util.List;

@Data
public class Comment {
    private Long parentId;
    private Long commentId;
    private Long level;
    private Long contentId;
    private String text;
    private String dateCreated;
    private String username;
    private String loginId;
    List<Comment> commentList;

    public Comment() {

    }
    public Comment(Long contentId, String text, String username,String dateCreated,String loginId) {
        this.contentId = contentId;
        this.text = text;
        this.username = username;
        this.dateCreated = dateCreated;
        this.loginId=loginId;
    }
    public Comment(Long contentId, String text, String username,String dateCreated,Long commentId,Long level,String loginId) {
        this.contentId = contentId;
        this.text = text;
        this.username = username;
        this.dateCreated = dateCreated;
        this.commentId = commentId;
        this.level = level;
        this.loginId=loginId;
    }
}

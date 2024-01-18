package mybatis_db.board.dto;

import lombok.Data;

@Data
public class BoardHomeTextsDto {

    private Long contentId;
    private String title;
    private String text;
    private String dateCreated;
    private Integer viewCount;
    private Integer likeCount;
    private Integer unlikeCount;
    private Long userId;
    private String loginId;
    private String username;

}
//    c.content_id as contentId,
//        c.title as title,
//        c.text as text,
//        c.date_created as dateCreated,
//        c.view_count as viewCount,
//        c.like_count as likeCount,
//        c.unlike_count as unlikeCount,
//        u.login_id as loginId,
//        u.username as username,
//        u.user_id as userId
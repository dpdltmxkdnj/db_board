package mybatis_db.board.domain;

import lombok.Data;

@Data
public class BoardHomeTexts {

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

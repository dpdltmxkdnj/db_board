package mybatis_db.board.domain;

import lombok.Data;

@Data
public class PageRequest {
    private final int page;
    private final int size;
}

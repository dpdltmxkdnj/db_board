package mybatis_db.board.dto;

import lombok.Data;

@Data
public class PageRequestDto {
    private final int page;
    private final int size;
}

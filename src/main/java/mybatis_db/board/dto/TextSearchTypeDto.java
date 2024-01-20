package mybatis_db.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TextSearchTypeDto {
    private String typeName;
    private String typeValue;

}

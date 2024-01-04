package mybatis_db.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TextSearchType {
    private String typeName;
    private String typeValue;

}

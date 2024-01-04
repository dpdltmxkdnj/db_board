package mybatis_db.board.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TextSaveDto {
    @NotBlank
    private String title;
    @NotBlank
    private String text;


    public TextSaveDto() {
    }

    public TextSaveDto(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
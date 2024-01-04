package mybatis_db.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TextUpdateDto {
    @NotBlank
    private String title;
    @NotBlank
    private String text;


    public TextUpdateDto() {
    }

    public TextUpdateDto(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
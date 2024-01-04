package mybatis_db.board.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginRegisterDto {
    @NotBlank
    private String loginId;
    @NotBlank
    private String password;
    @NotBlank
    private String username;
    private String passwordIdentify;
    private boolean isPasswordBlank = false;
    private boolean isAlreadyExist = false;

    public UserLoginRegisterDto() {

    }

    public UserLoginRegisterDto(String loginId,String password,String username) {
        this.loginId = loginId;
        this.password = password;
        this.username = username;
    }

}

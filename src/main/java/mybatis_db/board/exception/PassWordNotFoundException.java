package mybatis_db.board.exception;

import org.springframework.security.core.AuthenticationException;

public class PassWordNotFoundException extends AuthenticationException {

    public PassWordNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public PassWordNotFoundException(String msg) {
        super(msg);
    }
}

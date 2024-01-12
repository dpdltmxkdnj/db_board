package mybatis_db.board.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class ErrorController {
    @GetMapping("/error-404")
    public void error404(HttpServletResponse response) throws IOException {

        response.sendError(404, "404 오류!");
    }
    @GetMapping("/error-400")
    public void error400(HttpServletResponse response) throws IOException {
        response.sendError(400, "400 오류!");
    }
    @GetMapping("/error-500")
    public void error500(HttpServletResponse response) throws IOException {
        response.sendError(500);
    }
}

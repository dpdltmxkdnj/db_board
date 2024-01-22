package mybatis_db.board.controller;

import lombok.RequiredArgsConstructor;
import mybatis_db.board.domain.Comment;
import mybatis_db.board.domain.User;
import mybatis_db.board.service.CommentService;
import mybatis_db.board.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final UserService userService;
    private final CommentService commentService;

    @PostMapping("/home/addParentComment")
    @ResponseBody
    public Comment addParentComment(@RequestBody Map<String, String> jsonValue) {
        String loginId = getLoginId();
        User user = userService.findById(loginId);
        String username = user.getUsername();
        Long userId = user.getUserId();

        String text =  jsonValue.get("text");
        Long contentId =  Long.valueOf(jsonValue.get("contentId"));


        Comment comment = new Comment(contentId, text, username,userId);

        commentService.addParentComment(comment);

        return comment;
    }
    @PostMapping("/home/addComment")
    @ResponseBody
    public Comment addComment(@RequestBody Map<String, String> jsonValue) {
        String loginId = getLoginId();
        User user = userService.findById(loginId);
        String username = user.getUsername();
        Long userId = user.getUserId();


        String text =  jsonValue.get("text");
        Long contentId =  Long.valueOf(jsonValue.get("contentId"));
        Long parentCommentId =  Long.valueOf(jsonValue.get("parentCommentId"));


        Comment comment = new Comment(contentId, text, username,parentCommentId,Long.valueOf(  "1"),userId);

        commentService.addComment(comment);
        return comment;
    }

    private static String getLoginId() {
        String loginId = SecurityContextHolder.getContext().getAuthentication().getName();
        return loginId;
    }
}

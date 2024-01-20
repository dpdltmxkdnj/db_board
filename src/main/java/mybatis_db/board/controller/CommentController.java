package mybatis_db.board.controller;

import lombok.RequiredArgsConstructor;
import mybatis_db.board.domain.Comment;
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
        String username = userService.findById(loginId).getUsername();

        String text =  jsonValue.get("text");
        Long contentId =  Long.valueOf(jsonValue.get("contentId"));


        Comment comment = new Comment(contentId, text, username,loginId);

        commentService.addParentComment(comment);
        System.out.println("ParentComment:"+comment.getParentId());
//        Comment commentParentId = commentService.findCommentParentId(contentId);
//        Long parentId = commentParentId.getParentId();
//        String dateCreated = commentParentId.getDateCreated();
//
//        comment.setParentId(parentId);
//        comment.setDateCreated(dateCreated);
        return comment;
    }
    @PostMapping("/home/addComment")
    @ResponseBody
    public Comment addComment(@RequestBody Map<String, String> jsonValue) {
        String loginId = getLoginId();
        String username = userService.findById(loginId).getUsername();

        String text =  jsonValue.get("text");
        Long contentId =  Long.valueOf(jsonValue.get("contentId"));
        Long parentCommentId =  Long.valueOf(jsonValue.get("parentCommentId"));


        Comment comment = new Comment(contentId, text, username,parentCommentId,Long.valueOf(  "1"),loginId);

        commentService.addComment(comment);
        System.out.println("comment date:"+comment.getDateCreated());
        return comment;
    }

    private static String getLoginId() {
        String loginId = SecurityContextHolder.getContext().getAuthentication().getName();
        return loginId;
    }
}

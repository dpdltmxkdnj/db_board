package mybatis_db.board.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mybatis_db.board.domain.*;
import mybatis_db.board.dto.TextSaveDto;
import mybatis_db.board.dto.TextUpdateDto;
import mybatis_db.board.service.CommentService;
import mybatis_db.board.service.TextService;
import mybatis_db.board.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;
    private final UserService userService;
    private final CommentService commentService;
    @ModelAttribute("textSearchType")
    public List<TextSearchType> textSearchType() {
        List<TextSearchType> textSearchType = new ArrayList<>();
        textSearchType.add(new TextSearchType("전체","전체"));
        textSearchType.add(new TextSearchType("제목","제목"));
        textSearchType.add(new TextSearchType("작성자","작성자"));

        return textSearchType;
    }
    @GetMapping("/home")
    public String home(Model model,@RequestParam(name = "page",required = false,defaultValue = "1") Integer currentPage,@RequestParam(name = "searchType",required = false) String searchType,@RequestParam(name = "searchValue",required = false) String searchValue) {

        List<User> allUserTexts = null;
        int allTextCount = textService.allTextCount();

        int pageSize=10;
        int allPageButton=allTextCount%pageSize==0?allTextCount/pageSize:allTextCount/pageSize+1;

        if (searchType != null && searchValue != null && searchType.equals("제목") && !searchValue.isBlank()) {
            allUserTexts = userService.findAllUserTextByTitle(searchValue);
        } else if (searchType != null && searchValue != null && searchType.equals("작성자") && !searchValue.isBlank()) {
            allUserTexts = userService.findAllUserTextByUsername(searchValue);
        } else if (searchType != null && searchValue != null && searchType.equals("전체") && !searchValue.isBlank()) {
            allUserTexts = userService.findAllUserTextByUsernameAndTitle(searchValue);
        } else {
            int pageChange=(currentPage-1)*10;
            allUserTexts = userService.selectWithPaging(new PageRequest(pageChange, pageSize));
        }
        model.addAttribute("allPageButton", allPageButton);
        model.addAttribute("allTextCount", allTextCount);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("currentPage", currentPage);

        model.addAttribute("searchType", searchType);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("allUserTexts",allUserTexts);
        isLogin(model);

        return "home";
    }

    private static void isLogin(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            String loginId = authentication.getName();
            model.addAttribute("loginId", loginId);
        }
    }

    @GetMapping("/home/add")
    public String textAddForm(Model model) {
        model.addAttribute("text", new Text());
        return "addText";
    }
    @PostMapping("/home/add")
    public String textSave(@Valid @ModelAttribute("text") TextSaveDto textSaveDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "addText";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findById(authentication.getName());

        Text text = new Text(textSaveDto.getTitle(), textSaveDto.getText(),user.getUserId());

        textService.save(text);
        return "redirect:/home";
    }
    @GetMapping("/home/{id}")
    public String text(@PathVariable(name = "id") Long id,Model model) {
        boolean isMyThing = false;

        User userText = userService.findUserText(id);
        textService.increaseViewCount(id);

        List<Comment> parentComments = commentService.findCommentById(id);
        System.out.println(parentComments);
        model.addAttribute("parentComments", parentComments);
        model.addAttribute("userText", userText);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loginId = authentication.getName();

        if (loginId.equals(userText.getLoginId())) {
            isMyThing=true;
        }
        model.addAttribute("isMyThing", isMyThing);
        model.addAttribute("loginId", loginId);

        return "text";
    }
    @GetMapping("/home/{contentId}/edit")
    public String textEdit(@PathVariable(name = "contentId") Long id,Model model) {
         Text text = textService.findById(id);
        model.addAttribute("text", text);
        return "editText";
    }
    @PostMapping("/home/{contentId}/edit")
    public String textEditSave(@PathVariable(name = "contentId") Long id, @Valid @ModelAttribute("text") TextUpdateDto textUpdateDto,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editText";
        }
       textService.update(id,textUpdateDto);

        return "redirect:/home";
    }

    @PostMapping("/home/{contentId}/delete")
    @ResponseBody
    public String textDelete(@PathVariable(name = "contentId") Long id,Model model) {
        System.out.println(id);
        textService.delete(id);
        return "/home";
    }

    @PostMapping("/home/updateLikeCount")
    @ResponseBody
    public Map<String, Long> updateLikeCount(@RequestBody Map<String, Long> jsonValue) {
        Long likeCount =  jsonValue.get("count");
        Long contentId =  jsonValue.get("id");
        textService.increaseLikeCount(contentId);

        Map<String, Long> response = new HashMap<>();
        response.put("likeCount", likeCount);

        return response;
    }

}

package mybatis_db.board.controller;

import lombok.RequiredArgsConstructor;
import mybatis_db.board.domain.Text;
import mybatis_db.board.domain.TextSearchType;
import mybatis_db.board.domain.TextSearchValue;
import mybatis_db.board.domain.User;
import mybatis_db.board.dto.TextSaveDto;
import mybatis_db.board.dto.TextUpdateDto;
import mybatis_db.board.service.TextService;
import mybatis_db.board.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;
    private final UserService userService;

    @ModelAttribute("textSearchType")
    public List<TextSearchType> textSearchType() {
        List<TextSearchType> textSearchType = new ArrayList<>();
        textSearchType.add(new TextSearchType("전체","전체"));
        textSearchType.add(new TextSearchType("제목","제목"));
        textSearchType.add(new TextSearchType("작성자","작성자"));

        return textSearchType;
    }
    @GetMapping("/home")
    public String home(Model model,RedirectAttributes redirectAttributes,@RequestParam(name = "searchType",required = false) String searchType,@RequestParam(name = "searchTypeValue",required = false) String searchTypeValue) {
        List<User> allUser = null;
        if (searchType!=null && searchTypeValue!=null && searchType.equals("제목") && !searchTypeValue.isBlank()) {
            allUser = userService.findAllUserTextByTitle(searchTypeValue);
        } else if (searchType!=null && searchTypeValue!=null  && searchType.equals("작성자") && !searchTypeValue.isBlank()) {
            allUser = userService.findAllUserTextByUsername(searchTypeValue);
        } else if (searchType!=null && searchTypeValue!=null  && searchType.equals("전체") && !searchTypeValue.isBlank()){
            allUser = userService.findAllUserTextByUsernameAndTitle(searchTypeValue);
        }else{
            allUser = userService.findAllUserText();
        }
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTypeValue", searchTypeValue);
        model.addAttribute("texts",allUser);
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
    public String textSave(@Validated @ModelAttribute("text") TextSaveDto textSaveDto, BindingResult bindingResult,Model model) {
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
        model.addAttribute("userText", userText);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loginId = authentication.getName();

        if (loginId.equals(userText.getLoginId())) {
            isMyThing=true;
        }
        model.addAttribute("isMyThing", isMyThing);

        return "text";
    }
    @GetMapping("/home/{contentId}/edit")
    public String textEdit(@PathVariable(name = "contentId") Long id,Model model) {
        Text text = textService.findById(id);
        model.addAttribute("text", text);
        return "editText";
    }
    @PostMapping("/home/{contentId}/edit")
    public String textEditSave(@PathVariable(name = "contentId") Long id, @Validated @ModelAttribute("text") TextUpdateDto textUpdateDto,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editText";
        }
       textService.update(id,textUpdateDto);

        return "redirect:/home";
    }
}

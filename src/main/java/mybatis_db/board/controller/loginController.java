package mybatis_db.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis_db.board.domain.User;
import mybatis_db.board.dto.UserLoginRegisterDto;
import mybatis_db.board.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class loginController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginForm(Model model, @RequestParam(value = "error", required = false,defaultValue ="false") String error,@RequestParam(value = "message", required = false) String message) {
        model.addAttribute("user", new User());
        model.addAttribute("error", error);
        model.addAttribute("message", message);

        return "login/login";
    }
    @GetMapping("/login/register")
    public String loginRegisterForm(Model model) {
        UserLoginRegisterDto userLoginRegisterDto = new UserLoginRegisterDto();
        model.addAttribute("userLoginRegisterDto", userLoginRegisterDto);


        return "login/register";
    }
    @PostMapping("/login/register")
    public String loginRegister(@Validated @ModelAttribute UserLoginRegisterDto userLoginRegisterDto, BindingResult bindingResult) {
        if (!userLoginRegisterDto.getPassword().equals(userLoginRegisterDto.getPasswordIdentify())) {
            userLoginRegisterDto.setPasswordBlank(true);
            return "login/register";

        }
        if (!userLoginRegisterDto.getLoginId().isBlank() && userService.findById(userLoginRegisterDto.getLoginId()) != null) {
            userLoginRegisterDto.setAlreadyExist(true);
            return "login/register";
        }
        if (bindingResult.hasErrors()) {
            return "login/register";
        }

        userService.save(userLoginRegisterDto);
        return "redirect:/home";
    }
//    @PostMapping("/login")
//    public String login() {
//
//
//        return "redirect:/login";
//    }



}

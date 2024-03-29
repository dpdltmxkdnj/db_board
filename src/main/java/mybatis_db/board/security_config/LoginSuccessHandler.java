package mybatis_db.board.security_config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        setDefaultTargetUrl("/home");

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        this.clearAuthenticationAttributes(request);
        // 사용자가 권한이 필요한 자원에 접근해 인증 예외가 발생해 인증을 처리하는 것이 아닌 경우
        // SavedRequest 객체가 생성되지 않는다.
        if (savedRequest != null && savedRequest.getRedirectUrl()!=null && savedRequest.getRedirectUrl().contains("/home/add")) {
            redirectStrategy.sendRedirect(request, response, "/home");
        } else {
            redirectStrategy.sendRedirect(request, response, getDefaultTargetUrl());
        }
    }
}


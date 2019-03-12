package top.heapoverflow.yunnote.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import top.heapoverflow.yunnote.constant.CommonConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lhg
 * @date 2019-03-12 14:42
 * @description
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 登录拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession(false);
        return session != null && (boolean) session.getAttribute(CommonConstant.LOGIN_SUCCESS_FLAG);
    }
}

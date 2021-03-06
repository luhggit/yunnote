package top.heapoverflow.yunnote.controller;

import org.springframework.web.bind.annotation.*;
import top.heapoverflow.yunnote.constant.CommonConstant;
import top.heapoverflow.yunnote.service.LoginService;
import top.heapoverflow.yunnote.util.ResultUtils;
import top.heapoverflow.yunnote.vo.BaseVO;
import top.heapoverflow.yunnote.vo.login.LoginResultVO;
import top.heapoverflow.yunnote.vo.login.UserLoginVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author lhg
 * @date 2019-03-12 11:17
 * @description
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 登录接口
     * @param userLoginVO 登录参数
     * @return
     */
    @PostMapping(value = "/login")
    public BaseVO<LoginResultVO> login(@RequestBody UserLoginVO userLoginVO, HttpSession session) {
        userLoginVO.setSession(session);
        return ResultUtils.success(loginService.login(userLoginVO));
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @GetMapping(value = "/logout")
    public BaseVO<Boolean> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(CommonConstant.LOGIN_SUCCESS_FLAG);
            session.invalidate();
        }
        return ResultUtils.success(true);
    }
}

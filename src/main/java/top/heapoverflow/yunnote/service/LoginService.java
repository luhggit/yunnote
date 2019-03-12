package top.heapoverflow.yunnote.service;

import top.heapoverflow.yunnote.vo.login.LoginResultVO;
import top.heapoverflow.yunnote.vo.login.UserLoginVO;

/**
 * @author lhg
 * @date 2019-03-12 11:23
 * @description
 */
public interface LoginService {

    /**
     * 登录接口
     * @param userLoginVO 登录参数
     * @return
     */
    LoginResultVO login(UserLoginVO userLoginVO);
}

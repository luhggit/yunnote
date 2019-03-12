package top.heapoverflow.yunnote.service.impl;

import org.springframework.stereotype.Service;
import top.heapoverflow.yunnote.constant.CommonConstant;
import top.heapoverflow.yunnote.enums.StatusEnum;
import top.heapoverflow.yunnote.exception.ServiceRuntimeException;
import top.heapoverflow.yunnote.mapper.UserMapper;
import top.heapoverflow.yunnote.service.LoginService;
import top.heapoverflow.yunnote.util.EncryptUtils;
import top.heapoverflow.yunnote.vo.login.LoginResultVO;
import top.heapoverflow.yunnote.vo.login.UserLoginVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author lhg
 * @date 2019-03-12 11:24
 * @description
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;

    /**
     * 登录接口
     * @param userLoginVO 登录参数
     * @return
     */
    @Override
    public LoginResultVO login(UserLoginVO userLoginVO) {
        boolean isTimestampValid = checkTimestamp(userLoginVO.getTimestamp());
        if (!isTimestampValid) {
            throw new ServiceRuntimeException(StatusEnum.TIMESTAMP_INVALID);
        }

        boolean isPasswordValid = checkPassword(userLoginVO);
        if (!isPasswordValid) {
            throw new ServiceRuntimeException(StatusEnum.PASSWORD_INVALID);
        }

        // 检验成功，设置session属性
        HttpSession session = userLoginVO.getSession();
        session.setAttribute(CommonConstant.LOGIN_SUCCESS_FLAG, true);

        LoginResultVO loginResultVO = new LoginResultVO();
        loginResultVO.setInfo(CommonConstant.SUCCESS_INFO);
        loginResultVO.setResult(true);

        return loginResultVO;
    }

    /**
     * 检查密码是否正确
     * @param userLoginVO 用户登录数据
     * @return
     */
    private boolean checkPassword(UserLoginVO userLoginVO) {
        String username = userLoginVO.getUsername();
        String passwordMd5 = userLoginVO.getPassword();
        Long timestamp = userLoginVO.getTimestamp();

        // 使用username + 传过来的时间戳 + 真实密码 进行md5加密
        String realPass = userMapper.selectPasswordByUsername(username);
        String encryStr = username + timestamp + realPass;
        String md5 = EncryptUtils.md5(encryStr);

        return md5.equals(passwordMd5.toUpperCase());
    }


    /**
     * 检查时间戳的有效性，1天之内有效
     * @param timestamp 13位时间戳
     * @return
     */
    private boolean checkTimestamp(Long timestamp) {
        if (timestamp == null) {
            return false;
        } else {
            Long now = System.currentTimeMillis();
            // 将10小时转换为毫秒
            Long delta = 86400000L;
            if (Math.abs(now - timestamp) > delta) {
                return false;
            } else {
                return true;
            }
        }
    }
}

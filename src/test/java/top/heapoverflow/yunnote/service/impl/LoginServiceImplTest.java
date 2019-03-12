package top.heapoverflow.yunnote.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.DateUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.heapoverflow.yunnote.constant.CommonConstant;
import top.heapoverflow.yunnote.entity.User;
import top.heapoverflow.yunnote.exception.ServiceRuntimeException;
import top.heapoverflow.yunnote.mapper.UserMapper;
import top.heapoverflow.yunnote.service.LoginService;
import top.heapoverflow.yunnote.util.EncryptUtils;
import top.heapoverflow.yunnote.vo.login.LoginResultVO;
import top.heapoverflow.yunnote.vo.login.UserLoginVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author lhg
 * @date 2019-03-12 14:25
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class LoginServiceImplTest {

    @Resource
    private UserMapper userMapper;
    @Resource
    private LoginService loginService;
    @Mock
    private HttpSession session;

    private User user;

    @Before
    public void addUser() {
        user = new User();
        user.setUsername("test");
        user.setPassword("abc");
        userMapper.insertSelective(user);
    }

    /**
     * 测试登录，时间戳不正确
     */
    @Test(expected = ServiceRuntimeException.class)
    public void login() {
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setUsername(user.getUsername());
        userLoginVO.setPassword(user.getPassword());
        userLoginVO.setTimestamp(DateUtils.addDays(new Date(), 2).getTime());

        loginService.login(userLoginVO);
    }

    /**
     * 测试登录，密码不正确
     */
    @Test(expected = ServiceRuntimeException.class)
    public void login2() {
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setUsername(user.getUsername());
        userLoginVO.setPassword(user.getPassword() + "a");
        userLoginVO.setTimestamp(System.currentTimeMillis());

        loginService.login(userLoginVO);
    }

    /**
     * 测试登录，正常
     */
    @Test
    public void login3() {
        Long timestamp = System.currentTimeMillis();
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setUsername(user.getUsername());
        userLoginVO.setPassword(EncryptUtils.md5(user.getUsername() + timestamp + user.getPassword()));
        userLoginVO.setTimestamp(timestamp);
        userLoginVO.setSession(session);

        LoginResultVO loginResultVO = loginService.login(userLoginVO);
        assert loginResultVO.getResult();
        assert CommonConstant.SUCCESS_INFO.equals(loginResultVO.getInfo());
    }
}
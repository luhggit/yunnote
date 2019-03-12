package top.heapoverflow.yunnote.vo.login;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import javax.servlet.http.HttpSession;

/**
 * @author lhg
 * @date 2019-03-12 11:19
 * @description
 */
@Data
public class UserLoginVO {
    private String username;

    private String password;

    private Long timestamp;

    private HttpSession session;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

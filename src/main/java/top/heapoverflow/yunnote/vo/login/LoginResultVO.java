package top.heapoverflow.yunnote.vo.login;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

/**
 * @author lhg
 * @date 2019-03-12 11:22
 * @description
 */
@Data
public class LoginResultVO {
    private Boolean result;

    private String info;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

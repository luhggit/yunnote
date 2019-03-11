package top.heapoverflow.yunnote.vo;

import top.heapoverflow.yunnote.util.JsonUtils;

/**
 * @author lhg
 * @date 2019-03-11 14:41
 * @description
 */
public class BaseVO<T> {
    /**
     * 状态码
     */
    private Integer status;

    /**
     * 说明
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public BaseVO(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

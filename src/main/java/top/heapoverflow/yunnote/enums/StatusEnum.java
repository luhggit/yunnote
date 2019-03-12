package top.heapoverflow.yunnote.enums;

/**
 * @author lhg
 * @date 2019-03-11 14:46
 * @description
 */
public enum  StatusEnum {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 服务器异常
     */
    SERVER_ERROR(500, "服务器异常"),
    /**
     * 参数错误
     */
    PARAMS_ERROR(600, "参数错误"),
    /**
     * 时间戳无效
     */
    TIMESTAMP_INVALID(1000, "时间戳无效"),
    /**
     * 密码错误
     */
    PASSWORD_INVALID(1001, "密码错误")
    ;
    private Integer code;

    private String msg;

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

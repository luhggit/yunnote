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
    SUCCESS(200, "成功")
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

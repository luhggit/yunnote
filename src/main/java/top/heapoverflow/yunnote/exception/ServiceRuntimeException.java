package top.heapoverflow.yunnote.exception;

import top.heapoverflow.yunnote.enums.StatusEnum;

/**
 * @author lhg
 * @date 2019-03-11 18:17
 * @description
 */
public class ServiceRuntimeException extends RuntimeException {
    private StatusEnum statusEnum;

    public ServiceRuntimeException(StatusEnum statusEnum) {
        super(statusEnum.getMsg());
        this.statusEnum = statusEnum;
    }

    public ServiceRuntimeException(String message) {
        super(message);
    }

    public ServiceRuntimeException(Throwable cause) {
        super(cause);
    }
}

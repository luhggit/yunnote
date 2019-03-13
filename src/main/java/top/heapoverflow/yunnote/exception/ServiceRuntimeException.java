package top.heapoverflow.yunnote.exception;

import lombok.Data;
import top.heapoverflow.yunnote.enums.StatusEnum;

/**
 * @author lhg
 * @date 2019-03-11 18:17
 * @description
 */
@Data
public class ServiceRuntimeException extends RuntimeException {
    private StatusEnum statusEnum;

    private Object data;

    public ServiceRuntimeException(StatusEnum statusEnum) {
        super(statusEnum.getMsg());
        this.statusEnum = statusEnum;
    }

    public ServiceRuntimeException(StatusEnum statusEnum, Object data) {
        super(statusEnum.getMsg());
        this.statusEnum = statusEnum;
        this.data = data;
    }

    public ServiceRuntimeException(String message) {
        super(message);
    }

    public ServiceRuntimeException(Throwable cause) {
        super(cause);
    }
}

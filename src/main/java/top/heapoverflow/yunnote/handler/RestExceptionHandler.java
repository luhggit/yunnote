package top.heapoverflow.yunnote.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.heapoverflow.yunnote.enums.StatusEnum;
import top.heapoverflow.yunnote.exception.ServiceRuntimeException;
import top.heapoverflow.yunnote.util.ResultUtils;
import top.heapoverflow.yunnote.vo.BaseVO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author lhg
 * @date 2018-10-15 17:59
 * @description 统一异常处理类
 */
@ControllerAdvice
@Slf4j
public class RestExceptionHandler {
    /**
     * 字段大小值检验异常处理
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public BaseVO validExceptionHandler(BindException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        return ResultUtils.fail(StatusEnum.PARAMS_ERROR, getErrorList(bindingResult));
    }

    /**
     * 字段为空检验异常处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseVO validExceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        return ResultUtils.fail(StatusEnum.PARAMS_ERROR, getErrorList(bindingResult));
    }

    /**
     * 获取错误信息
     * @param bindingResult
     * @return
     */
    private List<Map<String, Object>> getErrorList(BindingResult bindingResult) {
        List<Map<String, Object>> errorList = new LinkedList<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(e -> {
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("field", e.getField());
            errorMap.put("message", e.getDefaultMessage());
            errorMap.put("errorValue", e.getRejectedValue());
            errorList.add(errorMap);
        });
        return errorList;
    }

    /**
     * 服务异常处理
     */
    @ExceptionHandler(ServiceRuntimeException.class)
    @ResponseBody
    public BaseVO<Object> validExceptionHandler(ServiceRuntimeException exception) {
        log.error("业务异常:", exception);
        return ResultUtils.fail(exception.getStatusEnum(), exception.getData());
    }

    /**
     * 全局异常处理
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public BaseVO validExceptionHandler(RuntimeException exception) {
        log.error("服务器异常:", exception);
        return ResultUtils.fail(StatusEnum.SERVER_ERROR, exception.getLocalizedMessage());
    }
}

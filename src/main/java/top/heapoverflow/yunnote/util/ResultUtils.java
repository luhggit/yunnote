package top.heapoverflow.yunnote.util;

import top.heapoverflow.yunnote.enums.StatusEnum;
import top.heapoverflow.yunnote.vo.BaseVO;

/**
 * @author lhg
 * @date 2019-03-11 14:43
 * @description 结果处理工具类
 */
public class ResultUtils {
    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseVO<T> success(T data) {
        return new BaseVO<>(StatusEnum.SUCCESS.getCode(), StatusEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 返回处理失败的BaseDTO，附带错误的数据
     * @param errorEnum 错误码
     * @param data 错误数据
     * @return
     */
    public static <T> BaseVO<T> fail(StatusEnum errorEnum,T data){
        BaseVO<T> response = new BaseVO<>();
        response.setStatus(errorEnum.getCode());
        response.setMsg(errorEnum.getMsg());
        response.setData(data);
        return response;
    }
}

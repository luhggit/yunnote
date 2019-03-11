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
}

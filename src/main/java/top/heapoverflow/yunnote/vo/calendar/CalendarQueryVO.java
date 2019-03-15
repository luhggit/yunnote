package top.heapoverflow.yunnote.vo.calendar;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

/**
 * @author lhg
 * @date 2019-03-13 09:57
 * @description calendar数据查询vo
 */
@Data
public class CalendarQueryVO {
    private Integer year;

    private Integer month;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

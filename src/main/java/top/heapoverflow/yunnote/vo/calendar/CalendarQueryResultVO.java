package top.heapoverflow.yunnote.vo.calendar;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

/**
 * @author lhg
 * @date 2019-03-13 09:54
 * @description 日历根据年份和月份获取数据
 */
@Data
public class CalendarQueryResultVO {
    private Integer id;

    private String content;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

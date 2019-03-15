package top.heapoverflow.yunnote.vo.calendar;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

/**
 * @author lhg
 * @date 2019-03-12 18:22
 * @description calendar新增vo
 */
@Data
public class CalendarAddVO {
    private Integer month;

    private Integer year;

    private String content;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

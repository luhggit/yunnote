package top.heapoverflow.yunnote.query;

import lombok.Data;

/**
 * @author lhg
 * @date 2019-03-13 10:32
 * @description 查询三个月的calendar数据
 */
@Data
public class CalendarThreeMonthQuery {
    private Integer month;

    private Integer year;

    private Integer preMonthYear;

    private Integer preMonth;

    private Integer nextMonthYear;

    private Integer nextMonth;
}

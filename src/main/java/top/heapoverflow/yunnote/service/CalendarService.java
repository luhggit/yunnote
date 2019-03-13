package top.heapoverflow.yunnote.service;

import top.heapoverflow.yunnote.vo.calendar.CalendarAddVO;
import top.heapoverflow.yunnote.vo.calendar.CalendarQueryResultVO;
import top.heapoverflow.yunnote.vo.calendar.CalendarQueryVO;

import java.util.List;

/**
 * @author lhg
 * @date 2019-03-12 18:30
 * @description
 */
public interface CalendarService {
    /**
     * 新增calendar
     * @param calendarAddVO
     * @return
     */
    Integer addCalendar(CalendarAddVO calendarAddVO);

    /**
     * 根据年份和月份取上一个月、当月和下一个月的数据
     * @param queryVO
     * @return
     */
    List<CalendarQueryResultVO> getCalendarEventByMonth(CalendarQueryVO queryVO);

    /**
     * 根据id删除calendar
     * @param id 主键
     */
    void deleteById(Integer id);
}

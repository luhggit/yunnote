package top.heapoverflow.yunnote.service;

import top.heapoverflow.yunnote.vo.calendar.CalendarAddVO;

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
}

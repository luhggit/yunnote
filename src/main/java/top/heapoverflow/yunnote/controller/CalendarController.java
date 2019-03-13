package top.heapoverflow.yunnote.controller;

import org.springframework.web.bind.annotation.*;
import top.heapoverflow.yunnote.service.CalendarService;
import top.heapoverflow.yunnote.util.ResultUtils;
import top.heapoverflow.yunnote.vo.BaseVO;
import top.heapoverflow.yunnote.vo.calendar.CalendarAddVO;
import top.heapoverflow.yunnote.vo.calendar.CalendarQueryResultVO;
import top.heapoverflow.yunnote.vo.calendar.CalendarQueryVO;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lhg
 * @date 2019-03-12 18:20
 * @description
 */
@RestController
@RequestMapping("/api/calendar")
public class CalendarController {
    @Resource
    private CalendarService calendarService;

    /**
     * 新增calendar
     * @param calendarAddVO
     * @return
     */
    @PostMapping("/save")
    public BaseVO<Integer> addCalendar(@RequestBody CalendarAddVO calendarAddVO) {
        return ResultUtils.success(calendarService.addCalendar(calendarAddVO));
    }

    /**
     * 根据年份和月份取上一个月、当月和下一个月的数据
     * @param year
     * @param month
     * @return
     */
    @GetMapping("/{year}/{month}")
    public BaseVO<List<CalendarQueryResultVO>> getCalendarEventByMonth(@PathVariable Integer year, @PathVariable Integer month) {
        CalendarQueryVO queryVO = new CalendarQueryVO();
        queryVO.setYear(year);
        queryVO.setMonth(month);
        return ResultUtils.success(calendarService.getCalendarEventByMonth(queryVO));
    }

    /**
     * 删除calendar
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public BaseVO<Void> deleteById(@PathVariable Integer id) {
        calendarService.deleteById(id);
        return ResultUtils.success(null);
    }
}

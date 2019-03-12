package top.heapoverflow.yunnote.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.heapoverflow.yunnote.service.CalendarService;
import top.heapoverflow.yunnote.util.ResultUtils;
import top.heapoverflow.yunnote.vo.BaseVO;
import top.heapoverflow.yunnote.vo.calendar.CalendarAddVO;

import javax.annotation.Resource;

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
}

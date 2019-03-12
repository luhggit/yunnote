package top.heapoverflow.yunnote.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.heapoverflow.yunnote.entity.Calendar;
import top.heapoverflow.yunnote.mapper.CalendarMapper;
import top.heapoverflow.yunnote.service.CalendarService;
import top.heapoverflow.yunnote.vo.calendar.CalendarAddVO;

import javax.annotation.Resource;

/**
 * @author lhg
 * @date 2019-03-12 18:33
 * @description
 */
@Service
public class CalendarServiceImpl implements CalendarService {
    @Resource
    private CalendarMapper calendarMapper;

    /**
     * 新增calendar
     * @param calendarAddVO
     * @return
     */
    @Override
    public Integer addCalendar(CalendarAddVO calendarAddVO) {
        Calendar calendar = new Calendar();
        BeanUtils.copyProperties(calendarAddVO, calendar);
        calendarMapper.insertSelective(calendar);

        return calendar.getId();
    }
}


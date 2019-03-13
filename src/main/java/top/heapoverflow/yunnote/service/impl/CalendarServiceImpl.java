package top.heapoverflow.yunnote.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.heapoverflow.yunnote.entity.Calendar;
import top.heapoverflow.yunnote.mapper.CalendarMapper;
import top.heapoverflow.yunnote.query.CalendarThreeMonthQuery;
import top.heapoverflow.yunnote.service.CalendarService;
import top.heapoverflow.yunnote.vo.calendar.CalendarAddVO;
import top.heapoverflow.yunnote.vo.calendar.CalendarQueryResultVO;
import top.heapoverflow.yunnote.vo.calendar.CalendarQueryVO;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * 根据年份和月份取上一个月、当月和下一个月的数据
     * @param queryVO
     * @return
     */
    @Override
    public List<CalendarQueryResultVO> getCalendarEventByMonth(CalendarQueryVO queryVO) {
        Integer year = queryVO.getYear();
        Integer month = queryVO.getMonth();

        // 上一个月
        Integer preMonthYear = year;
        Integer preMonth = month - 1;
        if (preMonth < 0) {
            preMonth = 11;
            preMonthYear = year - 1;
        }

        // 下一个月
        Integer nextMonthYear = year;
        Integer nextMonth = month + 1;
        if (nextMonth > 11) {
            nextMonth = 0;
            nextMonthYear = year + 1;
        }

        CalendarThreeMonthQuery calendarThreeMonthQuery = new CalendarThreeMonthQuery();
        calendarThreeMonthQuery.setMonth(month);
        calendarThreeMonthQuery.setYear(year);
        calendarThreeMonthQuery.setPreMonth(preMonth);
        calendarThreeMonthQuery.setPreMonthYear(preMonthYear);
        calendarThreeMonthQuery.setNextMonth(nextMonth);
        calendarThreeMonthQuery.setNextMonthYear(nextMonthYear);

        List<Calendar> calendars = calendarMapper.queryThreeMonth(calendarThreeMonthQuery);

        List<CalendarQueryResultVO> resultVOS = calendars.stream().map(calendar -> {
            CalendarQueryResultVO resultVO = new CalendarQueryResultVO();
            BeanUtils.copyProperties(calendar, resultVO);
            return resultVO;
        }).collect(Collectors.toList());

        return resultVOS;
    }

    /**
     * 根据id删除calendar
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
       calendarMapper.deleteByPrimaryKey(id);
    }
}


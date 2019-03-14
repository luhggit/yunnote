package top.heapoverflow.yunnote.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.heapoverflow.yunnote.entity.Calendar;
import top.heapoverflow.yunnote.mapper.CalendarMapper;
import top.heapoverflow.yunnote.service.CalendarService;
import top.heapoverflow.yunnote.vo.calendar.CalendarQueryResultVO;
import top.heapoverflow.yunnote.vo.calendar.CalendarQueryVO;
import top.heapoverflow.yunnote.vo.calendar.CalendarUpdateVO;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lhg
 * @date 2019-03-12 18:36
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class CalendarServiceImplTest {
    @Resource
    private CalendarMapper calendarMapper;
    @Resource
    private CalendarService calendarService;

    private Calendar calendar;

    @Before
    public void add() {
        calendar = new Calendar();
        calendar.setContent(".qaewi");
        calendar.setMonth(11);
        calendar.setYear(2019);
        calendarMapper.insertSelective(calendar);

        Calendar calendar2 = new Calendar();
        calendar2.setContent(".q22aewi");
        calendar2.setMonth(0);
        calendar2.setYear(2020);
        calendarMapper.insertSelective(calendar2);

        Calendar calendar3 = new Calendar();
        calendar3.setContent(".q22aewi");
        calendar3.setMonth(10);
        calendar3.setYear(2019);
        calendarMapper.insertSelective(calendar3);
    }

    /**
     * 测试新增calendar
     */
    @Test
    public void addCalendar() {
        Calendar calendar2 = calendarMapper.selectByPrimaryKey(calendar.getId());
        assert ".qaewi".equals(calendar2.getContent());
        assert 11 == calendar2.getMonth();
        assert 2019 == calendar2.getYear();
    }

    /**
     * 测试根据年份和月份获取calendar
     */
    @Test
    public void testGetCalendarEventByMonth() {
        CalendarQueryVO calendarQueryVO = new CalendarQueryVO();
        calendarQueryVO.setMonth(11);
        calendarQueryVO.setYear(2019);
        List<CalendarQueryResultVO> queryResultVOS = calendarService.getCalendarEventByMonth(calendarQueryVO);
        assert 3 == queryResultVOS.size();
    }

    /**
     * 测试删除
     */
    @Test
    public void testDeleteById() {
        calendarService.deleteById(calendar.getId());

        Calendar calendar2 = calendarMapper.selectByPrimaryKey(calendar.getId());
        assert null == calendar2;
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdateCalendar() {
        CalendarUpdateVO calendarUpdateVO = new CalendarUpdateVO();
        calendarUpdateVO.setContent(".aie2..32");
        calendarUpdateVO.setYear(238);
        calendarUpdateVO.setMonth(98);
        calendarUpdateVO.setId(calendar.getId());

        calendarService.updateCalendar(calendarUpdateVO);

        Calendar calendar3 = calendarMapper.selectByPrimaryKey(calendar.getId());
        assert ".aie2..32".equals(calendar3.getContent());
        assert 238 == calendar3.getYear();
        assert 98 == calendar3.getMonth();
    }
}
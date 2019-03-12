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

import javax.annotation.Resource;

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

    private Calendar calendar;

    @Before
    public void add() {
        calendar = new Calendar();
        calendar.setContent(".qaewi");
        calendar.setMonth(11);
        calendar.setYear(2019);
        calendarMapper.insertSelective(calendar);
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
}
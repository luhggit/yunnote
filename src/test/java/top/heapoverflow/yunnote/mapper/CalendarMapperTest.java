package top.heapoverflow.yunnote.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.heapoverflow.yunnote.entity.Calendar;
import top.heapoverflow.yunnote.query.CalendarThreeMonthQuery;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lhg
 * @date 2019-03-13 10:37
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class CalendarMapperTest {

    @Resource
    private CalendarMapper calendarMapper;

    /**
     * 测试查询三个月的数据
     */
    @Test
    public void queryThreeMonth() {
        CalendarThreeMonthQuery calendarThreeMonthQuery = new CalendarThreeMonthQuery();
        calendarThreeMonthQuery.setNextMonthYear(1);
        calendarThreeMonthQuery.setNextMonth(2);
        calendarThreeMonthQuery.setPreMonthYear(3);
        calendarThreeMonthQuery.setPreMonth(4);
        calendarThreeMonthQuery.setYear(5);
        calendarThreeMonthQuery.setMonth(6);
        List<Calendar> calendars = calendarMapper.queryThreeMonth(calendarThreeMonthQuery);
    }
}
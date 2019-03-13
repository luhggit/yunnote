package top.heapoverflow.yunnote.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.heapoverflow.yunnote.entity.Calendar;
import top.heapoverflow.yunnote.query.CalendarThreeMonthQuery;

import java.util.List;

/**
 * @author luhg
 */
public interface CalendarMapper {
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     * @param record
     * @return
     */
    int insert(Calendar record);

    /**
     * 插入非空
     * @param record
     * @return
     */
    int insertSelective(Calendar record);

    /**
     * 查找
     * @param id
     * @return
     */
    Calendar selectByPrimaryKey(Integer id);

    /**
     * 更新非空
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Calendar record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Calendar record);

    /**
     * 查询三个月的数据，上一个月、当月和下一个月
     * @param query
     * @return
     */
    @Select("select id, content from calendar where (month=#{query.month} and year=#{query.year}) or " +
            "(month=#{query.preMonth} and year=#{query.preMonthYear}) or " +
            "(month=#{query.nextMonth} and year=#{query.nextMonthYear})")
    List<Calendar> queryThreeMonth(@Param("query")CalendarThreeMonthQuery query);
}
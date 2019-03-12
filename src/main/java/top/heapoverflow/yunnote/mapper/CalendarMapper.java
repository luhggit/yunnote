package top.heapoverflow.yunnote.mapper;

import top.heapoverflow.yunnote.entity.Calendar;

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
}
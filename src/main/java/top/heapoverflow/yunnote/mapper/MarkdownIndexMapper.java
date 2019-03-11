package top.heapoverflow.yunnote.mapper;

import org.apache.ibatis.annotations.Select;
import top.heapoverflow.yunnote.entity.MarkdownIndex;

import java.util.List;

public interface MarkdownIndexMapper {
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
    int insert(MarkdownIndex record);

    /**
     * 插入非空
     * @param record
     * @return
     */
    int insertSelective(MarkdownIndex record);

    /**
     * 查找
     * @param id
     * @return
     */
    MarkdownIndex selectByPrimaryKey(Integer id);

    /**
     * 更新非空
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MarkdownIndex record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(MarkdownIndex record);

    /**
     * 查找所有，根据id大小降序排
     * @return
     */
    @Select("select * from markdown_index order by id desc")
    List<MarkdownIndex> selectAllOrderByIdDesc();
}
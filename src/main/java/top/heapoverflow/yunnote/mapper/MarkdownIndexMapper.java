package top.heapoverflow.yunnote.mapper;

import org.apache.ibatis.annotations.Param;
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
    @Select("select * from markdown_index order by detno desc")
    List<MarkdownIndex> selectAllOrderByDetnoDesc();

    /**
     * 查找同一层级最大的序号
     * @param pid
     * @return
     */
    @Select("select ifnull(max(detno), 0) from markdown_index where pid=#{pid}")
    Integer selectMaxDetnoByPid(@Param("pid") Integer pid);
}
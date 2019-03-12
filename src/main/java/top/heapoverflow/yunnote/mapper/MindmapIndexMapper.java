package top.heapoverflow.yunnote.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.heapoverflow.yunnote.entity.MindmapIndex;

import java.util.List;

/**
 * @author luhg
 */
public interface MindmapIndexMapper {
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
    int insert(MindmapIndex record);

    /**
     * 插入非空
     * @param record
     * @return
     */
    int insertSelective(MindmapIndex record);

    /**
     * 查找
     * @param id
     * @return
     */
    MindmapIndex selectByPrimaryKey(Integer id);

    /**
     * 更新非空
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MindmapIndex record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(MindmapIndex record);

    /**
     * 查找所有，根据id大小降序排
     * @return
     */
    @Select("select * from mindmap_index order by detno desc")
    List<MindmapIndex> selectAllOrderByDetnoDesc();

    /**
     * 查找同一层级最大的序号
     * @param pid
     * @return
     */
    @Select("select ifnull(max(detno), 0) from mindmap_index where pid=#{pid}")
    Integer selectMaxDetnoByPid(@Param("pid") Integer pid);
}
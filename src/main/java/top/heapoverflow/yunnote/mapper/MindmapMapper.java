package top.heapoverflow.yunnote.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import top.heapoverflow.yunnote.entity.Mindmap;

/**
 * @author luhg
 */
public interface MindmapMapper {
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
    int insert(Mindmap record);

    /**
     * 插入非空
     * @param record
     * @return
     */
    int insertSelective(Mindmap record);

    /**
     * 查找
     * @param id
     * @return
     */
    Mindmap selectByPrimaryKey(Integer id);

    /**
     * 更新非空
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Mindmap record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Mindmap record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Mindmap record);

    /**
     * 更新title
     * @param title
     * @param indexId
     */
    @Update("update mindmap set title=#{title} where index_id=#{indexId}")
    void updateMindmapTitle(@Param("title") String title, @Param("indexId") Integer indexId);

    /**
     * 根据index id 删除
     * @param indexId
     */
    @Delete("delete from mindmap where index_id=#{indexId}")
    void deleteByIndexId(@Param("indexId") Integer indexId);
}
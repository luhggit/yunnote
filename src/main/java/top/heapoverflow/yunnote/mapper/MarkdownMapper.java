package top.heapoverflow.yunnote.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.heapoverflow.yunnote.entity.Markdown;
import top.heapoverflow.yunnote.entity.MarkdownWithBLOBs;

import java.util.List;

public interface MarkdownMapper {
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
    int insert(MarkdownWithBLOBs record);

    /**
     * 插入非空
     * @param record
     * @return
     */
    int insertSelective(MarkdownWithBLOBs record);

    /**
     * 查找
     * @param id
     * @return
     */
    MarkdownWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * 更新非空
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MarkdownWithBLOBs record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(MarkdownWithBLOBs record);

    /**
     * 更新，除markdowncontent和htmlcontent
     * @param record
     * @return
     */
    int updateByPrimaryKey(Markdown record);

    /**
     * 根据indexid查找
     * @param indexId
     * @return
     */
    MarkdownWithBLOBs selectByIndexId(@Param("indexId") Integer indexId);

    /**
     * 根据index id 删除
     * @param indexId
     */
    @Delete("delete from markdown where index_id=#{indexId}")
    void deleteByIndexId(@Param("indexId") Integer indexId);

    /**
     * 更新title
     * @param title
     * @param indexId
     */
    @Update("update markdown set title=#{title} where index_id=#{indexId}")
    void updateMarkdownTitle(@Param("title") String title, @Param("indexId") Integer indexId);

    /**
     * 根据关键字查找markdown的id
     * @param keyword
     * @return
     */
    @Select("select index_id from markdown where md_content like \"%\"#{keyword}\"%\" or title like \"%\"#{keyword}\"%\"")
    List<Integer> selectIndexIdByKeyword(@Param("keyword") String keyword);
}
package top.heapoverflow.yunnote.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.heapoverflow.yunnote.entity.Markdown;

import java.util.List;

/**
 * @author luhg
 */
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
    int insert(Markdown record);

    /**
     * 插入非空
     * @param record
     * @return
     */
    int insertSelective(Markdown record);

    /**
     * 查找
     * @param id
     * @return
     */
    Markdown selectByPrimaryKey(Integer id);

    /**
     * 更新非空
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Markdown record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Markdown record);

    /**
     * 根据indexid查找
     * @param indexId
     * @return
     */
    Markdown selectByIndexId(@Param("indexId") Integer indexId);

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

    /**
     * 查找所有不同标题的markdown
     * @return
     */
    @Select("select distinct first_class firstClass, second_class secondClass, title from markdown order by first_class asc, second_class asc, last_update_time asc")
    List<Markdown> selectAllDistinctMarkdown();
}
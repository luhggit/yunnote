package top.heapoverflow.yunnote.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.heapoverflow.yunnote.entity.Markdown;
import top.heapoverflow.yunnote.entity.MarkdownWithBLOBs;

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
}
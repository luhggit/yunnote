package top.heapoverflow.yunnote.service;

import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexAddVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexTreeVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexUpdateVO;

import java.util.List;

/**
 * @author luhg 19-2-24 下午4:06
 */
public interface MarkdownIndexService {
    /**
     * 获取所有的markdown菜单
     * @return
     */
    List<MarkdownIndexTreeVO> getMarkdownIndex();

    /**
     * 新增markdown index
     * @param markdownIndexAddVO
     * @return
     */
    Integer addMarkdownIndex(MarkdownIndexAddVO markdownIndexAddVO);

    /**
     * 更新markdown index
     * @param markdownUpdateVO
     */
    void updateMarkdownIndex(MarkdownIndexUpdateVO markdownUpdateVO);

    /**
     * 删除markdown index
     * @param id
     */
    void deleteMarkdownIndex(Integer id);
}

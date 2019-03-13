package top.heapoverflow.yunnote.service;

import top.heapoverflow.yunnote.vo.markdown.MarkdownMsgVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownUpdateVO;

import java.util.List;

/**
 * @author lhg
 * @date 2019-03-11 18:50
 * @description
 */
public interface MarkdownService {
    /**
     * 更新markdown
     * @param markdownUpdateVO
     */
    void updateMarkdown(MarkdownUpdateVO markdownUpdateVO);

    /**
     * 根据markdown index id查找markdown
     * @param id markdown  index id
     * @return
     */
    MarkdownMsgVO getMarkdownMsgByIndexId(Integer id);

    /**
     * 根据关键字进行搜索
     * @param keyword 关键字
     * @return markdown对应的id
     */
    List<Integer> getMarkDownByKeyword(String keyword);
}

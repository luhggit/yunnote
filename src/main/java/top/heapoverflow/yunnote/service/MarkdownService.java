package top.heapoverflow.yunnote.service;

import top.heapoverflow.yunnote.vo.markdown.MarkdownUpdateVO;

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
}
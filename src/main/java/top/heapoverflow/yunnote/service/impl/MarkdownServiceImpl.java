package top.heapoverflow.yunnote.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.heapoverflow.yunnote.entity.MarkdownWithBLOBs;
import top.heapoverflow.yunnote.mapper.MarkdownMapper;
import top.heapoverflow.yunnote.service.MarkdownService;
import top.heapoverflow.yunnote.vo.markdown.MarkdownMsgVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownUpdateVO;

import javax.annotation.Resource;

/**
 * @author lhg
 * @date 2019-03-11 18:51
 * @description
 */
@Service
public class MarkdownServiceImpl implements MarkdownService {
    @Resource
    private MarkdownMapper markdownMapper;

    /**
     * 更新markdown
     * @param markdownUpdateVO
     */
    @Override
    public void updateMarkdown(MarkdownUpdateVO markdownUpdateVO) {
        MarkdownWithBLOBs markdownWithBLOBs = new MarkdownWithBLOBs();
        BeanUtils.copyProperties(markdownUpdateVO, markdownWithBLOBs);
        markdownMapper.updateByPrimaryKeySelective(markdownWithBLOBs);
    }

    /**
     * 根据id查找markdown
     * @param id markdown id
     * @return
     */
    @Override
    public MarkdownMsgVO getMarkdownMsg(Integer id) {
        MarkdownWithBLOBs markdown = markdownMapper.selectByPrimaryKey(id);
        MarkdownMsgVO markdownMsgVO = new MarkdownMsgVO();
        BeanUtils.copyProperties(markdown, markdownMsgVO);
        return markdownMsgVO;
    }
}

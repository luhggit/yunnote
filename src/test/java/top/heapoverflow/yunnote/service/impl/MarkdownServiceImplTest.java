package top.heapoverflow.yunnote.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.heapoverflow.yunnote.entity.MarkdownIndex;
import top.heapoverflow.yunnote.entity.Markdown;
import top.heapoverflow.yunnote.mapper.MarkdownIndexMapper;
import top.heapoverflow.yunnote.mapper.MarkdownMapper;
import top.heapoverflow.yunnote.service.MarkdownService;
import top.heapoverflow.yunnote.vo.markdown.MarkdownMsgVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownUpdateVO;

import javax.annotation.Resource;

import java.util.List;

/**
 * @author lhg
 * @date 2019-03-11 18:53
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class MarkdownServiceImplTest {

    @Resource
    private MarkdownMapper markdownMapper;
    @Resource
    private MarkdownIndexMapper markdownIndexMapper;
    @Resource
    private MarkdownService markdownService;

    private MarkdownIndex markdownIndex;
    private Markdown markdown;

    @Before
    public void add() {
        markdownIndex = new MarkdownIndex();
        markdownIndex.setTitle("root1");
        markdownIndexMapper.insertSelective(markdownIndex);

        markdown = new Markdown();
        markdown.setIndexId(markdownIndex.getId());
        markdown.setTitle(markdownIndex.getTitle());
        markdown.setMdContent("we");
        markdown.setHtmlContent("q.ewho");
        markdownMapper.insertSelective(markdown);
    }

    /**
     * 测试更新
     */
    @Test
    public void updateMarkdown() {
        MarkdownUpdateVO markdownUpdateVO = new MarkdownUpdateVO();
        markdownUpdateVO.setHtmlContent(".aewi");
        markdownUpdateVO.setMdContent(".ae2wi");
        markdownUpdateVO.setId(markdown.getId());
        markdownUpdateVO.setTitle(".aiewz3");
        markdownService.updateMarkdown(markdownUpdateVO);

        Markdown markdownWithBLOBs = markdownMapper.selectByPrimaryKey(markdown.getId());
        assert ".aewi".equals(markdownWithBLOBs.getHtmlContent());
        assert ".ae2wi".equals(markdownWithBLOBs.getMdContent());
        assert ".aiewz3".equals(markdownWithBLOBs.getTitle());
    }

    /**
     * 测试根据id获取
     */
    @Test
    public void testGetMarkdownMsg() {
        MarkdownMsgVO markdownMsgVO = markdownService.getMarkdownMsg(markdown.getId());
        assert "root1".equals(markdownMsgVO.getTitle());
        assert "we".equals(markdownMsgVO.getMdContent());
        assert "q.ewho".equals(markdownMsgVO.getHtmlContent());
    }

    /**
     * 测试根据关键字搜索
     */
    @Test
    public void testGetMarkDownByKeyword() {
        List<Integer> ids = markdownService.getMarkDownByKeyword("ot");
        assert 1 == ids.size();
        assert ids.get(0).equals(markdown.getIndexId());
    }
}
package top.heapoverflow.yunnote.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.heapoverflow.yunnote.entity.Markdown;
import top.heapoverflow.yunnote.entity.MarkdownIndex;
import top.heapoverflow.yunnote.entity.MarkdownWithBLOBs;
import top.heapoverflow.yunnote.mapper.MarkdownIndexMapper;
import top.heapoverflow.yunnote.mapper.MarkdownMapper;
import top.heapoverflow.yunnote.service.MarkdownIndexService;
import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexAddVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexTreeVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexUpdateVO;

import javax.annotation.Resource;

import java.util.List;

/**
 * @author lhg
 * @date 2019-03-11 14:36
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class MarkdownIndexServiceImplTest {

    @Resource
    private MarkdownIndexMapper markdownIndexMapper;
    @Resource
    private MarkdownIndexService markdownIndexService;
    @Resource
    private MarkdownMapper markdownMapper;

    private MarkdownIndex markdownIndex;
    private MarkdownWithBLOBs markdown;

    @Before
    public void add() {
        markdownIndex = new MarkdownIndex();
        markdownIndex.setTitle("root1");
        markdownIndexMapper.insertSelective(markdownIndex);

        MarkdownIndex markdownIndex2 = new MarkdownIndex();
        markdownIndex2.setTitle("root1.1");
        markdownIndex2.setPid(markdownIndex.getId());
        markdownIndexMapper.insertSelective(markdownIndex2);

        MarkdownIndex markdownIndex3 = new MarkdownIndex();
        markdownIndex3.setTitle("root1.1.1");
        markdownIndex3.setPid(markdownIndex2.getId());
        markdownIndexMapper.insertSelective(markdownIndex3);

        MarkdownIndex markdownIndex4 = new MarkdownIndex();
        markdownIndex4.setTitle("root2");
        markdownIndexMapper.insertSelective(markdownIndex4);

        MarkdownIndex markdownIndex5 = new MarkdownIndex();
        markdownIndex5.setTitle("root2.1");
        markdownIndex5.setPid(markdownIndex4.getId());
        markdownIndexMapper.insertSelective(markdownIndex5);

        markdown = new MarkdownWithBLOBs();
        markdown.setIndexId(markdownIndex.getId());
        markdown.setTitle(markdownIndex.getTitle());
        markdown.setMdContent("we");
        markdown.setHtmlContent("q.ewho");
        markdownMapper.insertSelective(markdown);
    }

    /**
     * 测试获取markdown树
     */
    @Test
    public void getMarkdownIndex() {
        List<MarkdownIndexTreeVO> markdownIndexTreeVOS  = markdownIndexService.getMarkdownIndex();
        log.warn(markdownIndexTreeVOS.toString());

        MarkdownIndexTreeVO markdownIndexTreeVO = markdownIndexTreeVOS.get(0);
        assert "root2".equals(markdownIndexTreeVO.getTitle());
        assert 0 == markdownIndexTreeVO.getPid();

        List<MarkdownIndexTreeVO> children = markdownIndexTreeVO.getChildren();
        assert 1 == children.size();
        assert "root2.1".equals(children.get(0).getTitle());

        MarkdownIndexTreeVO markdownIndexTreeVO2 = markdownIndexTreeVOS.get(1);
        assert "root1".equals(markdownIndexTreeVO2.getTitle());
        assert 0 == markdownIndexTreeVO2.getPid();

        List<MarkdownIndexTreeVO> children2 = markdownIndexTreeVO2.getChildren();
        assert 1 == children2.size();
        assert "root1.1".equals(children2.get(0).getTitle());

        assert 1 == children2.get(0).getChildren().size();
        assert "root1.1.1".equals(children2.get(0).getChildren().get(0).getTitle());
    }

    /**
     * 测试新增
     */
    @Test
    public void testAddMarkdownIndex() {
        MarkdownIndexAddVO markdownIndexAddVO = new MarkdownIndexAddVO();
        markdownIndexAddVO.setPid(0);
        markdownIndexAddVO.setTitle("test1");

        Integer id = markdownIndexService.addMarkdownIndex(markdownIndexAddVO);
        assert id != null;
        log.warn(id.toString());

        MarkdownIndex markdownIndex = markdownIndexMapper.selectByPrimaryKey(id);
        assert "test1".equals(markdownIndex.getTitle());
        assert 1 == markdownIndex.getDetno();
        System.out.println(markdownIndex);
        log.warn(markdownIndex.toString());

        MarkdownWithBLOBs markdownWithBLOBs = markdownMapper.selectByIndexId(id);
        log.warn(markdownWithBLOBs.toString());
        assert "".equals(markdownWithBLOBs.getHtmlContent());
        assert "".equals(markdownWithBLOBs.getMdContent());
        assert "test1".equals(markdownWithBLOBs.getTitle());
    }

    /**
     * 测试更新markdown index
     */
    @Test
    public void testUdpateMarkdownIndex() {
        MarkdownIndexUpdateVO markdownUpdateVO = new MarkdownIndexUpdateVO();
        markdownUpdateVO.setDetno(123);
        markdownUpdateVO.setTitle("e11w.");
        markdownUpdateVO.setId(markdownIndex.getId());
        markdownIndexService.updateMarkdownIndex(markdownUpdateVO);

        MarkdownIndex markdownIndex2 = markdownIndexMapper.selectByPrimaryKey(markdownIndex.getId());
        assert "e11w.".equals(markdownIndex2.getTitle());
        assert 123 == markdownIndex2.getDetno();

        MarkdownWithBLOBs markdownWithBLOBs = markdownMapper.selectByIndexId(markdownIndex.getId());
        assert "e11w.".equals(markdownWithBLOBs.getTitle());
    }

    /**
     * 测试删除markdown index
     */
    @Test
    public void testDeleteMarkdownIndex() {
        markdownIndexService.deleteMarkdownIndex(markdownIndex.getId());
        MarkdownIndex markdownIndex2 = markdownIndexMapper.selectByPrimaryKey(markdownIndex.getId());
        assert null == markdownIndex2;

        MarkdownWithBLOBs withBLOBs = markdownMapper.selectByIndexId(markdownIndex.getId());
        assert null == withBLOBs;
    }
}
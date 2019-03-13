package top.heapoverflow.yunnote.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.heapoverflow.yunnote.entity.Mindmap;
import top.heapoverflow.yunnote.entity.MindmapIndex;
import top.heapoverflow.yunnote.mapper.MindmapIndexMapper;
import top.heapoverflow.yunnote.mapper.MindmapMapper;
import top.heapoverflow.yunnote.service.MindmapService;
import top.heapoverflow.yunnote.vo.mindmap.MindmapMsgVO;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author lhg
 * @date 2019-03-13 18:49
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class MindmapServiceImplTest {

    @Resource
    private MindmapMapper mindmapMapper;
    @Resource
    private MindmapIndexMapper mindmapIndexMapper;
    @Resource
    private MindmapService mindmapService;

    private MindmapIndex mindmapIndex;
    private Mindmap mindmap;

    @Before
    public void add() {
        mindmapIndex = new MindmapIndex();
        mindmapIndex.setTitle("root1");
        mindmapIndexMapper.insertSelective(mindmapIndex);

        mindmap = new Mindmap();
        mindmap.setIndexId(mindmapIndex.getId());
        mindmap.setTitle(mindmapIndex.getTitle());
        mindmap.setContent("q.ewho");
        mindmapMapper.insertSelective(mindmap);
    }

    /**
     * 测试根据index id 查找mindmap
     */
    @Test
    public void getMindmapMsgByIndexId() {
        MindmapMsgVO mindmapMsgVO = mindmapService.getMindmapMsgByIndexId(mindmapIndex.getId());
        assert "q.ewho".equals(mindmapMsgVO.getContent());
        assert "root1".equals(mindmapMsgVO.getTitle());
    }
}
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
import top.heapoverflow.yunnote.service.MindmapIndexService;
import top.heapoverflow.yunnote.vo.mindmap.MindmapIndexAddVO;
import top.heapoverflow.yunnote.vo.mindmap.MindmapIndexTreeVO;
import top.heapoverflow.yunnote.vo.mindmap.MindmapIndexUpdateVO;

import javax.annotation.Resource;

import java.util.List;

/**
 * @author lhg
 * @date 2019-03-12 17:34
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class MindmapIndexServiceImplTest {
    @Resource
    private MindmapIndexMapper mindmapIndexMapper;
    @Resource
    private MindmapIndexService mindmapIndexService;
    @Resource
    private MindmapMapper mindmapMapper;

    private MindmapIndex mindmapIndex;
    private Mindmap mindmap;
    
    @Before
    public void add() {
        mindmapIndex = new MindmapIndex();
        mindmapIndex.setTitle("root1");
        mindmapIndex.setDetno(1);
        mindmapIndexMapper.insertSelective(mindmapIndex);

        MindmapIndex mindmapIndex2 = new MindmapIndex();
        mindmapIndex2.setTitle("root1.1");
        mindmapIndex2.setPid(mindmapIndex.getId());
        mindmapIndexMapper.insertSelective(mindmapIndex2);

        MindmapIndex mindmapIndex3 = new MindmapIndex();
        mindmapIndex3.setTitle("root1.1.1");
        mindmapIndex3.setPid(mindmapIndex2.getId());
        mindmapIndexMapper.insertSelective(mindmapIndex3);

        MindmapIndex mindmapIndex4 = new MindmapIndex();
        mindmapIndex4.setTitle("root2");
        mindmapIndex4.setDetno(2);
        mindmapIndexMapper.insertSelective(mindmapIndex4);

        MindmapIndex mindmapIndex5 = new MindmapIndex();
        mindmapIndex5.setTitle("root2.1");
        mindmapIndex5.setPid(mindmapIndex4.getId());
        mindmapIndexMapper.insertSelective(mindmapIndex5);

        mindmap = new Mindmap();
        mindmap.setIndexId(mindmapIndex.getId());
        mindmap.setTitle(mindmapIndex.getTitle());
        mindmap.setContent("a.ei");
        mindmapMapper.insertSelective(mindmap);
    }

    /**
     * 测试获取mindmap树
     */
    @Test
    public void testGetMindmapIndex() {
        List<MindmapIndexTreeVO> mindmapIndexTreeVOS  = mindmapIndexService.getMindmapIndex();
        log.warn(mindmapIndexTreeVOS.toString());

        MindmapIndexTreeVO mindmapIndexTreeVO = mindmapIndexTreeVOS.get(0);
        assert "root2".equals(mindmapIndexTreeVO.getTitle());
        assert 0 == mindmapIndexTreeVO.getPid();

        List<MindmapIndexTreeVO> children = mindmapIndexTreeVO.getChildren();
        assert 1 == children.size();
        assert "root2.1".equals(children.get(0).getTitle());

        MindmapIndexTreeVO mindmapIndexTreeVO2 = mindmapIndexTreeVOS.get(1);
        assert "root1".equals(mindmapIndexTreeVO2.getTitle());
        assert 0 == mindmapIndexTreeVO2.getPid();
        assert 1 == mindmapIndexTreeVO2.getDetno();

        List<MindmapIndexTreeVO> children2 = mindmapIndexTreeVO2.getChildren();
        assert 1 == children2.size();
        assert "root1.1".equals(children2.get(0).getTitle());

        assert 1 == children2.get(0).getChildren().size();
        assert "root1.1.1".equals(children2.get(0).getChildren().get(0).getTitle());
    }

    /**
     * 测试新增
     */
    @Test
    public void testAddMindmapIndex() {
        MindmapIndexAddVO mindmapIndexAddVO = new MindmapIndexAddVO();
        mindmapIndexAddVO.setPid(23);
        mindmapIndexAddVO.setTitle("aew");

        Integer id = mindmapIndexService.addMindmapIndex(mindmapIndexAddVO);
        assert id != null;

        MindmapIndex mindmapIndex = mindmapIndexMapper.selectByPrimaryKey(id);
        assert "aew".equals(mindmapIndex.getTitle());
        assert 23 == mindmapIndex.getPid();
        assert 1 == mindmapIndex.getDetno();
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdateMarkdownIndex() {
        MindmapIndexUpdateVO mindmapIndexUpdateVO = new MindmapIndexUpdateVO();
        mindmapIndexUpdateVO.setDetno(23);
        mindmapIndexUpdateVO.setId(mindmapIndex.getId());
        mindmapIndexUpdateVO.setTitle(".aie");

        mindmapIndexService.updateMindmapIndex(mindmapIndexUpdateVO);

        MindmapIndex mindmapIndex5 = mindmapIndexMapper.selectByPrimaryKey(mindmapIndex.getId());
        assert ".aie".equals(mindmapIndex5.getTitle());
        assert 23 == mindmapIndex5.getDetno();

        Mindmap mindmap5 = mindmapMapper.selectByPrimaryKey(mindmap.getId());
        assert ".aie".equals(mindmap5.getTitle());
    }

    /**
     * 测试删除
     */
    @Test
    public void testDeleteMarkdownIndex() {
        mindmapIndexService.deleteMindmapIndex(mindmapIndex.getId());

        MindmapIndex mindmapIndex5 = mindmapIndexMapper.selectByPrimaryKey(mindmapIndex.getId());
        assert null == mindmapIndex5;

        Mindmap mindmap5 = mindmapMapper.selectByPrimaryKey(mindmap.getId());
        assert null == mindmap5;
    }
}
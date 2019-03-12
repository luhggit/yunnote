package top.heapoverflow.yunnote.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
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
import java.util.stream.Collectors;

/**
 * @author luhg 19-2-24 下午4:06
 */
@Service
public class MindmapIndexServiceImpl implements MindmapIndexService {
    @Resource
    private MindmapIndexMapper mindmapIndexMapper;
    @Resource
    private MindmapMapper mindmapMapper;

    /**
     * 获取所有的mindmap菜单
     * @return
     */
    @Override
    public List<MindmapIndexTreeVO> getMindmapIndex() {
        List<MindmapIndex> mindmapIndices = mindmapIndexMapper.selectAllOrderByDetnoDesc();

        List<MindmapIndexTreeVO> treeVOS = mindmapIndices.stream().map(e -> {
            MindmapIndexTreeVO mindmapIndexTreeVO = new MindmapIndexTreeVO();
            BeanUtils.copyProperties(e, mindmapIndexTreeVO);
            return mindmapIndexTreeVO;
        }).collect(Collectors.toList());

        List<MindmapIndexTreeVO> roots = treeVOS.stream()
                .filter(e -> e.getPid() == 0).collect(Collectors.toList());
        setRootChildren(treeVOS, roots);

        return roots;
    }

    /**
     * 设置根节点的子节点
     * @param treeVOS 所有的节点
     * @param nodes 当前层级节点
     */
    private void setRootChildren(List<MindmapIndexTreeVO> treeVOS, List<MindmapIndexTreeVO> nodes) {
        nodes.forEach(node -> {
            List<MindmapIndexTreeVO> children = treeVOS.stream().filter(e -> e.getPid().equals(node.getId()))
                    .collect(Collectors.toList());
            node.setChildren(children);
            setRootChildren(treeVOS, children);
        });
    }

    /**
     * 新增mindmap index
     * @param mindmapIndexAddVO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addMindmapIndex(MindmapIndexAddVO mindmapIndexAddVO) {
        MindmapIndex mindmapIndex = new MindmapIndex();
        BeanUtils.copyProperties(mindmapIndexAddVO, mindmapIndex);
        if (mindmapIndex.getDetno() == null) {
            setMindmapIndexDetno(mindmapIndex);
        }
        mindmapIndexMapper.insertSelective(mindmapIndex);

        addMindmap(mindmapIndex);

        return mindmapIndex.getId();
    }

    /**
     * 添加mindmap
     * @param mindmapIndex
     */
    private void addMindmap(MindmapIndex mindmapIndex) {
        Mindmap mindmap = new Mindmap();
        mindmap.setTitle(mindmapIndex.getTitle());
        mindmap.setIndexId(mindmapIndex.getId());
        mindmapMapper.insertSelective(mindmap);
    }

    /**
     * 设置序号
     * @param mindmapIndex
     */
    private void setMindmapIndexDetno(MindmapIndex mindmapIndex) {
        Integer currentMaxDetno = mindmapIndexMapper.selectMaxDetnoByPid(mindmapIndex.getPid());
        mindmapIndex.setDetno(currentMaxDetno + 1);
    }

    /**
     * 更新mindmap index
     * @param mindmapUpdateVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMindmapIndex(MindmapIndexUpdateVO mindmapUpdateVO) {
        Integer indexId = mindmapUpdateVO.getId();
        MindmapIndex mindmapIndexOld = mindmapIndexMapper.selectByPrimaryKey(indexId);

        MindmapIndex mindmapIndex = new MindmapIndex();
        BeanUtils.copyProperties(mindmapUpdateVO, mindmapIndex);
        mindmapIndexMapper.updateByPrimaryKeySelective(mindmapIndex);

        // 更新title
        String title = mindmapUpdateVO.getTitle();
        if (title != null && !mindmapIndexOld.getTitle().equals(title)) {
            mindmapMapper.updateMindmapTitle(title, indexId);
        }
    }

    /**
     * 删除mindmap index，注意，连mindmap也一起删除！
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMindmapIndex(Integer id) {
        mindmapMapper.deleteByIndexId(id);
        mindmapIndexMapper.deleteByPrimaryKey(id);
    }
}

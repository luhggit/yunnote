package top.heapoverflow.yunnote.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.heapoverflow.yunnote.entity.Mindmap;
import top.heapoverflow.yunnote.mapper.MindmapMapper;
import top.heapoverflow.yunnote.service.MindmapService;
import top.heapoverflow.yunnote.vo.mindmap.MindmapMsgVO;
import top.heapoverflow.yunnote.vo.mindmap.MindmapUpdateVO;

import javax.annotation.Resource;

/**
 * @author lhg
 * @date 2019-03-13 18:47
 * @description
 */
@Service
public class MindmapServiceImpl implements MindmapService {
    @Resource
    private MindmapMapper mindmapMapper;

    /**
     * 根据mindmap index id 查找mindmap
     * @param indexId
     * @return
     */
    @Override
    public MindmapMsgVO getMindmapMsgByIndexId(Integer indexId) {
        Mindmap mindmap = mindmapMapper.selectByIndexId(indexId);
        MindmapMsgVO mindmapMsgVO = new MindmapMsgVO();
        BeanUtils.copyProperties(mindmap, mindmapMsgVO);
        return mindmapMsgVO;
    }

    /**
     * 更新mindmap
     * @param mindmapUpdateVO
     * @return
     */
    @Override
    public void updateMindmap(MindmapUpdateVO mindmapUpdateVO) {
        Mindmap mindmap = new Mindmap();
        BeanUtils.copyProperties(mindmapUpdateVO, mindmap);
        mindmapMapper.updateByPrimaryKeySelective(mindmap);
    }
}

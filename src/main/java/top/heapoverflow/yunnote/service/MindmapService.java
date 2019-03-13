package top.heapoverflow.yunnote.service;

import top.heapoverflow.yunnote.vo.mindmap.MindmapMsgVO;
import top.heapoverflow.yunnote.vo.mindmap.MindmapUpdateVO;

/**
 * @author lhg
 * @date 2019-03-13 18:46
 * @description
 */
public interface MindmapService {
    /**
     * 根据mindmap index id 查找mindmap
     * @param indexId
     * @return
     */
    MindmapMsgVO getMindmapMsgByIndexId(Integer indexId);

    /**
     * 更新mindmap
     * @param mindmapUpdateVO
     */
    void updateMindmap(MindmapUpdateVO mindmapUpdateVO);
}

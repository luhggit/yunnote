package top.heapoverflow.yunnote.service;

import top.heapoverflow.yunnote.vo.mindmap.MindmapIndexAddVO;
import top.heapoverflow.yunnote.vo.mindmap.MindmapIndexTreeVO;
import top.heapoverflow.yunnote.vo.mindmap.MindmapIndexUpdateVO;

import java.util.List;

/**
 * @author luhg 19-2-24 下午4:06
 */
public interface MindmapIndexService {
    /**
     * 获取所有的mindmap菜单
     * @return
     */
    List<MindmapIndexTreeVO> getMindmapIndex();

    /**
     * 新增mindmap index
     * @param mindmapIndexAddVO
     * @return
     */
    Integer addMindmapIndex(MindmapIndexAddVO mindmapIndexAddVO);

    /**
     * 更新mindmap index
     * @param mindmapUpdateVO
     */
    void updateMindmapIndex(MindmapIndexUpdateVO mindmapUpdateVO);

    /**
     * 删除mindmap index
     * @param id
     */
    void deleteMindmapIndex(Integer id);
}

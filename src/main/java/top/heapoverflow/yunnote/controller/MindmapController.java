package top.heapoverflow.yunnote.controller;

import org.springframework.web.bind.annotation.*;
import top.heapoverflow.yunnote.service.MindmapService;
import top.heapoverflow.yunnote.util.ResultUtils;
import top.heapoverflow.yunnote.vo.BaseVO;
import top.heapoverflow.yunnote.vo.mindmap.MindmapMsgVO;
import top.heapoverflow.yunnote.vo.mindmap.MindmapUpdateVO;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author lhg
 * @date 2019-03-13 18:44
 * @description
 */
@RestController
@RequestMapping("/api")
public class MindmapController {
    @Resource
    private MindmapService mindmapService;

    /**
     * 根据mindmap index id 查找 mindmap
     * @param indexId
     * @return
     */
    @GetMapping("/mindmap/{indexId}")
    public BaseVO<MindmapMsgVO> getMindmapMsgByIndexId(@PathVariable("indexId") Integer indexId) {
        return ResultUtils.success(mindmapService.getMindmapMsgByIndexId(indexId));
    }

    /**
     * 更新mindmap
     * @param mindmapUpdateVO
     * @return
     */
    @PatchMapping("/mindmap")
    public BaseVO<Void> updateMindmap(@RequestBody @Valid MindmapUpdateVO mindmapUpdateVO) {
        mindmapService.updateMindmap(mindmapUpdateVO);
        return ResultUtils.success(null);
    }
}

package top.heapoverflow.yunnote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.heapoverflow.yunnote.service.MindmapService;
import top.heapoverflow.yunnote.util.ResultUtils;
import top.heapoverflow.yunnote.vo.BaseVO;
import top.heapoverflow.yunnote.vo.mindmap.MindmapMsgVO;

import javax.annotation.Resource;

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
}

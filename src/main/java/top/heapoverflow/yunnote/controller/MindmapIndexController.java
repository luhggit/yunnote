package top.heapoverflow.yunnote.controller;

import org.springframework.web.bind.annotation.*;
import top.heapoverflow.yunnote.service.MindmapIndexService;
import top.heapoverflow.yunnote.util.ResultUtils;
import top.heapoverflow.yunnote.vo.BaseVO;
import top.heapoverflow.yunnote.vo.mindmap.MindmapIndexAddVO;
import top.heapoverflow.yunnote.vo.mindmap.MindmapIndexTreeVO;
import top.heapoverflow.yunnote.vo.mindmap.MindmapIndexUpdateVO;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author luhg 19-2-24 下午4:01
 */
@RestController
@RequestMapping("/api")
public class MindmapIndexController {
    @Resource
    private MindmapIndexService mindmapIndexService;

    /**
     * 获取markdown的目录
     * @return
     */
    @GetMapping("/mindmap/index")
    public BaseVO<List<MindmapIndexTreeVO>> getMindmapIndex() {
        return ResultUtils.success(mindmapIndexService.getMindmapIndex());
    }

    /**
     * 新增mindmap index
     * @param mindmapIndexAddVO
     * @return
     */
    @PostMapping("/mindmap/index")
    public BaseVO<Integer> addMindmapIndex(@RequestBody @Valid MindmapIndexAddVO mindmapIndexAddVO) {
        return ResultUtils.success(mindmapIndexService.addMindmapIndex(mindmapIndexAddVO));
    }

    /**
     * 更新markdown
     * @param markdownUpdateVO
     * @return
     */
    @PatchMapping("/mindmap/index")
    public BaseVO<Void> udpateMindmapIndex(@RequestBody @Valid MindmapIndexUpdateVO markdownUpdateVO) {
        mindmapIndexService.updateMindmapIndex(markdownUpdateVO);
        return ResultUtils.success(null);
    }

    /**
     * 删除markdown index
     * @param id
     * @return
     */
    @DeleteMapping("/mindmap/index/{id}")
    public BaseVO<Void> deleteMindmapIndex(@PathVariable Integer id) {
        mindmapIndexService.deleteMindmapIndex(id);
        return ResultUtils.success(null);
    }
}

package top.heapoverflow.yunnote.controller;

import org.springframework.web.bind.annotation.*;
import top.heapoverflow.yunnote.service.MarkdownIndexService;
import top.heapoverflow.yunnote.util.ResultUtils;
import top.heapoverflow.yunnote.vo.BaseVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexAddVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexTreeVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexUpdateVO;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author luhg 19-2-24 下午4:01
 */
@RestController
@RequestMapping("/api")
public class MarkdownIndexController {
    @Resource
    private MarkdownIndexService markdownIndexService;

    /**
     * 获取markdown的目录
     * @return
     */
    @GetMapping("/markdown/index")
    public BaseVO<List<MarkdownIndexTreeVO>> getMarkdownIndex() {
        return ResultUtils.success(markdownIndexService.getMarkdownIndex());
    }

    /**
     * 新增markdown index
     * @param markdownIndexAddVO
     * @return
     */
    @PostMapping("/markdown/index")
    public BaseVO<Integer> addMarkdownIndex(@RequestBody @Valid MarkdownIndexAddVO markdownIndexAddVO) {
        return ResultUtils.success(markdownIndexService.addMarkdownIndex(markdownIndexAddVO));
    }

    /**
     * 更新markdown
     * @param markdownUpdateVO
     * @return
     */
    @PatchMapping("/markdown/index")
    public BaseVO<Void> udpateMarkdownIndex(@RequestBody @Valid MarkdownIndexUpdateVO markdownUpdateVO) {
        markdownIndexService.updateMarkdownIndex(markdownUpdateVO);
        return ResultUtils.success(null);
    }

    /**
     * 删除markdown index
     * @param id
     * @return
     */
    @DeleteMapping("/markdown/index/{id}")
    public BaseVO<Void> deleteMarkdownIndex(@PathVariable Integer id) {
        markdownIndexService.deleteMarkdownIndex(id);
        return ResultUtils.success(null);
    }
}

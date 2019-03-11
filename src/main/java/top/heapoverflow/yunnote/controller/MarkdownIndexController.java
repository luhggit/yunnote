package top.heapoverflow.yunnote.controller;

import org.springframework.web.bind.annotation.*;
import top.heapoverflow.yunnote.service.MarkdownIndexService;
import top.heapoverflow.yunnote.util.ResultUtils;
import top.heapoverflow.yunnote.vo.BaseVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexAddVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexTreeVO;

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
     * 新增markdown
     * @param markdownIndexAddVO
     * @return
     */
    @PostMapping("/markdown/index/add")
    public BaseVO<Integer> addMarkdownIndex(@RequestBody @Valid MarkdownIndexAddVO markdownIndexAddVO) {
        return ResultUtils.success(markdownIndexService.addMarkdownIndex(markdownIndexAddVO));
    }
}

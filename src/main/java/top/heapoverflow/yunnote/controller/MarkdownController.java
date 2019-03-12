package top.heapoverflow.yunnote.controller;

import org.springframework.web.bind.annotation.*;
import top.heapoverflow.yunnote.service.MarkdownService;
import top.heapoverflow.yunnote.util.ResultUtils;
import top.heapoverflow.yunnote.vo.BaseVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownMsgVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownUpdateVO;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author lhg
 * @date 2019-03-11 18:45
 * @description
 */
@RestController
@RequestMapping("/api")
public class MarkdownController {
    @Resource
    private MarkdownService markdownService;

    /**
     * 更新markdown
     * @param markdownUpdateVO
     * @return
     */
    @PatchMapping("/markdown")
    public BaseVO<Void> udpateMarkdownIndex(@RequestBody @Valid MarkdownUpdateVO markdownUpdateVO) {
        markdownService.updateMarkdown(markdownUpdateVO);
        return ResultUtils.success(null);
    }

    /**
     * 根据id查找markdown
     * @param id
     * @return
     */
    @GetMapping("/markdown/{id}")
    public BaseVO<MarkdownMsgVO> getMarkdownMsg(@PathVariable Integer id) {
        return ResultUtils.success(markdownService.getMarkdownMsg(id));
    }

    /**
     * 根据关键字进行搜索
     * @param keyword 关键字
     * @return markdown对应的id
     */
    @GetMapping("/markdown/serach")
    public BaseVO<List<Integer>> getMarkDownByKeyword(@RequestParam("keyword") String keyword) {
        return ResultUtils.success(markdownService.getMarkDownByKeyword(keyword));
    }
}

package top.heapoverflow.yunnote.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.heapoverflow.yunnote.service.MarkdownService;
import top.heapoverflow.yunnote.util.ResultUtils;
import top.heapoverflow.yunnote.vo.BaseVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownUpdateVO;

import javax.annotation.Resource;
import javax.validation.Valid;

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
}

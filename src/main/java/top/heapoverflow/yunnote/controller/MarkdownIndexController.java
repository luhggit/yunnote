package top.heapoverflow.yunnote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.heapoverflow.yunnote.service.MarkdownIndexService;
import top.heapoverflow.yunnote.vo.MarkdownIndexTreeVO;

import javax.annotation.Resource;
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
    @GetMapping("/markdown")
    public List<MarkdownIndexTreeVO> getMarkdownIndex() {
        return markdownIndexService.getMarkdownIndex();
    }
}

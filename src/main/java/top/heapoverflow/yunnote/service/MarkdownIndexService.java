package top.heapoverflow.yunnote.service;

import top.heapoverflow.yunnote.vo.MarkdownIndexTreeVO;
import java.util.List;

/**
 * @author luhg 19-2-24 下午4:06
 */
public interface MarkdownIndexService {
    /**
     * 获取所有的markdown菜单
     * @return
     */
    List<MarkdownIndexTreeVO> getMarkdownIndex();
}

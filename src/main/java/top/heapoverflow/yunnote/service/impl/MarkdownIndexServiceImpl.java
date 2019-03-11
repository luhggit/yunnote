package top.heapoverflow.yunnote.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.heapoverflow.yunnote.entity.MarkdownIndex;
import top.heapoverflow.yunnote.mapper.MarkdownIndexMapper;
import top.heapoverflow.yunnote.service.MarkdownIndexService;
import top.heapoverflow.yunnote.vo.MarkdownIndexTreeVO;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luhg 19-2-24 下午4:07
 */
@Service
public class MarkdownIndexServiceImpl implements MarkdownIndexService {

    @Resource
    private MarkdownIndexMapper markdownIndexMapper;

    /**
     * 获取所有的markdown菜单
     * @return
     */
    @Override
    public List<MarkdownIndexTreeVO> getMarkdownIndex() {
        List<MarkdownIndex> markdownIndices = markdownIndexMapper.selectAllOrderByIdDesc();

        List<MarkdownIndexTreeVO> treeVOS = markdownIndices.stream().map(e -> {
            MarkdownIndexTreeVO markdownIndexTreeVO = new MarkdownIndexTreeVO();
            BeanUtils.copyProperties(e, markdownIndexTreeVO);
            return markdownIndexTreeVO;
        }).collect(Collectors.toList());

        List<MarkdownIndexTreeVO> roots = treeVOS.stream()
                .filter(e -> 0 == e.getPid()).collect(Collectors.toList());
        setRootChildren(treeVOS, roots);

        return roots;
    }

    /**
     * 设置根节点的子节点
     * @param treeVOS
     * @param roots
     */
    private void setRootChildren(List<MarkdownIndexTreeVO> treeVOS, List<MarkdownIndexTreeVO> roots) {
        roots.forEach(root -> {
            List<MarkdownIndexTreeVO> children = treeVOS.stream().filter(e -> e.getPid().equals(root.getId()))
                    .collect(Collectors.toList());
            root.setChildren(children);
        });
    }


}

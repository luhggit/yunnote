package top.heapoverflow.yunnote.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.heapoverflow.yunnote.entity.Markdown;
import top.heapoverflow.yunnote.entity.MarkdownIndex;
import top.heapoverflow.yunnote.entity.MarkdownWithBLOBs;
import top.heapoverflow.yunnote.mapper.MarkdownIndexMapper;
import top.heapoverflow.yunnote.mapper.MarkdownMapper;
import top.heapoverflow.yunnote.service.MarkdownIndexService;
import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexAddVO;
import top.heapoverflow.yunnote.vo.markdown.MarkdownIndexTreeVO;

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
    @Resource
    private MarkdownMapper markdownMapper;

    /**
     * 获取所有的markdown菜单
     * @return
     */
    @Override
    public List<MarkdownIndexTreeVO> getMarkdownIndex() {
        List<MarkdownIndex> markdownIndices = markdownIndexMapper.selectAllOrderByDetnoDesc();

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
     * @param treeVOS 所有的节点
     * @param nodes 当前层级节点
     */
    private void setRootChildren(List<MarkdownIndexTreeVO> treeVOS, List<MarkdownIndexTreeVO> nodes) {
        nodes.forEach(node -> {
            List<MarkdownIndexTreeVO> children = treeVOS.stream().filter(e -> e.getPid().equals(node.getId()))
                    .collect(Collectors.toList());
            node.setChildren(children);
            setRootChildren(treeVOS, children);
        });
    }

    /**
     * 新增markdown
     * @param markdownIndexAddVO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addMarkdownIndex(MarkdownIndexAddVO markdownIndexAddVO) {
        MarkdownIndex markdownIndex = new MarkdownIndex();
        BeanUtils.copyProperties(markdownIndexAddVO, markdownIndex);
        if (markdownIndex.getDetno() == null) {
            setMarkdownIndexDetno(markdownIndex);
        }
        markdownIndexMapper.insertSelective(markdownIndex);

        addMarkdown(markdownIndex);

        return markdownIndex.getId();
    }

    /**
     * 添加markdown
     * @param markdownIndex
     */
    private void addMarkdown(MarkdownIndex markdownIndex) {
        MarkdownWithBLOBs markdown = new MarkdownWithBLOBs();
        markdown.setTitle(markdownIndex.getTitle());
        markdown.setIndexId(markdownIndex.getId());
        markdown.setHtmlContent("");
        markdown.setMdContent("");
        markdownMapper.insertSelective(markdown);
    }

    /**
     * 设置序号
     * @param markdownIndex
     */
    private void setMarkdownIndexDetno(MarkdownIndex markdownIndex) {
        Integer currentMaxDetno = markdownIndexMapper.selectMaxDetnoByPid(markdownIndex.getPid());
        markdownIndex.setDetno(currentMaxDetno + 1);
    }
}

package top.heapoverflow.yunnote.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.heapoverflow.yunnote.entity.Markdown;
import top.heapoverflow.yunnote.entity.MarkdownIndex;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author lhg
 * @date 2019-03-15 15:28
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class MarkdownMapperTest {

    @Resource
    private MarkdownMapper markdownMapper;

    /**
     * 根据markdown插入markdown index
     */
    @Test
    public void testIndex() {
        List<Markdown> markdowns = markdownMapper.selectAllDistinctMarkdown();

        Set<String> firstClassSet = new HashSet<>();
        Set<String> secondClassSet = new HashSet<>();
        Set<String> titleSet = new HashSet<>();

        MarkdownIndex firstClassIndex = new MarkdownIndex();
        MarkdownIndex secondClassIndex = new MarkdownIndex();
        MarkdownIndex titleMarkdownIndex;

        int firstClassDetno = 0;
        int secondClassDetno = 0;
        int titleDetno = 0;

        List<MarkdownIndex> markdownIndices = new LinkedList<>();

        for (Markdown markdown : markdowns) {
            String firstClass = markdown.getFirstClass();
            String secondClass = markdown.getSecondClass();
            String title = markdown.getTitle();
            if (!firstClassSet.contains(firstClass)) {
                firstClassSet.add(firstClass);

                secondClassSet.clear();
                titleSet.clear();

                secondClassDetno = 0;
                titleDetno = 0;

                firstClassIndex  = new MarkdownIndex();
                firstClassIndex.setPid(0);
                firstClassIndex.setTitle(firstClass);
                firstClassIndex.setDetno(firstClassDetno);

                // TODO insert firstClassIndex

                firstClassDetno ++;

                markdownIndices.add(firstClassIndex);
            }

            boolean hasSecondClass = !StringUtils.isEmpty(secondClass);
            if (hasSecondClass && !secondClassSet.contains(secondClass)) {
                secondClassSet.add(secondClass);

                titleSet.clear();

                titleDetno = 0;

                secondClassIndex = new MarkdownIndex();
                secondClassIndex.setPid(firstClassIndex.getId());
                secondClassIndex.setTitle(secondClass);
                secondClassIndex.setDetno(secondClassDetno);

                // TODO insert secondClassIndex
                secondClassDetno ++;

                markdownIndices.add(secondClassIndex);
            }

            if (!titleSet.contains(title)) {
                titleMarkdownIndex = new MarkdownIndex();
                if (!hasSecondClass) {
                    secondClassDetno ++;
                    titleMarkdownIndex.setPid(firstClassIndex.getId());
                } else {
                    titleMarkdownIndex.setPid(secondClassIndex.getId());
                }
                titleMarkdownIndex.setTitle(title);
                titleMarkdownIndex.setDetno(titleDetno);
                titleDetno ++;

                // TODO insert titleMarkdownIndex

                markdownIndices.add(titleMarkdownIndex);
            }
        }

        markdownIndices.forEach(e -> {
            System.out.println(e);
        });
    }
}
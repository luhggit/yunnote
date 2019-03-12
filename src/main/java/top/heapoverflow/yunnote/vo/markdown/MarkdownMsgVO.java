package top.heapoverflow.yunnote.vo.markdown;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

/**
 * @author lhg
 * @date 2019-03-12 10:31
 * @description
 */
@Data
public class MarkdownMsgVO {
    private Integer id;

    private String title;

    private String htmlContent;

    private String mdContent;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

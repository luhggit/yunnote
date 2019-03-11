package top.heapoverflow.yunnote.vo.markdown;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

/**
 * @author lhg
 * @date 2019-03-11 18:50
 * @description markdown更新对象
 */
@Data
public class MarkdownUpdateVO {
    private Integer id;

    private String title;

    private String htmlContent;

    private String mdContent;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

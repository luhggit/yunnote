package top.heapoverflow.yunnote.vo.markdown;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

/**
 * @author lhg
 * @date 2019-03-11 15:07
 * @description
 */
@Data
public class MarkdownIndexAddVO {
    private Integer pid;

    private String title;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

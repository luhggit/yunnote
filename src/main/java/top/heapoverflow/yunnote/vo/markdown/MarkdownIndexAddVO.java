package top.heapoverflow.yunnote.vo.markdown;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lhg
 * @date 2019-03-11 15:07
 * @description
 */
@Data
public class MarkdownIndexAddVO {
    @NotNull(message = "pid不能为空")
    private Integer pid;

    @NotBlank(message = "title不能为空")
    private String title;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

package top.heapoverflow.yunnote.vo.markdown;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lhg
 * @date 2019-03-11 18:50
 * @description markdown更新对象
 */
@Data
public class MarkdownUpdateVO {
    @NotNull(message = "id不能为空")
    private Integer id;

    private String title;

    private String htmlContent;

    @NotNull(message = "markdown内容不能为空")
    private String mdContent;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

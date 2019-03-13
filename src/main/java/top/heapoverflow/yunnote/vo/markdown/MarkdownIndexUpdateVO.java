package top.heapoverflow.yunnote.vo.markdown;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lhg
 * @date 2019-03-11 17:55
 * @description
 */
@Data
public class MarkdownIndexUpdateVO {
    @NotNull(message = "id不能为空")
    private Integer id;

    @NotBlank(message = "title不能为空")
    private String title;

    private Integer detno;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

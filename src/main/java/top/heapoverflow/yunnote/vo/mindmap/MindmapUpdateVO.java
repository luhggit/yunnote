package top.heapoverflow.yunnote.vo.mindmap;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lhg
 * @date 2019-03-13 18:56
 * @description
 */
@Data
public class MindmapUpdateVO {
    @NotNull(message = "id不能为空")
    private Integer id;

    @NotNull(message = "content不能为空")
    private String content;
}

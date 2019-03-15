package top.heapoverflow.yunnote.vo.calendar;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lhg
 * @date 2019-03-12 18:22
 * @description calendar新增vo
 */
@Data
public class CalendarUpdateVO {
    @NotNull(message = "id不能为空")
    private Integer id;

    private Integer month;

    private Integer year;

    @NotBlank(message = "content不能为空")
    private String content;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

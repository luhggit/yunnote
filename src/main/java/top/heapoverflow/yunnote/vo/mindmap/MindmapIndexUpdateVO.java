package top.heapoverflow.yunnote.vo.mindmap;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

/**
 * @author lhg
 * @date 2019-03-11 17:55
 * @description
 */
@Data
public class MindmapIndexUpdateVO {
    private Integer id;

    private String title;

    private Integer detno;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

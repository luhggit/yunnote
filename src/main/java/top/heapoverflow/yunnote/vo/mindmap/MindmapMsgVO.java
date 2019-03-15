package top.heapoverflow.yunnote.vo.mindmap;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

/**
 * @author lhg
 * @date 2019-03-13 18:45
 * @description
 */
@Data
public class MindmapMsgVO {
    private Integer id;

    private String content;

    private String title;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

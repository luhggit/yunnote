package top.heapoverflow.yunnote.vo.mindmap;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import java.util.List;

/**
 * @author luhg 19-2-24 下午4:03
 */
@Data
public class MindmapIndexTreeVO {
    private Integer id;

    private Integer pid;

    @JsonProperty("label")
    private String title;

    private List<MindmapIndexTreeVO> children;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

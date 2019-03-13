package top.heapoverflow.yunnote.vo.markdown;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import java.util.List;

/**
 * @author luhg 19-2-24 下午4:03
 */
@Data
public class MarkdownIndexTreeVO {
    private Integer id;

    private Integer pid;

    @JsonProperty("label")
    private String title;

    private Integer detno;

    private List<MarkdownIndexTreeVO> children;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

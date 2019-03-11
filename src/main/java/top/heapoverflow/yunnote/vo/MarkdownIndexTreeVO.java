package top.heapoverflow.yunnote.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author luhg 19-2-24 下午4:03
 */
@Data
public class MarkdownIndexTreeVO {
    private Integer id;

    private Integer pid;

    @JsonProperty("label")
    private String name;

    private List<MarkdownIndexTreeVO> children;
}

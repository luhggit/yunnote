package top.heapoverflow.yunnote.entity;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import java.util.Date;

/**
 * @author luhg
 */
@Data
public class MindMap {
    private Integer id;

    private String mindmapContent;

    private Date createTime;

    private Date lastUpdateTime;

    private String firstClass;

    private String secondClass;

    private String title;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}

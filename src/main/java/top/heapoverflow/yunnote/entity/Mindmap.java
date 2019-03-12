package top.heapoverflow.yunnote.entity;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import java.util.Date;

@Data
public class Mindmap {
    private Integer id;

    private Integer indexId;

    private String title;

    private Date createTime;

    private Date lastUpdateTime;

    private String content;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
package top.heapoverflow.yunnote.entity;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import java.util.Date;

@Data
public class MarkdownIndex {
    private Integer id;

    private Integer pid;

    private String name;

    private Integer detno;

    private Date createTime;

    private Date updateTime;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
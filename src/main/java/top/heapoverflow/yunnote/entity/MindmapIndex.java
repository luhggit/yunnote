package top.heapoverflow.yunnote.entity;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import java.util.Date;

@Data
public class MindmapIndex {
    private Integer id;

    private Integer pid;

    private String title;

    private Integer detno;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
package top.heapoverflow.yunnote.entity;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import java.util.Date;

/**
 * @author luhg
 */
@Data
public class Calendar {
    private Integer id;

    private Integer month;

    private Integer year;

    private Date createTime;

    private Date lastUpdateTime;

    private String content;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
package top.heapoverflow.yunnote.entity;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private Date createTime;

    private Date lastUpdateTime;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
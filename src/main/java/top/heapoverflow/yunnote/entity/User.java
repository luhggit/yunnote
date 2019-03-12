package top.heapoverflow.yunnote.entity;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

/**
 * @author luhg
 */
@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
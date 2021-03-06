package top.heapoverflow.yunnote.entity;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

import java.util.Date;

/**
 * @author luhg
 */
@Data
public class Markdown {
    private Integer id;

    private Date createTime;

    private Date lastUpdateTime;

    private String status;

    private String firstClass;

    private String secondClass;

    private String title;

    private Integer indexId;

    private String htmlContent;

    private String mdContent;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
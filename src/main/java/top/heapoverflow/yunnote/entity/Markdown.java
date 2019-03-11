package top.heapoverflow.yunnote.entity;

import lombok.Data;

import java.util.Date;

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

}
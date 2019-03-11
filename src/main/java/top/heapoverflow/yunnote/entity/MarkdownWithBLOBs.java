package top.heapoverflow.yunnote.entity;

import lombok.Data;
import top.heapoverflow.yunnote.util.JsonUtils;

@Data
public class MarkdownWithBLOBs extends Markdown {
    private String htmlContent;

    private String mdContent;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
package top.heapoverflow.yunnote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luhg 19-2-24 上午10:12
 */
@RestController
public class HelloController {

    /**
     * 接口测试
     * @return
     */
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello";
    }
}

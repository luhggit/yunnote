package top.heapoverflow.yunnote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.heapoverflow.yunnote.mapper")
public class YunnoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunnoteApplication.class, args);
    }

}

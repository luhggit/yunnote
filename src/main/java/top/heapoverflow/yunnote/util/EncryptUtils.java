package top.heapoverflow.yunnote.util;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author lhg
 * @date 2019-01-19 09:56
 * @description
 */
@Slf4j
public class EncryptUtils {

    /**
     * 生成 MD5
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String md5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            log.error("生成MD5失败", e);
            throw new RuntimeException(e);
        }
    }
}

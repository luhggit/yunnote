package top.heapoverflow.yunnote.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lhg
 * @date 2019-03-11 18:00
 * @description
 */
@Slf4j
public class CheckUtils {
    /**
     * 检查字段是否有值时排除的字段名
     */
    private static List<String> excludeFieldNames = Arrays.asList("id", "uid", "serialVersionUID");

    /**
     * 检查obj里非ID及UID对应的字段是否有任何一个字段是非空
     * @param obj 实例对象，通常用于检测vo里的字段是否有值
     * @return
     */
    public static boolean anyNotNullExceptUidAndId(Object obj) {
        Class clazz = obj.getClass();
        boolean result = false;
        List<Field> fields = Arrays.stream(clazz.getDeclaredFields()).filter(f -> !f.isSynthetic()).collect(Collectors.toList());
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                String key = field.getName();
                Object value = field.get(obj);
                if (!excludeFieldNames.contains(key) && value != null) {
                    result = true;
                    break;
                }
            } catch (IllegalAccessException exception) {
                log.error("get value error:", exception);
            }
        }
        return result;
    }
}

package top.heapoverflow.yunnote.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.heapoverflow.yunnote.entity.User;

public interface UserMapper {
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 插入非空
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 查找
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 更新非空
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查找密码
     * @param username
     * @return
     */
    @Select("select password from user where username=#{username}")
    String selectPasswordByUsername(@Param("username") String username);
}
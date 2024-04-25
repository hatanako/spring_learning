package generator.mapper;

import generator.com.atguigu.pojo.User;

/**
* @author 11303
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-01-20 22:55:19
* @Entity generator.com.atguigu.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}

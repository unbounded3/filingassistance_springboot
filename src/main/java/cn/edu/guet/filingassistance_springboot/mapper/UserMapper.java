package cn.edu.guet.filingassistance_springboot.mapper;

import cn.edu.guet.filingassistance_springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findByName(@Param(value = "name") String name);
    User findByIdCard(@Param(value = "idCard") String idCard);
    void InsertUserInfo(User user);
}
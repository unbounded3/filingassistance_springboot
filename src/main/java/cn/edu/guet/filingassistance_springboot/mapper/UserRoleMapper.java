package cn.edu.guet.filingassistance_springboot.mapper;

import java.util.List;

import cn.edu.guet.filingassistance_springboot.bean.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Liwei
 * @Date 2021-08-13 17:50
 */
@Mapper
public interface UserRoleMapper {
    List<UserRole> findUserRoles(@Param(value = "userId") String userId);
}
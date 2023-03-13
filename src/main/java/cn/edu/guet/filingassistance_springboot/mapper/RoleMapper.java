package cn.edu.guet.filingassistance_springboot.mapper;

import java.util.List;
import cn.edu.guet.filingassistance_springboot.bean.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Liwei
 * @Date 2021-08-13 17:50
 */
@Mapper
public interface RoleMapper {
    Role selectByPrimaryKey(String id);
    List<Role> findAll();
}
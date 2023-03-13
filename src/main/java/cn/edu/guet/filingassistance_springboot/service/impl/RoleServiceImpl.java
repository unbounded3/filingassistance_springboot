package cn.edu.guet.filingassistance_springboot.service.impl;

import cn.edu.guet.filingassistance_springboot.bean.Role;
import cn.edu.guet.filingassistance_springboot.mapper.RoleMapper;
import cn.edu.guet.filingassistance_springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> findAll() {
		return roleMapper.findAll();
	}
	
}

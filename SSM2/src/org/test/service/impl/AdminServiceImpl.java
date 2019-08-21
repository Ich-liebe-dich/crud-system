package org.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.entity.Admin;
import org.test.mapper.AdminMapper;
import org.test.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}

	@Override
	public List<Admin> queryAdmin(Admin admin) {
		return adminMapper.queryAdmin(admin);
	}

	@Override
	public Admin queryAdminById(int id) {
		return adminMapper.queryAdminById(id);
	}

	@Override
	public List<Admin> queryAdminList() {
		return adminMapper.queryAdminList();
	}

	@Override
	public int addAdmin(Admin admin) {
		return adminMapper.addAdmin(admin);
	}

	@Override
	public int updateAdmin(Admin admin) {
		return adminMapper.updateAdmin(admin);
	}

}

package org.test.service;

import java.util.List;

import org.test.entity.Admin;

public interface AdminService {
	List<Admin> queryAdmin(Admin admin);

    Admin queryAdminById(int id);
    
    List<Admin> queryAdminList();
  
    int addAdmin(Admin admin);
    
    int updateAdmin(Admin admin);

}

package org.test.mapper;

import java.util.List;
import org.test.entity.Admin;

public interface AdminMapper {
	
	int addAdmin(Admin admin);
	
	int updateAdmin(Admin admin);
	
    List<Admin> queryAdmin(Admin admin);

    Admin queryAdminById(int id);
    
    List<Admin> queryAdminList();
   
}
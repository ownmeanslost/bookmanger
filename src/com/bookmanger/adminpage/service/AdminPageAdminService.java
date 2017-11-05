package com.bookmanger.adminpage.service;

import com.bookmanger.common.model.Administer;

public interface AdminPageAdminService{
	public Administer get(String user_id);
	
	/**
	 * 修改管理员信息
	 * @param administer
	 * @return
	 */
	public boolean updateAdministerInfo(Administer administer);
}

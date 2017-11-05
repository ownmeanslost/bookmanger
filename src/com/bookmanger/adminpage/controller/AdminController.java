package com.bookmanger.adminpage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookmanger.adminpage.service.AdminPageAdminService;
import com.bookmanger.common.model.Administer;
import com.bookmanger.common.model.User;

@Controller
@RequestMapping(value="/AdminController")
public class AdminController {
	
	@Autowired
	AdminPageAdminService adminPageAdminService;
	/**
	 * 管理员信息
	 * @return
	 */
	@RequestMapping(value="/GoToAdminInfo")
	public String goToAdminInfo(HttpSession session,Model model){
		String user_id = getUserSession(session);
		Administer administer= adminPageAdminService.get("123456");
		model.addAttribute("administer", administer);
		return "adminpage/AdminInfo";
	}
	/**
	 * 图书录入
	 * @return
	 */
	@RequestMapping(value="/GoToBookRegister")
	public String goToBookRegister(){
		return "adminpage/BookRegister";
	}
	/**
	 * 读者信息
	 * @return
	 */
	@RequestMapping(value="/GoToUserInfo")
	public String goToUserInfo(){
		return "adminpage/UserInfo";
	}
	/**
	 * 消息中心
	 * @return
	 */
	@RequestMapping(value="/GoToNewsCenter")
	public String goToNewsCenter(){
		return "adminpage/NewsCenter";
	}
	/**
	 * 获得session
	 * 
	 * @param session
	 * @return
	 */
	public String getUserSession(HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		return user_id;
	}

	/**
	 * 移除session
	 * 
	 * @param session
	 */
	public void delUserSession(HttpSession session) {
		session.removeAttribute("user_id");
	}
	
	/**
	 * 获得管理员信息
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/GetAdminInfo", method = RequestMethod.POST)
	@ResponseBody
	public Administer getUserInfo(HttpSession session) {
		String user_id = getUserSession(session);
		return adminPageAdminService.get("123456");

	}
	/**
	 * 修改管理员信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/UpdateAdminInfo")
	@ResponseBody
	public String updateUserInfo(Administer administer,HttpSession session) {
		String user_id = getUserSession(session);
		Administer upAdminister= adminPageAdminService.get("123456");
		upAdminister.setPassword(administer.getPassword());
		if (adminPageAdminService.updateAdministerInfo(upAdminister)) {
			return "1";
		}
		return "0";
	}


}

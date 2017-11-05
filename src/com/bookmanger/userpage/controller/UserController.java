package com.bookmanger.userpage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookmanger.common.model.User;
import com.bookmanger.common.utils.CompareExpression;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.userpage.service.UserPageBookService;
import com.bookmanger.userpage.service.UserService;
import com.bookmanger.userpage.vo.BorrowInfoVO;
import com.bookmanger.userpage.vo.HaveBorrowVO;

@Controller
@RequestMapping(value = "/UserController")
public class UserController {
	@Autowired
	UserService userService1;
	@Autowired
	UserPageBookService userPageBookService;

	/**
	 * 个人信息
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/GoToUserInfo")
	public String goToUserInfo(HttpSession session, Model model) {
		String user_id = getUserSession(session);
		User user = userService1.get(user_id);
		model.addAttribute("user", user);
		return "userpage/UserInfo";
	}

	/**
	 * 跳转到修改密码页面
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/UpdatePassword")
	public String updatePassword(HttpSession session, Model model) {
		String user_id = getUserSession(session);
		User user = userService1.get(user_id);
		model.addAttribute("user", user);
		return "userpage/UpdatePassword";
	}

	/**
	 * 已经借阅图书
	 * 
	 * @return
	 */
	@RequestMapping(value = "/HaveBorrow")
	public String haveBorrow() {

		return "userpage/HaveBorrow";
	}

	@RequestMapping(value = "/NewsCenter")
	public String newsCenter() {

		return "userpage/HaveExpire";
	}

	@RequestMapping(value = "/BorrowCenter")
	public String borrowCenter() {

		return "userpage/BookCheck";
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

	@RequestMapping(value = "/GetUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public User getUserInfo(HttpSession session) {
		String user_id = getUserSession(session);
		return userService1.get(user_id);

	}

	/**
	 * 修改密码
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/UpdateUserInfo")
	@ResponseBody
	public String updateUserInfo(User user) {
		User upuser = userService1.get(user.getUser_id());
		upuser.setPassword(user.getPassword());
		if (userService1.updateUserInfo(upuser)) {
			return "1";
		}
		return "0";
	}

	/**
	 * 获得用户已经借阅图书列表
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/GetHaveBorrowList", method = RequestMethod.POST)
	@ResponseBody
	public PaginationResponse<HaveBorrowVO> getHaveBorrowList(
			HttpSession session, HttpServletRequest request) {
		QueryCondition queryCondition = null;
		String user_id = getUserSession(session);
		List<QueryCondition> cons = new ArrayList<QueryCondition>();
		// 添加查询条件
		if (user_id != null && !user_id.equals("")) {
			queryCondition = new QueryCondition(CompareExpression.Eq,
					"s1.user_id", user_id);
			cons.add(queryCondition);
		}

		return userPageBookService.getHaveBorrow(cons);

	}

	/**
	 * 获得用户已经超期图书列表
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/GetHaveExpireList", method = RequestMethod.POST)
	@ResponseBody
	public PaginationResponse<HaveBorrowVO> getHaveExpireList(
			HttpSession session, HttpServletRequest request) {
		QueryCondition queryCondition = null;
		String user_id = getUserSession(session);
		List<QueryCondition> cons = new ArrayList<QueryCondition>();
		// 添加查询条件
		if (user_id != null && !user_id.equals("")) {
			queryCondition = new QueryCondition(CompareExpression.Eq,
					"s1.user_id", user_id);
			cons.add(queryCondition);
		}

		return userPageBookService.getHaveExpire(cons);

	}

	@RequestMapping("/JingQueCheck")
	public String goToJingQueCheck(HttpServletRequest request, Model model) {
		String ISDN = request.getParameter("ISDN");
		if (ISDN != null && !ISDN.equals("")) {
			model.addAttribute("ISDN", ISDN);
		}
		return "/userpage/JingQueCheck";
	}

	@RequestMapping("/BorrowBook")
	@ResponseBody
	public BorrowInfoVO borrowBook(HttpServletRequest request,
			HttpSession session) {
		String ISDN = request.getParameter("ISDN");

		QueryCondition queryCondition = null;
		String user_id = getUserSession(session);
		List<QueryCondition> cons = new ArrayList<QueryCondition>();
		// 添加查询条件
		if (user_id != null && !user_id.equals("")) {
			queryCondition = new QueryCondition(CompareExpression.Eq,
					"s1.user_id", user_id);
			cons.add(queryCondition);
		}

		BorrowInfoVO bo = userPageBookService.userBorrow(ISDN, cons, user_id);
		return bo;
	}
}

package com.bookmanger.adminpage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bookmanger.adminpage.service.AdminPageAdminService;
import com.bookmanger.adminpage.service.AdminPageBookService;
import com.bookmanger.adminpage.service.AdminPageBorrow_labService;
import com.bookmanger.adminpage.service.AdminPageUserService;
import com.bookmanger.adminpage.vo.BookVO;
import com.bookmanger.adminpage.vo.HaveBorrowVO;
import com.bookmanger.common.model.Administer;
import com.bookmanger.common.model.Book;
import com.bookmanger.common.model.Borrow_lab;
import com.bookmanger.common.model.User;
import com.bookmanger.common.utils.CompareExpression;
import com.bookmanger.common.utils.DateTransfor;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.common.utils.UploadFileUtils;

@Controller
@RequestMapping(value = "/AdminController")
public class AdminController {

	@Autowired
	AdminPageAdminService adminPageAdminService;

	@Autowired
	AdminPageBookService adminPageBookService;

	@Autowired
	AdminPageBorrow_labService adminPageBorrow_labService;
	
	@Autowired
	AdminPageUserService adminPageUserService;
	/**
	 * 管理员信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/GoToAdminInfo")
	public String goToAdminInfo(HttpSession session, Model model) {
		String user_id = getUserSession(session);
		if(user_id!=null){
			Administer administer = adminPageAdminService.get(user_id);
			model.addAttribute("administer", administer);
			return "adminpage/AdminInfo";
		}
		return "/homepage/erro";
	}

	/**
	 * 图书录入
	 * 
	 * @return
	 */
	@RequestMapping(value = "/GoToBookRegister")
	public String goToBookRegister(HttpSession session) {
		if(getUserSession(session)!=null)
		return "adminpage/BookRegister";
		return "/homepage/erro";
		
	}

	/**
	 * 读者信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/GoToUserInfo")
	public String goToUserInfo(HttpSession session) {
		if(getUserSession(session)!=null)
		return "adminpage/UserInfo";
		return "/homepage/erro";
	}

	/**
	 * 消息中心
	 * 
	 * @return
	 */
	@RequestMapping(value = "/GoToNewsCenter")
	public String goToNewsCenter(HttpSession session) {
		if(getUserSession(session)!=null)
		return "adminpage/NewsCenter";
		return "/homepage/erro";
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
	@RequestMapping(value="/DelUserSeeion")
	@ResponseBody
	public String delUserSession(HttpSession session) {
		session.removeAttribute("user_id");
		return "1";
	}

	/**
	 * 获得管理员信息
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/GetAdminInfo", method = RequestMethod.POST)
	@ResponseBody
	public Administer getUserInfo(HttpSession session) {
		String user_id = getUserSession(session);
		Administer adm=new Administer();
		if(user_id!=null){
			adm=adminPageAdminService.get(user_id);
			return adm;
		}
		else return adm;

	}

	/**
	 * 修改管理员信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/UpdateAdminInfo")
	@ResponseBody
	public String updateUserInfo(Administer administer, HttpSession session) {
		String user_id = getUserSession(session);
		Administer upAdminister = adminPageAdminService.get(user_id);
		upAdminister.setPassword(administer.getPassword());
		if (adminPageAdminService.updateAdministerInfo(upAdminister)) {
			return "1";
		}
		return "0";
	}

	/**
	 * 上传书的信息，除图片以外
	 * 
	 * @param book
	 * @return
	 */
	@RequestMapping(value = "/AddBookInfo", method = RequestMethod.POST)
	@ResponseBody
	public String addBookInfo(BookVO bookVO) {
		if (adminPageBookService.get(bookVO.getBook_id()) == null) {
			Book book = new Book();
			book.setBook_id(bookVO.getBook_id());
			book.setBook_name(bookVO.getBook_name());
			book.setAuthor(bookVO.getAuthor());
			book.setInclude(bookVO.getInclude());
			book.setIntruduce(bookVO.getIntruduce());
			book.setOrder(bookVO.getOrder());
			book.setPrint_time(DateTransfor.stringToDate(bookVO.getPrint_time()));
			book.setPrinter(bookVO.getPrinter());
			Borrow_lab borrow_lab = new Borrow_lab();
			borrow_lab.setBookid(bookVO.getBook_id());
			borrow_lab.setKucun(Integer.parseInt(bookVO.getKucun()));
			adminPageBookService.save(book);
			adminPageBorrow_labService.save(borrow_lab);
			return "1";
		} else {
			return "0";
		}
	}

	/**
	 * 上传图片
	 * 
	 * @param id
	 * @param request
	 * @param inputfile
	 * @return
	 */

	@RequestMapping(value = "/LoadPicture", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> loadPicture(String id,
			MultipartHttpServletRequest request,
			@RequestParam MultipartFile[] inputfile) {
		System.out.println(id);
		String pictureurl = UploadFileUtils.uploadImage(request, inputfile[0],
				id);
		if (pictureurl != null && pictureurl.length() > 0) {
			Book book = adminPageBookService.get(id);
			book.setList(pictureurl);
			java.sql.Date d = DateTransfor.getNowDateAsDate();
			book.setUpdateTime(d);
			adminPageBookService.update(book);
			System.out.println("上传成功！" + pictureurl); //

		} else {
			System.out.println("上传失败！");
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		return map;

	}

	/**
	 * 删除书
	 * 
	 * @param ISDN
	 * @return
	 */
	@RequestMapping(value = "/DelBook", method = RequestMethod.POST)
	@ResponseBody
	public String delBook(String ISDN) {
		Book book = adminPageBookService.get(ISDN);
		if (book != null) {
			adminPageBookService.delete(book);
			return "1";
		} else {
			return "0";
		}
	}
	/**
	 *读者查询分页
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/GetUserList",method=RequestMethod.POST)
	@ResponseBody
	public PaginationResponse<User> getUserList(HttpServletRequest request){
		String pageNumber = request.getParameter("offset");
		String pageSize = request.getParameter("limit");
		String user_id=request.getParameter("user_id");
		String name=request.getParameter("name");
		String id_num=request.getParameter("id_num");
		String number=request.getParameter("number");
		if (pageNumber == null) {
			pageNumber = "0";
		}
		if (pageSize == null) {
			pageSize = "5";
		}
		QueryCondition queryCondition = null;
		List<QueryCondition> cons = new ArrayList<QueryCondition>();
		if ("1".equals(number)&& user_id != null && !user_id.equals("")) {
			queryCondition = new QueryCondition(CompareExpression.Eq,
					"user_id",user_id);
			cons.add(queryCondition);
		}else if ("2".equals(number)&& name != null && !name.equals("")) {
			queryCondition = new QueryCondition(CompareExpression.Like,
					"name", name);
			cons.add(queryCondition);
		}else if ("3".equals(number)&& id_num != null && !id_num.equals("")) {
			queryCondition = new QueryCondition(CompareExpression.Like,
					"id_num", id_num);
			cons.add(queryCondition);
		}
		return adminPageUserService.getByPage(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), cons);
		
	}
	/**
	 * 删除读者
	 */
	@RequestMapping(value="/DelUser",method=RequestMethod.POST)
	@ResponseBody
	public String delUser(String user_id){
		User user= adminPageUserService.get(user_id);
		if(user==null){
			return "0";
		}else {
			adminPageUserService.delete(user);
			return "1";
		}
	}
	/**
	 * 读者重置密码
	 */
	@RequestMapping(value="/ResetUserPassword",method=RequestMethod.POST)
	@ResponseBody
	public String resetUserPassword(String user_id){
		User user= adminPageUserService.get(user_id);
		if(user==null){
			return "0";
		}else {
			user.setPassword("123456");
			adminPageUserService.update(user);
			return "1";
		}
	}
	
	@RequestMapping(value="/GetAllExpireList",method=RequestMethod.POST)
	@ResponseBody
	public PaginationResponse<HaveBorrowVO> getAllExpireList(){
		List<QueryCondition> cons = new ArrayList<QueryCondition>();
		return adminPageBookService.getHaveExpire(cons);
	}
}

package com.bookmanger.homepage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookmanger.common.model.Book;
import com.bookmanger.common.model.Bulletin;
import com.bookmanger.common.model.News;
import com.bookmanger.common.utils.CompareExpression;
import com.bookmanger.common.utils.MakeCertPic;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.homepage.service.AdministerService;
import com.bookmanger.homepage.service.BookService;
import com.bookmanger.homepage.service.BulletinService;
import com.bookmanger.homepage.service.NewsService;
import com.bookmanger.homepage.service.UserService;
import com.bookmanger.homepage.vo.BookVO;
import com.bookmanger.homepage.vo.HaveBorrowVO;
import com.bookmanger.homepage.vo.MohuCheckConditoonVO;
import com.bookmanger.homepage.vo.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/HomePageTiaoZhuan")
public class TiaoZhuanZhuanYongController {

	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	@Autowired
	BulletinService bulletinService;
	@Autowired
	NewsService newsService;
	@Autowired
	AdministerService administerService;

	@RequestMapping(value = "/Other")
	public String goToOther() {
		return "/homepage/Other";
	}

	@RequestMapping("/CheckBook")
	public String goToCheckBook() {

		return "/homepage/BookCheck";
	}
	/**
	 * 新闻内容
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/GoToNewsContent")
	public String goToNewsContent(Model model,String guid){
		News news=newsService.get(guid);
		model.addAttribute("news", news);
		return "/homepage/NewsContent";
		
	}
	@RequestMapping(value="/GoToBookInfo")
	public String goToBookInfo(Model model,String ISDN){
		if (ISDN != null && !ISDN.equals("")) {
			model.addAttribute("ISDN", ISDN);
		}
		return "/homepage/BookInfo";
		
	}
	@RequestMapping("/JingQueCheck")
	public String goToJingQueCheck(HttpServletRequest request, Model model) {
		String ISDN = request.getParameter("ISDN");
		if (ISDN != null && !ISDN.equals("")) {
			model.addAttribute("ISDN", ISDN);
		}
		return "/homepage/JingQueCheck";
	}

	@RequestMapping("/GoToReaderKnow")
	public String goToReaderKnow() {

		return "/homepage/ReaderKnow";
	}

	/*
	 * 获得读者须知内容 bulletin表第一条数据
	 */
	@RequestMapping(value = "/GetReaderKnow", method = RequestMethod.POST)
	@ResponseBody
	public Bulletin getReaderKnow() {

		return bulletinService.getReaderKnow();
	}

	/**
	 * 忘记密码
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/GotoForgetPassword")
	public String gotoForgetPassword() {

		return "homepage/ForgetPassword";
	}

	@RequestMapping(value = "/zhuCe")
	@ResponseBody
	public String zhuCe(UserVO user) {
		try {
			userService.addUser(user);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}

	@RequestMapping(value = "/FindOneBook", method = RequestMethod.POST)
	@ResponseBody
	public BookVO FindOneBook(String ISDN) {
		BookVO book = bookService.findOneBook(ISDN);
		if (book.getBook_id() != null)
			return book;
		return null;
	}

	/**
	 * 校验当前登录名/邮箱的唯一性
	 * 
	 * @param loginName
	 *            登录名
	 * @param userId
	 *            用户ID（用户已经存在，即又改回原来的名字还是唯一的）
	 * @return
	 */
	@RequestMapping(value = "/checkExist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String checkExist(HttpServletResponse response,
			HttpServletRequest request) {
		String phone = request.getParameter("phone");
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		UserVO user = userService.checkExist(phone);
		// 用户不存在，校验有效
		if ("".equals(user.getUser_id())) {
			map.put("valid", true);
		} else {
			map.put("valid", false);
		}
		ObjectMapper mapper = new ObjectMapper();
		String resultString = "";
		try {
			resultString = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return resultString;
	}

	@RequestMapping(value = "/BookList", method = RequestMethod.POST)
	@ResponseBody
	public PaginationResponse<Book> BookList(MohuCheckConditoonVO mo,
			HttpServletRequest request) {

		String pageNumber = request.getParameter("offset");
		String pageSize = request.getParameter("limit");
		if (pageNumber == null) {
			pageNumber = "1";
		}
		if (pageSize == null) {
			pageSize = "5";
		}
		QueryCondition queryCondition = null;
		List<QueryCondition> cons = new ArrayList<QueryCondition>();

		// 添加查询条件
		if (mo.getAuthor() != null && !mo.getAuthor().equals("")) {
			queryCondition = new QueryCondition(CompareExpression.Like,
					"author", mo.getAuthor());
			cons.add(queryCondition);
		}
		if (mo.getBook_name() != null && !mo.getBook_name().equals("")) {
			queryCondition = new QueryCondition(CompareExpression.Like,
					"book_name", mo.getBook_name());
			cons.add(queryCondition);
		}
		if (mo.getInclude() != null && !mo.getInclude().equals("--请选择--")) {
			queryCondition = new QueryCondition(CompareExpression.Like,
					"include", mo.getInclude());
			cons.add(queryCondition);
		}
		if (mo.getPrinter() != null && !mo.getPrinter().equals("")) {
			queryCondition = new QueryCondition(CompareExpression.Like,
					"printer", mo.getPrinter());
			cons.add(queryCondition);
		}
		if (!cons.isEmpty())
			return bookService.getBookList(pageNumber, pageSize, cons);
		return null;
	}

	/**
	 * 公告分页
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/BulletinFenYe", method = RequestMethod.POST)
	@ResponseBody
	public PaginationResponse<HaveBorrowVO> otherFenYe(HttpServletRequest request) {
		String pageNumber = request.getParameter("offset");
		String pageSize = request.getParameter("limit");
		if (pageNumber == null) {
			pageNumber = "0";
		}
		if (pageSize == null) {
			pageSize = "5";
		}
		List<QueryCondition> cons = new ArrayList<QueryCondition>();
		return bookService.getHaveExpire(cons,pageNumber,pageSize);
	}

	/**
	 * 新闻分页
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping(value = "/NewsFenYe", method = RequestMethod.POST)
	@ResponseBody
	public PaginationResponse<News> newsFenYe(String id) {
		String pageNumber = ((Integer.parseInt(id) - 1) * 5) + "";// 从哪一条开始
		String pageSize = "5";// 一次五条数据
		List<QueryCondition> cons = new ArrayList<QueryCondition>();
		return newsService.getOtherList(pageNumber, pageSize, cons);
	}

	/**
	 * 新书推荐分页
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/NewBooksFenYe", method = RequestMethod.POST)
	@ResponseBody
	public PaginationResponse<Book> newBooksFenYe(String id) {
		String pageNumber = ((Integer.parseInt(id) - 1) * 12) + "";// 从哪一条开始
		String pageSize = "12";// 一次12条数据
		List<QueryCondition> cons = new ArrayList<QueryCondition>();
		return bookService.getBookList(pageNumber, pageSize, cons);
	}

	/**
	 * 找回密码
	 * 
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/FindPassword", method = RequestMethod.POST)
	@ResponseBody
	public String findPassword(UserVO vo) {

		return userService.checkFindPassword(vo);

	}

	/**
	 * 验证码生成
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/GetYanZhengMa")
	@ResponseBody
	public void getYanZhengMa(HttpServletResponse response, HttpSession session)
			throws IOException {
		String str = MakeCertPic.getCerPic(0, 0, response.getOutputStream());
		session.setAttribute("YanZhengCode", str);

	}

	/**
	 * 验证码获取
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/GetSession", method = RequestMethod.POST)
	@ResponseBody
	public String getYZSession(HttpSession session) {
		String str = session.getAttribute("YanZhengCode").toString();
		return str;

	}

	/**
	 * 登录验证
	 * 
	 * @param user_id
	 * @param loginPassword
	 * @return
	 */
	@RequestMapping(value = "/LoginYanZheng", method = RequestMethod.POST)
	@ResponseBody
	public String loginYanZheng(String user_id, String loginPassword,
			HttpSession session) {
		boolean result = false;
		if (user_id.length() == 11) {
			result = userService.checkUser_id(user_id, loginPassword);
			if (result) {
				session.setAttribute("user_id", user_id);
				return "1";
			}

		} else if (user_id.length() == 7) {
			result = administerService.checkUser_id(user_id, loginPassword);
			if (result) {
				session.setAttribute("user_id", user_id);
				return "2";
			}
		}

		return "0";

	}
/**
 * 跳转到读者页面
 * @param session
 * @return
 */
	@RequestMapping("/GoToUserPage")
	public String goToUserPage(HttpSession session) {
		String str=(String) session.getAttribute("user_id");
		//判断是否登录，未登录不允许进入
		if(str!=null&&!str.equals("")&&str.length()==11)
		return "/userpage/UserPage";
		else
		return "/adminpage/AdminPage";
	}
}

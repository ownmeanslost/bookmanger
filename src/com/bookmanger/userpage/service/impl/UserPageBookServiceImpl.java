package com.bookmanger.userpage.service.impl;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanger.common.model.BorrowList;
import com.bookmanger.common.model.Borrow_lab;
import com.bookmanger.common.model.UserList;
import com.bookmanger.common.utils.DateTransfor;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.userpage.dao.UserPageBookDao;
import com.bookmanger.userpage.dao.UserPageBorrowLabDao;
import com.bookmanger.userpage.dao.UserPageBorrowListDao;
import com.bookmanger.userpage.dao.UserPageUserListDao;
import com.bookmanger.userpage.service.UserPageBookService;
import com.bookmanger.userpage.vo.BorrowInfoVO;
import com.bookmanger.userpage.vo.HaveBorrowVO;

public class UserPageBookServiceImpl implements UserPageBookService {

	@Autowired
	UserPageBookDao userPageBookDao;
	@Autowired
	UserPageBorrowLabDao userPageBorrowLabDao;
	@Autowired
	UserPageBorrowListDao userPageBorrowListDao;
	@Autowired
	UserPageUserListDao userPageUserListDao;

	@Override
	public PaginationResponse<HaveBorrowVO> getHaveBorrow(
			List<QueryCondition> cons) {

		return userPageBookDao.getHaveBorrow(cons);
	}

	@Override
	public PaginationResponse<HaveBorrowVO> getHaveExpire(
			List<QueryCondition> cons) {
		PaginationResponse<HaveBorrowVO> pa = userPageBookDao
				.getHaveBorrow(cons);
		// 删除借阅天数大于等于0的
		for (int i = 0; i < pa.getRows().size(); i++) {
			if (Integer.parseInt((pa.getRows().get(i).getRemainingTime())) >= 0) {
				pa.getRows().remove(i);
				i = i - 1;
				pa.setTotal(pa.getTotal() - 1);
			}

		}
		return pa;
	}

	/**
	 * 读者借书
	 * 
	 * @param ISDN
	 * @return
	 */
	@Override
	public BorrowInfoVO userBorrow(String ISDN, List<QueryCondition> cons,
			String user_id) {
		BorrowInfoVO bo = new BorrowInfoVO();
		PaginationResponse<HaveBorrowVO> pa = userPageBookDao
				.getHaveBorrow(cons);
		int result = 1;
		// 判断库存
		Borrow_lab bol = userPageBorrowLabDao.get(ISDN);
		if (bol.getKucun() <= 0)
			result = 3;
		// 判断是否达到借书上限
		if (pa.getTotal() == 5) {
			result = 4;
		}
		// 判断是否借过这本书
		for (HaveBorrowVO ha : pa.getRows()) {
			if (ha.getIsdn().equals(ISDN)) {
				result = 2;
				break;
			}

		}
		// 可以借
		if (result == 1) {
			bol.setKucun(bol.getKucun() - 1);
			Date d = DateTransfor.getNowDateAsDate();
			// 更改库存
			userPageBorrowLabDao.update(bol);
			// 插入借阅清单
			Serializable borrow_listnum = insertBorrowList(ISDN, user_id,d);
			// 更改读者借阅清单
			upDatUserList(user_id, borrow_listnum,d);
			bo.setReturnTime(DateTransfor.addordecDayAsDate(+15,d));
		}
		
		bo.setResult(result + "");
		return bo;
	}

	/**
	 * 插入借阅清单
	 */
	public Serializable insertBorrowList(String ISDN, String user_id,Date d) {
		
		BorrowList borrowList = new BorrowList();
		borrowList.setBook_id(ISDN);
		borrowList.setUser_id(user_id);
		borrowList.setBorrow_time(d);
		borrowList.setReturn_time(DateTransfor.addordecDayAsDate(+15,d));
		Serializable result = userPageBorrowListDao.save(borrowList);
		return result;
	}

	/**
	 * 更改读者借阅清单
	 * 
	 */
	public void upDatUserList(String user_id, Serializable borrow_listnum,Date d) {
		UserList userList = userPageUserListDao.get(user_id);
		String str = "borrow_listnum";
		String num = "";
		for (int i = 1; i <= 5; i++) {
			num = str + i;
			if (userList.isNullBorrowListNum(num) == null)
				break;

		}
		userList.setBorrow_list(num, (Integer) borrow_listnum);
		userList.setBorrow_num(userList.getBorrow_num() + 1);
		userPageUserListDao.update(userList);
	}
}

package com.bookmanger.common.utils;

import java.util.ArrayList;
import java.util.List;

public class PaginationResponse<T> {

	 /// <summary>
    ///总纪录数[返回值]
    /// </summary>
    private int total;
	
    private List<T> rows = new ArrayList<T>();
   



	public int getTotal() {
		return total;
	}

	public void setTotal(int recordCount) {
		this.total = recordCount;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> returnResult) {
		this.rows = returnResult;
	}
}

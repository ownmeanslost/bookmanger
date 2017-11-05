package com.bookmanger.common.utils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class QueryCondition {
	private CompareExpression compareExpression = CompareExpression.Eq;

	// / <summary>
	// / 字段
	// / </summary>
	private String field;

	// / <summary>
	// / 比较值1
	// / </summary>
	private Object value1;

	// / <summary>
	// / 比较值2
	// / </summary>
	private Object value2;
	
	/**
	 * 是否是数字类型
	 * 影响toString方法
	 */
	private boolean numFlag = false;
	
	public QueryCondition(CompareExpression compare, String field, Object value1) {
		this(compare, field, value1, "");
	}

	public QueryCondition(CompareExpression compare, String field, Object value1, Object value2) {
		this.compareExpression = compare;
		this.field = field;
		this.value1 = value1;
		this.value2 = value2;
	}
	

	public QueryCondition copy(){
		QueryCondition nCondition = new QueryCondition(this.compareExpression, this.field, this.value1, this.value2);
		nCondition.numFlag = this.numFlag;
		
		return nCondition;
	}

	public static QueryCondition eq(String field, Object value) {
		return new QueryCondition(CompareExpression.Eq, field, value);
	}
	
	public static QueryCondition eq(String field, Object value, boolean isNum) {
		QueryCondition queryCondition = new QueryCondition(CompareExpression.Eq, field, value);
		queryCondition.setNumFlag(isNum);
		return queryCondition;
	}

	public static QueryCondition notEq(String field, Object value) {
		return new QueryCondition(CompareExpression.NotEq, field, value);
	}
	
	public static QueryCondition notEq(String field, Object value, boolean isNum) {
		QueryCondition queryCondition = new QueryCondition(CompareExpression.NotEq, field, value);
		queryCondition.setNumFlag(isNum);
		return queryCondition;
	}
	
	public static QueryCondition in(String field, Collection<?> values) {
		Object[] objs = values.toArray();
		QueryCondition queryCondition = new QueryCondition(CompareExpression.In, field, objs);
		return queryCondition;
	}

	public static QueryCondition in(String field, Collection<?> values, boolean isNum) {
		Object[] objs = values.toArray();
		QueryCondition queryCondition = new QueryCondition(CompareExpression.In, field, objs);
		queryCondition.setNumFlag(isNum);
		return queryCondition;
	}

	public static QueryCondition in(String field, String[] values) {
		return new QueryCondition(CompareExpression.In, field, values);
	}
	
	public static QueryCondition in(String field, String[] values, boolean isNum) {
		QueryCondition queryCondition = new QueryCondition(CompareExpression.In, field, values);
		queryCondition.setNumFlag(isNum);
		return queryCondition;
	}

	public static QueryCondition between(String field, Object value1, Object value2) {
		return new QueryCondition(CompareExpression.Between, field, value1, value2);
	}
	
	public static QueryCondition between(String field, Object value1, Object value2, boolean isNum) {
		QueryCondition queryCondition =  new QueryCondition(CompareExpression.Between, field, value1, value2);
		queryCondition.setNumFlag(isNum);
		return queryCondition;
	}

	public static QueryCondition notNull(String field) {
		return new QueryCondition(CompareExpression.NotNull, field, "");
	}

	public static QueryCondition isNull(String field) {
		return new QueryCondition(CompareExpression.IsNull, field, "");
	}

	public static QueryCondition like(String field, String str) {
		return new QueryCondition(CompareExpression.Like, field, str);
	}

	public static QueryCondition likeEnd(String field, String str) {
		return new QueryCondition(CompareExpression.LikeEnd, field, str);
	}

	public static QueryCondition likeBegin(String field, String str) {
		return new QueryCondition(CompareExpression.LikeBegin, field, str);
	}

	public static QueryCondition gt(String field, long value) {
		return new QueryCondition(CompareExpression.Gt, field, value);
	}

	public static QueryCondition ge(String field, long value) {
		return new QueryCondition(CompareExpression.Ge, field, value);
	}

	public static QueryCondition le(String field, long value) {
		return new QueryCondition(CompareExpression.Le, field, value);
	}

	public static QueryCondition lt(String field, long value) {
		return new QueryCondition(CompareExpression.Lt, field, value);
	}

	public static QueryCondition gt(String field, int value) {
		return new QueryCondition(CompareExpression.Gt, field, value);
	}
	
	public static QueryCondition gt(String field, Date value)
	{
		return new QueryCondition(CompareExpression.Gt, field, value);
	}
	public static QueryCondition ge(String field, Date value) {
		return new QueryCondition(CompareExpression.Ge, field, value);
	}

	public static QueryCondition ge(String field, int value) {
		return new QueryCondition(CompareExpression.Ge, field, value);
	}

	public static QueryCondition le(String field, int value) {
		return new QueryCondition(CompareExpression.Le, field, value);
	}

	public static QueryCondition lt(String field, int value) {
		return new QueryCondition(CompareExpression.Lt, field, value);
	}
	
	public static QueryCondition le(String field, Date value) {
		return new QueryCondition(CompareExpression.Le, field, value);
	}

	public static QueryCondition lt(String field, Date value) {
		return new QueryCondition(CompareExpression.Lt, field, value);
	}

	public static QueryCondition lt(String field, BigDecimal value) {
		return new QueryCondition(CompareExpression.Lt, field, value);
	}

	public static QueryCondition gt(String field, BigDecimal value) {
		return new QueryCondition(CompareExpression.Gt, field, value);
	}

	public static QueryCondition and(QueryCondition condition1, QueryCondition condition2) {
		return new QueryCondition(CompareExpression.And, "", condition1, condition2);
	}

	public static QueryCondition and(QueryCondition condition1, QueryCondition condition2, QueryCondition... conditions) {
		QueryCondition condition = new QueryCondition(CompareExpression.And, "", condition1, condition2);
		for (int i = 0; i < conditions.length; i++) {
			condition = new QueryCondition(CompareExpression.And, "", condition, conditions[i]);
		}

		return condition;
	}

	public static QueryCondition or(QueryCondition condition1, QueryCondition condition2, QueryCondition... conditions) {

		QueryCondition condition = new QueryCondition(CompareExpression.Or, "", condition1, condition2);
		for (int i = 0; i < conditions.length; i++) {
			condition = new QueryCondition(CompareExpression.Or, "", condition, conditions[i]);
		}

		return condition;
	}
	
	public static QueryCondition or(List<QueryCondition> cons) {
		int size = cons.size();
		if (size < 2) {
			return cons.get(0);
		}
		QueryCondition condition = new QueryCondition(CompareExpression.Or, "", cons.get(0), cons.get(1));
		for (int i = 2; i < size; i++) {
			condition = new QueryCondition(CompareExpression.Or, "", condition, cons.get(i));
		}

		return condition;
	}

	public static QueryCondition not(QueryCondition condition) {
		return new QueryCondition(CompareExpression.Not, "", condition);
	}

	public CompareExpression getCompareExpression() {
		return compareExpression;
	}

	public void setCompareExpression(CompareExpression compareExpression) {
		this.compareExpression = compareExpression;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getValue1() {
		return value1;
	}

	public void setValue1(Object value1) {
		this.value1 = value1;
	}

	public Object getValue2() {
		return value2;
	}

	public void setValue2(Object value2) {
		this.value2 = value2;
	}

	public String toString() {
		switch (getCompareExpression()) {
		case Eq:
			if(this.numFlag){
				return getField() + "=" + getValue1().toString() + "";
			} else{
				return getField() + "='" + getValue1().toString() + "'";
			}
		case NotEq:
			if(this.numFlag){
				return getField() + "<>" + getValue1().toString() + "";
			}else{
				return getField() + "<>'" + getValue1().toString() + "'";
			}
		case Like:
			return getField() + " LIKE '%" + getValue1().toString() + "%'";
		case LikeBegin:
			return getField() + " LIKE '" + getValue1().toString() + "%'";
		case LikeEnd:
			return getField() + " LIKE '%" + getValue1().toString() + "'";
		case Lt:
			return getField() + "<" + getValue1().toString() + "";
		case Ge:
			return getField() + ">=" + getValue1().toString() + "";
		case Gt:
			return getField() + ">" + getValue1().toString() + "";
		case IsNull:
			return getField() + " IS NULL";
		case NotNull:
			return getField() + " IS NOT NULL";
		case And:
			QueryCondition condition1 = (QueryCondition) getValue1();
			QueryCondition condition2 = (QueryCondition) getValue2();
			return "((" + condition1.toString() + ") AND (" + condition2.toString() + "))";
		case Or:
			QueryCondition condition3 = (QueryCondition) getValue1();
			QueryCondition condition4 = (QueryCondition) getValue2();
			return "((" + condition3.toString() + ") OR (" + condition4.toString() + "))";
		case Not:
			QueryCondition condition5 = (QueryCondition) getValue1();
			return "(NOT (" + condition5.toString() + "))";
		default:
			return "";
		}
	}

	public boolean isNumFlag() {
		return numFlag;
	}

	public void setNumFlag(boolean numFlag) {
		this.numFlag = numFlag;
	}
}

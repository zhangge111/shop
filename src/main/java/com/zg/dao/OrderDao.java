package com.zg.dao;

import com.zg.beans.Pager;
import com.zg.entity.Member;
import com.zg.entity.Order;

/*
* @author gez
* @version 0.1
*/

public interface OrderDao extends BaseDao<Order, String> {

	public String getLastOrderSn();

	public Pager<Order> getOrderPager(Member member, Pager<Order> pager);

	public Long getUnprocessedOrderCount();

	public Long getPaidUnshippedOrderCount();

}

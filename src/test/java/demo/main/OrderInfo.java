package demo.main;

import java.util.List;

public class OrderInfo {

	private String orderSn;
	private String goodsName;
	private String size;
	private String num;
	private List<OrderInfo> tableData;

	public OrderInfo() {
	}

	public OrderInfo(String orderSn, String goodsName, String size, String num) {
		this.orderSn = orderSn;
		this.goodsName = goodsName;
		this.size = size;
		this.num = num;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public List<OrderInfo> getTableData() {
		return tableData;
	}

	public void setTableData(List<OrderInfo> tableData) {
		this.tableData = tableData;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderSn=" + orderSn + ", goodsName=" + goodsName + ", size=" + size + ", num=" + num + "]";
	}



}

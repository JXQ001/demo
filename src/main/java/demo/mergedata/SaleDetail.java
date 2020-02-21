package demo.mergedata;

import java.io.Serializable;

public class SaleDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;// 主键
	private String orderNo;// 订单号
	private String goodsCode;// 商品编号
	private String saleTotal;// 销售量
	private String price;// 商品单价
	private String venderId;// 商家编码
	private String source;// 订单来源

	public SaleDetail() {
	}

	public SaleDetail(String id, String orderNo, String goodsCode, String saleTotal, String price, String venderId,
			String source) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.goodsCode = goodsCode;
		this.saleTotal = saleTotal;
		this.price = price;
		this.venderId = venderId;
		this.source = source;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getSaleTotal() {
		return saleTotal;
	}

	public void setSaleTotal(String saleTotal) {
		this.saleTotal = saleTotal;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getVenderId() {
		return venderId;
	}

	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((venderId == null) ? 0 : venderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleDetail other = (SaleDetail) obj;
		if (orderNo == null) {
			if (other.orderNo != null)
				return false;
		} else if (!orderNo.equals(other.orderNo))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (venderId == null) {
			if (other.venderId != null)
				return false;
		} else if (!venderId.equals(other.venderId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SaleDetail [id=" + id + ", orderNo=" + orderNo + ", goodsCode=" + goodsCode + ", saleTotal=" + saleTotal
				+ ", price=" + price + ", venderId=" + venderId + ", source=" + source + "]";
	}

	
}

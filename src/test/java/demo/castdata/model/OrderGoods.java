package demo.castdata.model;

import java.util.List;


public class OrderGoods {
	private String orderSn;
	private String goodsName;
	private String goodsStyle;
	private String goodsNumbers;
	private String sizeType;
	private List<Size> sizes;
	public OrderGoods() {
	}
	public OrderGoods(String orderSn, String goodsName, String goodsStyle, String goodsNumbers, String sizeType,
			List<Size> sizes) {
		this.orderSn = orderSn;
		this.goodsName = goodsName;
		this.goodsStyle = goodsStyle;
		this.goodsNumbers = goodsNumbers;
		this.sizeType = sizeType;
		this.sizes = sizes;
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
	public String getGoodsStyle() {
		return goodsStyle;
	}
	public void setGoodsStyle(String goodsStyle) {
		this.goodsStyle = goodsStyle;
	}
	public String getGoodsNumbers() {
		return goodsNumbers;
	}
	public void setGoodsNumbers(String goodsNumbers) {
		this.goodsNumbers = goodsNumbers;
	}
	public String getSizeType() {
		return sizeType;
	}
	public void setSizeType(String sizeType) {
		this.sizeType = sizeType;
	}
	public List<Size> getSizes() {
		return sizes;
	}
	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + ((goodsNumbers == null) ? 0 : goodsNumbers.hashCode());
		result = prime * result + ((goodsStyle == null) ? 0 : goodsStyle.hashCode());
		result = prime * result + ((sizeType == null) ? 0 : sizeType.hashCode());
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
		OrderGoods other = (OrderGoods) obj;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (goodsNumbers == null) {
			if (other.goodsNumbers != null)
				return false;
		} else if (!goodsNumbers.equals(other.goodsNumbers))
			return false;
		if (goodsStyle == null) {
			if (other.goodsStyle != null)
				return false;
		} else if (!goodsStyle.equals(other.goodsStyle))
			return false;
		if (sizeType == null) {
			if (other.sizeType != null)
				return false;
		} else if (!sizeType.equals(other.sizeType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SourceObj [orderSn=" + orderSn + ", goodsName=" + goodsName + ", goodsStyle=" + goodsStyle
				+ ", goodsNumbers=" + goodsNumbers + ", sizeType=" + sizeType + ", sizes=" + sizes + "]";
	}
	
}

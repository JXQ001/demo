package demo.castdata.model;

public class SourceObj {
	private String orderSn;
	private String goodsName;
	private String goodsStyle;
	private String goodsNumbers;
	private String sizeType;
	private String sizeName;
	private String sizeNum;
	private String schoolName;
	
	public SourceObj() {
	}

	public SourceObj(String orderSn, String goodsName, String goodsStyle, String goodsNumbers, String sizeType,
			String sizeName, String sizeNum, String schoolName) {
		this.orderSn = orderSn;
		this.goodsName = goodsName;
		this.goodsStyle = goodsStyle;
		this.goodsNumbers = goodsNumbers;
		this.sizeType = sizeType;
		this.sizeName = sizeName;
		this.sizeNum = sizeNum;
		this.schoolName = schoolName;
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
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public String getSizeNum() {
		return sizeNum;
	}
	public void setSizeNum(String sizeNum) {
		this.sizeNum = sizeNum;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Override
	public String toString() {
		return "SourceObj [orderSn=" + orderSn + ", goodsName=" + goodsName + ", goodsStyle=" + goodsStyle
				+ ", goodsNumbers=" + goodsNumbers + ", sizeType=" + sizeType + ", sizeName=" + sizeName + ", sizeNum="
				+ sizeNum + ", schoolName=" + schoolName + "]";
	}

}

package demo.easyexcel;

import java.util.List;

public class Goods {
	private String goodsName;
	private String goodsStyle;
	private String goodsNumber;
	private String goodsSizeType;
	private List<School> schools;
	public Goods() {
	}
	
	public Goods(String goodsName, String goodsStyle, String goodsNumber, String goodsSizeType, List<School> schools) {
		super();
		this.goodsName = goodsName;
		this.goodsStyle = goodsStyle;
		this.goodsNumber = goodsNumber;
		this.goodsSizeType = goodsSizeType;
		this.schools = schools;
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
	public String getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getGoodsSizeType() {
		return goodsSizeType;
	}
	public void setGoodsSizeType(String goodsSizeType) {
		this.goodsSizeType = goodsSizeType;
	}
	public List<School> getSchools() {
		return schools;
	}
	public void setSchools(List<School> schools) {
		this.schools = schools;
	}
	@Override
	public String toString() {
		return "Goods [goodsName=" + goodsName + ", goodsStyle=" + goodsStyle + ", goodsNumber=" + goodsNumber
				+ ", goodsSizeType=" + goodsSizeType + ", schools=" + schools + "]";
	}
	
}

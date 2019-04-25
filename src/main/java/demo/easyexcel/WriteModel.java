package demo.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class WriteModel extends BaseRowModel {

	@ExcelProperty(value = { "零售商品生产明细表", "商品名称" }, index = 0)
	private String title1;

	@ExcelProperty(value = { "零售商品生产明细表", "款式" }, index = 1)
	private String title2;

	@ExcelProperty(value = { "零售商品生产明细表", "款号" }, index = 2)
	private String title3;

	@ExcelProperty(value = { "零售商品生产明细表", "尺码类型" }, index = 3)
	private String title4;

	@ExcelProperty(value = { "零售商品生产明细表", "学校名称" }, index = 4)
	private String title5;

	@ExcelProperty(value = { "零售商品生产明细表", "尺码规格" }, index = 5)
	private String title6;

	@ExcelProperty(value = { "零售商品生产明细表", "数量" }, index = 6)
	private String title7;

	public WriteModel() {
	}

	public WriteModel(String title1, String title2, String title3, String title4, String title5, String title6,
			String title7) {
		this.title1 = title1;
		this.title2 = title2;
		this.title3 = title3;
		this.title4 = title4;
		this.title5 = title5;
		this.title6 = title6;
		this.title7 = title7;
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getTitle3() {
		return title3;
	}

	public void setTitle3(String title3) {
		this.title3 = title3;
	}

	public String getTitle4() {
		return title4;
	}

	public void setTitle4(String title4) {
		this.title4 = title4;
	}

	public String getTitle5() {
		return title5;
	}

	public void setTitle5(String title5) {
		this.title5 = title5;
	}

	public String getTitle6() {
		return title6;
	}

	public void setTitle6(String title6) {
		this.title6 = title6;
	}

	public String getTitle7() {
		return title7;
	}

	public void setTitle7(String title7) {
		this.title7 = title7;
	}

}

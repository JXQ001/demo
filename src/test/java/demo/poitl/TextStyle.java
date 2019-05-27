package demo.poitl;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc.Enum;

import com.deepoove.poi.data.style.Style;

public class TextStyle extends Style {

	/**
	 * 背景色
	 */
	private String backgroundColor;

	/**
	 * 对齐方式 STJc.LEFT 左对齐 STJc.CENTER 居中对齐 STJc.RIGHT 右对齐
	 */
	private STJc.Enum align;

	public TextStyle() {
		super();
	}

	public TextStyle(String fontFamily, int fontSize) {
		super(fontFamily, fontSize);
	}

	public TextStyle(String color) {
		super(color);
	}

	public TextStyle(String backgroundColor, Enum align) {
		super();
		this.backgroundColor = backgroundColor;
		this.align = align;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public STJc.Enum getAlign() {
		return align;
	}

	public void setAlign(STJc.Enum align) {
		this.align = align;
	}

}

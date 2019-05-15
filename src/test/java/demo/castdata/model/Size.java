package demo.castdata.model;

import java.util.List;

public class Size {
	private String sizeName;
	private String sizeNum;
	private List<School> schools;

	public Size() {
	}

	public Size(String sizeName, String sizeNum, List<School> schools) {
		this.sizeName = sizeName;
		this.sizeNum = sizeNum;
		this.schools = schools;
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

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

	@Override
	public String toString() {
		return "Size [sizeName=" + sizeName + ", sizeNum=" + sizeNum + ", schools=" + schools + "]";
	}
	
}

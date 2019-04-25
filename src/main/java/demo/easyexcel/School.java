package demo.easyexcel;

import java.util.List;

public class School {

	private String schoolName;
	private List<Size> sizes;

	public School() {
	}

	public School(String schoolName, List<Size> sizes) {
		this.schoolName = schoolName;
		this.sizes = sizes;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public List<Size> getSizes() {
		return sizes;
	}

	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}

	@Override
	public String toString() {
		return "School [schoolName=" + schoolName + ", sizes=" + sizes + "]";
	}

}

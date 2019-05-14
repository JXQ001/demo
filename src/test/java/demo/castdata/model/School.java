package demo.castdata.model;

public class School {

	private String schoolName;

	public School() {
	}

	public School(String schoolName) {
		this.schoolName = schoolName;
	}


	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Override
	public String toString() {
		return "School [schoolName=" + schoolName + "]";
	}
	
	
}

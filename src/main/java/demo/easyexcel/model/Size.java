package demo.easyexcel.model;

public class Size {

	private String sizeName;
	private String sizeTotal;

	public Size() {
	}

	public Size(String sizeName, String sizeTotal) {
		this.sizeName = sizeName;
		this.sizeTotal = sizeTotal;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public String getSizeTotal() {
		return sizeTotal;
	}

	public void setSizeTotal(String sizeTotal) {
		this.sizeTotal = sizeTotal;
	}

	@Override
	public String toString() {
		return "Size [sizeName=" + sizeName + ", sizeTotal=" + sizeTotal + "]";
	}

}

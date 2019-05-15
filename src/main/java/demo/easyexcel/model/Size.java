package demo.easyexcel.model;

public class Size {


    private String sizeName;
    private Integer sizeTotal = 1;

    public Size() {
    }

    public Size(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Integer getSizeTotal() {
        return sizeTotal;
    }

    public void setSizeTotal(Integer sizeTotal) {
        this.sizeTotal = sizeTotal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sizeName == null) ? 0 : sizeName.hashCode());
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
        Size other = (Size) obj;
        if (sizeName == null) {
            if (other.sizeName != null)
                return false;
        } else if (!sizeName.equals(other.sizeName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Size [sizeName=" + sizeName + ", sizeTotal=" + sizeTotal + "]";
    }

}

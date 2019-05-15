package demo.easyexcel.model;

import java.util.List;

public class School {


    private String schoolName;
    private List<Size> sizes;

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
        result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
        result = prime * result + ((sizes == null) ? 0 : sizes.hashCode());
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
        School other = (School) obj;
        if (schoolName == null) {
            if (other.schoolName != null)
                return false;
        } else if (!schoolName.equals(other.schoolName))
            return false;
        if (sizes == null) {
            if (other.sizes != null)
                return false;
        } else if (!sizes.equals(other.sizes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "School [schoolName=" + schoolName + ", sizes=" + sizes + "]";
    }
}

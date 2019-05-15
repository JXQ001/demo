package demo.easyexcel.model;

import java.util.List;

public class Goods {

    private String goodsName;
    private String goodsStyle;
    private String goodsNumbers;
    private String goodsSizeType;
    private List<School> schools;

    public Goods() {
    }

    public Goods(String goodsName, String goodsStyle, String goodsNumbers, String goodsSizeType) {
        this.goodsName = goodsName;
        this.goodsStyle = goodsStyle;
        this.goodsNumbers = goodsNumbers;
        this.goodsSizeType = goodsSizeType;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
        result = prime * result + ((goodsNumbers == null) ? 0 : goodsNumbers.hashCode());
        result = prime * result + ((goodsSizeType == null) ? 0 : goodsSizeType.hashCode());
        result = prime * result + ((goodsStyle == null) ? 0 : goodsStyle.hashCode());
        result = prime * result + ((schools == null) ? 0 : schools.hashCode());
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
        Goods other = (Goods) obj;
        if (goodsName == null) {
            if (other.goodsName != null)
                return false;
        } else if (!goodsName.equals(other.goodsName))
            return false;
        if (goodsNumbers == null) {
            if (other.goodsNumbers != null)
                return false;
        } else if (!goodsNumbers.equals(other.goodsNumbers))
            return false;
        if (goodsSizeType == null) {
            if (other.goodsSizeType != null)
                return false;
        } else if (!goodsSizeType.equals(other.goodsSizeType))
            return false;
        if (goodsStyle == null) {
            if (other.goodsStyle != null)
                return false;
        } else if (!goodsStyle.equals(other.goodsStyle))
            return false;
        if (schools == null) {
            if (other.schools != null)
                return false;
        } else if (!schools.equals(other.schools))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Goods [goodsName=" + goodsName + ", goodsStyle=" + goodsStyle + ", goodsNumbers=" + goodsNumbers + ", goodsSizeType=" + goodsSizeType + ", schools=" + schools + "]";
    }
}

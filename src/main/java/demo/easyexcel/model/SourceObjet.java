package demo.easyexcel.model;

/**
 * @author jiangxiuqiang
 * @version 1.0
 * @ClassName:SourceObjet
 * @Description:
 * @date 2019/5/15 14:07
 */
public class SourceObjet {

    private String goodsName;
    private String goodsStyle;
    private String goodsNumbers;
    private String goodsSizeType;
    private String schoolName;
    private String sizeName;

    public SourceObjet() {
    }

    public SourceObjet(String goodsName, String goodsStyle, String goodsNumbers, String goodsSizeType, String schoolName, String sizeName) {
        this.goodsName = goodsName;
        this.goodsStyle = goodsStyle;
        this.goodsNumbers = goodsNumbers;
        this.goodsSizeType = goodsSizeType;
        this.schoolName = schoolName;
        this.sizeName = sizeName;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
        result = prime * result + ((goodsNumbers == null) ? 0 : goodsNumbers.hashCode());
        result = prime * result + ((goodsSizeType == null) ? 0 : goodsSizeType.hashCode());
        result = prime * result + ((goodsStyle == null) ? 0 : goodsStyle.hashCode());
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
        SourceObjet other = (SourceObjet) obj;
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
        return true;
    }

    @Override
    public String toString() {
        return "SourceObjet [goodsName=" + goodsName + ", goodsStyle=" + goodsStyle + ", goodsNumbers=" + goodsNumbers + ", goodsSizeType=" + goodsSizeType + ", schoolName=" + schoolName + ", sizeName=" + sizeName + "]";
    }
}

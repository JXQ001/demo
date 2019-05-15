package demo.poitl;

import com.deepoove.poi.data.PictureRenderData;

/**
 * @author jiangxiuqiang
 * @version 1.0
 * @ClassName:SegmentData
 * @Description:
 * @date 2019/4/29 9:09
 */
public class SegmentData {
    private String title;
    private String content;
    private PictureRenderData picture;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PictureRenderData getPicture() {
        return picture;
    }

    public void setPicture(PictureRenderData picture) {
        this.picture = picture;
    }
}

package demo.easyexcel.model;

import java.util.List;

/**
 * @author jiangxiuqiang
 * @version 1.0
 * @ClassName:RenderData
 * @Description:
 * @date 2019/5/15 14:05
 */
public class RenderData {


    private List<WriteModel> writeModels;
    private List<Merge> merges;

    public RenderData() {
    }

    public RenderData(List<WriteModel> writeModels, List<Merge> merges) {
        this.writeModels = writeModels;
        this.merges = merges;
    }

    public List<WriteModel> getWriteModels() {
        return writeModels;
    }

    public void setWriteModels(List<WriteModel> writeModels) {
        this.writeModels = writeModels;
    }

    public List<Merge> getMerges() {
        return merges;
    }

    public void setMerges(List<Merge> merges) {
        this.merges = merges;
    }

    @Override
    public String toString() {
        return "RenderData [writeModels=" + writeModels + ", merges=" + merges + "]";
    }

}

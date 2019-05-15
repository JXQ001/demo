package demo.easyexcel;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;

import demo.easyexcel.model.Goods;
import demo.easyexcel.model.Merge;
import demo.easyexcel.model.RenderData;
import demo.easyexcel.model.School;
import demo.easyexcel.model.Size;
import demo.easyexcel.model.SourceObjet;
import demo.easyexcel.model.WriteModel;

public class Main {

    public static void main(String[] args) throws Exception {

        /**
         * 初始化业务数据
         */
        List<SourceObjet> sourceObjets = initData();

        /**
         * 将业务数据转换为层级数据
         */
        List<Goods> goodsList = castSourceObjectToGoodsList(sourceObjets);

        /**
         * 使用层级数据初始化渲染数据
         */
        RenderData renderData = initRenderData(goodsList);

        /**
         * 执行渲染生成excel
         */
        String file = "C:\\Users\\Administrator\\Desktop\\零售商品生产明细表.xlsx";
        generateExcel(renderData, file);
    }

    /**
     * castSourceObjectToGoodsList:(将业务数据转换为层级数据). <br/>
     *
     * @author jxq
     * @param sourceObjets
     * @return
     * @since JDK 1.8.0
     */
    private static List<Goods> castSourceObjectToGoodsList(List<SourceObjet> sourceObjets) {
        try {
            Map<Goods, List<SourceObjet>> goodsMap = new HashMap<>();
            // 1.合并商品名称、款式、款号、尺码类型
            for (SourceObjet sourceObjet : sourceObjets) {
                List<SourceObjet> tmpSourceObjectList;
                Goods goods = new Goods(sourceObjet.getGoodsName(), sourceObjet.getGoodsStyle(),
                        sourceObjet.getGoodsNumbers(), sourceObjet.getGoodsSizeType());
                boolean containsKey = goodsMap.containsKey(goods);
                // 不存在
                if (!containsKey) {//containsKey==false
                    tmpSourceObjectList = new ArrayList<>();
                    tmpSourceObjectList.add(sourceObjet);
                    goodsMap.put(goods, tmpSourceObjectList);
                } else {// 存在
                    tmpSourceObjectList = goodsMap.get(goods);
                    tmpSourceObjectList.add(sourceObjet);
                }
            }

            // 合并学校
            Iterator<Map.Entry<Goods, List<SourceObjet>>> iterator0 = goodsMap.entrySet().iterator();
            while (iterator0.hasNext()) {
                Map.Entry<Goods, List<SourceObjet>> entry0 = iterator0.next();
                Goods goods = entry0.getKey();
                List<SourceObjet> sourceObjetList = entry0.getValue();
                //System.out.println("Key = " + goods + ", Value = " + sourceObjetList);

                Map<School, List<SourceObjet>> schoolMap = new HashMap<>();

                for (SourceObjet sourceObjet : sourceObjetList) {
                    School school = new School(sourceObjet.getSchoolName());
                    boolean containsKey = schoolMap.containsKey(school);
                    // 不存在
                    if (!containsKey) {//containsKey==false
                        List<SourceObjet> value = new ArrayList<>();
                        value.add(sourceObjet);
                        schoolMap.put(school, value);
                    } else {// 存在
                        List<SourceObjet> list = schoolMap.get(school);
                        list.add(sourceObjet);
                    }
                }
                goods.setSchools(new ArrayList<>(schoolMap.keySet()));

                // 合并尺码
                Iterator<Map.Entry<School, List<SourceObjet>>> iterator1 = schoolMap.entrySet().iterator();
                while (iterator1.hasNext()) {
                    Map.Entry<School, List<SourceObjet>> entry1 = iterator1.next();
                    School school = entry1.getKey();
                    List<SourceObjet> schoolSourceObjets = entry1.getValue();
                    //System.out.println("Key = " + school + ", Value = " + schoolSourceObjets);
                    Map<Size, Size> sizeMap = new HashMap<>();
                    for (SourceObjet sizeSourceObjet : schoolSourceObjets) {
                        Size size = new Size(sizeSourceObjet.getSizeName());
                        boolean containsKey = sizeMap.containsKey(size);
                        Size value;
                        // 不存在
                        if (!containsKey) {//containsKey==false
                            value = new Size(size.getSizeName());
                        } else {// 存在
                            value = sizeMap.get(size);
                            value.setSizeTotal(value.getSizeTotal() + 1);
                        }
                        sizeMap.put(size, value);
                    }
                    school.setSizes(new ArrayList<>(sizeMap.values()));

                }
                schoolMap.forEach((school, schoolSourceObjets) -> {
                });

            }
            goodsMap.forEach((goods, sourceObjetList) -> {
            });
            return new ArrayList<>(goodsMap.keySet());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * initRenderData:(使用层级数据初始化渲染数据). <br/>
     *
     * @author jxq
     * @param goodsList
     * @return
     * @since JDK 1.8.0
     */
    private static RenderData initRenderData(List<Goods> goodsList) {
        try {
            List<WriteModel> writeModels = new ArrayList<>();
            List<Merge> merges = new ArrayList<>();
            int firstRow = 2;
            int sum = 0;

            int schoolFirstRow = 2;
            int schoolSum = 0;

            for (Goods goods : goodsList) {
                String goodsName = goods.getGoodsName();
                String goodsStyle = goods.getGoodsStyle();
                String goodsNumbers = goods.getGoodsNumbers();
                String goodsSizeType = goods.getGoodsSizeType();

                List<School> schools = goods.getSchools();
                int step = -1;
                firstRow = 2 + sum;
                for (School school : schools) {
                    String schoolName = school.getSchoolName();

                    int schoolStep = -1;
                    schoolFirstRow = 2 + schoolSum;

                    List<Size> sizes = school.getSizes();
                    for (Size size : sizes) {
                        String sizeName = size.getSizeName();
                        Integer sizeTotal = size.getSizeTotal();
                        WriteModel writeModel = new WriteModel(goodsName, goodsStyle, goodsNumbers, goodsSizeType,
                                schoolName, sizeName, sizeTotal);
                        writeModels.add(writeModel);
                        sum++;
                        schoolSum++;
                        step++;
                        schoolStep++;
                    }
                    int schoolLastRow = schoolFirstRow + schoolStep;
                    if (schoolFirstRow != schoolLastRow) {
                        merges.add(new Merge(schoolFirstRow, schoolLastRow, 4, 4));
                    }
                }
                int lastRow = firstRow + step;
                if (firstRow != lastRow) {
                    merges.add(new Merge(firstRow, lastRow, 0, 0));
                    merges.add(new Merge(firstRow, lastRow, 1, 1));
                    merges.add(new Merge(firstRow, lastRow, 2, 2));
                    merges.add(new Merge(firstRow, lastRow, 3, 3));
                }
            }
            return new RenderData(writeModels, merges);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * initData:(初始化业务数据). <br/>
     *
     * @author jxq
     * @return
     * @since JDK 1.8.0
     */
    private static List<SourceObjet> initData() {
        List<SourceObjet> sourceObjets = new ArrayList<>();
        SourceObjet sourceObjet1 = new SourceObjet("商品001", "SP-001", "男款", "平台尺码", "北京海淀区北京大学", "160");
        SourceObjet sourceObjet2 = new SourceObjet("商品001", "SP-001", "男款", "平台尺码", "北京海淀区北京大学", "160");
        SourceObjet sourceObjet4 = new SourceObjet("商品001", "SP-001", "男款", "平台尺码", "北京海淀区北京大学", "170");
        SourceObjet sourceObjet3 = new SourceObjet("商品001", "SP-001", "男款", "平台尺码", "北京海淀区清华大学", "170");
        SourceObjet sourceObjet5 = new SourceObjet("商品002", "SP-002", "男款", "平台尺码", "北京海淀区北京大学", "160");
        SourceObjet sourceObjet6 = new SourceObjet("商品002", "SP-002", "男款", "平台尺码", "北京海淀区北京大学", "180");
        sourceObjets = Arrays.asList(sourceObjet1, sourceObjet2, sourceObjet3, sourceObjet4, sourceObjet5, sourceObjet6);
        return sourceObjets;
    }

    /**
     * generateExcel:(执行渲染生成excel). <br/>
     *
     * @author jxq
     * @param renderData
     * @param file
     * @since JDK 1.8.0
     */
    private static void generateExcel(RenderData renderData, String file) {
        try {
            List<WriteModel> writeModels = renderData.getWriteModels();
            List<Merge> merges = renderData.getMerges();

            OutputStream out = new FileOutputStream(file);
            ExcelWriter writer = EasyExcelFactory.getWriter(out);

            Sheet sheet = new Sheet(1, 3, WriteModel.class, "零售商品生产明细表", null);
            writer.write(writeModels, sheet);

            // 合并单元格
            merges.forEach(merge -> {
                writer.merge(merge.getFirstRow(), merge.getLastRow(), merge.getFirstCol(), merge.getLastCol());
            });

            writer.finish();
            out.close();
            System.out.println("====================生成excel完成====================");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

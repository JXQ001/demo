package demo.easyexcel;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.IndexedColors;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.TableStyle;

import demo.easyexcel.model.Goods;
import demo.easyexcel.model.Merge;
import demo.easyexcel.model.RenderData;
import demo.easyexcel.model.School;
import demo.easyexcel.model.Size;
import demo.easyexcel.model.SourceObjet;
import demo.easyexcel.model.WriteModel;
/**
 * @author jiangxiuqiang
 * @version 1.0
 * @ClassName:EasyExcelUtil
 * @Description:
 * @date 2019/5/15 14:13
 */
public class EasyExcelUtil {


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
        SourceObjet sourceObjet3 = new SourceObjet("商品001", "SP-001", "男款", "平台尺码", "北京海淀区北京大学", "170");
        SourceObjet sourceObjet5 = new SourceObjet("商品002", "SP-002", "男款", "平台尺码", "北京海淀区北京大学", "160");
        SourceObjet sourceObjet6 = new SourceObjet("商品002", "SP-002", "男款", "平台尺码", "北京海淀区北京大学", "180");
        sourceObjets = Arrays.asList(sourceObjet1, sourceObjet2, sourceObjet3, sourceObjet4, sourceObjet5, sourceObjet6);
        return sourceObjets;
    }

    public static void main(String[] args) throws Exception {
        String file = "C:\\Users\\Administrator\\Desktop\\零售商品生产明细表121212121212.xlsx";
        generateExcel(initData(), new FileOutputStream(file));
    }

    /**
     * generateExcel:(生成excel). <br/>
     *
     * @author jxq
     * @param sourceObjets
     * @param out
     * @since JDK 1.8.0
     */
    private static void generateExcel(List<SourceObjet> sourceObjets, OutputStream out) {
        try {
            // 将业务数据转换为层级数据
            List<Goods> goodsList = castSourceObjectToGoodsList(sourceObjets);
            // 使用层级数据初始化渲染数据
            RenderData renderData = initRenderData(goodsList);
            // 执行渲染生成excel
            generateExcel(renderData, out);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
            goodsMap.forEach((goods, sourceObjetList) -> {
                Map<School, List<SourceObjet>> schoolMap = new HashMap<>();
                sourceObjetList.forEach(sourceObjet -> {
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
                });
                goods.setSchools(new ArrayList<>(schoolMap.keySet()));

                // 合并尺码
                schoolMap.forEach((school, schoolSourceObjets) -> {
                    Map<Size, Size> sizeMap = new HashMap<>();
                    schoolSourceObjets.forEach(sizeSourceObjet -> {
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
                    });
                    school.setSizes(new ArrayList<>(sizeMap.values()));
                });
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
     * generateExcel:(执行渲染生成excel). <br/>
     *
     * @author jxq
     * @param renderData
     * @param out
     * @since JDK 1.8.0
     */
    private static void generateExcel(RenderData renderData, OutputStream out) {
        try {
            List<WriteModel> writeModels = renderData.getWriteModels();
            List<Merge> merges = renderData.getMerges();

            ExcelWriter writer = EasyExcelFactory.getWriter(out);

            Sheet sheet = new Sheet(1, 3, WriteModel.class, "零售商品生产明细表", null);

            // 设置样式
            sheet.setTableStyle(createTableStyle());

            writer.write(writeModels, sheet);

            // 合并单元格
            merges.forEach(merge -> {
                writer.merge(merge.getFirstRow(), merge.getLastRow(), merge.getFirstCol(), merge.getLastCol());
            });

            Sheet sheet1 = new Sheet(2, 3, WriteModel.class, "零售商品生产明细表1", null);
            // 设置样式
            sheet1.setTableStyle(createTableStyle());
            writer.write(writeModels, sheet1);

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

    private static TableStyle createTableStyle() {
        TableStyle tableStyle = new TableStyle();
        Font headFont = new Font();
        headFont.setBold(true);
        headFont.setFontHeightInPoints((short) 14);
        headFont.setFontName("宋体");
        tableStyle.setTableHeadFont(headFont);
        tableStyle.setTableHeadBackGroundColor(IndexedColors.BROWN);

        Font contentFont = new Font();
        contentFont.setBold(true);
        contentFont.setFontHeightInPoints((short) 11);
        contentFont.setFontName("宋体");
        tableStyle.setTableContentFont(contentFont);
        tableStyle.setTableContentBackGroundColor(IndexedColors.WHITE);
        return tableStyle;
    }
}

package demo.easyexcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.easyexcel.model.Goods;
import demo.easyexcel.model.School;
import demo.easyexcel.model.Size;
import demo.easyexcel.model.SourceObjet;
/**
 * @author jiangxiuqiang
 * @version 1.0
 * @ClassName:CastUtil
 * @Description:
 * @date 2019/5/15 14:12
 */
public class CastUtil {


    public static List<Goods> castSourceObjectToGoodsList(List<SourceObjet> sourceObjets) {
        Map<Goods, List<SourceObjet>> goodsMap = new HashMap<>();
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(goodsMap.keySet());
    }
}

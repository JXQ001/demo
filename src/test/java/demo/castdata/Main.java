package demo.castdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import demo.castdata.model.OrderGoods;
import demo.castdata.model.SourceObj;

public class Main {

	public static void main(String[] args) {

		// 初始化数据
		List<SourceObj> sourceObjs = initData();
		sourceObjs.forEach(sourceObj -> {
			System.out.println(sourceObj);
		});

		System.out.println("=======================================================");
		
		// 转换成层级数据
		List<OrderGoods> orderGoods = castData(sourceObjs);
		orderGoods.forEach(orderGoods1 -> {
			System.out.println(orderGoods1);
		});
	}

	private static List<OrderGoods> castData(List<SourceObj> sourceObjs) {
		if (sourceObjs == null)
			return null;

		Map<OrderGoods, List<SourceObj>> map = new HashMap<>();
		sourceObjs.forEach(sourceObj -> {
			String orderSn = sourceObj.getOrderSn();
			String goodsName = sourceObj.getGoodsName();
			String goodsStyle = sourceObj.getGoodsStyle();
			String goodsNumbers = sourceObj.getGoodsNumbers();
			String sizeType = sourceObj.getSizeType();
			OrderGoods orderGoods = new OrderGoods(orderSn, goodsName, goodsStyle, goodsNumbers, sizeType, null);
			boolean containsKey = map.containsKey(orderGoods);
			if (!containsKey) {// no key
				List<SourceObj> asList = new ArrayList<>();
				asList.add(sourceObj);
				map.put(orderGoods, asList);
			} else {// find key
				List<SourceObj> sObjs = map.get(orderGoods);
				sObjs.add(sourceObj);
			}
		});
		return new ArrayList<>(map.keySet());
	}

	private static List<SourceObj> initData() {
		SourceObj sourceObj1 = new SourceObj("orderSn001", "商品01", "男款", "SP-001M", "平台尺码", "160", "2", "北京大学");
		SourceObj sourceObj2 = new SourceObj("orderSn002", "商品01", "男款", "SP-001M", "平台尺码", "160", "3", "北京大学");
		SourceObj sourceObj3 = new SourceObj("orderSn003", "商品01", "男款", "SP-001M", "平台尺码", "160", "4", "清华大学");
		SourceObj sourceObj4 = new SourceObj("orderSn004", "商品01", "男款", "SP-001M", "平台尺码", "160", "1", "清华大学");
		return Arrays.asList(sourceObj1, sourceObj2, sourceObj3, sourceObj4);
	}

}

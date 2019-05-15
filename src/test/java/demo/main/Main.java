package demo.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		List<OrderInfo> poList = initData();
		for (OrderInfo orderInfo : poList) {
			System.out.println(orderInfo);
		}

		Map<String, OrderInfo> orderInfoMap = new HashMap<>();
		for (OrderInfo orderInfo : poList) {
			String key = orderInfo.getGoodsName();
			boolean containsKey = orderInfoMap.containsKey(key);
			if (!containsKey) {// 不存在
				List<OrderInfo> tableData = new ArrayList<>();
				tableData.add(orderInfo);
				orderInfo.setTableData(tableData);
				orderInfoMap.put(key, orderInfo);
			} else {// 存在
				OrderInfo orderInfo2 = orderInfoMap.get(key);
				List<OrderInfo> tableData = orderInfo2.getTableData();
				tableData.add(orderInfo);
			}
		}

		System.out.println("----------------------------------------------");

		ArrayList<OrderInfo> arrayList = new ArrayList<>(orderInfoMap.values());
		for (OrderInfo orderInfo2 : arrayList) {
			List<OrderInfo> tableData = orderInfo2.getTableData();
			System.out.println(orderInfo2 + "tableData Size:" + tableData.size());
			for (OrderInfo orderInfo : tableData) {
				System.out.println("==============================={" + orderInfo.getSize() + ", " + orderInfo.getNum()
						+ "}===============================");
			}
		}

		for (OrderInfo orderInfo : arrayList) {
			List<OrderInfo> tableData = orderInfo.getTableData();
			Map<String, OrderInfo> tableDataMap = new HashMap<>();
			for (OrderInfo orderInfo2 : tableData) {
				int opeNum = Integer.parseInt(orderInfo2.getNum());
				String key = orderInfo2.getSize();
				boolean containsKey = tableDataMap.containsKey(key);
				if (!containsKey) {// 不存在
					tableDataMap.put(key, orderInfo2);
				} else {// 存在
					OrderInfo orderInfo3 = tableDataMap.get(key);
					int num = Integer.parseInt(orderInfo3.getNum());
					num += opeNum;
					orderInfo3.setNum("" + num);
				}
			}
			tableData = new ArrayList<>(tableDataMap.values());
			orderInfo.setTableData(tableData);
		}

		System.out.println("==============================================================");
		
		for (OrderInfo orderInfo2 : arrayList) {
			List<OrderInfo> tableData = orderInfo2.getTableData();
			System.out.println(orderInfo2 + "tableData Size:" + tableData.size());
			for (OrderInfo orderInfo : tableData) {
				System.out.println("==============================={" + orderInfo.getSize() + ", " + orderInfo.getNum()
						+ "}===============================");
			}
		}
	}

	private static List<OrderInfo> initData() {
		List<OrderInfo> dataList = new ArrayList<>();
		OrderInfo orderInfo1 = new OrderInfo("001", "商品1", "145", "1");
		OrderInfo orderInfo2 = new OrderInfo("001", "商品1", "150", "2");
		OrderInfo orderInfo3 = new OrderInfo("001", "商品1", "155", "3");
		OrderInfo orderInfo4 = new OrderInfo("002", "商品1", "150", "6");
		OrderInfo orderInfo5 = new OrderInfo("003", "商品1", "145", "4");
		OrderInfo orderInfo6 = new OrderInfo("004", "商品2", "155", "1");
		OrderInfo orderInfo7 = new OrderInfo("004", "商品2", "160", "2");
		OrderInfo orderInfo8 = new OrderInfo("005", "商品2", "155", "1");
		OrderInfo orderInfo9 = new OrderInfo("005", "商品2", "150", "3");
		dataList.add(orderInfo1);
		dataList.add(orderInfo2);
		dataList.add(orderInfo3);
		dataList.add(orderInfo4);
		dataList.add(orderInfo5);
		dataList.add(orderInfo6);
		dataList.add(orderInfo7);
		dataList.add(orderInfo8);
		dataList.add(orderInfo9);
		return dataList;
	}

}

package demo.mergedata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Main {

	public static void main(String[] args) {

		Map<String, List<SaleDetail>> map = new HashMap<>();
		List<SaleDetail> saleDetails = new ArrayList<>();
		SaleDetail saleDetail1 = new SaleDetail("1", "orderNo001", "goodsCode001", "2", "1.5", "venderId001", "pos");
		SaleDetail saleDetail2 = new SaleDetail("2", "orderNo001", "goodsCode002", "1", "1.7", "venderId001", "pos");
		SaleDetail saleDetail3 = new SaleDetail("3", "orderNo001", "goodsCode003", "2", "1.0", "venderId001", "pos");
		saleDetails.add(saleDetail1);
		saleDetails.add(saleDetail2);
		saleDetails.add(saleDetail3);
		map.put("saleDetails", saleDetails);

		String jsonString = JSON.toJSONString(map);

		System.out.println(jsonString);
		System.out.println("-----------------------------------------------------------------------------------------");

		JSONObject parseObject = JSON.parseObject(jsonString);
		Object object = parseObject.get("saleDetails");

		List<SaleDetail> parseArray = JSON.parseArray(object.toString(), SaleDetail.class);

		Map<SaleDetail, List<SaleDetail>> sourceData = new HashMap<>();
		for (SaleDetail saleDetail : parseArray) {
			boolean containsKey = sourceData.containsKey(saleDetail);
			List<SaleDetail> details = new ArrayList<>();
			if (!containsKey) {
				details.add(saleDetail);
				sourceData.put(saleDetail, saleDetails);
			} else {
				List<SaleDetail> list = sourceData.get(saleDetail);
				list.add(saleDetail);
			}
			System.out.println(saleDetail);
		}
		
		List<SaleDetail> targetList = new ArrayList<>();
		
		sourceData.forEach((saleDetail, saleDetailList)->{
			if (saleDetailList.size() == 1) {
				targetList.add(saleDetail);
			}else {
				saleDetailList.forEach((saleDetailT)->{
					String price = saleDetail.getPrice();
					String saleTotal = saleDetailT.getSaleTotal();
					targetList.add(saleDetail);
				});
			}
		});
		
		System.out.println("----------------------------------------------------------------");
		
		targetList.forEach((saleDetail)->{
			System.out.println(saleDetail);
		});
		
		

	}

}

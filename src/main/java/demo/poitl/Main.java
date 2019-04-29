package demo.poitl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.DocxRenderData;
import com.deepoove.poi.data.HyperLinkTextRenderData;
import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.data.NumbericRenderData;
import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.util.BytePictureUtils;

public class Main {

	public static void main(String[] args) throws Exception {
		test01();
		test02();
	}

	private static void test02() throws Exception {

		Map<String, Object> map = new HashMap<>();

		List<Order> orders = new ArrayList<Order>();

		Order o1 = null;
		for (int i = 0; i < 1000; i++) {
			o1 = new Order();
			o1.setOrderNo("123456789123456789");
			o1.setAddTime("2019/1/17 8:44:30");
			o1.setPayTime("2019/1/17 8:46:30");
			o1.setConsignee("张三");
			o1.setMobile("15698297075");
			o1.setAddress("北京市 朝阳区 望京科技创业园 E座412A");
			o1.setSchoolName("北京市 海淀区 北京大学");
			orders.add(o1);
		}
		map.put("order", new DocxRenderData(new File("src/main/resources/shipmentBillTemplate.docx"), orders));

		XWPFTemplate template = XWPFTemplate.compile("src/main/resources/order.docx").render(map);
		FileOutputStream out = new FileOutputStream("src/main/resources/out_order.docx");
		template.write(out);
		out.flush();
		out.close();
		template.close();
		System.out.println("生成完成");
	}

	private static void test01() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("title", "Poi-tl 模板引擎");
		map.put("author", new TextRenderData("000000", "Sayi卅一"));
		map.put("introduce", "http://www.deepoove.com");
		map.put("link", new HyperLinkTextRenderData("website.", "http://www.deepoove.com"));

		// 本地图片
		map.put("localPicture", new PictureRenderData(120, 120, "src/main/resources/sayi.png"));

		// 本地图片byte数据
		byte[] localByteArray = BytePictureUtils.getLocalByteArray(new File("src/main/resources/logo.png"));
		map.put("localBytePicture", new PictureRenderData(100, 120, ".png", localByteArray));

		// 网络图片
		map.put("urlPicture", new PictureRenderData(100, 100, ".png",
				BytePictureUtils.getUrlByteArray("https://avatars3.githubusercontent.com/u/1394854")));

		// java 图片
		// map.put("bufferImagePicture", new PictureRenderData(100, 120, ".png",
		// BytePictureUtils.getBufferByteArray(bufferImage)));

		RowRenderData header = RowRenderData.build(new TextRenderData("000000", "姓名"),
				new TextRenderData("000000", "学历"));

		RowRenderData row0 = RowRenderData.build("张三", "研究生");
		RowRenderData row1 = RowRenderData.build("李四", "博士");
		RowRenderData row2 = RowRenderData.build("王五", "博士后");

		map.put("table", new MiniTableRenderData(header, Arrays.asList(row0, row1, row2)));

		map.put("feature", new NumbericRenderData(new ArrayList<TextRenderData>() {
			{
				add(new TextRenderData("Plug-in grammar"));
				add(new TextRenderData("Supports word text, header..."));
				add(new TextRenderData("Not just templates, but also style templates"));
			}
		}));

		List<SegmentData> segments = new ArrayList<SegmentData>();
		SegmentData s1 = new SegmentData();
		s1.setTitle("经常抱怨的自己");
		s1.setContent(
				"每个人生活得都不容易，经常向别人抱怨的人，说白了就是把对方当做“垃圾场”，你一股脑地将自己的埋怨与不满倒给别人，自己倒是爽了，你有考虑过对方的感受吗？对方的脸上可能一笑了之，但是心里可能有一万只草泥马奔腾而过。");
		segments.add(s1);

		SegmentData s2 = new SegmentData();
		s2.setTitle("拖拖拉拉的自己");
		s2.setContent(
				"能够今天做完的事情，不要拖到明天，你的事情没有任何人有义务去帮你做；不要做“宅男”、不要当“宅女”，放假的日子约上三五好友出去转转；经常动手做家务，既能分担伴侣的负担，又有一个干净舒适的环境何乐而不为呢？");
		segments.add(s2);

		map.put("docx_word", new DocxRenderData(new File("src/main/resources/segment.docx"), segments));

		XWPFTemplate template = XWPFTemplate.compile("src/main/resources/template.docx").render(map);
		FileOutputStream out = new FileOutputStream("src/main/resources/out_template.docx");
		template.write(out);
		out.flush();
		out.close();
		template.close();
		System.out.println("生成完成");
	}
}

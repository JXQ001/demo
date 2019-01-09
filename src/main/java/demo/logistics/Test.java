package demo.logistics;

public class Test {

	public static void main(String[] args) throws Exception {

		String logistics = "demo.logistics.ShunFeng";
		logistics = "demo.logistics.ZhongTong";
		Class<?> clazz = Class.forName(logistics);
		Logistics obj = (Logistics) clazz.newInstance();

		Context context = new Context(obj);
		context.zaiXianYuYue("北京张三", "上海李四");
		context.dianZiMianDan("北京张三", "上海李四");
		context.chaXunWuLiuGuiJi("1102322");
		
		test();
	}

	private static void test() {
		System.out.println("local mod");
	}

}

package demo.logistics;

public class Test {

	public static void main(String[] args) throws Exception {

		String logistics = "demo.logistics.ShunFeng";
		logistics = "demo.logistics.ZhongTong";
		Class<?> clazz = Class.forName(logistics);
		Logistics obj = (Logistics) clazz.newInstance();

		Context context = new Context(obj);
		context.zaiXianYuYue("北京张三123", "上海李四");
		context.dianZiMianDan("北京张三11111", "上海李四");
		context.chaXunWuLiuGuiJi("1102322");
		
		String str = "remote mod";
		
		test();
	}

	private static void test() {
		String str1 = "remote mod 1";
		
		System.out.println("local mod");
		
		String string = "local mod ";
		
		String str2 = "remote mod 2";
	}

}

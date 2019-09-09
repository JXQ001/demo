package demo.main;

import java.util.Date;

public class Main1 {
	public static void main(String[] args) throws Exception {
		int flag = 1;
		while (flag <= 6) {// 5min
			Thread.sleep(5000);// 5s
			System.out.println("[" + new Date() + "]" + " 第" + flag + "次执行业务");
			flag++;
		}
	}
}

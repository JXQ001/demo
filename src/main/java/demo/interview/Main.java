package demo.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.chart.UnitsRecord;

/**
 * @author jiangxiuqiang
 * @version 1.0
 * @ClassName:Main
 * @Description:
 * @date 2019/5/25 9:28
 */
public class Main {
	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		ExecutorService chedThreadPool = Executors.newCachedThreadPool();
		System.out.println("Hello GC ....");
		byte[] bytes = new byte[50 * 1024 * 1024];

		// test01();
		test02();
	}

	private static void test02() {
		// Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
		String string = "";
		while (true) {
			string += "dsalhdkashdlkashdlkahldh";
			System.out.println(string);
		}
	}

	private static void test01() {
		test01();// Exception in thread "main" java.lang.StackOverflowError
	}
}

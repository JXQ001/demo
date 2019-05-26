package demo.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.eclipse.jetty.util.thread.ExecutorThreadPool;

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
    }
}

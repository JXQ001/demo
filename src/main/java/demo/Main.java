package demo;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 并发环境下的缓存，使用读写锁ReentrantReadWriteLock保证读原子性
 * 
 * @author liya
 *
 */
class MyCache {
	// 容器
	private volatile Map<String, Object> ceche = new HashMap<>();
	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

	// 存
	public void set(String key, Object value) {

		rwLock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t开始缓存:" + key);
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ceche.put(key, value);
			System.out.println(Thread.currentThread().getName() + "\t缓存完成");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwLock.writeLock().unlock();
		}
	}

	// 取
	public void get(String key) {
		rwLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t开始读取");
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Object value = ceche.get(key);
			System.out.println(Thread.currentThread().getName() + "\t读取完成" + value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwLock.readLock().unlock();
		}
	}
}

public class Main {
	public static void main(String[] args) {

		// 模拟抢车位或者饭店等位，走一个进一个
		Semaphore semaphore = new Semaphore(3);
		for (int i = 1; i <= 6; i++) {
			new Thread(() -> {
				try {
					semaphore.acquire();// 抢到车位
					System.out.println(Thread.currentThread().getName() + "\t抢到车位");
					TimeUnit.SECONDS.sleep(3);
					System.out.println(Thread.currentThread().getName() + "\t3秒后离开车位");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaphore.release();// 释放车位
				}
			}, String.valueOf(i)).start();
		}
	}

	/**
	 * 并发缓存
	 */
	@SuppressWarnings("unused")
	private static void concurrentCache() {
		MyCache cache = new MyCache();
		for (int i = 1; i <= 5; i++) {
			final int temInt = i;
			new Thread(() -> {
				cache.set(temInt + "", temInt + "");
			}, String.valueOf(i)).start();
		}
		for (int i = 1; i <= 5; i++) {
			final int temInt = i;
			new Thread(() -> {
				cache.get(temInt + "");
			}, String.valueOf(i)).start();
		}
	}
}

package demo.interview;

import demo.easyexcel.model.SourceObjet;
import jdk.management.resource.internal.inst.InitInstrumentation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyResource{
    // 标志位
    private int number = 1;//A 1,B 2, C 2
    // lock锁
    private Lock lock = new ReentrantLock();
    // Condition标记线程一把锁三个钥匙
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try{
            while (number != 1){
                c1.await();
                for (int i = 1;i<=5;i++){
                    System.out.println(Thread.currentThread().getName()+"\t"+i);
                }
            }number =2 ;
            c2.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void print10() {
        lock.lock();
        try{
            while (number != 2){
                c2.await();
                for (int i = 1;i<=10;i++){
                    System.out.println(Thread.currentThread().getName()+"\t"+i);
                }
            }
            number =3;
            c3.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void print15() {
        lock.lock();
        try{
            while (number != 3){
                c3.await();
                for (int i = 1;i<=15;i++){
                    System.out.println(Thread.currentThread().getName()+"\t"+i);
                }
            }number =1;
            c1.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}

/**
 * @author jiangxiuqiang
 * @version 1.0
 * @ClassName:Main
 * @Description:
 * @date 2019/5/25 9:28
 */
public class Main {
	public static void main(String[] args) {
        callAble();

        conditionTest();
    }

    private static void conditionTest() {
        MyResource myResource = new MyResource();
        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                myResource.print5();
            }
        },"线程A").start();

        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                myResource.print10();
            }
        },"线程B").start();

        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                myResource.print15();
            }
        },"线程C").start();
    }

    private static void callAble() {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1024;
            }
        });

        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("======================================");
    }
}

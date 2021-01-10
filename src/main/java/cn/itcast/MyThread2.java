package cn.itcast;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * description:
 *
 * @auther hugo
 * @date 2020/12/13 22:05
 */
public class MyThread2 implements Callable<String> {
    private String title;

    public MyThread2(String title){
        this.title=title;

    }
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(title+"线程执行"+i);
        }
        return "线程执行完毕";

    }
}
class demo{
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(new MyThread2("A"));
        new Thread(futureTask).start();
        FutureTask futureTask1 = new FutureTask(new MyThread2("B"));
        new Thread(futureTask1).start();

        System.out.println("线程返回值："+futureTask.get());
        System.out.println("线程返回值："+futureTask1.get());


    }
}

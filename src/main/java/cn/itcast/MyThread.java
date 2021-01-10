package cn.itcast;

/**
 * description:
 *
 * @auther hugo
 * @date 2020/12/13 21:19
 */
public class MyThread extends Thread {
    private String title;
    public MyThread(String title) {
        this.title = title;
    }
    @Override
    public void run() {//线程的主体方法
        for(int x = 0; x < 10 ; x++) {

            System.out.println(this.title + "运行，x = " + x);

        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread mt = new MyThread("线程A");
        mt.start();
        System.out.println(mt.getName()+"999"+mt.getId());
        new MyThread("线程B").start();
        new MyThread("线程C").start();

    }
}

class MyThread1 implements Runnable{

    private String title;
    public MyThread1(String title){
        this.title=title;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title+"运行，i="+i);
        }

    }

    public static void main(String[] args) {
        new Thread(new MyThread1("线程X")).start();
        new  Thread(new MyThread1("线程Y")).start();
        new Thread(new MyThread1("线程Z")).start();

//        new  MyThread1("Q").run();
//        new MyThread1("R").run();
//        new MyThread1("S").run();
    }
}


 class Demo1 {

    public static void main(String[] args) {

        System.out.println("开始执行main方法");
        //1. 创建子类对象
        MyThread myThread = new MyThread("罗永浩直播间1:");
        myThread.start();
        //2. 打印 10 ~ 19
        for(int i = 10 ; i<20 ; i++){
            System.out.println("main线程:"+i);
        }
    }
}



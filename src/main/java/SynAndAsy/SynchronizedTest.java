package SynAndAsy;

/**
 * description:
 *
 * @auther hugo
 * @date 2020/12/13 22:50
 */
public class SynchronizedTest {
    private static int cnt=1;

    public static void main(String[] args)  {
        Mythread mythread = new Mythread();
        Thread thread1 = new Thread(mythread);
        Thread thread2 = new Thread(mythread);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private static class Mythread implements Runnable{
        public void run() {
            while (true){
                synchronized (this){
                    this.notify();
                    if (cnt<100){
                        String name = Thread.currentThread().getName();
                        System.err.println(name+":"+cnt++);
                        try {
                            this.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }else {
                        return;
                    }
                }
            }
        }
    }
}
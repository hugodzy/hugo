package cn.itcast;

/**
 * description:
 *
 * @auther hugo
 * @date 2020/12/13 20:58
 */
public class MultithreadTest implements Runnable {

    private int ticket=5;

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (this.ticket>0){
                System.out.println("买票，ticket="+ticket--);
            }
        }

    }

}

 class ThreadTest{
     public static void main(String[] args) {
         MultithreadTest mt = new MultithreadTest();
         new Thread(mt).start();
         new Thread(mt).start();
         new Thread(mt).start();
     }

}

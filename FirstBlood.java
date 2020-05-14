package lession1;

public class FirstBlood {
    public static void main(String[] args) throws InterruptedException {
//        //main线程阻塞
//        Thread.sleep(9999999999l);
//
//        //子线程阻塞
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(9999999999l);
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"第一滴血") .start();
//
//        //子线程和main线程都阻塞
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(9999999999l);
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"第一滴血") .start();
//        Thread.sleep(9999999999l);

//        //
//        Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(9999999999l);
//                    }catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//        },"第一滴血") ;
//        t.run();

        //第五段代码:main和子线程同时运行,并打印,观察执行顺序
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一滴血");
            }
        },"第一滴血").start();
        System.out.println("main");
    }
}

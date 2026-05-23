package com.testing.projectblue.test;

public class MultiThreadingTest implements Runnable {
    String name;
    @Override
    public void run() {
        System.out.println("Thread is running: " + name);
    }

    public static void main(String[] args) {
        MultiThreadingTest multiThreadingTest = new MultiThreadingTest();
        MultiThreadingTest multiThreadingTest1 = new MultiThreadingTest();
        MultiThreadingTest multiThreadingTest2 = new MultiThreadingTest();
        MultiThreadingTest multiThreadingTest3 = new MultiThreadingTest();

        Thread thread = new Thread(multiThreadingTest);
        Thread thread1 = new Thread(multiThreadingTest1);
        Thread thread2 = new Thread(multiThreadingTest2);
        Thread thread3 = new Thread(multiThreadingTest3);

        multiThreadingTest.name = "Thread 1";
        multiThreadingTest1.name = "Thread 2";
        multiThreadingTest2.name = "Thread 3";
        multiThreadingTest3.name = "Thread 4";
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        

        System.out.println("Main thread is running");
    }

}

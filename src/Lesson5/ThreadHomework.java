package Lesson5;

import java.util.Arrays;

public class ThreadHomework {

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }
    public static void firstMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }
    public static void secondMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        int size1 = size/2;

        float[] leftArr = new float[size1];
        float[] rightArr = new float[size1];
        System.arraycopy(arr,0,leftArr,0,size1);
        System.arraycopy(arr,size1,rightArr,0,size1);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < leftArr.length; i++) {
                    leftArr[i] = (float) (leftArr[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < rightArr.length; i++) {
                    rightArr[i] = (float) (rightArr[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        float[] mergedArr = new float[size];
        System.arraycopy(leftArr,0,mergedArr,0,size1);
        System.arraycopy(rightArr,0,mergedArr,size1,size1);

        System.out.println("Two thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }
}

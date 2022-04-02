package com.company;

public class Main {

    public static void main(String[] args) {
        InfiniteQueue<Integer> queue = new InfiniteQueue<>();

        for(int i = 0; i<100; i++) {
            queue.enqueue(i);
        }

        System.out.println(queue.size());
    }
}

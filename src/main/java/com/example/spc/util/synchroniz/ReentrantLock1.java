package com.example.spc.util.synchroniz;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLock1 {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
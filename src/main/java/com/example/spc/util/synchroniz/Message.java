package com.example.spc.util.synchroniz;

class Message {
    private String content;
    private boolean empty = true;

    public synchronized String read() {
        while (empty) {
            try {
                wait(); // 等待通知
            } catch (InterruptedException e) {
            }
        }
        empty = true;
        notifyAll(); // 通知所有等待线程
        return content;
    }

    public synchronized void write(String content) {
        while (!empty) {
            try {
                wait(); // 等待通知
            } catch (InterruptedException e) {
            }
        }
        empty = false;
        this.content = content;
        notifyAll(); // 通知所有等待线程
    }
}

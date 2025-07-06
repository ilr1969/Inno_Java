package Homework_3;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    private final List<Worker> workers;
    private final LinkedList<Runnable> taskQueue = new LinkedList<>();
    private boolean isShutdown = false;

    public ThreadPool(int poolSize) {
        if (poolSize < 2)
            throw new IllegalArgumentException("Потоков не может быть меньше двух, ведь тестируем многопоточность");
        this.workers = new LinkedList<>();
        for (int i = 0; i < poolSize; i++) {
            Worker w = new Worker();
            workers.add(w);
            w.thread.start();
        }
    }

    public void execute(Runnable task) {
        if (task == null) throw new NullPointerException("Таска пустая");
        synchronized (taskQueue) {
            if (isShutdown) {
                throw new IllegalStateException("Отработал shutdown, не могу запустить задачу");
            }
            taskQueue.addLast(task);
            taskQueue.notify();
        }
    }

    public void shutdown() {
        isShutdown = true;
        for (Worker w : workers) {
            w.thread.interrupt();
        }
    }

    public void awaitTermination() throws InterruptedException {
        for (Worker w : workers) {
            w.thread.join();
        }
    }

    private class Worker implements Runnable {
        private final Thread thread;

        Worker() {
            this.thread = new Thread(this);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Runnable task;
                    synchronized (taskQueue) {
                        while (taskQueue.isEmpty()) {
                            if (isShutdown) {
                                return;
                            }
                            try {
                                taskQueue.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread()
                                        .interrupt();
                                return;
                            }
                        }
                        task = taskQueue.removeFirst();
                    }
                    try {
                        task.run();
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } finally {
            }
        }
    }
}

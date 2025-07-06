package Homework_3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool(5);
        Main m = new Main();

        System.out.println("Запускаем потоки");
        m.runTask(pool);
        System.out.println("Потоки запущены");

        pool.shutdown();
        System.out.println("Отработал shutdown");

        // Тут та же задача, но уже не принятая в работу.
        // Но, плиз, на разборе уточните, можно ли сделать так, чтобы мы запустили 100 задач, потом, пока они ещё не отработали, применили shutdown,
        // и из 100 запущенных задач завершились только те, которые успели начаться, а все не начатые отменились. Я не понял, как это сделать,
        // в дебаге вижу, что в первом цикле сразу все задачи встали в очередь.
        m.runTask(pool);

        pool.awaitTermination();

        System.out.println("Все задачи завершены успешно.");
    }

    public void runTask(ThreadPool pool) {
        for (int i = 0; i < 8; i++) {
            final int idx = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread()
                        .getName() + " выполняет задачу " + idx);
                double result = 0.0;
                for (long k = 1; k <= 100000000; k++) {
                    result += Math.sin(k) * Math.cos(k);
                }
            });
        }
    }
}


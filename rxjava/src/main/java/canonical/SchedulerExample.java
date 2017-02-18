package canonical;


import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.stream.Stream;

/**
 * Created by Uladzislau_Kaminski on 2/18/2017.
 */
public class SchedulerExample {
    public static void main(String[] args) throws InterruptedException {
        Observable.range(1, 100)
                .map(it -> {
                    System.out.println(Thread.currentThread().getName());
                    return it * 2;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.immediate())
                .subscribe(it -> {
                    System.out.println(Thread.currentThread().getName() + ": " + it);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        Thread.sleep(100000);
    }
}

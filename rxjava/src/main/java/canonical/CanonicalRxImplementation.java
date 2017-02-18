package canonical;


import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

public class CanonicalRxImplementation {
    public static void main(String[] args) {
        Observable<String> observable = Observable.create(subsciber -> {
                    try {
                        Stream.of("first", "second", "thirdl", "forth").forEach(subsciber::onNext);
                        subsciber.onCompleted();

                    } catch (Exception e) {
                        subsciber.onError(e);
                    }
                }
        );

        Subscription complete = observable.subscribeOn(Schedulers.io()).subscribe(it -> {
            System.out.println(it);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, System.out::println, () -> System.out.println("Complete"));
        System.out.println(complete.isUnsubscribed());
        observable.map(String::toUpperCase).subscribe(System.out::println, System.out::println, () -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("COMPLETE");
        });
        LongAdder longAdder = new LongAdder();

    }


    // Observer наблюдатель
    // Subscriber = Observer + менеджмент подписки
}

package completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Created by Uladzislau_Kaminski on 2/18/2017.
 */
public class CompletableFutureSamples {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture.completedFuture("Hello")
//                .thenApplyAsync(it -> {
//                    try {
//                        System.out.println(Thread.currentThread().getName());
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    return it.toUpperCase();
//                })
//                .whenComplete((s, throwable) -> System.out.println(s));
//        System.out.println("hi");
//        Thread.sleep(1000);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
        CompletableFuture<String> hello = CompletableFuture.completedFuture("hello");

        CompletableFuture.completedFuture(integers).thenApply(it -> {
            System.out.println("Async: " + Thread.currentThread().getName());
            List<Integer> collect = it.stream().map(i -> i * 2).collect(Collectors.toList());
            return collect;
        }).thenApplyAsync(it -> {
            System.out.println("No Async: " + Thread.currentThread().getName());
            return it;
        }).thenCo.thenCombine(hello, (list, s) -> list.stream().map(it -> s+it).collect(Collectors.toList()))
        .thenAccept(System.out::println);


        Thread.sleep(10000);

    }
}

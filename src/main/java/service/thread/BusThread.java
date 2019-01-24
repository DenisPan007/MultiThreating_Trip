package service.thread;

import java.util.concurrent.Callable;

public class BusThread implements Callable<String> {
    public String call() {
        return "result";
    }
}

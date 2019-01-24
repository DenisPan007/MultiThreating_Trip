package service.thread;

import java.util.concurrent.Callable;

public class PassengerThread implements Callable<String> {
    public String call(){
        return "result";
    }
}

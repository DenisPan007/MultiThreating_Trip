package service.thread;

import static org.junit.Assert.*;
import  org.junit.Test;

import java.util.concurrent.*;

public class BusThreadTest {

    @Test
    public void call() throws InterruptedException, ExecutionException {
        BusThread busThread1 = new BusThread();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(busThread1);
        TimeUnit.SECONDS.sleep(2);
        executor.shutdown();
        String expectedResult = "result";
        assertEquals(future.get(),expectedResult);


    }
}
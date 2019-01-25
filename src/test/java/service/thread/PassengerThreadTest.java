package service.thread;

import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.*;

public class PassengerThreadTest {

    @Test
    public void call() throws InterruptedException, ExecutionException {
        PassengerThread passengerThread = new PassengerThread();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(passengerThread);
        TimeUnit.SECONDS.sleep(2);
        executor.shutdown();
        String expectedResult = "result";
        assertEquals(future.get(),expectedResult);
    }
}
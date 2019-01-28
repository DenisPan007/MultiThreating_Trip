package service.thread;

import static org.junit.Assert.*;

import entity.Bus;
import entity.BusStop;
import entity.Passenger;
import entity.Route;
import org.junit.Before;
import org.junit.Test;
import service.dispatcher.BusDispatcher;
import service.dispatcher.BusStopDispatcher;
import util.ComparatorPassengerByName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class BusThreadTest {
    private List<Callable<String>> listOfThreads = new ArrayList<>();
    private List<BusStopDispatcher> expectedListOfStops = new ArrayList<>();
    private List<BusStopDispatcher> actualListOfStops = new ArrayList<>();

    @Before
    public void fill() {
        BusStop b1 = new BusStop( 1);
        BusStop b2 = new BusStop( 2);
        BusStop b3 = new BusStop( 3);
        BusStop b4 = new BusStop(4);
        Passenger p1 = new Passenger("Den1", b4);
        Passenger p2 = new Passenger("Den2", b2);
        Passenger p3 = new Passenger("Den3", b4);
        Passenger p4 = new Passenger("Den4", b4);
        Passenger p5 = new Passenger("Den5", b3);
        Passenger p6 = new Passenger("Den6", b4);
        Passenger p7 = new Passenger("Den7", b4);
        Passenger p8 = new Passenger("Den8", b2);
        Passenger p9 = new Passenger("Den9", b1);
        BusStopDispatcher bsd1 = new BusStopDispatcher(b1, p1, p2, p3);
        BusStopDispatcher bsd2 = new BusStopDispatcher(b2, p4, p5);
        BusStopDispatcher bsd3 = new BusStopDispatcher(b3, p6, p9);
        BusStopDispatcher bsd4 = new BusStopDispatcher(b4, p7, p8);
        actualListOfStops =
                new ArrayList<>(Arrays.asList(bsd1, bsd2, bsd3, bsd4));
        List<BusStopDispatcher> listOfStops1 =
                new ArrayList<>(Arrays.asList(bsd1, bsd2, bsd3, bsd4));
        Route route1 = new Route(1, listOfStops1);
        List<BusStopDispatcher> listOfStops2 =
                new ArrayList<>(Arrays.asList(bsd4, bsd3, bsd2, bsd1));
        Route route2 = new Route(2, listOfStops2);
        List<BusStopDispatcher> listOfStops3 =
                new ArrayList<>(Arrays.asList(bsd1, bsd3, bsd4, bsd2));
        Route route3 = new Route(3, listOfStops3);
        Bus bus1 = new Bus(1, 5);
        Bus bus2 = new Bus(2, 5);
        BusDispatcher bd1 = new BusDispatcher(bus1, route1);
        BusDispatcher bd2 = new BusDispatcher(bus2, route2);
        BusDispatcher bd3 = new BusDispatcher(bus2, route3);
        BusThread bth1 = new BusThread(bd1);
        BusThread bth2 = new BusThread(bd2);
        BusThread bth3 = new BusThread(bd3);
        listOfThreads.add(bth1);
        listOfThreads.add(bth2);
        listOfThreads.add(bth3);
        expectedListOfStops.add(new BusStopDispatcher(b1, p9));
        expectedListOfStops.add(new BusStopDispatcher(b2, p2, p8));
        expectedListOfStops.add(new BusStopDispatcher(b3, p5));
        expectedListOfStops.add(new BusStopDispatcher(b4, p7, p1, p3, p4, p6));
    }

    @Test
    public void call() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(listOfThreads.get(0));
        executor.submit(listOfThreads.get(1));
        executor.submit(listOfThreads.get(2));
        ComparatorPassengerByName comparator = new ComparatorPassengerByName();
        TimeUnit.SECONDS.sleep(4);
        for (int i = 0; i < actualListOfStops.size();i++){
            actualListOfStops.get(i).getListOfPassengers().sort(comparator);
            expectedListOfStops.get(i).getListOfPassengers().sort(comparator);
        }
        assertEquals(expectedListOfStops, actualListOfStops);
    }
}
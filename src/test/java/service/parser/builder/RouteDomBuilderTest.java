package service.parser.builder;

import entity.BusStop;
import entity.Route;
import org.junit.Before;
import org.junit.Test;
import service.dispatcher.BusStopDispatcher;

import java.util.*;

import static org.junit.Assert.*;

public class RouteDomBuilderTest {
    private Set<Route> expectedSet = new LinkedHashSet<>();
    @Before
    public void fillSet(){
        BusStop b1 = new BusStop( 1);
        BusStop b2 = new BusStop( 2);
        BusStop b3 = new BusStop( 3);
        BusStop b4 = new BusStop(4);
        BusStopDispatcher bsd1 = new BusStopDispatcher(b1);
        BusStopDispatcher bsd2 = new BusStopDispatcher(b2);
        BusStopDispatcher bsd3 = new BusStopDispatcher(b3);
        BusStopDispatcher bsd4 = new BusStopDispatcher(b4);
        List<BusStopDispatcher> listOfStops1 =
                new ArrayList<>(Arrays.asList(bsd1, bsd2, bsd3, bsd4));
        Route route1 = new Route(1, listOfStops1);
        List<BusStopDispatcher> listOfStops2 =
                new ArrayList<>(Arrays.asList(bsd4, bsd3, bsd2, bsd1));
        Route route2 = new Route(2, listOfStops2);
        List<BusStopDispatcher> listOfStops3 =
                new ArrayList<>(Arrays.asList(bsd1, bsd3, bsd4, bsd2));
        Route route3 = new Route(3, listOfStops3);
        expectedSet.addAll(Arrays.asList(route1,route2,route3));
    }

    @Test
    public void buildSetEntities() throws BuilderException {
        String filePath = "src/test/resources/Routes.xml";
        BaseEntitiesBuilder<Route> builder = new RouteDomBuilder();
        builder.buildSetEntities(filePath);
        Set<Route> actualSet = builder.getEntities();
        assertEquals(expectedSet,actualSet);
    }
}
package service.parser.builder;

import entity.BusStop;
import entity.Passenger;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PassengerDomBuilderTest {
    private Set<Passenger> expectedSet = new LinkedHashSet<>();
    @Before
    public void fillSet(){
        Passenger p1 = new Passenger("Den1",new BusStop(2));
        Passenger p2 = new Passenger("Den2",new BusStop(3));
        Passenger p3 = new Passenger("Den3",new BusStop(4));
        expectedSet.addAll(Arrays.asList(p1,p2,p3));
    }

    @Test
    public void buildSetEntities() throws BuilderException {
        String filePath = "src/test/resources/Passengers.xml";
        BaseEntitiesBuilder<Passenger> builder = new PassengerDomBuilder();
        builder.buildSetEntities(filePath);
        Set<Passenger> actualSet =builder.getEntities();
        assertEquals(actualSet,expectedSet);
    }
}
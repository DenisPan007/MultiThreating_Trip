package service.parser;

import entity.Bus;
import entity.Entity;
import org.junit.Before;
import org.junit.Test;
import service.parser.builder.AbstractEntitiesBuilder;
import service.parser.builder.BusDOMBuilder;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class EntityParserTest {
    private Set<Bus> expectedSet = new LinkedHashSet<>();
    @Before
    public void fillSet(){
        Bus b1 = new Bus(1,2);
        Bus b2 = new Bus(1,3);
        Bus b3 = new Bus(1,4);
        expectedSet.addAll(Arrays.asList(b1,b2,b3));
    }

    @Test
    public void parse() throws XmlParserException {
        String filePath = "src/test/resources/Buses.xml";
        String schemaPath = "src/test/resources/BusesXsd.xsd";
        AbstractEntitiesBuilder<Bus> builder = new BusDOMBuilder();
        EntityParser<Bus> parser = new EntityParser<>(builder);
        Set<Bus> actualSet = parser.parse(filePath,schemaPath);
        assertEquals(actualSet,expectedSet);
    }
}
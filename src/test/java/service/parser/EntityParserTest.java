package service.parser;

import entity.Bus;
import org.junit.Before;
import org.junit.Test;
import service.parser.builder.BaseEntitiesBuilder;
import service.parser.builder.BusDomBuilder;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class EntityParserTest {
    private Set<Bus> expectedSet = new LinkedHashSet<>();
    @Before
    public void fillSet(){
        Bus b1 = new Bus(1,5);
        Bus b2 = new Bus(2,4);
        Bus b3 = new Bus(3,3);
        expectedSet.addAll(Arrays.asList(b1,b2,b3));
    }

    @Test
    public void parse() throws XmlParserException {
        String filePath = "src/test/resources/Buses.xml";
        String schemaPath = "src/test/resources/BusesXsd.xsd";
        BaseEntitiesBuilder<Bus> builder = new BusDomBuilder();
        EntityParser<Bus> parser = new EntityParser<>(builder);
        Set<Bus> actualSet = parser.parse(filePath,schemaPath);
        assertEquals(actualSet,expectedSet);
    }
}
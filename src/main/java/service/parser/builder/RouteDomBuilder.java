package service.parser.builder;

import entity.BusStop;
import entity.Route;
import entity.RouteEnum;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import service.dispatcher.BusStopDispatcher;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RouteDomBuilder extends BaseEntitiesBuilder<Route> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void buildSetEntities(String fileName) throws BuilderException {
        LOGGER.debug("Start parsing...");
        try {
            DocumentBuilder docBuilder;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                docBuilder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                LOGGER.error(e);
                throw new BuilderException(e);
            }
            Document doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            entities.clear();
            NodeList routeList = root.getElementsByTagName(RouteEnum.ROUTE.getValue());
            for (int i = 0; i < routeList.getLength(); i++) {
                Element element = (Element) routeList.item(i);
                Route route = buildRoute(element);
                entities.add(route);
            }
        } catch (IOException | SAXException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            throw new BuilderException(e);
        }
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }

    private Route buildRoute(Element routeElement) {
        Route route = new Route();
        route.setNumber(Integer.valueOf(getElementTextContent(routeElement, RouteEnum.NUMBER.getValue())));
        route.setListOfBusStopDispatcher(buildBusStopDispatcher(routeElement));
        return route;
    }
    private List<BusStopDispatcher> buildBusStopDispatcher(Element routeElement ) {
        List<BusStopDispatcher> listOfStops = new ArrayList<>();
        NodeList busStops = routeElement.getElementsByTagName(RouteEnum.BUS_STOPS.getValue());
        Element currentBusStop = (Element) busStops.item(0);
        NodeList stopsList = currentBusStop.getElementsByTagName(RouteEnum.STOP.getValue());
        for (int i = 0; i < stopsList.getLength(); i++) {
           Node node = stopsList.item(i);
            BusStopDispatcher stop = new BusStopDispatcher();
            stop.setBusStop(new BusStop(Integer.valueOf(node.getTextContent())));
            listOfStops.add(stop);

        }
        return listOfStops;
    }
}

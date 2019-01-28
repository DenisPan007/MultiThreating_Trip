package service.parser.builder;

import entity.Bus;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BusDOMBuilder extends AbstractEntitiesBuilder<Bus> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void buildSetEntities(String fileName) throws BuilderException {
        Document doc;
        LOGGER.log(Level.DEBUG, "Start parsing...");
        try {
            DocumentBuilder docBuilder;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                docBuilder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                LOGGER.log(Level.ERROR, e.getMessage());
                throw new BuilderException(e);
            }
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            entities.clear();
            NodeList busesList = root.getElementsByTagName("");
            for (int i = 0; i < busesList.getLength(); i++) {
                Element element = (Element) busesList.item(i);
                Bus bus = buildBus(element);
                entities.add(bus);
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

    private Bus buildBus(Element busElement) {
        Bus bus = new Bus(3,5);
        return bus;
    }
}
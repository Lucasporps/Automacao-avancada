package io.av1;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MobilityCompany extends Thread {
    private ArrayList<Route> routes, executingRoutes, executedRoutes;
    
    public MobilityCompany() {
        this.ReadRoutes();
    }

    public void ReadRoutes() {
		String uriItineraryXML = "data/dados2.xml";
		//String idItinerary = _idRoute;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(uriItineraryXML);
			NodeList nList = doc.getElementsByTagName("vehicle");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) nNode;
					String idRouteAux = Integer.toString(i);
					Node node = elem.getElementsByTagName("route").item(0);
					Element edges = (Element) node;
					String[] itinerary = new String[] { idRouteAux, edges.getAttribute("edges") };
					routes.add(new Route(idRouteAux, itinerary));
				}
			}

			Thread.sleep(100);

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

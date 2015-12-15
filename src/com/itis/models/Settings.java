package com.itis.models;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Settings {
	
	private String baseUrl;

	public Settings(String fileName) {
		generateFromXml(fileName);
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}
	
	private void generateFromXml(String fileName) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(getClass().getResourceAsStream(fileName));
			NodeList baseUrlNodeList = doc.getElementsByTagName("baseUrl");
			if (baseUrlNodeList != null && baseUrlNodeList.getLength() != 0) {
				Node baseUrlNode = baseUrlNodeList.item(0);
				if (baseUrlNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) baseUrlNode;
					baseUrl = baseUrlNode.getTextContent();
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

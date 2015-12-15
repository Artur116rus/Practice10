package com.itis.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.Before;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.itis.helpers.ApplicationManager;
import com.itis.models.BaseModel;
import com.itis.models.Subscription;
import com.itis.models.User;

public class TestBase<T extends BaseModel> {

	protected ApplicationManager app;

	@Before
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}

	@After
	public void tearDown() throws Exception {
		app.stop();
	}
	
	public List<BaseModel> getFromXml(String objectName, String[] fields) {
		try {
			List<BaseModel> objects = new ArrayList<BaseModel>();
			boolean isUser = false;
			if (Arrays.asList(fields).contains("password")) isUser = true;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("objects.xml");
			NodeList nodeList = doc.getElementsByTagName(objectName);
			if (nodeList != null && nodeList.getLength() != 0) {
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node nodeObject = nodeList.item(i);
					if (nodeObject.getNodeType() == Node.ELEMENT_NODE) {
						Element elem = (Element) nodeObject;
						if (isUser) objects.add(createUser(elem));
						else objects.add(createSubscription(elem));
					}
				}
			}
			return objects;
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
		return null;
		
	}
	
	private User createUser(Element elem) {
		User user = new User();
		user.setEmail(elem.getElementsByTagName("email").item(0).getTextContent());
		user.setPassword(elem.getElementsByTagName("password").item(0).getTextContent());
		user.setName(elem.getElementsByTagName("name").item(0).getTextContent());
		user.setPasswordConfirmation(elem.getElementsByTagName("passwordConfirmation").item(0).getTextContent());
		return user;
		
	}
	
	private Subscription createSubscription(Element elem) {
		return new Subscription(elem.getElementsByTagName("email").item(0).getTextContent());
	}
}

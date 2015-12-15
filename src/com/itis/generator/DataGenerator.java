package com.itis.generator;

import java.io.File;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.itis.models.BaseModel;

public class DataGenerator {

	private static String rootElement;
	private static String objectElement;
	private static String[] fields;

	public static <T extends BaseModel> T createTestData(Class<T> clazz) {
		if (clazz.getName().contains("User")) {
			generateUsersXml(1);
		} else {
			generateSubscriptionsXml(1);
		}
		return null;
	}

	private static void generateUsersXml(int count) {
		rootElement = "users";
		objectElement = "user";
		fields = new String[] { "name", "email", "password",
				"passwordConfirmation" };
		generateXml(count);
	}

	private static void generateSubscriptionsXml(int count) {
		rootElement = "subscriptions";
		objectElement = "subscription";
		fields = new String[] { "email" };
		generateXml(count);
	}

	private static void generateXml(int count) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Element root = doc.createElement(rootElement);
			doc.appendChild(root);
			for(int i = 0; i < count; i++) {
				Element object = doc.createElement(objectElement);
				root.appendChild(object);
				
				for (String field : fields) {
					Element fieldElem = doc.createElement(field);
					if ("email".equals(field)) {
						fieldElem.appendChild(doc.createTextNode(getRandomText() + "@gmail.com"));
					} else {
						fieldElem.appendChild(doc.createTextNode(getRandomText()));
					}
					object.appendChild(fieldElem);
				}
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("objects.xml"));
			transformer.transform(source, result);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String getRandomText() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

}

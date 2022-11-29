package com.lincentpega.alfatestassignment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@SpringBootTest
public class XmlParserTest {
    @Value("${xml.data.path}")
    private Resource xmlLocation;
    private Document doc;

    @BeforeEach
    public void init() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        doc = builder.parse(xmlLocation.getFile());
        doc.getDocumentElement().normalize();
    }

    @Test
    public void whenGetElementByTag_thenSuccess() {
        NodeList nodeList = doc.getElementsByTagName("Storage");

        Node first = nodeList.item(0);
        assertEquals(1, nodeList.getLength());
        assertEquals(Node.ELEMENT_NODE, first.getNodeType());
        assertEquals("Storage", first.getNodeName());
    }

    @Test
    public void whenGetFirstElementAttributes_thenSuccess() {
        Node storage = doc.getElementsByTagName("Storage").item(0);
        NamedNodeMap attributes = storage.getAttributes();

        assertEquals(1, attributes.getLength());
        assertEquals("id", attributes.item(0).getNodeName());
        assertEquals("1", attributes.item(0).getNodeValue());
    }

    @Test
    public void whenGetChildNodes_thenSuccess() {
        Node storage = doc.getElementsByTagName("Storage").item(0);
        NodeList childNodes = storage.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node current = childNodes.item(i);
            if (current.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(current.getNodeName());
            }
        }
    }
}

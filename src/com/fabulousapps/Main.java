package com.fabulousapps;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class Main {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {

            builder = factory.newDocumentBuilder();
            while(true) {

                System.out.println("Enter currency you want to convert(dolltorup to convert dollar to rupee)(ruptodol to convert rupee to dollar): ");
                Scanner employee = new Scanner(System.in);

                File document = new File("C:/Users/bassi/IdeaProjects/Currency Converter/src/CurrencyDatabase.xml");
                String empid = employee.nextLine();

                doc = builder.parse("C:/Users/bassi/IdeaProjects/Currency Converter/src/CurrencyDatabase.xml");

                // Create XPathFactory object
                XPathFactory xpathFactory = XPathFactory.newInstance();

                // Create XPath object
                XPath xpath = xpathFactory.newXPath();
                XPathExpression name =
                        xpath.compile("/conversionsData\n/conversion[@id='" + empid + "']/default/text()");
                String currency = (String) name.evaluate(doc, XPathConstants.STRING);
                float currencyF = Float.parseFloat(currency);
                while (true){
                    System.out.println("amount> ");
                    Scanner amountInp = new Scanner(System.in);
                    float amount = amountInp.nextFloat();
                    float result = amount * currencyF;
                    System.out.println("The result is: " + result);
                }



            }











        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
            e.printStackTrace();
        }
	// write your code here
    }
}

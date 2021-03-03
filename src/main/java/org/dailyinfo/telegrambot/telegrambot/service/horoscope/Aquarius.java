package org.dailyinfo.telegrambot.telegrambot.service.horoscope;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aquarius {
    public static List<Object> getAquarius(int index) {
        return Collections.singletonList(aquarius.get(index));
    }

    public static void setAquarius(Object nextElementInCapricorn) {
        aquarius.add(nextElementInCapricorn);
    }

    static List<Object> aquarius = new ArrayList<>();

    public String forAquarius(String name, int index){

        try {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document document = documentBuilder.parse("horoscope.xml");


            Node root = document.getDocumentElement();

            System.out.println("This horoscope for Aquarius:");
            System.out.println();

            NodeList books = root.getChildNodes();
            // for (int i = 0; i < books.getLength(); i++) {

            Node book = books.item(23);
            // Если нода не текст, то это книга - заходим внутрь
            if (book.getNodeType() != Node.TEXT_NODE) {
                NodeList bookProps = book.getChildNodes();
                for(int j = 0; j < bookProps.getLength(); j++) {

                    Node bookProp = bookProps.item(j);
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                        //    System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());

                        Aquarius.setAquarius(Collections.singletonList(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent()));


                    }
                }

            }



        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
return "\n" + name + "\n" + getAquarius(index).toString();
    }

}


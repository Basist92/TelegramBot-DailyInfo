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

public class Virgo {
    public static List<Object> getVirgo(int index) {
        return Collections.singletonList(virgo.get(index));
    }

    public static void setVirgo(Object nextElementInVirgo) {

        virgo.add(nextElementInVirgo);
    }

    static List<Object> virgo = new ArrayList<>();

    public String forVirgo(String name, int index){
        try {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document document = documentBuilder.parse("horoscope.xml");


            Node root = document.getDocumentElement();

            System.out.println("This horoscope for virgo:");
            System.out.println();

            NodeList books = root.getChildNodes();
            // for (int i = 0; i < books.getLength(); i++) {

            Node book = books.item(13);
            // Если нода не текст, то это книга - заходим внутрь
            if (book.getNodeType() != Node.TEXT_NODE) {
                NodeList bookProps = book.getChildNodes();
                for(int j = 0; j < bookProps.getLength(); j++) {

                    Node bookProp = bookProps.item(j);
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                        // System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());

                        Virgo.setVirgo(Collections.singletonList(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent()));
//                        System.out.println(Virgo.virgo.size());
//                        for (int k = 0; k<Virgo.virgo.size(); k++)
//                            System.out.println(Virgo.virgo.get(k));
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
return "\n" + name + "\n" + getVirgo(index).toString();
    }
}


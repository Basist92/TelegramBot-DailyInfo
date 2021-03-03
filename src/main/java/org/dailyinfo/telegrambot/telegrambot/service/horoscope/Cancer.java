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

public class Cancer {
    public static List<Object> getCancer(int index) {
        return Collections.singletonList(cancer.get(index));
    }


    public static void setCancer(Object nextElementInCancer) {
        cancer.add(nextElementInCancer);
    }

    static List<Object> cancer = new ArrayList<>();

    public String forCancer(String name, int index){
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("horoscope.xml");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            System.out.println("This horoscope for Cancer:");
            System.out.println();
            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList books = root.getChildNodes();
            // for (int i = 0; i < books.getLength(); i++) {

            Node book = books.item(9);
            // Если нода не текст, то это книга - заходим внутрь
            if (book.getNodeType() != Node.TEXT_NODE) {
                NodeList bookProps = book.getChildNodes();
                for(int j = 0; j < bookProps.getLength(); j++) {

                    Node bookProp = bookProps.item(j);
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                        //  System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());

                       Cancer.setCancer(Collections.singletonList(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent()));
//                        System.out.println(Cancer.cancer.size());
//                        for (int k = 0; k<Cancer.cancer.size(); k++)
//                            System.out.println(Cancer.cancer.get(k));
                    }
                }
            }

            //  }

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
return "\n" + name + "\n" + getCancer(index).toString();
    }

}


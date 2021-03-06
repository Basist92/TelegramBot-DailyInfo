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

public class Gemini {
    public static List<Object> getGemini(int index) {
        return Collections.singletonList(gemini.get(index));
    }

    public static void setGemini(Object o) {

        gemini.add(o);
    }

    static List<Object> gemini = new ArrayList<>();
    public String forGemini(String name, int index){
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("horoscope.xml");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            System.out.println("This horoscope for Gemini:");
            System.out.println();
            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList books = root.getChildNodes();
            // for (int i = 0; i < books.getLength(); i++) {

            Node book = books.item(7);
            // Если нода не текст, то это книга - заходим внутрь
            if (book.getNodeType() != Node.TEXT_NODE) {
                NodeList bookProps = book.getChildNodes();
                for(int j = 0; j < bookProps.getLength(); j++) {

                    Node bookProp = bookProps.item(j);
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                        //  System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());

                        Gemini.setGemini(Collections.singletonList(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent()));
//                        System.out.println(Gemini.gemini.size());
//                        for (int k = 0; k<Gemini.gemini.size(); k++)
//                            System.out.println(Gemini.gemini.get(k));
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
return "\n" + name + "\n" + getGemini(index).toString();
    }


}


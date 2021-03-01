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



class Aries extends Horoscope {
    static List<Object> aries = new ArrayList<>();

    public static List<Object> getAries(int index) {
        System.out.println(aries.get(index));
        return Collections.singletonList(aries.get(index));
    }
    public static void setAries(Object nextElementInAries) {
        Aries.aries = aries;
        aries.add(nextElementInAries);

    }
    public void forAries(){
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("horoscope.xml");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            System.out.println("This horoscope for Aries:");
            System.out.println();
            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList books = root.getChildNodes();
            // for (int i = 0; i < books.getLength(); i++) {

            Node book = books.item(3);
            // Если нода не текст, то это книга - заходим внутрь
            if (book.getNodeType() != Node.TEXT_NODE) {
                NodeList bookProps = book.getChildNodes();
                for(int j = 0; j < bookProps.getLength(); j++) {

                    Node bookProp = bookProps.item(j);
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                        //  System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
                        Aries.setAries(Collections.singletonList(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent()));

//                        System.out.println(Aries.aries.size());
//                        for (int k = 0; k<Aries.aries.size(); k++)
//                            System.out.println(Aries.aries.get(k));
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

    }
}



class Taurus extends Horoscope {
    public static List<Object> getTaurus(int index) {
        return Collections.singletonList(taurus.get(index));
    }

    public static void setTaurus(Object nextElementInTaurus) {

        taurus.add(nextElementInTaurus);
    }
    static List<Object> taurus = new ArrayList<>();
    public void forTaurus(){
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("horoscope.xml");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            System.out.println("This horoscope for taurus:");
            System.out.println();
            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList books = root.getChildNodes();
            // for (int i = 0; i < books.getLength(); i++) {

            Node book = books.item(5);
            // Если нода не текст, то это книга - заходим внутрь
            if (book.getNodeType() != Node.TEXT_NODE) {
                NodeList bookProps = book.getChildNodes();
                for(int j = 0; j < bookProps.getLength(); j++) {

                    Node bookProp = bookProps.item(j);
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                        // System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());

                        Taurus.setTaurus(Collections.singletonList(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent()));
//                        System.out.println(Taurus.taurus.size());
//                        for (int k = 0; k<Taurus.taurus.size(); k++)
//                            System.out.println(Taurus.taurus.get(k));
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

    }

}


class Gemini extends Horoscope {
    public static List<Object> getGemini(int index) {
        return Collections.singletonList(gemini.get(index));
    }

    public static void setGemini(Object o) {

        gemini.add(o);
    }

    static List<Object> gemini = new ArrayList<>();
    public void forGemini(){
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

    }


}

class Cancer extends Horoscope {
    public static List<Object> getCancer(int index) {
        return Collections.singletonList(cancer.get(index));
    }

    public static void setCancer(Object nextElementInCancer) {
        cancer.add(nextElementInCancer);
    }

    static List<Object> cancer = new ArrayList<>();

    public void forCancer(){
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

    }

}

class Leo extends Horoscope {
    public static List<Object> getLeo(int index) {
        return Collections.singletonList(leo.get(index));
    }

    public static void setLeo(Object nextElementInLeo) {

        leo.add(nextElementInLeo);
    }


    static List<Object> leo = new ArrayList<>();

    public void forLeo(){
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("horoscope.xml");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

            System.out.println("This horoscope for leo:");
            System.out.println();
            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList books = root.getChildNodes();
            // for (int i = 0; i < books.getLength(); i++) {

            Node book = books.item(11);
            // Если нода не текст, то это книга - заходим внутрь
            if (book.getNodeType() != Node.TEXT_NODE) {
                NodeList bookProps = book.getChildNodes();
                for(int j = 0; j < bookProps.getLength(); j++) {

                    Node bookProp = bookProps.item(j);
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                        // System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());

                        Leo.setLeo(Collections.singletonList(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent()));
//                        System.out.println(Leo.leo.size());
//                        for (int k = 0; k<Leo.leo.size(); k++)
//                            System.out.println(Leo.leo.get(k));
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

    }

}

class Virgo extends Horoscope {
    public static List<Object> getVirgo(int index) {
        return Collections.singletonList(virgo.get(index));
    }

    public static void setVirgo(Object nextElementInVirgo) {

        virgo.add(nextElementInVirgo);
    }

    static List<Object> virgo = new ArrayList<>();

    public void forVirgo(){
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

    }
}


class Libra extends Horoscope {
    public static List<Object> getLibra(int index) {
        return Collections.singletonList(libra.get(index));
    }

    public static void setLibra(Object nextElementInLibra) {

        libra.add(nextElementInLibra);
    }

    static List<Object> libra = new ArrayList<>();

    public void forLibra(){
        try {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document document = documentBuilder.parse("horoscope.xml");


            Node root = document.getDocumentElement();

            System.out.println("This horoscope for libra:");
            System.out.println();

            NodeList books = root.getChildNodes();
            // for (int i = 0; i < books.getLength(); i++) {

            Node book = books.item(15);
            // Если нода не текст, то это книга - заходим внутрь
            if (book.getNodeType() != Node.TEXT_NODE) {
                NodeList bookProps = book.getChildNodes();
                for(int j = 0; j < bookProps.getLength(); j++) {

                    Node bookProp = bookProps.item(j);
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                        // System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());

                        Libra.setLibra(Collections.singletonList(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent()));
//                        System.out.println(Libra.libra.size());
//                        for (int k = 0; k<Libra.libra.size(); k++)
//                            System.out.println(Libra.libra.get(k));
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

    }

}

class Scorpio extends Horoscope{
    public static List<Object> getScorpio(int index) {
        return Collections.singletonList(scorpio.get(index));
    }

    public static void setScorpio(Object nextElementInScorpio) {

        scorpio.add(nextElementInScorpio);
    }

    static List<Object> scorpio = new ArrayList<>();

    public void forScorpio(){
        try {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document document = documentBuilder.parse("horoscope.xml");


            Node root = document.getDocumentElement();

            System.out.println("This horoscope for Scorpio:");
            System.out.println();

            NodeList books = root.getChildNodes();
            // for (int i = 0; i < books.getLength(); i++) {

            Node book = books.item(17);
            // Если нода не текст, то это книга - заходим внутрь
            if (book.getNodeType() != Node.TEXT_NODE) {
                NodeList bookProps = book.getChildNodes();
                for(int j = 0; j < bookProps.getLength(); j++) {

                    Node bookProp = bookProps.item(j);
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                        // System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());

                        Scorpio.setScorpio(Collections.singletonList(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent()));
//                        System.out.println(Scorpio.scorpio.size());
//                        for (int k = 0; k<Scorpio.scorpio.size(); k++)
//                            System.out.println(Scorpio.scorpio.get(k));
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

    }


}


class Sagittarius extends Horoscope {
    public static List<Object> getSagittarius(int index) {
        return Collections.singletonList(sagittarius.get(index));
    }

    public static void setSagittarius(Object nextElementInSagittarius) {

        sagittarius.add(nextElementInSagittarius);
    }

    static List<Object> sagittarius = new ArrayList<>();

    public void forSaggitarius(){
        try {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document document = documentBuilder.parse("horoscope.xml");


            Node root = document.getDocumentElement();

            System.out.println("This horoscope for Saggitarius:");
            System.out.println();

            NodeList books = root.getChildNodes();
            // for (int i = 0; i < books.getLength(); i++) {

            Node book = books.item(19);
            // Если нода не текст, то это книга - заходим внутрь
            if (book.getNodeType() != Node.TEXT_NODE) {
                NodeList bookProps = book.getChildNodes();
                for(int j = 0; j < bookProps.getLength(); j++) {

                    Node bookProp = bookProps.item(j);
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                        //   System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());

                        Sagittarius.setSagittarius(Collections.singletonList(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent()));
//                        System.out.println(Sagittarius.sagittarius.size());
//                        for (int k = 0; k<Sagittarius.sagittarius.size(); k++)
//                            System.out.println(Sagittarius.sagittarius.get(k));
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

    }



}

class Capricorn extends Horoscope{
    public static List<Object> getCapricorn(int index) {
        return Collections.singletonList(capricorn.get(index));
    }

    public static void setCapricorn(Object nextElementInCapricorn) {
        capricorn.add(nextElementInCapricorn);
    }

    static List<Object> capricorn = new ArrayList<>();

    public void forCapricorn(){
        try {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document document = documentBuilder.parse("horoscope.xml");


            Node root = document.getDocumentElement();

            System.out.println("This horoscope for Capricorn:");
            System.out.println();

            NodeList books = root.getChildNodes();
            // for (int i = 0; i < books.getLength(); i++) {

            Node book = books.item(21);
            // Если нода не текст, то это книга - заходим внутрь
            if (book.getNodeType() != Node.TEXT_NODE) {
                NodeList bookProps = book.getChildNodes();
                for(int j = 0; j < bookProps.getLength(); j++) {

                    Node bookProp = bookProps.item(j);
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                        //   System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());

                        Capricorn.setCapricorn(Collections.singletonList(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent()));
//                        System.out.println(Capricorn.capricorn.size());
//                        for (int k = 0; k<Capricorn.capricorn.size(); k++)
//                            System.out.println(Capricorn.capricorn.get(k));
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

    }



}

class Pisces extends Horoscope{
    public static List<Object> getPisces(int index) {
        return Collections.singletonList(pisces.get(index));
    }

    public static void setPisces(Object nextElementInPisces) {
        pisces.add(nextElementInPisces);
    }

    static List<Object> pisces = new ArrayList<>();

    public void forPisces(){
        try {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document document = documentBuilder.parse("horoscope.xml");


            Node root = document.getDocumentElement();

            System.out.println("This horoscope for Pisces:");
            System.out.println();

            NodeList books = root.getChildNodes();
            // for (int i = 0; i < books.getLength(); i++) {

            Node book = books.item(25);
            // Если нода не текст, то это книга - заходим внутрь
            if (book.getNodeType() != Node.TEXT_NODE) {
                NodeList bookProps = book.getChildNodes();
                for(int j = 0; j < bookProps.getLength(); j++) {

                    Node bookProp = bookProps.item(j);
                    // Если нода не текст, то это один из параметров книги - печатаем
                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                        //  System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());

                        Pisces.setPisces(Collections.singletonList(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent()));
//                        System.out.println(Pisces.pisces.size());
//                        for (int k = 0; k<Pisces.pisces.size(); k++)
//                            System.out.println(Pisces.pisces.get(k));
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

    }


}

class Aquarius extends Horoscope{
    public static List<Object> getAquarius(int index) {
        return Collections.singletonList(aquarius.get(index));
    }

    public static void setAquarius(Object nextElementInCapricorn) {
        aquarius.add(nextElementInCapricorn);
    }

    static List<Object> aquarius = new ArrayList<>();

    public void forAquarius(){
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
//                        System.out.println(Aquarius.aquarius.size());
//                        for (int k = 0; k<Aquarius.aquarius.size(); k++)
//                            System.out.println(Aquarius.aquarius.get(k));
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

    }



}





public class Horoscope {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {


        Gemini gemini = new Gemini();
        gemini.forGemini();

        Cancer cancer = new Cancer();
        cancer.forCancer();

        Leo leo = new Leo();
        leo.forLeo();

        Virgo virgo = new Virgo();
        virgo.forVirgo();

        Libra libra = new Libra();
        libra.forLibra();

        Scorpio scorpio = new Scorpio();
        scorpio.forScorpio();

        Sagittarius sagittarius = new Sagittarius();
        sagittarius.forSaggitarius();

        Capricorn capricorn = new Capricorn();
        capricorn.forCapricorn();

        Aquarius aquarius = new Aquarius();
        aquarius.forAquarius();

        Pisces pisces = new Pisces();
        pisces.forPisces();

        Aries aries = new Aries();
        aries.forAries();


        Taurus taurus = new Taurus();
        taurus.forTaurus();





    }
}




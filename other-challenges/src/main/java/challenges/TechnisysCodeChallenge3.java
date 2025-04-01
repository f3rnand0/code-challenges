package technical.challenges;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TechnisysCodeChallenge3 {
    public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        List<Integer> col = new ArrayList<>();
        try {
            db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            try {
                Document doc = db.parse(is);
                NodeList elements = doc.getDocumentElement().getElementsByTagName("entry");
                for (int i = 0; i < elements.getLength(); i++) {
                    Element entry = (Element) elements.item(i);
                    if (entry.getElementsByTagName("message").item(0).getTextContent().equals(message)) {
                        int value = Integer.valueOf(entry.getAttributeNode("id").getValue());
                        col.add(value);
                    }
                }
            } catch (SAXException e) {
                System.out.println("SAXException");
            } catch (IOException e) {
                System.out.println("IOException");
            }
        } catch (ParserConfigurationException e1) {
            System.out.println("ParserConfigurationException");
        }
        return col;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<log>\n" +
                "    <entry id=\"1\">\n" +
                "        <message>Application started</message>\n" +
                "    </entry>\n" +
                "    <entry id=\"2\">\n" +
                "        <message>Application ended</message>\n" +
                "    </entry>\n" +
                "</log>";

        Collection<Integer> ids = getIdsByMessage(xml, "Application started");
        for (int id : ids)
            System.out.println(id);
    }
}
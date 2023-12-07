package refactoring;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
// import java.util.Iterator;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class PrintOutXML {

  public static void print(Customer customer)
      throws FileNotFoundException, XMLStreamException, UnsupportedEncodingException {
    try {
      String currentPath = new java.io.File(".").getCanonicalPath();
      String filePath = currentPath + "/src/refactoring/xmlOutput.xml";

      System.out.println(currentPath);
      Writer fileWriter = new FileWriter(filePath);

      XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

      XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(fileWriter);

      xmlStreamWriter.writeStartElement(customer.getName());
      xmlStreamWriter.writeAttribute("totalAmount", customer.getTotalAmount() + "");
      xmlStreamWriter.writeAttribute("totalPoints", customer.getPoints() + "");

      customer.getRentals().forEach(rental -> {
        try {
          Movie movie = rental.getMovie();
          xmlStreamWriter.writeStartElement(movie.getTitle().replaceAll("\\s", ""));
          xmlStreamWriter.writeAttribute("feeAmounts", rental.getAmount() + "");
          xmlStreamWriter.writeAttribute("points", rental.getPoints() + "");

        } catch (XMLStreamException e) {
          e.printStackTrace();
        }
        try {
          xmlStreamWriter.writeEndElement();
        } catch (XMLStreamException e) {
          e.printStackTrace();
        }
      });

      xmlStreamWriter.writeEndElement();
      xmlStreamWriter.writeEndDocument();
      xmlStreamWriter.flush();
      xmlStreamWriter.close();
      System.out.println("XML file created successfully.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

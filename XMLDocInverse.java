import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;

public class XMLDocInverse
{

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException{  
		DocumentBuilderFactory dBfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dBfactory.newDocumentBuilder();
		// Fetch XML File
		Document document = builder.parse(new File("tags.xml"));
		document.getDocumentElement().normalize();
		//Get root node
		Element root = document.getDocumentElement();
		String rootNode=root.getNodeName().toString();
		String childNode1="",childNode2="";
		//Get all nodes
		NodeList nList = document.getDocumentElement().getChildNodes();
		
    for (int i = 0; i < nList.getLength(); i++)
		{
		  Node node = nList.item(i);
		  	if (node.getNodeType() == Node.ELEMENT_NODE){
      		  Element element = (Element) node;
      		    if(!node.getNodeName().equals("#text")){
      		      childNode1=node.getNodeName().toString();
      		      NodeList nList1 = element.getElementsByTagName(childNode1);
      		  
      		      for (int i1 = 0; i1 < nList1.getLength(); i1++){
      		  	   Node node1 = nList1.item(i);
      		  	   //System.out.println(node1.getNodeName());
      		  	   //childNode2="c";
      		  	   childNode2=node1.getNodeName().toString();
		  	 }
		    }
		  }
		}
    System.out.println("<"+childNode2+"><"+childNode1+"><"+rootNode+"></"+rootNode+"></"+childNode1+"></"+childNode2+">");
	}
}
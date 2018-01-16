package xmlApp;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import xmlProject.Customer;

public class UnMarshallar {

	public static void main(String[] args) throws DatatypeConfigurationException {
		try {

			File file = new File("K:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Customer author = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(ReflectionToStringBuilder.toString(author));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}

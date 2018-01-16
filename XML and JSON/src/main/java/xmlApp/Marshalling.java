package xmlApp;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import xmlProject.Address;
import xmlProject.Card;
import xmlProject.Customer;

public class Marshalling {
	public static void main(String[] args) throws DatatypeConfigurationException {
		try {

			File file = new File("C:\\temp\\bookData.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Customer author = createAuthor();
			jaxbMarshaller.marshal(author, file);
			jaxbMarshaller.marshal(author, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static Customer createAuthor() throws DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

		Customer customer = new Customer();
		Address address = new Address();
		Card card = new Card();
		Card card2 = new Card();
		card.setCardNumber(1473847596);
		card.setCardName("chase");
		card.setCardType("CREDITCARD");
		card.setDateFrom(date2);
		card.setDateTO(date2);

		card2.setCardNumber(347859378);
		card2.setCardName("city");
		card2.setCardType("DEBITCARD");
		card2.setDateFrom(date2);
		card2.setDateTO(date2);
		customer.getPayment().add(card);
		customer.getPayment().add(card2);

		address.setAddres("3839 Baldwin ave, Los Angeles, CA 91731");
		customer.setCustomerId(1);
		customer.setName("Akash");
		customer.setAnualSalary(70000);
		customer.setDataOfBirth(date2);
		customer.setAddress(address);

		return customer;
	}

}

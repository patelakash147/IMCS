package jsonApp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jsonProject.Address;
import jsonProject.Customer;
import jsonProject.Payment;

public class JsonMapper {

	private static String FILE_PATH = "K:\\test.json";

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Enter your Choice");
			System.out.println("1 Serialize JSON");
			System.out.println("2 Deserialize JSON");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				serialize();
				break;
			case 2:
				deserialize();
				break;

			}
		}

	}

	private static void serialize() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		// convert Object to json string
		Customer emp = createCustomer();

		// configure Object mapper for pretty print
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		// writing to console, can write to any output stream such as file
		objectMapper.writeValue(System.out, emp);
		objectMapper.writeValue(new PrintWriter("K:\\\\test.json"), emp);
	}

	public static void deserialize() throws IOException {

		// read json file data to String
		byte[] jsonData = Files.readAllBytes(Paths.get(FILE_PATH));

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		// convert json string to object
		Customer emp = objectMapper.readValue(jsonData, Customer.class);

		System.out.println("Customer Object\n" + emp);

	}

	private static Customer createCustomer() {
		Customer customer = new Customer();
		Address address = new Address();
		Payment payment = new Payment();
		Payment payment2 = new Payment();
		address.setAddress("3839 Baldwin ave, Los Angeles, CA 91731");
		payment.setCardNumber(347826738);
		payment.setCardName("Chase");
		payment.setCardType("CREDITCARD");
		payment.setDateForm(new Date());
		payment.setDateTo(new Date());
		payment2.setCardNumber(467384675);
		payment2.setCardName("City");
		payment2.setCardType("DEBITCARD");
		payment2.setDateForm(new Date());
		payment2.setDateTo(new Date());
		List<Payment> list = new ArrayList<>();
		list.add(payment);
		list.add(payment2);
		customer.setCustomerId(1);
		customer.setName("Akash");
		customer.setDateOfBirth(new Date());
		customer.setAnnualSalary(60000);
		customer.setAddress(address);
		customer.setPayment(list);
		return customer;
	}

}

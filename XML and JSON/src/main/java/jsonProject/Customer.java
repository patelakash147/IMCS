package jsonProject;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class Customer {
	
	@Getter @Setter int customerId;
	@Getter @Setter String name;
	@Getter @Setter Date dateOfBirth;
	@Getter @Setter float annualSalary;
	@Getter @Setter Address address;
	@Getter @Setter List<Payment> payment;

}

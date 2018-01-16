package jsonProject;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Payment {
	
	@Getter @Setter int cardNumber;
	@Getter @Setter String cardName;
	@Getter @Setter Date dateForm;
	@Getter @Setter  Date dateTo;
	@Getter @Setter String CardType;
	
	

}

package pojo;

import java.util.Date;

public class Order {

	private int orderIDPK;
	private int custIdFk;
	private Date invoiceCreationDate;
	private Date deliveryDueDate;
	private Date paymentDueDate;
	private String customMessage;
	
	public int getOrderIDPK() {
		return orderIDPK;
	}
	public void setOrderIDPK(int orderIDPK) {
		this.orderIDPK = orderIDPK;
	}
	public int getCustIdFk() {
		return custIdFk;
	}
	public void setCustIdFk(int custIdFk) {
		this.custIdFk = custIdFk;
	}
	public Date getInvoiceCreationDate() {
		return invoiceCreationDate;
	}
	public void setInvoiceCreationDate(Date invoiceCreationDate) {
		this.invoiceCreationDate = invoiceCreationDate;
	}
	public Date getDeliveryDueDate() {
		return deliveryDueDate;
	}
	public void setDeliveryDueDate(Date deliveryDueDate) {
		this.deliveryDueDate = deliveryDueDate;
	}
	public Date getPaymentDueDate() {
		return paymentDueDate;
	}
	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	public String getCustomMessage() {
		return customMessage;
	}
	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}
 
	
}

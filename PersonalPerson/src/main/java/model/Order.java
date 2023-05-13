package model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import jakarta.persistence.OneToMany;

@Entity
@Table(name = "orderr")
public class Order {
//	+mã đơn hàng
//	+tên đơn hàng--
//	+địa chỉ người mua
//	+địa chỉ người nhận
//	+Trạng thái:mới tạo,đang xử lí,đang giao hàng,giao hàng thành công,trả hàng
//	+hình thức thanh toán
//	+trạng thái thanh toán
//	+số tiền đã thanh toán
//	+số tiền còn thiếu
@Id
	private String orderCode;

@ManyToMany(mappedBy = "ord")
	private Set<Client> client;
	private String purchaseAddress;
	private String receiverAddress;
	private String personReceiver;
	private String status_; //trạng thái
	private String payments;//hình thức thanh toán
	private String paymentStatus;
	private double amountPaid; 
	//amount:số lượng,tiền
	//paid:trả
	private double missingAmount;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderdetails_id")
	private OrderDetails orderDetails;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(String orderCode, Set<Client> client, String purchaseAddress, String receiverAddress, String status,
			String payments, String paymentStatus, double amountPaid, double missingAmount) {
		super();
		this.orderCode = orderCode;
		this.client = client;
		this.purchaseAddress = purchaseAddress;
		this.receiverAddress = receiverAddress;
		this.status_ = status;
		this.payments = payments;
		this.paymentStatus = paymentStatus;
		this.amountPaid = amountPaid;
		this.missingAmount = missingAmount;
	}

	public Order(String orderCode, Set<Client> client, String purchaseAddress, String receiverAddress, String status,
			String payments, String paymentStatus, double amountPaid, double missingAmount, OrderDetails orderDetails) {
		super();
		this.orderCode = orderCode;
		this.client = client;
		this.purchaseAddress = purchaseAddress;
		this.receiverAddress = receiverAddress;
		this.status_ = status;
		this.payments = payments;
		this.paymentStatus = paymentStatus;
		this.amountPaid = amountPaid;
		this.missingAmount = missingAmount;
		this.orderDetails = orderDetails;
	}
	
	public String getPersonReceiver() {
		return personReceiver;
	}

	public void setPersonReceiver(String personReceiver) {
		this.personReceiver = personReceiver;
	}

	public Order(String orderCode, Set<Client> client, String purchaseAddress, String receiverAddress,
			String personReceiver, String status_, String payments, String paymentStatus, double amountPaid,
			double missingAmount, OrderDetails orderDetails) {
		super();
		this.orderCode = orderCode;
		this.client = client;
		this.purchaseAddress = purchaseAddress;
		this.receiverAddress = receiverAddress;
		this.personReceiver = personReceiver;
		this.status_ = status_;
		this.payments = payments;
		this.paymentStatus = paymentStatus;
		this.amountPaid = amountPaid;
		this.missingAmount = missingAmount;
		this.orderDetails = orderDetails;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Set<Client> getClient() {
		return client;
	}
	
	public void setClient(Set<Client> client) {
		this.client = client;
	}

	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getPurchaseAddress() {
		return purchaseAddress;
	}
	public void setPurchaseAddress(String purchaseAddress) {
		this.purchaseAddress = purchaseAddress;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getStatus() {
		return status_;
	}
	public void setStatus(String status) {
		this.status_ = status;
	}
	public String getPayments() {
		return payments;
	}
	public void setPayments(String payments) {
		this.payments = payments;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public double getMissingAmount() {
		return missingAmount;
	}
	public void setMissingAmount(double missingAmount) {
		this.missingAmount = missingAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderCode, other.orderCode);
	}
	@Override
	public String toString() {
		return "---------------\norderCode=" + orderCode + "\nclient=" + client.size() +"\npurchaseAddress=" + purchaseAddress
				+ "\nreceiverAddress=" + receiverAddress + "\nstatus=" + status_ + "\npayments=" + payments
				+ "\npaymentStatus=" + paymentStatus + "\namountPaid=" + amountPaid + "\nmissingAmount=" + missingAmount+"\n---------------";
	}
	
}

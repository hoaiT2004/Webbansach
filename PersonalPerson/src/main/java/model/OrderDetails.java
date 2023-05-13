package model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "orderdetails")
public class OrderDetails {//chi tiết đơn hàng
//+mã chi tiết đơn hàng
//	+đơn hàng
//	+Mã sách
//	+số lượng
//	+giá bìa  ==>Bỏ cái này(Xàm)
//	+voucher
//	+giá tiền
//	+thuế VAT
//	+tổng thành tiền
	@Id
	private String orderDetailsCode;
	
	@OneToMany(mappedBy = "orderDetails")
	private Set<Order> order;
	
//	@OneToOne
//	private Book book;
	
	private int count_;
//	private int coverPrice;
	private int voucher;
	private int price;
//	private int tax; //Thuế /taeks/
	private int totalMoney;
	private String sanPham;
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}
//	public OrderDetails(String orderDetailsCode,Set<Order> order,double count, double coverPrice, double voucher,
//			double price, double tax, double totalMoney) {
//		super();
//		this.orderDetailsCode = orderDetailsCode;
//		this.order = order;
////		this.book = book;
//		this.count = count;
//		this.coverPrice = coverPrice;
//		this.voucher = voucher;
//		this.price = price;
//		this.tax = tax;
//		this.totalMoney = totalMoney;
//	}
//	
	public OrderDetails(String orderDetailsCode, int count_, int voucher, int price,
			 int totalMoney) {
		super();
		this.orderDetailsCode = orderDetailsCode;
		this.count_ = count_;
		//this.coverPrice = coverPrice;
		this.voucher = voucher;
		this.price = price;
//		this.tax = tax;
		this.totalMoney = totalMoney;
	}

	public String getOrderDetailsCode() {
		return orderDetailsCode;
	}
	public OrderDetails(String orderDetailsCode, Set<Order> order, int count_, int voucher, int price,
		int totalMoney) {
	super();
	this.orderDetailsCode = orderDetailsCode;
	this.order = order;
	this.count_ = count_;
	//this.coverPrice = coverPrice;
	this.voucher = voucher;
	this.price = price;
//	this.tax = tax;
	this.totalMoney = totalMoney;
}
	public void setOrderDetailsCode(String orderDetailsCode) {
		this.orderDetailsCode = orderDetailsCode;
	}
	
public int getCount_() {
		return count_;
	}
	public void setCount_(int count_) {
		this.count_ = count_;
	}
//	public int getCoverPrice() {
//		return coverPrice;
//	}
//	public void setCoverPrice(int coverPrice) {
//		this.coverPrice = coverPrice;
//	}
	
	public int getVoucher() {
		return voucher;
	}
	public String getSanPham() {
		return sanPham;
	}
	public void setSanPham(String sanPham) {
		this.sanPham = sanPham;
	}
	public void setVoucher(int voucher) {
		this.voucher = voucher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
//	public int getTax() {
//		return tax;
//	}
//	public void setTax(int tax) {
//		this.tax = tax;
//	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	//	public Book getBook() {
//		return book;
//	}
//	public void setBook(Book book) {
//		this.book = book;
//	}
	public Set<Order> getOrder() {
		return order;
	}
	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		return Objects.equals(order, other.order);
	}
	@Override
	public String toString() {
		return "-------------/norderDetailsCode="+orderDetailsCode +"\norder=" + order.size() +"\ncount=" + count_ +  "\nvoucher="
				+ voucher + "\nprice=" + price + "\ntotalMoney=" + totalMoney + "\n-------------";
	}
	
	
}

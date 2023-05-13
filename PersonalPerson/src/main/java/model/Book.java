package model;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "book")
public class Book {
//	+Mã sách
//  +tên sách
//	+Tác giả --
//	+Năm xuất bản
//	+Giá bán
//	+Số lượng
//	+Thể loại --
//	+Ngôn ngữ
//	+mô tả -- describe 
	@Id
	private String bookCode;
	
	private String bookName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="author_id")
	private Author auth;
	
	
	private int publishingYear;
	private double price;
	private int count_;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category cate;
	
	private String language_;
	private String describe_;
	
//	@OneToOne
//	private OrderDetails orderDetails;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String bookCode,String bookName, Author auth, int publishingYear, double price, int count, Category cate,
			String language, String describe_) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.auth = auth;
		this.publishingYear = publishingYear;
		this.price = price;
		this.count_ = count;
		this.cate = cate;
		this.language_ = language;
		this.describe_ = describe_;
	}
	public Author getAuth() {
		return auth;
	}
	public void setAuth(Author auth) {
		this.auth = auth;
	}
	public int getCount_() {
		return count_;
	}
	public void setCount_(int count_) {
		this.count_ = count_;
	}
	public Category getCate() {
		return cate;
	}
	public void setCate(Category cate) {
		this.cate = cate;
	}
	public String getLanguage_() {
		return language_;
	}
	public void setLanguage_(String language_) {
		this.language_ = language_;
	}
	public String getDescribe() {
		return describe_;
	}
	public void setDescribe(String describe_) {
		this.describe_ = describe_;
	}
	
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPublishingYear() {
		return publishingYear;
	}
	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(bookName, other.bookName);
	}
	@Override
	public String toString() {
		return "---------------\nbookName=" + bookName + "\nauthor=" + auth.toString() + "\npublishingYear=" + publishingYear + "\nprice="
				+ price + "\ncount=" + count_ + "\ncategory=" + cate.toString() + "\nlanguage=" + language_ + "\ndescribe="
				+ describe_ + "\n---------------";
	}
	
}

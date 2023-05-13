package model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "category")
public class Category { //thể loại
//	+Mã thể loại
//	+Tên thể loại
	@Id
	private String categoryCode;
	private String categoryName;
//	
//	@OneToMany(mappedBy = "cate",cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "cate")
	private Set<Book> book;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(String categoryCode, String categoryName) {
		super();
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
	}
	
	public Category(String categoryCode, String categoryName, Set<Book> book) {
		super();
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.book = book;
	}
	
	public Set<Book> getBook() {
		return book;
	}
	public void setBook(Set<Book> book) {
		this.book = book;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(categoryCode, other.categoryCode);
	}
	@Override
	public String toString() {
		return "---------------\ncategoryCode=" + categoryCode + "\ncategoryName=" + categoryName + "\n---------------";
	}
	
}

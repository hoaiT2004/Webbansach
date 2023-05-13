package model;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "author")
public class Author { //tác giả
//	+mã tác gỉa
//	+Tên tác giả
//	+giới tính
//	+Ngày sinh
//	+Tiểu sử
	@Id
	private String authorCode;
	private String authorNames;
	private String sex;
	private Date dateOfBirth;
	private String story;
	
	//@OneToMany(mappedBy = "auth",cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "auth")
	private Set<Book> book;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(String authorCode, String authorNames, String sex, Date dateOfBirth, String story) {
		super();
		this.authorCode = authorCode;
		this.authorNames = authorNames;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.story = story;
	}

	public Author(String authorCode, String authorNames, String sex, Date dateOfBirth, String story, Set<Book> book,
			Set<Order> order) {
		super();
		this.authorCode = authorCode;
		this.authorNames = authorNames;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.story = story;
		this.book = book;
		
	}
	
	public Set<Book> getBook() {
		return book;
	}
	public void setBook(Set<Book> book) {
		this.book = book;
	}
	
	
	public String getAuthorCode() {
		return authorCode;
	}
	public void setAuthorCode(String authorCode) {
		this.authorCode = authorCode;
	}
	public String getAuthorNames() {
		return authorNames;
	}
	public void setAuthorNames(String authorNames) {
		this.authorNames = authorNames;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	@Override
	public int hashCode() {
		return Objects.hash(authorCode, authorNames, dateOfBirth, sex, story);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(authorCode, other.authorCode);
				
	}
	@Override
	public String toString() {
		return "-----------------\n-authorCode=" + authorCode + "\n-authorNames=" + authorNames + "\n-sex=" + sex + "\n-dateOfBirth="
				+ dateOfBirth + "\n-story=" + story+"\n---------------";
	}
	
}

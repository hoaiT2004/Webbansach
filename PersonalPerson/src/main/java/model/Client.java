package model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {// khách hàng
//	+Mã khách hàng
//	+Tên đăng nhập
//	+Mật khẩu
//	+Họ và tên
//	+Giới tính
//	+Địa chỉ
//	+Địa chỉ nhận hàng
//	+Ngày sinh
//	+Số điện thoại
//	+Địa chỉ email
	@Id
	private String clientCode;
	private String userName;
	private String password;
	private String fullName;
	private String sex;
	private String address;
	private String receiverAddress;
	private Date dateOfBirth;
	private String phoneNumber;
	private String emailAddress;
	private String verificationCodes;
	private Date TimeOfSpecify;
	private boolean authenticationStatus;
	private String url_;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	// jointable:Là 1 table tạm thời để chứa cả 2 class
	@JoinTable(name = "order_client", joinColumns = { @JoinColumn(name = "id_client") }, inverseJoinColumns = {
			@JoinColumn(name = "id_order") })
	private Set<Order> ord;

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String clientCode, String userName, String password, String fullName, String sex, String address,
			String receiverAddress, Date dateOfBirth, String phoneNumber, String emailAddress) {
		super();
		this.clientCode = clientCode;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.sex = sex;
		this.address = address;
		this.receiverAddress = receiverAddress;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	public Client(String clientCode, String userName, String password, String fullName, String sex, String address,
			String receiverAddress, Date dateOfBirth, String phoneNumber, String emailAddress, String verificationCodes,
			Date TimeOfSpecify, boolean authenticationStatus, String url) {
		super();
		this.clientCode = clientCode;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.sex = sex;
		this.address = address;
		this.receiverAddress = receiverAddress;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.verificationCodes = verificationCodes;
		this.TimeOfSpecify = TimeOfSpecify;
		this.authenticationStatus = authenticationStatus;
		this.url_ = url;
	}

	public Client(String clientCode, String userName, String password, String fullName, String sex, String address,
			String receiverAddress, Date dateOfBirth, String phoneNumber, String emailAddress, String verificationCodes,
			Date TimeOfSpecify, boolean authenticationStatus) {
		super();
		this.clientCode = clientCode;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.sex = sex;
		this.address = address;
		this.receiverAddress = receiverAddress;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.verificationCodes = verificationCodes;
		this.TimeOfSpecify = TimeOfSpecify;
		this.authenticationStatus = authenticationStatus;
	}

	public Client(String clientCode, String userName, String password, String fullName, String sex, String address,
			String receiverAddress, Date dateOfBirth, String phoneNumber, String emailAddress, String verificationCodes,
			Date timeOfSpecify, boolean authenticationStatus, String url_, Set<Order> ord) {
		super();
		this.clientCode = clientCode;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.sex = sex;
		this.address = address;
		this.receiverAddress = receiverAddress;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.verificationCodes = verificationCodes;
		TimeOfSpecify = timeOfSpecify;
		this.authenticationStatus = authenticationStatus;
		this.url_ = url_;
		this.ord = ord;
	}

	public Set<Order> getOrd() {
		return ord;
	}

	public void setOrd(Set<Order> ord) {
		this.ord = ord;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getVerificationCodes() {
		return verificationCodes;
	}

	public void setVerificationCodes(String verificationCodes) {
		this.verificationCodes = verificationCodes;
	}

	public Date getTimeOfSpecify() {
		return TimeOfSpecify;
	}

	public void setTimeOfSpecify(Date timeOfSpecify) {
		TimeOfSpecify = timeOfSpecify;
	}

	public boolean isAuthenticationStatus() {
		return authenticationStatus;
	}

	public void setAuthenticationStatus(boolean authenticationStatus) {
		this.authenticationStatus = authenticationStatus;
	}

	public String getUrl() {
		return url_;
	}

	public void setUrl(String url) {
		this.url_ = url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(clientCode, other.clientCode);
	}

	@Override
	public String toString() {
		return "-------------\nclientCode=" + clientCode + "\nuserName=" + userName + "\npassword=" + password
				+ "\nfullName=" + fullName + "\nsex=" + sex + "\naddress=" + address + "\nreceiverAddress="
				+ receiverAddress + "\ndateOfBirth=" + dateOfBirth + "\nphoneNumber=" + phoneNumber + "\nemailAddress="
				+ emailAddress + "\nĐường dẫn=" + url_ + "\n-------------";
	}

}

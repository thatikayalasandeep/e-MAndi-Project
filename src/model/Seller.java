package model;

public class Seller {
	
	private long sellerid;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String password;
	private String confpassword;
	private String city;
	private String State;
	private long zip;
	
	//constructor with parameters
	public Seller(long sellerid, String firstname, String lastname, String email, String phone, String password,
			String confpassword, String city, String state, long zip) {
		super();
		this.sellerid = sellerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.confpassword = confpassword;
		this.city = city;
		State = state;
		this.zip = zip;
	}
  //constructor with two parameters
	public Seller(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	
	//getters and setters
	public long getSellerid() {
		return sellerid;
	}

	public void setSellerid(long sellerid) {
		this.sellerid = sellerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfpassword() {
		return confpassword;
	}

	public void setConfpassword(String confpassword) {
		this.confpassword = confpassword;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}
	
	
	
}

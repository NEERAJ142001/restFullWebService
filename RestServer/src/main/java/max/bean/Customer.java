package max.bean;

public class Customer {
	private String name;
	private String address;
	private String aadhar;
	private String dob;

	public Customer() {
		super();

	}

	public Customer(String name, String address, String aadhar, String dob) {
		super();
		this.name = name;
		this.address = address;
		this.aadhar = aadhar;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", aadhar=" + aadhar + ", dob=" + dob + "]";
	}

}

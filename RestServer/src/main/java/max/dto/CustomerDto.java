package max.dto;

public class CustomerDto {
	private String name;
	private String address;
	private String aadhar;
	private String dob;
	private String id;
	private String date;
	private int age;

	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(String name, String address, String aadhar, String dob, String id, String date,int age) {
		super();
		this.name = name;
		this.address = address;
		this.aadhar = aadhar;
		this.dob = dob;
		this.id = id;
		this.date = date;
		this.age=age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", address=" + address + ", aadhar=" + aadhar + ", dob=" + dob + ", id="
				+ id + ", date=" + date + ", age=" + age + "]";
	}

}

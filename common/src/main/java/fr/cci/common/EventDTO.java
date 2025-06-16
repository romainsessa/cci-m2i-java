package fr.cci.common;

public class EventDTO {

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public EventDTO() {
		// TODO Auto-generated constructor stub
	}

	public EventDTO(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

}

package entities;

public class Informations {
	private static Informations uniqueInstance;
	
	private Informations() {
	}
	public static synchronized Informations getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Informations();

		return uniqueInstance;
	}
	private static String stateName;
	private static String city;
	private static String cpf;
	
	
	public String getCpf() {
		return cpf;
	}
	public static void setCpf(String cpff) {
		cpf = cpff;
	}

	private static String name;

	public static String getState() {
		return stateName;
	}
	public static void setState(String statee) {
		stateName = statee;
	}
	public static String getCity() {
		return city;
	}
	public static void setCity(String cityy) {
		city = cityy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

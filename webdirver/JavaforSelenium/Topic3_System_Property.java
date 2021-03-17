package JavaforSelenium;

public class Topic3_System_Property {

	public static void main(String[] args) {
		String projectlocation = System.getProperty("user.dir");
		System.out.println(projectlocation);
	}

}

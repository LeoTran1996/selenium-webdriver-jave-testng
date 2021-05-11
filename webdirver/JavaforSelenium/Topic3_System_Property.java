package JavaforSelenium;

public class Topic3_System_Property {

	public static void main(String[] args) {
		String projectlocation = System.getProperty("user.dir");
		String osName = System.getProperty("os.name");
		System.out.println(projectlocation);
		System.out.println(osName);
		System.out.println(projectlocation + "\\Browser\\chromedriver.exe");
	}

}

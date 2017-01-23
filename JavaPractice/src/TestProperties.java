import java.io.FileWriter;
import java.util.*;
public class TestProperties {
	
	
	public static void main(String[] args) {
		Properties p = new Properties();
		p.setProperty("Name", "Varun");
		p.setProperty("Email", "varun5300@gmail.com");
		
		try{
			p.store(new FileWriter("info.properties"),"Javatpoint Properties Example"); 
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

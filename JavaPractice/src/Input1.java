import java.io.*;

public class Input1{

	public static void main(String[] args) throws Exception {
		FileInputStream f1 = new FileInputStream("/Users/varun/Desktop/F1.txt");
		FileInputStream f2 = new FileInputStream("/Users/varun/Desktop/F2.txt");
		FileOutputStream o1 = new FileOutputStream("/Users/varun/Desktop/out.txt");
		SequenceInputStream s1 = new SequenceInputStream(f1, f2);
		
		int i;
		while((i = s1.read()) != -1) {
			System.out.print((char)i);
			o1.write(i);
		}
		s1.close();
		o1.close();
		f2.close();
		f1.close();
		System.out.println("Success....");
	}
}

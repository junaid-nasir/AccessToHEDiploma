import java.io.*;
import static java.lang.System.*;

public class OutWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter("StudentDatabase1.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("Course:30 credits");
			
			pw.close();
		} catch (IOException e) {
			out.println("Error!");
		}
	}

}

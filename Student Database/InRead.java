import java.io.*;
import static java.lang.System.*;

public class InRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("StudentDatabase1.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String str;
			while ((str = br.readLine()) !=null) {
				out.println(str + "\n");
			}
			
			br.close();
		} catch (IOException e) {
			out.println("File not found");
		}
	}

}

import java.io.*;

public class addstud {

public addstud()
{

}

public void addnew()throws Exception
{
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
BufferedReader readFile=new BufferedReader(new FileReader("studentdatabase.txt"));
BufferedWriter writeFile=new BufferedWriter(new FileWriter("studentdatabase.txt",true));

String fn,cs;


System.out.println("Enter Student number:");
String sn=input.readLine();
System.out.println("Enter Fullname:");
fn=input.readLine();
System.out.println("Enter Course & Section");
cs=input.readLine();



int lineNum=0;
String line;

while((line=readFile.readLine())!=null)
{

lineNum++;
if(line.equals("Student number:" + sn))
{
System.out.println("Inputted student number already exists.");
break;
}
else
{

writeFile.newLine();
writeFile.write("Student number:" + sn);
writeFile.newLine();
writeFile.write("Fullname:" + fn);
writeFile.newLine();
writeFile.write("Course & Section:" + cs);
System.out.println(sn +"\n" + fn + "\n" + cs + "\n" + "\nstudent info successfully written to textfile.");
break;
}

}
writeFile.close();
readFile.close();
}
}
import java.util.*;

public class Student {

	int studentID;
	String name;
	String gender;
	String address;
	String postcode;
	double computer_science;
	double math;
	double english;

	public Student(int ID, String name, String gender, String address,
			String postcode, double cs, double math, double english) {

		this.studentID = ID;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.postcode = postcode;
		this.computer_science = cs;
		this.math = math;
		this.english = english;

	}

	//public String getName()
	// {
	// return name;
	// }
	//
	// public String getGender()
	// {
	// return gender;
	// }
	//
	// public String getCourse()
	// {
	// return course;
	// }
	//
	// public String getPostcode()
	// {
	// return postcode;
	// }
	//
	// public String getAddress()
	// {
	// return address;
	// }
	//
	// public double getMath()
	// {
	// return math;
	// }
	//
	// public double getComputerScience()
	// {
	// return computer_science;
	// }
	//
	// public double getEnglish()
	// {
	// return english;
	// }
	//
	// public int getStudentID()
	// {
	// return studentID;
	 //}

	public String toString() {
		return "ID: " + studentID + ", Name: " + name + ", Gender: " + gender
				+ ", Address: " + address + ", Postcode: " + postcode
				+ ", Computer Science: " + computer_science + ", Math: " + math
				+ ", English: " + english;
	}
}
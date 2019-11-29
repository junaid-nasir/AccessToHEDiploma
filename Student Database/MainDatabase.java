import java.io.*;
import java.util.*;

public class MainDatabase implements Serializable {

	static ArrayList<Student> studentsArrayList = new ArrayList<Student>();
	static Scanner input = new Scanner(System.in);
	static final int DB_SIZE = 20;

	public static void main(String[] args) { // Main Menu

		inputStudentData(); // Fill database with default student data.
		mainMenu();
		outputStudentData();
	}

	static void mainMenu() {
		int menuChoice; // Menu Choices = 6
		do {
			System.out.println("\t\t\tStudent Record Menu");
			System.out
					.println("\t\t1. Add Student\t2. Edit Student\t3. Remove Student\t4. Search Students\t5. Report Totals\t6. Classify by Marks\t7. Exit");
			// Show all menu options

			try {
				System.out.println("Enter a choice (1-6): ");
				menuChoice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input. Enter a number 1-7");
				continue;
			}

			if (menuChoice == 1) // Menu Choice 1: Add Student
				addRecord();
			else if (menuChoice == 2) // Menu Choice 2: Edit Student
				editStudent();
			else if (menuChoice == 3) // Menu Choice 3: Remove Student
				removeStudent1();
			else if (menuChoice == 4) // Menu Choice 4: Search students
				searchStudents();
			else if (menuChoice == 5) // Menu Choice 5: Report Totals
				reportTotals();
			else if (menuChoice == 6) // Menu Choice 6: Classify by Marks
				classifyByMarks();
			else if (menuChoice == 7) { // Menu Choice 7: Exit
				System.out.println("\nGood bye!");
				break;
				// outputStudentData();
				// System.exit(0);
			} else
				System.out.println("Incorrect input. Enter a number 1-6");

		} while (true); // continuous loop illustrating main menu

	}

	private static void eof() { // end of file - terminates data entry process
		System.out
				.println("Continue to add/modify record? (Press Enter to continue OR type 'eof' to cancel)");
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();
		if (answer.equals("eof"))
			mainMenu();
	}

	private static void editStudent() {
		// TODO Auto-generated method stub
		System.out.println("StudentID to find");
		String answer = input.nextLine();
		if (answer.equals("eof"))
				return;
				
		// double dblAnswer = -1;
		int studentIDToFind = -1; // stores the users input as an
									// integer
		do { // range check for student Id to use in edit
			try {
				studentIDToFind = Integer.parseInt(answer);
				// converts user input to integer and stores it
				if (studentIDToFind >= 1 && studentIDToFind <= DB_SIZE)
					break;
				else
					System.out.println("Please enter an integer between 1 and "
							+ DB_SIZE + "!");
				return;
			} catch (NumberFormatException e) {
				System.out.println("This is not a valid number! Retry.");
				// break;
			}
		} while (true);

		Student studentToEdit = null;
		for (Student s : studentsArrayList) {
			if (studentIDToFind == s.studentID) {
				studentToEdit = s;
				break;
			}
		}

		if (studentToEdit != null) {
			System.out.println("You have selected to edit:\n" + studentToEdit);
			if (yesOrNoAnswer("Do you want to edit this student?")) {

				// edit student name
				System.out.println("Student name: " + studentToEdit.name);
				System.out
						.println("Enter the student new name [Press RETURN to keep the current one]: ");
				answer = input.nextLine();
				if (!answer.isEmpty())
					if (answer.equals("eof"))
						return;
					else
						studentToEdit.name = answer;

				// edit student gender
				System.out.println("Student gender: " + studentToEdit.gender);
				System.out
						.println("Enter the student new gender [Press RETURN to keep the current one]: ");
				answer = input.nextLine();
				if (!answer.isEmpty())
					if (answer.equals("eof")) {
						System.out
								.println("You have canceled the modification of the student with ID: "
										+ studentToEdit.studentID);
						return;
					} else
						studentToEdit.gender = answer;

				// edit student address
				System.out.println("Student address: " + studentToEdit.address);
				System.out
						.println("Enter the student new address [Press RETURN to keep the current one]: ");
				answer = input.nextLine();
				if (!answer.isEmpty())
					if (answer.equals("eof")) {
						System.out
								.println("You have canceled the modification of the student with ID: "
										+ studentToEdit.studentID);
						return;
					} else
						studentToEdit.address = answer;

				// edit student post code
				System.out.println("Student post code: "
						+ studentToEdit.postcode);
				System.out
						.println("Enter the student new post code [Press RETURN to keep the current one]: ");
				answer = input.nextLine();
				if (!answer.isEmpty())
					if (answer.equals("eof")) {
						System.out
								.println("You have canceled the modification of the student with ID: "
										+ studentToEdit.studentID);
						return;
					} else
						studentToEdit.postcode = answer;

				double newMark;

				// edit computer science mark ;
				do {
					System.out
							.println("Computer Science: Enter a No. between 0 and 100 [Press RETURN to keep the current one]");

					answer = input.nextLine();
					if (!answer.isEmpty())
						if (answer.equals("eof")) {
							System.out
									.println("You have canceled the modification of the student with ID: "
											+ studentToEdit.studentID);
							return;
						} else {
							try {
								newMark = Double.parseDouble(answer);
							} catch (NumberFormatException e) {
								System.out.println("Number not entered.");
								continue;
							}
							if (newMark >= 0 && newMark <= 100) {
								studentToEdit.computer_science = newMark;
								break;
							} else
								System.out
										.println("The entered mark is not in the range 0 - 100");
						}
					if (answer.isEmpty())
						System.out.println("Exam mark not modified");
					break;
				} while (true);

				// edit math mark
				do {
					System.out.println("Maths: Enter a No. between 0 and 100 [Press RETURN to keep the current one]");

					answer = input.nextLine();
					if (!answer.isEmpty())
						if (answer.equals("eof")) {
							System.out
									.println("You have canceled the modification of the student with ID: "
											+ studentToEdit.studentID);
							return;
						} else {
							try {
								newMark = Double.parseDouble(answer);
							} catch (NumberFormatException e) {
								System.out.println("Number not entered.");
								continue;
							}
							if (newMark >= 0 && newMark <= 100) {
								studentToEdit.math = newMark;
								break;
							} else
								System.out
										.println("The entered mark is not in the range 0 - 100");
						}
					if (answer.isEmpty())
						System.out.println("Exam mark not modified");
					break;
				} while (true);
				// edit English mark
				do {
					System.out
							.println("English: Enter a No. between 0 and 100 [Press RETURN to keep the current one]");

					answer = input.nextLine();
					if (!answer.isEmpty())
						if (answer.equals("eof")) {
							System.out
									.println("You have canceled the modification of the student with ID: "
											+ studentToEdit.studentID);
							return;
						} else {
							try {
								newMark = Double.parseDouble(answer);
							} catch (NumberFormatException e) {
								System.out.println("Number not entered.");
								continue;
							}
							if (newMark >= 0 && newMark <= 100) {
								studentToEdit.english = newMark;
								break;
							} else
								System.out
										.println("The entered mark is not in the range 0 - 100");
						}
					if (answer.isEmpty())
						System.out.println("Exam mark not modified");
					break;
				} while (true);
			}
		}

		else
			System.out
					.println("The user with this ID cannot be found in the database!");

	}

	static boolean yesOrNoAnswer(String question) {
		System.out.println(question);
		while (true) {
			System.out.println("Enter Yes/No: ");
			String answer = input.nextLine();
			if (answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y"))
				return true;
			else if (answer.equalsIgnoreCase("No")
					|| answer.equalsIgnoreCase("N"))
				return false;
			else
				System.out.println("Please answer Yes or No!");
		}
	}

	static void inputStudentData() { // read in the student data from a text
										// file
		// System.out.println(System.getProperty("user.dir"));
		try {
			Scanner sf = new Scanner(new File(System.getProperty("user.dir")
					+ "\\studentdata.txt"));
			while (sf.hasNext()) {
				// read next Line
				String stDataLine = sf.nextLine();
				// split the line into several strings using comma as a
				// delimiter and store the strings into a new String array
				String stData[] = stDataLine.split(","); // create an array with
															// 8 strings, each
															// for one of the
															// student data
															// fields
				// trim each string array element and parse it into proper data
				// type and store it into a variable (do this for all 8 elements
				// of the array)
				try {
					int stID = Integer.parseInt(stData[0].trim()); // trim and
																	// convert
																	// the first
																	// array
																	// element
																	// from
																	// string to
																	// integer
																	// and store
																	// it in
																	// variable
																	// stID
					String name = (stData[1].trim());
					String gender = (stData[2].trim());
					String address = (stData[3].trim());
					String postcode = (stData[4].trim());
					double computerscience = Double.parseDouble(stData[5]
							.trim());
					double math = Double.parseDouble(stData[6].trim());
					double english = Double.parseDouble(stData[7].trim());

					// create a new object from the 8 variables where the field
					// data are stored and add the object to the array list
					studentsArrayList.add(new Student(stID, name, gender,
							address, postcode, computerscience, math, english));

				} catch (NumberFormatException e) {
					System.out
							.println("A line in the student data file contains number format error");
					continue;
				}

			}
			sf.close();

		} catch (IOException e) {
			System.out
					.println("The file studentdata.txt does not exist or is corrupt.");
			System.exit(-1);
		}
	}

	static void outputStudentData() {// write in the student data from a text
										// file

		try {
			FileWriter fw = new FileWriter(new File(
					System.getProperty("user.dir") + "\\studentdata.txt"));
			BufferedWriter output = new BufferedWriter(fw);

			for (int i = 0; i < studentsArrayList.size(); i++) {
				output.write(studentsArrayList.get(i).studentID + ","
						+ studentsArrayList.get(i).name + ","
						+ studentsArrayList.get(i).gender + ","
						+ studentsArrayList.get(i).address + ","
						+ studentsArrayList.get(i).postcode + ","
						+ studentsArrayList.get(i).computer_science + ","
						+ studentsArrayList.get(i).math + ","
						+ studentsArrayList.get(i).english);
				output.newLine();

			}

			output.close();

		} catch (Exception e) {
			System.out
					.println("Unable to save records to studentdata.txt, file may not exist or is corrupt.");
			System.exit(-1);
		}
	}

	static void addRecord() { // Menu Choice 1

		if (studentsArrayList.size() < DB_SIZE) {

			System.out.println("Full name (or eof to cancel):");
			String name = input.nextLine();
			if (name.equals("eof"))
				return;

			System.out.println("Gender (or eof to cancel):");
			String gender = input.nextLine();
			if (gender.equals("eof"))
				return;

			System.out.println("Address (or eof to cancel):");
			String address = input.nextLine();
			if (address.equals("eof"))
				return;

			System.out.println("Postcode (or eof to cancel):");
			String postcode = input.nextLine();
			if (postcode.equals("eof"))
				return;

			double computerscience = -1, math = -1, english = -1;
			do {
				System.out
						.println("Computer Science: Enter a No. between 0 and 100");
				String answer = input.nextLine();
				if (answer.equals("eof"))
					return;

				try {
					computerscience = Double.parseDouble(answer);
				} catch (NumberFormatException e) {
					System.out.println("Enter a number!");
					continue;
				}
				if (computerscience >= 0 && computerscience <= 100)
					break;
				else
					System.out
							.println("The mark for Computer science is out of range 0-100. Please, re-enter the mark:");
			} while (true);

			do {
				System.out
						.println("Maths: Enter a No. between 0 and 100");
				String answer = input.nextLine();
				if (answer.equals("eof"))
					return;

				try {
					math = Double.parseDouble(answer);
				} catch (NumberFormatException e) {
					System.out.println("Enter a number!");
					continue;
				}
				if (math >= 0 && math <= 100)
					break;
				else
					System.out
							.println("The mark for Maths is out of range 0-100. Please, re-enter the mark:");
			} while (true);

			do {
				System.out
						.println("English: Enter a No. between 0 and 100");
				String answer = input.nextLine();
				if (answer.equals("eof"))
					return;

				try {
					english = Double.parseDouble(answer);
				} catch (NumberFormatException e) {
					System.out.println("Enter a number!");
					continue;
				}
				if (english >= 0 && english <= 100)
					break;
				else
					System.out
							.println("The mark for English is out of range 0-100. Please, re-enter the mark:");
			} while (true);

			int newStudentID = findFirstAvailableID();

			// create a new Student object out of the entered data and add it to
			// the student array list
			if (newStudentID != 0) { // Checks if there is a space to add a
										// student
				Student newStudent = new Student(newStudentID, name, gender,
						address, postcode, computerscience, math, english);
				// create new student object
				studentsArrayList.add(newStudent);
				// inserts student in list
			} else
				System.out
						.println("You cannot add more records. Twenty records have already been added. \nThe data base is full!");

		} else
			System.out
					.println("You cannot add more records. Twenty records have already been added. \nThe data base is full!");

	}

	static void removeStudent() { // Menu Choice 2

		System.out.println("StudentID to delete");
		String userInput = input.nextLine();
		int studentToRemove = -1; // stores the users input as an
									// integer
		do {
			try {
				studentToRemove = Integer.parseInt(userInput);
				// converts user input to integer and stores it
			} catch (NumberFormatException e) {
				System.out.println("This is not a valid number!");
			}
		} while (studentToRemove < 1 || studentToRemove > DB_SIZE);
		// range check
		studentsArrayList.remove(studentToRemove - 1);
		// removes the selected id from list
		System.out.println("Record has been successfully deleted");

	}

	private static void removeStudent1() {
		// TODO Auto-generated method stub
		System.out.println("StudentID to find");
		String answer = input.nextLine();
		// double dblAnswer = -1;
		int studentIDToFind = -1; // stores the users input as an
		// integer
		do { // range check for student Id to use in edit
			try {
				studentIDToFind = Integer.parseInt(answer);
				// converts user input to integer and stores it
				if (studentIDToFind >= 1 && studentIDToFind <= DB_SIZE)
					break;
				else
					System.out.println("Please enter an integer between 1 and "
							+ DB_SIZE + "!");
			} catch (NumberFormatException e) {
				System.out.println("This is not a valid number! Retry.");
				// break;
			}
		} while (true);

		Student studentToRemove = null;
		for (Student s : studentsArrayList) {
			if (studentIDToFind == s.studentID) {
				studentToRemove = s;
				System.out.println(s);
				// System.out.println("The ID is: " + studentIDToFind);
				break;
			}
		}
		if (studentToRemove != null) {

			if (yesOrNoAnswer("Do you want to remove this student?")) {
				studentsArrayList.remove(studentToRemove);
				// removes the selected id from list
				System.out.println("Record has been successfully deleted");
			} 
		}else
			System.out
			.println("The user with this ID cannot be found in the database!");
	}

	static void searchStudents() { // Search Students Menu
		int menuChoice; // Menu Choices
		do {
			System.out.println("\t\t\tStudent Search Menu");
			System.out
					.println("\t\t1. Search by ID\t2. Search by Name\t3. Multiple Criteria\t4. Show All\t5. Return to Main Menu");
			// Show all menu options

			try {
				System.out.println("Enter a choice: ");
				menuChoice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect choice. Enter a number 1-5");
				continue;
			}

			if (menuChoice == 1) // Menu Choice 1
				searchByID();
			else if (menuChoice == 2) // Menu Choice 2
				searchByName();
			else if (menuChoice == 3) // Menu Choice 3
				multipleCriteria();
			else if (menuChoice == 4) // Menu Choice 4
				showAll();
			else if (menuChoice == 5) // Menu Choice 5 Return to the main menu
				break;

		} while (true); // continuous loop illustrating main menu
	}

	static void searchByID() {
		
		int studentIDToFind = -1; // stores the users input as an
		// integer
		do {
			System.out.println("StudentID to find");
			String userInput = input.nextLine();
			try {
				studentIDToFind = Integer.parseInt(userInput);
				// converts user input to integer and stores it
				if (studentIDToFind >= 1 && studentIDToFind <= DB_SIZE)
					break;
				else
					System.out.println("Please enter an integer between 1 and "
							+ DB_SIZE + "!");
				
			} catch (NumberFormatException e) {
				System.out.println("This is not a valid number! Retry.");
				
			}
		} while (true);
		// range check
		for (Student st : studentsArrayList) {
			if (studentIDToFind == st.studentID) {
				System.out.println(st);
				break;
			}
		}
	}
	

	static void searchByName() {
		System.out.println("Student name to find");
		String userInput = input.nextLine();
		String studentNameToFind = userInput;

		for (Student st : studentsArrayList) {

			if (st.name.toUpperCase().contains(studentNameToFind.toUpperCase())) {
				// turn
				// the
				// two
				// strings
				// in
				// capital
				// letters
				// to
				// ignore
				// their
				// case
				System.out.println(st);
			}
		}
	}

	// If we reach this point, it means the student was never found in the for
	// loop.

	static void multipleCriteria() {

		System.out
				.println("Enter a (part of) student name or press 'Enter' for any:");
		String nameToSearch = input.nextLine();

		System.out.println("Gender if available or press 'Enter' to continue:");
		String genderToSearch = input.nextLine();

		System.out
				.println("Address if available or press 'Enter' to continue:");
		String addressToSearch = input.nextLine();

		System.out
				.println("Postcode if available or press 'Enter' to continue:");
		String postcodeToSearch = input.nextLine();

		double csLowerMarkLimit = -1; // Computer Science lower mark limit entry
		do {
			try {
				System.out
						.println("Enter the LOWER limit for the CS mark (0-100) to search for (or press 'Enter' for any):");
				String strUserInput = input.nextLine();
				if (!strUserInput.isEmpty())
					csLowerMarkLimit = Double.parseDouble(strUserInput);
			} catch (NumberFormatException e) {
				System.out.println("Enter a number!");
				continue;
			}
			// check if the mark is in the range 0-100
			if (csLowerMarkLimit == -1
					|| (csLowerMarkLimit >= 0 && csLowerMarkLimit <= 100)) // condition
																			// for
																			// a
																			// number
																			// in
																			// the
																			// range
																			// 0-100
				break;
			else
				System.out
						.println("The lower mark limit is outside the range 0-100. Please re-enter a correct lower mark limit to search for.");
		} while (true);

		double csUpperMarkLimit = -1; // Computer Science upper mark limit entry
		do {
			try {
				System.out
						.println("Enter the UPPER limit for the CS mark (0-100) to search for (or press 'Enter' for any):");
				String strUserInput = input.nextLine();
				if (!strUserInput.isEmpty())
					csUpperMarkLimit = Double.parseDouble(strUserInput);
			} catch (NumberFormatException e) {
				System.out.println("Enter a number!");
				continue;
			}
			// check if the mark is in the range 0-100
			if (csUpperMarkLimit == -1
					|| (csUpperMarkLimit >= 0 && csUpperMarkLimit <= 100)) // condition
																			// for
																			// a
																			// number
																			// in
																			// the
																			// range
																			// 0-100
				if (csUpperMarkLimit >= csLowerMarkLimit)
					break;
				else
					System.out
							.println("The upper mark limit is LESS than the lower mark limit. Please re-enter the upper mark limit.");
			else
				System.out
						.println("The upper mark limit is outside the range 0-100. Please re-enter the upper mark limit.");
		} while (true);

		double mathLowerMarkLimit = -1; // Maths lower mark limit entry
		do {
			try {
				System.out
						.println("Enter the LOWER limit for the Maths mark (0-100) to search for (or press 'Enter' for any):");
				String strUserInput = input.nextLine();
				if (!strUserInput.isEmpty())
					mathLowerMarkLimit = Double.parseDouble(strUserInput);
			} catch (NumberFormatException e) {
				System.out.println("Enter a number!");
				continue;
			}
			// check if the mark is in the range 0-100
			if (mathLowerMarkLimit == -1
					|| (mathLowerMarkLimit >= 0 && mathLowerMarkLimit <= 100)) // condition
																				// for
																				// a
																				// number
																				// in
																				// the
																				// range
																				// 0-100
				break;
			else
				System.out
						.println("The lower mark limit is outside the range 0-100. Please re-enter a correct lower mark limit to search for.");
		} while (true);

		double mathUpperMarkLimit = -1; // Maths upper mark limit entry
		do {
			try {
				System.out
						.println("Enter the UPPER limit for the Maths mark (0-100) to search for (or press 'Enter' for any):");
				String strUserInput = input.nextLine();
				if (!strUserInput.isEmpty())
					mathUpperMarkLimit = Double.parseDouble(strUserInput);
			} catch (NumberFormatException e) {
				System.out.println("Enter a number!");
				continue;
			}
			// check if the mark is in the range 0-100
			if (mathUpperMarkLimit == -1
					|| (mathUpperMarkLimit >= 0 && mathUpperMarkLimit <= 100)) // condition
																				// for
																				// a
																				// number
																				// in
																				// the
																				// range
																				// 0-100
				if (mathUpperMarkLimit >= mathLowerMarkLimit)
					break;
				else
					System.out
							.println("The upper mark limit is LESS than the lower mark limit. Please re-enter the upper mark limit.");
			else
				System.out
						.println("The upper mark limit is outside the range 0-100. Please re-enter the upper mark limit.");
		} while (true);

		double engLowerMarkLimit = -1; // English lower mark limit entry
		do {
			try {
				System.out
						.println("Enter the LOWER limit for the English mark (0-100) to search for (or press 'Enter' for any):");
				String strUserInput = input.nextLine();
				if (!strUserInput.isEmpty())
					engLowerMarkLimit = Double.parseDouble(strUserInput);
			} catch (NumberFormatException e) {
				System.out.println("Enter a number!");
				continue;
			}
			// check if the mark is in the range 0-100
			if (engLowerMarkLimit == -1
					|| (engLowerMarkLimit >= 0 && engLowerMarkLimit <= 100)) // condition
																				// for
																				// a
																				// number
																				// in
																				// the
																				// range
																				// 0-100
				break;
			else
				System.out
						.println("The lower mark limit is outside the range 0-100. Please re-enter a correct lower mark limit to search for.");
		} while (true);

		double engUpperMarkLimit = -1; // English upper mark limit entry
		do {
			try {
				System.out
						.println("Enter the UPPER limit for the English mark (0-100) to search for (or press 'Enter' for any):");
				String strUserInput = input.nextLine();
				if (!strUserInput.isEmpty())
					engUpperMarkLimit = Double.parseDouble(strUserInput);
			} catch (NumberFormatException e) {
				System.out.println("Enter a number!");
				continue;
			}
			// check if the mark is in the range 0-100
			if (engUpperMarkLimit == -1
					|| (engUpperMarkLimit >= 0 && engUpperMarkLimit <= 100)) // condition
																				// for
																				// a
																				// number
																				// in
																				// the
																				// range
																				// 0-100
				if (engUpperMarkLimit >= engLowerMarkLimit)
					break;
				else
					System.out
							.println("The upper mark limit is LESS than the lower mark limit. Please re-enter the upper mark limit.");
			else
				System.out
						.println("The upper mark limit is outside the range 0-100. Please re-enter the upper mark limit.");
		} while (true);

		for (Student st : studentsArrayList) {
			if ((nameToSearch == null || st.name.toUpperCase().contains(
					nameToSearch.toUpperCase()))
					&& (genderToSearch == null || st.gender.toUpperCase()
							.contains(genderToSearch.toUpperCase()))
					&& (addressToSearch == null || st.address.toUpperCase()
							.contains(addressToSearch.toUpperCase()))
					&& (postcodeToSearch == null || st.postcode.toUpperCase()
							.contains(postcodeToSearch.toUpperCase()))
					&& ((csLowerMarkLimit == -1) || (st.computer_science >= csLowerMarkLimit))
					&& ((csUpperMarkLimit == -1) || (st.computer_science <= csUpperMarkLimit))
					&& ((mathLowerMarkLimit == -1) || (st.math >= mathLowerMarkLimit))
					&& ((mathUpperMarkLimit == -1) || (st.math <= mathUpperMarkLimit))
					&& ((engLowerMarkLimit == -1) || (st.english >= engLowerMarkLimit))
					&& ((engUpperMarkLimit == -1) || (st.english <= engUpperMarkLimit)))

				System.out.println(st);
		}
	}

	static void showAll() {
		System.out.println("Students:");
		for (Student student : studentsArrayList) {
			System.out.println(student);
		}
	}

	static void reportTotals() { // Report Totals Menu
		int menuChoice; // Menu Choices
		do {
			System.out.println("\t\t\tStudent Report Totals Menu");
			System.out
					.println("\t\t1. Highest mark for particular subject\t2. Lowest mark for particular subject\t3. Average mark for particular subject (All Students)\t4. Average mark for particular subject (By ID)\t5. Return to Main Menu");
			// Show all menu options

			try {
				System.out.println("Enter a choice: ");
				menuChoice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect choice. Enter a number 1-5");
				continue;
			}

			if (menuChoice == 1) // Menu Choice 1
				highestMark();
			else if (menuChoice == 2) // Menu Choice 2
				lowestMark();
			else if (menuChoice == 3) // Menu Choice 3
				avgSubjectMarks();
			else if (menuChoice == 4) // Menu Choice 4
				avgSubjectMarksByID();
			else if (menuChoice == 5) // Menu Choice 5 Return to the main menu
				break;

		} while (true); // continuous loop illustrating main menu
	}

	private static void avgSubjectMarksByID() { // Sub-Menu
		// TODO Auto-generated method stub
		double avgMarksByID = 0;
		System.out.println("StudentID to find");
		String userInput = input.nextLine();
		int studentIDToFind = -1; // stores the users input as an
									// integer
		do {
			try {
				studentIDToFind = Integer.parseInt(userInput);
				// converts user input to integer and stores it
				if (studentIDToFind >= 1 && studentIDToFind <= DB_SIZE)
					break;
				else
					System.out.println("Please enter an integer between 1 and "
							+ DB_SIZE + "!");
			} catch (NumberFormatException e) {
				System.out.println("This is not a valid number! Retry.");
				break;
			}
		} while (true);
		// range check
		for (Student st : studentsArrayList) {
			if (studentIDToFind == st.studentID) {
				avgMarksByID = (st.english + st.math + st.computer_science) / 3;
				System.out.println(st + " Average Mark is " + avgMarksByID);
				break;
			}
		}
	}

	private static void avgSubjectMarks() { // Sub-Menu
		// TODO Auto-generated method stub
		int menuChoice; // Menu Choices
		do {
			System.out.println("\t\t\tStudent Average Subject Mark Menu");
			System.out
					.println("\t\t1. Computer Science\t2. Math\t3. English\t4. Return to Previous Menu");
			// Show all menu options

			try {
				System.out.println("Enter a choice: ");
				menuChoice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect choice. Enter a number 1-4");
				continue;
			}

			if (menuChoice == 1) // Menu Choice 1
				avgMarkCS();
			else if (menuChoice == 2) // Menu Choice 2
				avgMarkMath();
			else if (menuChoice == 3) // Menu Choice 3
				avgMarkEnglish();
			else if (menuChoice == 4) // Menu Choice 4 Return to the main menu
				break;

		} while (true); // continuous loop illustrating main menu
	}

	private static void avgMarkEnglish() {
		// TODO Auto-generated method stub
		double total = 0; // adds up marks to find total
		for (Student st : studentsArrayList) {
			total += st.english;
		}

		double avg = 0; // divides total marks by number of students (size of
						// array)
		if (studentsArrayList.size() > 0) {
			avg = total / studentsArrayList.size();
		}
		System.out.println(avg); // prints the average mark for subject
	}

	private static void avgMarkMath() {
		// TODO Auto-generated method stub
		double total = 0; // adds up marks to find total
		for (Student st : studentsArrayList) {
			total += st.math;
		}

		double avg = 0; // divides total marks by number of students (size of
						// array)
		if (studentsArrayList.size() > 0) {
			avg = total / studentsArrayList.size();
		}
		System.out.println(avg); // prints the average mark for subject
	}

	private static void avgMarkCS() {
		// TODO Auto-generated method stub
		double total = 0; // adds up marks to find total
		for (Student st : studentsArrayList) {
			total += st.computer_science;
		}

		double avg = 0; // divides total marks by number of students (size of
						// array)
		if (studentsArrayList.size() > 0) {
			avg = total / studentsArrayList.size();
		}
		System.out.println(avg); // prints the average mark for subject
	}

	private static void lowestMark() { // Sub-Menu
		// TODO Auto-generated method stub
		int menuChoice; // Menu Choices
		do {
			System.out.println("\t\t\tStudent Lowest Mark Menu");
			System.out
					.println("\t\t1. Computer Science\t2. Math\t3. English\t4. Return to Previous Menu");
			// Show all menu options

			try {
				System.out.println("Enter a choice: ");
				menuChoice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect choice. Enter a number 1-4");
				continue;
			}

			if (menuChoice == 1) // Menu Choice 1
				lowestMarkCS();
			else if (menuChoice == 2) // Menu Choice 2
				lowestMarkMath();
			else if (menuChoice == 3) // Menu Choice 3
				lowestMarkEnglish();
			else if (menuChoice == 4) // Menu Choice 4 Return to the main menu
				break;

		} while (true); // continuous loop illustrating main menu
	}

	private static void lowestMarkEnglish() {
		// TODO Auto-generated method stub
		double min = 100;
		for (Student st : studentsArrayList)
			// finding max of English mark
			if (st.english < min)
				min = st.english;
		for (Student st : studentsArrayList)
			// print out students with max mark for English
			if (st.english == min)
				System.out.println(st);
	}

	private static void lowestMarkMath() {
		// TODO Auto-generated method stub
		double min = 100;
		for (Student st : studentsArrayList)
			// finding max of math mark
			if (st.math < min)
				min = st.math;
		for (Student st : studentsArrayList)
			// print out students with max mark for math
			if (st.math == min)
				System.out.println(st);
	}

	private static void lowestMarkCS() {
		// TODO Auto-generated method stub
		double min = 100;
		for (Student st : studentsArrayList)
			// finding max of computer science mark
			if (st.computer_science < min)
				min = st.computer_science;
		for (Student st : studentsArrayList)
			// print out students with max mark for computer science
			if (st.computer_science == min)
				System.out.println(st);
	}

	private static void highestMark() { // Sub-Menu
		// TODO Auto-generated method stub
		int menuChoice; // Menu Choices
		do {
			System.out.println("\t\t\tStudent Highest Mark Menu");
			System.out
					.println("\t\t1. Computer Science\t2. Math\t3. English\t4. Return to Previous Menu");
			// Show all menu options

			try {
				System.out.println("Enter a choice: ");
				menuChoice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect choice. Enter a number 1-4");
				continue;
			}

			if (menuChoice == 1) // Menu Choice 1
				highestMarkCS();
			else if (menuChoice == 2) // Menu Choice 2
				highestMarkMath();
			else if (menuChoice == 3) // Menu Choice 3
				highestMarkEnglish();
			else if (menuChoice == 4) // Menu Choice 4 Return to the main menu
				break;

		} while (true); // continuous loop illustrating main menu
	}

	private static void highestMarkEnglish() {
		// TODO Auto-generated method stub
		double max = 0;
		for (Student st : studentsArrayList)
			// finding max of english mark
			if (st.english > max)
				max = st.english;
		for (Student st : studentsArrayList)
			// print out students with max mark for english
			if (st.english == max)
				System.out.println(st);
	}

	private static void highestMarkMath() {
		// TODO Auto-generated method stub
		double max = 0;
		for (Student st : studentsArrayList)
			// finding max of math mark
			if (st.math > max)
				max = st.math;
		for (Student st : studentsArrayList)
			// print out students with max mark for math
			if (st.math == max)
				System.out.println(st);
	}

	private static void highestMarkCS() {
		// TODO Auto-generated method stub
		double max = 0;
		for (Student st : studentsArrayList)
			// finding max of computer science mark
			if (st.computer_science > max)
				max = st.computer_science;
		for (Student st : studentsArrayList)
			// print out students with max mark for computer science
			if (st.computer_science == max)
				System.out.println(st);
	}

	static void classifyByMarks() { // Classify Menu
		int menuChoice; // Menu Choices
		do {
			System.out.println("\t\t\tStudent Classification Menu");
			System.out
					.println("\t\t1. Particular Subject Gradet\t2. Average Mark Grade\t3. Return to Previous Menu");
			// Show all menu options

			try {
				System.out.println("Enter a choice: ");
				menuChoice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect choice. Enter a number 1-3");
				continue;
			}

			if (menuChoice == 1) // Menu Choice 1: Particular Subject Grade
				subjectGrade();
			else if (menuChoice == 2) // Menu Choice 2: Average Mark Grade
				avgMarkGrade();
			else if (menuChoice == 3) // Menu Choice 3 Return to the main menu
				break;

		} while (true); // continuous loop illustrating main menu
	}

	private static void avgMarkGrade() {
		// TODO Auto-generated method stub
		double distGradeAll = 90;
		double meritGradeAll = 70;
		double passGradeAll = 50;
		double failGradeAll = 0;
		double avgMarkGrade = 0;

		for (Student st : studentsArrayList) { // print out students with
												// distinction grade for average
												// mark of all subjects
			avgMarkGrade = (st.english + st.math + st.computer_science) / 3;
			if (avgMarkGrade >= distGradeAll)
				System.out.println("Distinction: " + st + " AvgMark: "
						+ avgMarkGrade);
		}
		for (Student st : studentsArrayList) { // print out students with merit
												// grade for average mark of all
												// subjects
			avgMarkGrade = (st.english + st.math + st.computer_science) / 3;
			if (avgMarkGrade >= meritGradeAll && avgMarkGrade < distGradeAll)
				System.out
						.println("Merit: " + st + " AvgMark: " + avgMarkGrade);
		}
		for (Student st : studentsArrayList) { // print out students with pass
												// grade for average mark of all
												// subjects
			avgMarkGrade = (st.english + st.math + st.computer_science) / 3;
			if (avgMarkGrade >= passGradeAll && avgMarkGrade < meritGradeAll)
				System.out.println("Pass: " + st + " AvgMark: " + avgMarkGrade);
		}
		for (Student st : studentsArrayList) { // print out students with fail
												// grade for average mark of all
												// subjects
			avgMarkGrade = (st.english + st.math + st.computer_science) / 3;
			if (avgMarkGrade >= failGradeAll && avgMarkGrade < passGradeAll)
				System.out.println("Fail: " + st + " AvgMark: " + avgMarkGrade);
		}
	}

	private static void subjectGrade() {
		// TODO Auto-generated method stub
		int menuChoice; // Menu Choices
		do {
			System.out.println("\t\t\tStudent Subject Grade Menu");
			System.out
					.println("\t\t1. Computer Science\t2. Math\t3. English\t4. Return to Previous Menu");
			// Show all menu options

			try {
				System.out.println("Enter a choice: ");
				menuChoice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect choice. Enter a number 1-4");
				continue;
			}

			if (menuChoice == 1) // Menu Choice 1
				csGrade();
			else if (menuChoice == 2) // Menu Choice 2
				mathGrade();
			else if (menuChoice == 3) // Menu Choice 3
				englishGrade();
			else if (menuChoice == 4) // Menu Choice 4 Return to the main menu
				break;

		} while (true); // continuous loop illustrating main menu
	}

	private static void englishGrade() {
		// TODO Auto-generated method stub
		double distGradeE = 90;
		double meritGradeE = 70;
		double passGradeE = 50;
		double failGradeE = 0;

		for (Student st : studentsArrayList)
			// print out students with distinction grade for English
			if (st.english >= distGradeE)
				System.out.println("Distinction: " + st);
		for (Student st : studentsArrayList)
			// print out students with merit grade for English
			if (st.english >= meritGradeE && st.english < distGradeE)
				System.out.println("Merit: " + st);
		for (Student st : studentsArrayList)
			// print out students with pass grade for English
			if (st.english >= passGradeE && st.english < meritGradeE)
				System.out.println("Pass: " + st);
		for (Student st : studentsArrayList)
			// print out students with fail grade for English
			if (st.english >= failGradeE && st.english < passGradeE)
				System.out.println("Fail: " + st);
	}

	private static void mathGrade() {
		// TODO Auto-generated method stub
		double distGradeM = 90;
		double meritGradeM = 70;
		double passGradeM = 50;
		double failGradeM = 0;

		for (Student st : studentsArrayList)
			// print out students with distinction grade for math
			if (st.math >= distGradeM)
				System.out.println("Distinction: " + st);
		for (Student st : studentsArrayList)
			// print out students with merit grade for math
			if (st.math >= meritGradeM && st.math < distGradeM)
				System.out.println("Merit: " + st);
		for (Student st : studentsArrayList)
			// print out students with pass grade for math
			if (st.math >= passGradeM && st.math < meritGradeM)
				System.out.println("Pass: " + st);
		for (Student st : studentsArrayList)
			// print out students with fail grade for math
			if (st.math >= failGradeM && st.math < passGradeM)
				System.out.println("Fail: " + st);
	}

	private static void csGrade() {
		// TODO Auto-generated method stub
		double distGradeCS = 90;
		double meritGradeCS = 70;
		double passGradeCS = 50;
		double failGradeCS = 0;

		for (Student st : studentsArrayList)
			// print out students with distinction grade for computer science
			if (st.computer_science >= distGradeCS)
				System.out.println("Distinction: " + st);
		for (Student st : studentsArrayList)
			// print out students with merit grade for computer science
			if (st.computer_science >= meritGradeCS
					&& st.computer_science < distGradeCS)
				System.out.println("Merit: " + st);
		for (Student st : studentsArrayList)
			// print out students with pass grade for computer science
			if (st.computer_science >= passGradeCS
					&& st.computer_science < meritGradeCS)
				System.out.println("Pass: " + st);
		for (Student st : studentsArrayList)
			// print out students with fail grade for computer science
			if (st.computer_science >= failGradeCS
					&& st.computer_science < passGradeCS)
				System.out.println("Fail: " + st);
	}

	// private static int findAvailableID(ArrayList<Student> studentList) { //
	// Student ID
	// // Available
	// // Checker
	// int freeIndex = -1;
	// boolean[] usedIDs = new boolean[DB_SIZE]; // Stores a record of all of
	// // the
	// // used IDs
	// for (int i = 0; i < studentList.size(); i++) { // Checks student list
	// // for all of the used
	// // IDs#
	// Student currentStudent = studentList.get(i);
	// // Gets the student from the list at the current index
	// usedIDs[currentStudent.studentID - 1] = true; // Inputs the
	// // student's ID
	// }
	//
	// // Check the boolean array for the first unused ID
	// for (int i = 0; i < DB_SIZE; i++) {
	// if (!usedIDs[i]) {
	// // Set the new id and exit the for loop
	// freeIndex = i;
	// break;
	// }
	// }
	// return freeIndex + 1;
	// }
	private static int findFirstAvailableID() {
		for (int i = 1; i <= DB_SIZE; i++) {
			boolean isUsed = false;
			for (Student s : studentsArrayList) {
				if (i == s.studentID) {
					isUsed = true;
					break;
				}
			}
			if (isUsed == false)
				return i;
		}
		return 0;
	}
}

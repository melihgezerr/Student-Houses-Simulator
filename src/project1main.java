
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class project1main {

	public static void main(String[] args) {
		/*
		 * Adds all the input lines as String arrays to an ArrayList.
		 */
		String inputFileName = args[0];
		File myInputFile = new File(inputFileName);
		ArrayList<String[]> myInputArray = new ArrayList<String[]>();
		try {
			Scanner myReader = new Scanner(myInputFile);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] splitted = data.split("\\s+");
				myInputArray.add(splitted);
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			out.println("Catch - An error occurred.");
			e.printStackTrace();
		}

		/*
		 * Now creating Student and House Arraylists and passing the data to them.
		 * Then sorting them with respect to their id's, ascending order.
		 */

		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<House> houses = new ArrayList<House>();
		int semesters = 0;

		for (String[] elem : myInputArray) {
			if (elem[0].equals("s")) {
				int id = Integer.parseInt(elem[1]);
				String name = elem[2];
				int duration = Integer.parseInt(elem[3]);
				double rating = Double.parseDouble(elem[4]);
				students.add(new Student(id, name, duration, rating));
				if (duration > semesters)
					semesters = duration;
			}

			else if (elem[0].equals("h")) {
				int id = Integer.parseInt(elem[1]);
				int duration = Integer.parseInt(elem[2]);
				double rating = Double.parseDouble(elem[3]);
				houses.add(new House(id, duration, rating));

			}
		}
		Collections.sort(students);
		Collections.sort(houses);

		/*
		 * Now with nested-for-loops' help, allocations will be done for 8 semesters.
		 */

		int flag = 0;
		while (flag<semesters) {
			flag++;
			for (Student student : students) {
				if (student.getDuration()==0) {    //Checks whether a student is graduated.
					student.setSituationID(-1);;
					continue;
				}
				else if (student.getSituationID() != -1){ // Checks whether a students already has a house.
					continue;
				}
				else{
					for (House house : houses) { // If student has no house, this block search a house for her/him.
						if (house.getDuration() != 0)
							continue;
						if (house.getDuration()==0) { //When a student graduates, this block make the house empty.
							house.setSituationID(-1);
						}
						if (house.getDuration()==0 && student.getRating() <= house.getRating() && student.getSituationID() == -1) { // If all the prerequisites hold, this block places the student at house. 
							student.setSituationID(house.getId());
							student.setIsStayed(1);;
							house.setSituationID(student.getId());;
							house.setDuration(student.getDuration());;
							break;
						}
					}
				}
				if (student.getDuration() != 0) 
					student.setDuration(student.getDuration()-1);;
			}
			for (House myhouse : houses)
				if (myhouse.getDuration()>0)
					myhouse.setDuration(myhouse.getDuration()-1);;
		}
		String outputFileName = args[1];   //Writes to output file.
		File myOutputFile = new File(outputFileName);
		try {
		      if (myOutputFile.createNewFile()) {
		        out.println("File created: " + outputFileName);
		      } else {
		        out.println("File already exists.");
		        out.println("MyFileIO ends with existing output file");
		        return;
		      }
		      
		      FileWriter myWriter = new FileWriter(outputFileName);
		      for(Student stu :students) {
		    	  if (stu.getIsStayed() ==0) {
		    	  myWriter.write(stu.getName());
		    	  myWriter.write("\n");
		    	  }
		      }
		      
		      myWriter.close();
		      
	    } catch (IOException e) {
	      out.println("Catch - An error occurred.");
	      e.printStackTrace();
	    }


	}

}

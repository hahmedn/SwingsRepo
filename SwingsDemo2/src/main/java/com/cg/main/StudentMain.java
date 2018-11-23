package com.cg.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.entity.Student;
import com.cg.service.IStudentService;
import com.cg.service.StudentServiceImpl;

public class StudentMain {

	static Student student = null;

	static IStudentService stService = null;

	public static void main(String[] args) {

		System.out.println("Student database");

		Scanner sc = new Scanner(System.in);
		student = new Student();
		stService = new StudentServiceImpl();

		System.out.println("ENTER YOUR CHOICE\n\n1 - INSERT DATA\n2 - VIEW ALL DATA\n"
				+ "3 - DELETE THE DATA\n4 - UPDATE DATA\n5 - GET DETAIL BY ID\n"
				+ "6 - EXIT ");
		int option = sc.nextInt();

		switch(option) {
		case 1:
			System.out.print("Enter the name: ");
			String name = sc.next();
			student.setName(name);
			System.out.print("Enter the roll no: ");
			int rollno = sc.nextInt();
			student.setRollno(rollno);

			int check1 = stService.insertStudent(student);

			if(check1 != 0)
				System.out.println("Inserted successfully");
			else
				System.out.println("Data not inserted");

			break;

		case 2:
			ArrayList<Student> arrList = new ArrayList<Student>();
			arrList = (ArrayList<Student>) stService.getStudentDetail();

			Iterator<Student> stItr = arrList.iterator();
			while(stItr.hasNext()) {
				Student stud = stItr.next();
				System.out.println(stud.getId()+" "+stud.getName()+" "+stud.getRollno());
			}

			break;

		case 3:
			System.out.println("Enter the id to be deleted");
			int id1 = sc.nextInt();
			student.setId(id1);

			int check2 = stService.deleteStudent(student);

			if(check2 != 0)
				System.out.println("deleted successfully");
			else
				System.out.println("Data not deleted");


			break;

		case 4:
			System.out.println("Enter the id to be updated");
			int id2 = sc.nextInt();
			student.setId(id2);

			System.out.print("Enter the name: ");
			String name1 = sc.next();
			student.setName(name1);
			System.out.print("Enter the roll no: ");
			int rollno1 = sc.nextInt();
			student.setRollno(rollno1);

			boolean check3 = stService.updateStudent(student);

			if(check3 != false)
				System.out.println("updated successfully");
			else
				System.out.println("Data not updated");

			break;

		case 5:
			System.out.println("Enter the Id to get details");
			int id3 = sc.nextInt();
			student.setId(id3);

			Student stud = new Student();
			stud = stService.getStudentById(id3);
			System.out.println(stud.getId()+" "+stud.getName()+" "+stud.getRollno());

			break;

		case 6:
			System.out.println("Application Terminated");
			System.exit(0);
		break;

		default:
			System.out.println("Not allowed");
		}
	}
}

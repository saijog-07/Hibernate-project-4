package service;

import java.util.Scanner;
import dao.DaoStudentI;
import model.Student;

public class StudentService {

    private Scanner sc;
    private DaoStudentI dao;

    public StudentService() {
        sc = new Scanner(System.in);
        dao = new DaoStudentI();
    }

    
    
    public void searchName() {
        System.out.println("Enter name:");
        String name = sc.nextLine();
        dao.serachHQLName(name);
    }
    
    public void searchNameMarks() {
        System.out.println("Enter name:");
        String name = sc.nextLine();
        System.out.println("Enter marks:");
        int marks = sc.nextInt();
        dao.serachHQLNamMarkse(name, marks);
    }
    
    
    public void searchUseMarks() {
        System.out.println("Enter marks:");
        int marks = sc.nextInt();
        dao.searchUsingMarks(marks);
    }
    
    
    public void removeUsingRoll() {
        System.out.println("Enter roll no:");
        int roll = sc.nextInt();
        dao.removeByRollNo(roll);
    }
    
    public void updateNameByRoll() {
        System.out.println("Enter roll No:");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new name:");
        String name = sc.nextLine();
        dao.updateByRoll(roll, name);
    }
    
    public void displayData() {
    	dao.showData();
    }
    
    public void displayData1() {
    	dao.showData1("Isha");
    }

}

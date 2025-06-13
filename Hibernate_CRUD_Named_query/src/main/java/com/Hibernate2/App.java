package com.Hibernate2;

import service.StudentService;
import dao.DaoStudentI;

public class App {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        // service.saveStudent();  
        // service.removeData(); 
        // service.updateStudent();
        // service.searchRoll();
        
//        DaoStudentI dao = new DaoStudentI();
//        dao.ShowData("Sai");
        
       // service.searchName();
        
        service.displayData1();
       // service.searchNameMarks();
       // service.searchUseMarks();
      // service.removeUsingRoll();
       // service.updateNameByRoll();
       
    }
}

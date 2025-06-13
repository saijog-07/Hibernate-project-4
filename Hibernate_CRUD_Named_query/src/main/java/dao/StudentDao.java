package dao;

import model.Student;

public interface StudentDao {
	void serachHQLName(String name);

	void serachHQLNamMarkse(String name, double marks);

	void searchUsingMarks(int marks); 
	public void removeByRollNo(int rollno);

	void updateByRoll(int rollno, String newName);

	void showData();

	
	void showData1(String name);
}

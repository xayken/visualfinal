package pack1;

public class Student {

	String name, surname, languages, gender;
	int age;
	Department department;
	public Student(String name, String surname, String languages,
			String gender, int age) {
		this.name = name;
		this.surname = surname;
		this.languages = languages;
		this.gender = gender;
		this.age = age;
	}
	
	public void setDepartment(Department department){
		this.department = department;
	}
}
  
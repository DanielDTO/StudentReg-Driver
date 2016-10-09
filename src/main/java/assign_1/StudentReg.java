package assign_1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.joda.time.LocalDate;

import assignment_1.Course;
import assignment_1.Module;
import assignment_1.Student;
public class StudentReg {

	public static void main(String[] args) {
		String courseName = "Electronic and Computer Engineering (ECE)";
	//Easier and less complicated to use arrays of Students rather than individual student objects. Same applies for the module class.
	//Chose this method after trying to create individual students and adding them to modules on at a time.
		
		Student[] s1 ={ new Student("William Jacob", "22/05/1994", 22, 3001),
						new Student("Jonah Hill", "04/03/1995", 21, 2014),
						new Student("Sean Dyche", "15/06/1993", 23, 2111)};
		Student[] s2 ={ new Student("Regen John", "20/01/1994", 22, 3125),
						new Student("Wayne Cook", "29/11/1993", 23, 2158)};
		Student[] s3 ={ new Student("Jacob Miles", "14/10/1995", 21, 3257),
						new Student("Peter Parker", "10/12/1992", 24, 3459)};
		
		Module[] modulesList ={ new Module("Digital Signal Processing","EE457", s1),
							 new Module("Software Engineering III", "CT417", s2),
							 new Module("Telecommunication Software Applications", "EE453", s3)};
		
		LocalDate startDate = new LocalDate(2016, 9, 1);
		LocalDate endDate = new LocalDate(2017, 4, 25);
		Course Prog = new Course( courseName, modulesList, startDate, endDate );
		
		Module[] m = Prog.getModuleList();
		HashMap <Student, ArrayList<Module>> map_a = new HashMap<Student, ArrayList<Module>>();
		HashMap <Module, Course> map_b = new HashMap<Module, Course>();
		
		for (int i=0; i<m.length;i++){
			Student[] enrolled_Students = m[i].getStudentList();
			map_b.put(m[i], Prog);
			
			for (int j=0; j<enrolled_Students.length; j++){
				if (!map_a.containsKey(enrolled_Students[j])){
					map_a.put(enrolled_Students[j], new ArrayList<Module>());
				}
				
				map_a.get(enrolled_Students[j]).add(m[i]);
			
		}

	}
		
		Set<Student> keys = map_a.keySet();
		Iterator<Student> i = keys.iterator();
		
		while(i.hasNext()){
			Student temp = i.next();
			System.out.println("Student:" + "\t" + temp.getUsername() + "\t");
			ArrayList<Module> list = map_a.get(temp);
			Iterator<Module> itr = list.iterator();
			
			System.out.println("Modules:");
			
			while(itr.hasNext()){
				Module t = itr.next();
				System.out.println(t.getModuleName() + " ");
			}
			
			System.out.println("Course:" + map_b.get(list.get(0)).getCourseName());
		}

}
}
package edu.handong.analysis;

import java.util.ArrayList;
import java.util.HashMap;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	
	private ArrayList<Student> students;
	private ArrayList<Course> courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Student> initiateStudentArrayFromLines(String[] lines) {
		
		String name;
		ArrayList<Student> names = new ArrayList<Student>();
		//Student[] names = new Student[numOfStudents];
		int count=0;
		
		
		
		for(int i=0; i<lines.length; i++) {
			name = lines[i].split(", ")[1];
			Student naming = new Student(name);
		
			if(count==0) {
				names.add(count, new Student(name.trim()));
				count++;
			}
			
			while(studentExist(names,naming)) {
				if(count>=numOfStudents) break;
				names.add(count, new Student(name.trim()));
				count++;
			}
		}
		
		return names;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param names
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> names, Student student) {
		
		
		for(int i=0; i<names.size(); i++) {
			if(names.get(i)==null) break;
			if(names.get(i).getName().equals(student.getName())) return false;
			
		}
		
		// TODO: implement this method
		return true;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines) {
		
		String course;
		ArrayList<Course> courses = new ArrayList<Course>();
		//Course[] courses = new Course[numOfCourses];
		int count=0;
		
		for(int i=0; i<lines.length; i++) {
			course = lines[i].split(", ")[2];
			Course again = new Course(course);
			
			if(count==0) {
				courses.add(count, new Course(course.trim()));
				count++;
			}
			
			while(courseExist(courses,again)) {
				if(count>=numOfCourses) break;
				courses.add(count, new Course(course.trim()));
				count++;
			}
		}
		
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> courses, Course course) {
		
		for(int i=0; i<courses.size(); i++) {
			if(courses.get(i)==null) break;
			else if(courses.get(i).getCourseName().equals(course.getCourseName())) return false;
		}
		// TODO: implement this method

		return true;
	}

}

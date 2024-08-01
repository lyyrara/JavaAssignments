package com.example.CourseRating.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.CourseRating.model.*;
import com.example.catalogservice.model.Course;
import com.example.catalogservice.model.User;

public class CourseRatingDAO {
    List<Course> courses;

	public void CourseRatingDAO(){
		courses = new ArrayList<>();
		
		Course course1 = new Course("001", "Math", "10", "Great");
		Course course2 = new Course("002", "Chemistry", "8", "Good");
		Course course3 = new Course("003", "Physics", "6", "Average");
		Course course4 = new Course("004", "Computer Science", "4", "Bad");
		
		
		courses .add(course1); 
		courses .add(course2);
		courses .add(course3);
		courses .add(course4);
	}
	
	public Optional<Course> getCourse(String courseId) {
		
		return courses.stream().filter(course -> course.getCourseId().equals(courseId)).findFirst();
	}
	
	public List<Course> allCourses() {
		
		return courses;
	}
}


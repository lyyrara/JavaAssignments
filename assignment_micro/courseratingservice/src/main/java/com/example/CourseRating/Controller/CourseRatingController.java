package com.example.CourseRating.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.CourseRating.DAO.CourseRatingDAO;
import com.example.CourseRating.model.Course;

public class CourseRatingController {
    @Autowired
	CourseRatingDAO courserRatingDAO;

	
	@GetMapping("/getCourse/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		
		return courserRatingDAO.getCourse(courseId).orElse(null);
	}
	

	@GetMapping("/getRating/{courseId}")
	public String getCourseRating(@PathVariable String courseId) {
		
		Course course = courserRatingDAO.getCourse(courseId).orElse(null);
		String ratings = course.getRate();
		String comment = course.getComment();
		return ratings+comment;
	}


	@GetMapping("/allCourses")
	public List<Course> getAllCourses() {
		
		return courserRatingDAO.allCourses();
	}
}

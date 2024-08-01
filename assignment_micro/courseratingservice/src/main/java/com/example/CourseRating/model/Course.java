package com.example.CourseRating.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {

	private String courseId;
	private String course_name;
	private String rate;
	private String comment;
	
}
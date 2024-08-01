package com.example.EnrolledCourse.model;

import java.util.List;

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
	private List<User> users;

}

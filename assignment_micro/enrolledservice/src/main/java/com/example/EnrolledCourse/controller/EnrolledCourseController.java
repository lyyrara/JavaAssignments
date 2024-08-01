package com.example.EnrolledCourse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.EnrolledCourse.DAO.EnrolledDAO;
import com.example.EnrolledCourse.model.Course;

@RestController
@RequestMapping("/enrolled")
public class EnrolledCourseController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
	EnrolledDAO enrolledDAO;

    @GetMapping("/{userId}")
    public List<Course> getCatalog(@PathVariable String userId) {
        
        List<String> enrolleds = enrolledDAO.findByUserId(userId);
        List<Course> courses = new ArrayList<>();
        for (String courseId : enrolleds) {
            Course course = restTemplate.getForObject("http://course/getCourse/"+courseId, Course.class);
            courses.add(course);
        }
        return courses;
    }
}



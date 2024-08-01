package com.example.EnrolledCourse.DAO;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.EnrolledCourse.model.*;

@Repository
public class EnrolledDAO{
	List<Enrolled> enrolledlist;	
		
	public EnrolledDAO() {
		enrolledlist = new ArrayList<>();
		Enrolled enrolled1 = new Enrolled("1", "101", "001");
		Enrolled enrolled2 = new Enrolled("2", "101", "002");
		Enrolled enrolled3 = new Enrolled("3", "102", "001");
		Enrolled enrolled4 = new Enrolled("4", "102", "004");
		Enrolled enrolled5 = new Enrolled("5", "103", "004");
		enrolledlist.add(enrolled1);
		enrolledlist.add(enrolled2);
		enrolledlist.add(enrolled3);
		enrolledlist.add(enrolled4);
		enrolledlist.add(enrolled5);
	}

	public List<String> findByUserId(String userId){
		List<String> res = new ArrayList<>();
		for(Enrolled enrolled: enrolledlist){
			if (enrolled.getUserId().equals(userId)){
				res.add(enrolled.getCourseId());
			}
		}
		return res;
	}
	
}
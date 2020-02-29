package com.pal.dao;

import java.util.List;

import com.pal.entity.Teacher_subject_t;
import com.pal.entity.Teachers_t;

public interface Teacher_subjectDao {
	
	
	public List<Teacher_subject_t> getTeacher_subject_ts();

	public void saveTeacher_subject_t(Teacher_subject_t theTeacher_subject_t);

	public Teacher_subject_t getTeacher_subject_t(int theId);

	public void deleteTeacher_subject_t(int theId);
	
}

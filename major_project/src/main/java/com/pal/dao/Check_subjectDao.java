package com.pal.dao;

import java.util.List;

import com.pal.entity.Check_subject;

public interface Check_subjectDao {
	public List<Check_subject> getCheck_subject_ts();
	
	
	public void saveCheck_subject_t(Check_subject theCheck_subject_t);
	
	
	public Check_subject getCheck_Subject_t(int theId);
	
	public void deleteCheck_subject_t(int theId);
}

package com.pal.dao;

import java.util.List;

import com.pal.entity.Class_t;
import com.pal.entity.Subject_t;

public interface SubjectDao {
	public List<Subject_t> getSubject_ts();

	public void saveSubject_t(Subject_t theSubject_t);

	public Subject_t getSubject_t(int theId);

	public void deleteSubject_t(int theId);
}

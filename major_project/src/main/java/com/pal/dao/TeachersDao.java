package com.pal.dao;

import java.util.List;

import com.pal.entity.Class_t;
import com.pal.entity.Teachers_t;

public interface TeachersDao {
	public List<Teachers_t> getTeachers_ts();

	public void saveTeachers_t(Teachers_t theTeachers_t);

	public Teachers_t getTeachers_t(int theId);

	public void deleteTeachers_t(int theId);
}

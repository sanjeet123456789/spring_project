package com.pal.dao;

import java.util.List;

import com.pal.entity.Class_t;

public interface ClassDao {
	public List<Class_t> getClass_ts();

	public void saveClass_t(Class_t theClass_t);

	public Class_t getClass_t(int theId);

	public void deleteClass_t(int theId);
}

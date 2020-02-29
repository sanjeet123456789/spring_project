package com.pal.dao;

import java.util.List;

import com.pal.entity.Check_busy;
import com.pal.entity.Check_subject;

public interface Check_busyDao {
	
	
	public List<Check_busy> getCheck_busy_ts();

	public void saveCheck_busy_t(Check_busy theCheck_busy_t);
	
	
	public Check_busy getCheck_busy_t(int theId);
	
	public void deleteCheck_busy_t(int theId);

}

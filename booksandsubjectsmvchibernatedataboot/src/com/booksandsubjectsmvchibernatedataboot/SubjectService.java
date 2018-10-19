package com.booksandsubjectsmvchibernatedataboot;

import org.springframework.ui.ModelMap;

public interface SubjectService 
{
	public String addSubject(Subject subject,String bookIds);
	
	public String deleteSubject(long subjectId,ModelMap map);
	
	public String searchSubject(long subjectId,ModelMap map);
}

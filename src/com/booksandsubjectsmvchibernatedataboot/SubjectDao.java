package com.booksandsubjectsmvchibernatedataboot;

public interface SubjectDao 
{
	public void addSubject(Subject subject);
	
	public Subject searchSubject(long subject);
	
	public void deleteSubject(long subjectId);
	

}

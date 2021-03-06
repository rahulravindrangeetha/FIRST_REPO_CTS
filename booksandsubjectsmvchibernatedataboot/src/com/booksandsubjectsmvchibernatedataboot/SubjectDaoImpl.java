package com.booksandsubjectsmvchibernatedataboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDaoImpl implements SubjectDao 
{

	@Autowired
	private SubjectRepo subjectRepo;
	
	
	
	@Override
	public void addSubject(Subject subject) 
	{
		subjectRepo.save(subject);

	}

	@Override
	public Subject searchSubject(long subject) 
	{
		// TODO Auto-generated method stub
		return subjectRepo.findOne(subject);
	}

	@Override
	public void deleteSubject(long subjectId) 
	{
		subjectRepo.delete(subjectId);

	}

}

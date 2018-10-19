package com.booksandsubjectsmvchibernatedataboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("SubjectRepo")
public interface SubjectRepo extends JpaRepository<Subject, Long>
{

}

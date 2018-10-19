package com.booksandsubjectsmvchibernatedataboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("BookRepo")
public interface BookRepo extends JpaRepository<Book, Long>
{

}

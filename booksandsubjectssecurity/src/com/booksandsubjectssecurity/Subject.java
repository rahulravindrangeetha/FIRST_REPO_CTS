package com.booksandsubjectssecurity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by rahul.rg on 9/6/2018.
 */
@Entity
@Table(name="SUBJECT")
public class Subject implements Serializable
{
	@Id
	@Column(name="SUBJECT_ID")
    private long subjectId;
	
	@Column(name="SUBJECT_TITLE")
    private String subTitle;
    
	@Column(name="DURATION_IN_HOURS")
    private int durationInHours;
    
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinTable(name="BOOK_SUBJECT_LINK",joinColumns=@JoinColumn(name="SUBJECT_ID_LINK"),inverseJoinColumns=@JoinColumn(name="BOOK_ID_LINK"))
    private Set<Book> reference = new HashSet<>();

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }

    public Set<Book> getReference() {
        return reference;
    }

    public void setReference(Set<Book> reference) {
        this.reference = reference;
    }
    
    public String toString()
    {
    	return "SubjectID->"+subjectId+",subjectTitle->"+getSubTitle();
    }


}
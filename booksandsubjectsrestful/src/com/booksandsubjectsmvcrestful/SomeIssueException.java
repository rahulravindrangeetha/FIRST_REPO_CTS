package com.booksandsubjectsmvcrestful;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="This book is not found in the system")
public class SomeIssueException extends Exception 
{

}

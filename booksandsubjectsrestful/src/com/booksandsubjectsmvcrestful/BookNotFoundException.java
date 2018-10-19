package com.booksandsubjectsmvcrestful;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_GATEWAY,reason="This book is not found in the system")
public class BookNotFoundException extends Exception 
{

}

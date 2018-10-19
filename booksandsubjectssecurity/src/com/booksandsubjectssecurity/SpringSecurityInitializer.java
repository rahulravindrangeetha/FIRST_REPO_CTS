package com.booksandsubjectssecurity;

import javax.swing.Spring;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer
{
	public SpringSecurityInitializer()
	{
		super(SecurityConfig.class);
	}

}

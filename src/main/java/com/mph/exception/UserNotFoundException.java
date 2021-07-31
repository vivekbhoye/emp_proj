package com.mph.exception;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
		System.out.println("Username or Password is Wrong ");
	}

	public String toString() {
		return ("UserNotFoundException Raised.");

	}

}

package com.andrewdemaria.test.rmi.remote_test;

import java.io.Serializable;

public class User implements Serializable {

	String name;

	String surname;

	public User(final String name, final String surname) {
		this.name = name;
		this.surname = surname;
	}

}

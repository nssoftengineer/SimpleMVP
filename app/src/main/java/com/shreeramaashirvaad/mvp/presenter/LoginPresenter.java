package com.shreeramaashirvaad.mvp.presenter;

import com.shreeramaashirvaad.mvp.model.Student;

public interface LoginPresenter {
	/**
	 * Login.
	 * @param username the username
	 * @param password the password
	 */
	void login(String username, String password);
	void login(Student student);
}
package com.shreeramaashirvaad.mvp.view;

import com.shreeramaashirvaad.mvp.model.Student;

public interface LoginView {
	/**
	 * Show validation error.
	 */
	void showValidationError();
	/**
	 * Login success.
	 */
	void loginSuccess();

	void loginSuccess(Student student);
	/**
	 * Login error.
	 */
	void loginError();
}
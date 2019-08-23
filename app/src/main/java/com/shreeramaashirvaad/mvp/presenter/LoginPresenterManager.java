package com.shreeramaashirvaad.mvp.presenter;

import android.text.TextUtils;

import com.shreeramaashirvaad.mvp.model.Student;
import com.shreeramaashirvaad.mvp.view.LoginView;

public class LoginPresenterManager implements LoginPresenter {
	/** The login view. */
	private LoginView loginView;

	public LoginPresenterManager(LoginView loginView) {
		this.loginView = loginView;
	}
	/**
	 */@Override
	public void login(String username, String password) {
		if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
			loginView.showValidationError();
		} else {
			if (username.equals("admin") && password.equals("admin")) {
				loginView.loginSuccess();
			} else {
				loginView.loginError();
			}
		}
	}
	public void login(Student student) {
		if (TextUtils.isEmpty(student.getName()) || TextUtils.isEmpty(student.getPassword())) {
			loginView.showValidationError();
		} else {
			if (student.getName().equals("admin") && student.getPassword().equals("admin")) {
				loginView.loginSuccess(student);
			} else {
				loginView.loginError();
			}
		}
	}
}
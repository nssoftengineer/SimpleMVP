package com.shreeramaashirvaad.mvp.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shreeramaashirvaad.mvp.R;
import com.shreeramaashirvaad.mvp.model.Student;
import com.shreeramaashirvaad.mvp.presenter.LoginPresenterManager;
import com.shreeramaashirvaad.mvp.presenter.LoginPresenter;
import com.shreeramaashirvaad.mvp.view.LoginView;



public class LoginActivity extends Activity implements LoginView {
	private LoginPresenter presenter;
	private Button buttonLogin;
	private TextView textViewMessage;
	private EditText editUserName,editPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		presenter = new LoginPresenterManager(this);
		//presenter.login("admin", "admin");
	}

	private void login(String username,String password) {
		Student student =new Student();
		student.setName(username);
		student.setPassword(password);
		presenter.login(student);
	}

	private void init() {
		buttonLogin = (Button) findViewById(R.id.buttonLogin);
		editUserName = (EditText) findViewById(R.id.editUserName);
		editPassword = (EditText) findViewById(R.id.editUserPassword);
		textViewMessage = (TextView) findViewById(R.id.textViewMessage);
		buttonLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				login(editUserName.getText().toString(),editPassword.getText().toString());
			}
		});
	}

	@Override
	public void showValidationError() {
		Toast.makeText(this, "Please enter valid username and password!", Toast.LENGTH_SHORT).show();
	}
	@Override
	public void loginSuccess() {
		Toast.makeText(this, "You are successfully logged in!", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void loginSuccess(Student student) {
		textViewMessage.setText(student.getName()+" is successfully logged in!");
	}

	@Override
	public void loginError() {
		Toast.makeText(this, "Invalid login credentials!", Toast.LENGTH_SHORT).show();
	}

}
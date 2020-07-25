package com.android.teamworkapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

	private UserViewModel mUserViewModel;
	private EditText mEmailId;
	private EditText mUsername;
	private EditText mPassword;
	private EditText mConfirmPassword;
	private Button mSignupButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);

		mEmailId = (EditText) findViewById(R.id.signup_email);
		mUsername = (EditText) findViewById(R.id.signup_name);
		mPassword = (EditText) findViewById(R.id.signup_password);
		mConfirmPassword = (EditText) findViewById(R.id.signup_confirm_password);
		mSignupButton = (Button) findViewById(R.id.signup_btn);
		mUserViewModel = ViewModelProviders.of(this, new UserViewModel.Factory(getApplicationContext())).get(UserViewModel.class);

		mSignupButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if(mPassword.getText().toString().equals(mConfirmPassword.getText().toString())) {
					mUserViewModel.createUser(mEmailId.getText().toString(), mUsername.getText().toString(), mPassword.getText().toString());
					Toast.makeText(getBaseContext(), "Successfully Created An Accopunt!", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getBaseContext(), "pasword and confirm passweord not matched!", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}

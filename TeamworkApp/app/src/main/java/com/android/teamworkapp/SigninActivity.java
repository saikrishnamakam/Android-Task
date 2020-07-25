package com.android.teamworkapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {

	private UserViewModel mUserViewModel;
	private EditText mEmailId;
	private EditText mPassword;
	private Button mSignInButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signin);

		mEmailId = (EditText) findViewById(R.id.signin_email);
		mPassword = (EditText) findViewById(R.id.signin_password);
		mSignInButton = (Button) findViewById(R.id.signin_btn);
		mUserViewModel = ViewModelProviders.of(this, new UserViewModel.Factory(getApplicationContext())).get(UserViewModel.class);

		mSignInButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean isValid = mUserViewModel.checkValidLogin(mEmailId.getText().toString(), mPassword.getText().toString());

				if(isValid) {

					Intent intent = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(intent);

					Toast.makeText(getBaseContext(), "Successfully Logged In!", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getBaseContext(), "Inavalid Login!", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}

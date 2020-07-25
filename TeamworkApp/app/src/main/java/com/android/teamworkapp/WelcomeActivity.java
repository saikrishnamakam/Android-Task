package com.android.teamworkapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

	private Button mSignInButton;
	private Button mSignUpButtton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		mSignInButton = (Button) findViewById(R.id.signin_btn);
		mSignUpButtton = (Button) findViewById(R.id.signup_btn);

		mSignUpButtton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(WelcomeActivity.this , SignupActivity.class);
				startActivity(intent);
			}
		});

		mSignInButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(WelcomeActivity.this , SigninActivity.class);
				startActivity(intent);
			}
		});

	}
}

package com.android.teamworkapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private Toolbar mToolbar;
	private TabLayout mTabLayout;
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//mToolbar = (Toolbar) findViewById(R.id.toolbar);
		//setSupportActionBar(mToolbar);
		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(adapter);

		mTabLayout = (TabLayout) findViewById(R.id.tablayout);
		mTabLayout.setupWithViewPager(mViewPager);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		//call super
		super.onActivityResult(requestCode, resultCode, data);
	}
}

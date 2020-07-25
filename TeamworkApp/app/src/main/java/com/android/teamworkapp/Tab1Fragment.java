package com.android.teamworkapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Tab1Fragment extends Fragment {

	public static Fragment getInstance() {

		Tab1Fragment tab1Fragment = new Tab1Fragment();
		return tab1Fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.contact_us, container, false);
		return v;
	}

}

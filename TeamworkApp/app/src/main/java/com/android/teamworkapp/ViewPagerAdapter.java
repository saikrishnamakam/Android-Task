package com.android.teamworkapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

	private String tabTitles[] = {"Contact Us", "View Images", "Images"};

	public ViewPagerAdapter(FragmentManager manager) {

		super(manager);
	}

	@Override
	public Fragment getItem(int position) {

		Fragment fragment = null;

		switch(position) {

			case 0:
				fragment = Tab1Fragment.getInstance();
				break;
			case 1:
				fragment = Tab2Fragment.getInstance();
				break;
			case 2:
				fragment = Tab3Fragment.getInstance();
				break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return tabTitles.length;
	}

	@Override
	public CharSequence getPageTitle(int position) {

		return tabTitles[position];
	}
}

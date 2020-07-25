package com.android.teamworkapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;


public class Tab2Fragment extends Fragment {
	private Button mPhotoButton;
	private ImageView mPhotoView;
	private static final int REQUEST_PHOTO = 0;

	public static Fragment getInstance() {

		Tab2Fragment tab2Fragment = new Tab2Fragment();
		return tab2Fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.images, container, false);

		mPhotoButton = (Button) v.findViewById(R.id.imgBtn);
		mPhotoView = (ImageView) v.findViewById(R.id.imgView);

		mPhotoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				mPhotoButton.setVisibility(View.GONE);
				mPhotoView.setVisibility(View.VISIBLE);
				Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

				i.putExtra("crop", "true");
				i.putExtra("aspectX", 100);
				i.putExtra("aspectY", 100);
				i.putExtra("outputX", 256);
				i.putExtra("outputY", 356);

				try {

					i.putExtra("return-data", true);
					startActivityForResult(
							Intent.createChooser(i, "Select Picture"), 0);
				}catch (ActivityNotFoundException ex){
					ex.printStackTrace();
				}
			}
		});

		return v;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==0 && resultCode == Activity.RESULT_OK){
			try {
				Bundle bundle = data.getExtras();
				Bitmap bitmap = bundle.getParcelable("data");
				mPhotoView.setImageBitmap(bitmap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


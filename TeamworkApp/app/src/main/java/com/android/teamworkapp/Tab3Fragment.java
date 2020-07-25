package com.android.teamworkapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.teamworkapp.FetchPhotos.GetDataService;
import com.android.teamworkapp.FetchPhotos.Photo;
import com.android.teamworkapp.FetchPhotos.RetrofitClientInstance;

import org.httprpc.WebServiceProxy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tab3Fragment extends Fragment {

	private RecyclerviewAdapter mAdapter;
	private RecyclerView mRecyclerView;
	ProgressDialog mProgressDialog;
	List<Photo> mPhotoList;

	public static Fragment getInstance() {

		com.android.teamworkapp.Tab3Fragment tab3Fragment = new com.android.teamworkapp.Tab3Fragment();
		return tab3Fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		mProgressDialog = new ProgressDialog(getActivity());
		mProgressDialog.setMessage("Loading....");
		mProgressDialog.show();

		/*Create handle for the RetrofitInstance interface*/
		GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

		Call<List<Photo>> call = service.getAllPosts();
		call.enqueue(new Callback<List<Photo>>() {

			@Override
			public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
				Log.i("sai", "successs");
				mProgressDialog.dismiss();
				//mPhotoList = ;
				generateDataList(response.body());
			}

			@Override
			public void onFailure(Call<List<Photo>> call, Throwable t) {
				Log.i("sai", "failed");
				mProgressDialog.dismiss();
				Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.view_images, container, false);
		Log.i("sai", "in-oncreateview");
		mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);


			Log.i("sai", "not-null");
		return v;
	}

	private void generateDataList(List<Photo> photoList) {
		mAdapter = new RecyclerviewAdapter(getActivity(),photoList);
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
		mRecyclerView.setLayoutManager(layoutManager);
		mRecyclerView.setAdapter(mAdapter);
	}

	@Override
	public void onResume() {

		super.onResume();
	}

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.CustomViewHolder> {

	private List<Photo> dataList;
	private Context context;

	public RecyclerviewAdapter(Context context, List<Photo> dataList){
		this.context = context;
		this.dataList = dataList;
	}

	class CustomViewHolder extends RecyclerView.ViewHolder {

		public final View mView;

		ImageView mImageView;
		TextView mId, mTitle;

		CustomViewHolder(View itemView) {
			super(itemView);
			mView = itemView;
			mImageView = (ImageView) mView.findViewById(R.id.image_view);
			mId = (TextView) mView.findViewById(R.id.text_view_id);
			mTitle = (TextView) mView.findViewById(R.id.text_view_title);
		}
	}

	@Override
	public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view = layoutInflater.inflate(R.layout.item_markup, parent, false);
		return new CustomViewHolder(view);
	}

	@Override
	public void onBindViewHolder(CustomViewHolder holder, int position) {
		holder.mTitle.setText("Title: " + dataList.get(position).getTitle());
		holder.mId.setText("Id: " + Integer.toString(dataList.get(position).getId()));
		holder.mImageView.setImageResource(R.drawable.no_image);
	}

	@Override
	public int getItemCount() {
		if(dataList != null)
			return dataList.size();
		else
			return 5;
	}
}
}
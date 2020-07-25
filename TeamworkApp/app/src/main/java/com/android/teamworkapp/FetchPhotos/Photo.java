package com.android.teamworkapp.FetchPhotos;

import com.google.gson.annotations.SerializedName;

import java.net.URL;

public class Photo {

	@SerializedName("albumId")
	private Integer albumId;
	@SerializedName("id")
	private Integer id;
	@SerializedName("title")
	private String title;
	@SerializedName("url")
	private URL url;
	@SerializedName("thumbnailUrl")
	private URL thumbnailUrl;

	public Photo(Integer albumId, Integer id, String title, URL url, URL thumbnailUrl) {

		this.albumId = albumId;
		this.id = id;
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
	}

	public int getId() {

		return id.intValue();

	}

	public int getAlbumId() {

		return albumId.intValue();

	}

	public String getTitle() {

		return title;

	}

	public URL getUrl() {

		return url;

	}

	public URL getThumbnailUrl() {

		return thumbnailUrl;

	}

}

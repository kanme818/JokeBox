package ky.jokebox.widgets;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.view.View;

public class GifView extends View {

	private Movie movie;
	private int duration;
	private boolean loop = true;
	private long mMovieStart;
	private byte[] array;

	public GifView(Context context, int resource) {
		super(context);
		setFocusable(true);
		array = streamToBytes(getStream(context, resource));
		movie = Movie.decodeByteArray(array, 0, array.length);
		duration = movie.duration();
	}

	public GifView(Context context, String resource) {
		super(context);
		setFocusable(true);
		array = streamToBytes(getStream(context, resource));
		movie = Movie.decodeByteArray(array, 0, array.length);
		duration = movie.duration();
	}

	public GifView(Context context, int resource, boolean loop) {
		this(context, resource);
		this.loop = loop;
	}

	public GifView(Context context, String resource, boolean loop) {
		this(context, resource);
		this.loop = loop;
	}

	private java.io.InputStream getStream(Context context, int resource) {
		java.io.InputStream is = context.getResources().openRawResource(
				resource);
		return is;
	}

	private java.io.InputStream getStream(Context context, String resource) {
		java.io.InputStream is = null;
		try {
			is = new BufferedInputStream(
					new FileInputStream(new File(resource)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is;
	}

	private byte[] streamToBytes(InputStream is) {
		ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
		byte[] buffer = new byte[1024];
		int len;
		try {
			while ((len = is.read(buffer)) >= 0) {
				os.write(buffer, 0, len);
			}
		} catch (java.io.IOException e) {
		} finally {
			try {
				os.flush();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return os.toByteArray();
	}

	@Override
	public void draw(Canvas canvas) {
		long now = android.os.SystemClock.uptimeMillis();
		if (mMovieStart == 0) {
			mMovieStart = now;
		}
		if (movie != null) {
			if (!loop) {
				if ((now - mMovieStart) > duration) {
					movie.setTime(duration);
					movie.draw(canvas, 0, 0);
					super.draw(canvas);
					return;
				}
			}

			int relTime = (int) ((now - mMovieStart) % duration);
			movie.setTime(relTime);
			movie.draw(canvas, 0, 0);
			invalidate();
		}
		super.draw(canvas);
	}

}
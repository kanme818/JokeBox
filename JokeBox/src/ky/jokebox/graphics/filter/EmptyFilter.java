/*
 * 虽然没有钱，但至少还有网。 ╮(╯▽╰)╭
 * 
 * @auth KanYong 2012
 */
package ky.jokebox.graphics.filter;

import android.graphics.Bitmap;

// TODO: Auto-generated Javadoc
/**
 * 没什么用，开发时站位子用的.
 */
public class EmptyFilter extends BaseFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see kanyong.jokebox.graphics.Filter#doFilter(android.graphics.Bitmap)
	 */
	@Override
	public Bitmap doFilter(Bitmap bmp) {
		// Do nothing, just for development.
		return bmp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kanyong.jokebox.graphics.Filter#reset()
	 */
	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

}

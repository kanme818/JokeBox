/*
 * 虽然没有钱，但至少还有网。 ╮(╯▽╰)╭
 * 
 * @auth KanYong 2012
 */
package ky.jokebox.graphics.filter;

import ky.jokebox.graphics.PS;
import android.graphics.Bitmap;

// TODO: Auto-generated Javadoc
/**
 * 倒影滤镜3D.
 */
public class Reflection3DFilter extends ReflectionFilter {

	protected Bitmap applyRotateFilter(Bitmap bmp) {
		Bitmap rotatedBmp = PS.quickApply(bmp, new Rotate3DFilter());
		return rotatedBmp;
	}

}

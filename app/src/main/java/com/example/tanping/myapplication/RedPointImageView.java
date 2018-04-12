package com.example.tanping.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 带红点的RadioButton
 * 
 * @author tanping
 * 
 */
public class RedPointImageView extends android.support.v7.widget.AppCompatImageView {
	public String rightText;
	public String redBgColor = "#FF0000";
	public String textColor = "#FFFFFF";
	public int textSize =8;//dp
	public int raduis = 8;// dp


	public RedPointImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public RedPointImageView(Context context) {
		super(context);
		initView();
	}

	private void initView() {
		rightText = 18+"+";
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (rightText != null) {
			Paint paint = new Paint();
			paint.setColor(Color.parseColor(redBgColor));
			int maxr = getWidth();
			paint.setAntiAlias(true);// 抗锯齿
			paint.setStyle(Style.FILL); // 描边
			paint.setStrokeWidth(1);
			int r = DensityUtil.dip2px(getContext(), raduis); // 半径

			int cx = getWidth()-r ;
			if (getLayoutDirection()== View.LAYOUT_DIRECTION_RTL){//布局方向，可以用其他代码替换
				cx = r ;
			}
			Log.d("draw_red", "cx:"+cx +" r:"+r);
			// 画圆
			canvas.drawCircle(cx, r, r, paint);
			paint.setColor(Color.parseColor(textColor));
			//转换成
			int textSizePx = DensityUtil.dip2px(getContext(), textSize);

			//长度小 字可以大些
			if (rightText.length() ==1){
				textSizePx *= 1.5;
			}

			paint.setTextSize(textSizePx);
			paint.setTextAlign(Paint.Align.CENTER);
			//基准线和中线点偏移 testsize/3
			canvas.drawText(rightText,cx,r+textSizePx/3.0f,paint);
		}
	}

	public void setRaduis(int raduis) {
		this.raduis = raduis;
		invalidate();
	}

	public String getRightText() {
		return rightText;
	}

	public void setRightText(String rightText) {
		this.rightText = rightText;
		invalidate();
	}

	public String getRedBgColor() {
		return redBgColor;
	}

	public void setRedBgColor(String redBgColor) {
		this.redBgColor = redBgColor;
		invalidate();
	}
	


}

package com.muratonnet.customscrollview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initializeViewPager();
	}

	private void initializeViewPager() {
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		MyPagerAdapter adapter = new MyPagerAdapter(this, new String[] {
				"Page 1", "Page 2", "Page 3", "Page 4", "Page 5" });
		pager.setAdapter(adapter);
	}

	public class MyPagerAdapter extends PagerAdapter {

		Context mContext;
		String[] mPageContents;

		public MyPagerAdapter(Context context, String[] pageContents) {
			mContext = context;
			mPageContents = pageContents;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {

			TextView page = new TextView(mContext);
			page.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT));
			page.setText(mPageContents[position]);
			page.setGravity(Gravity.CENTER);

			container.addView(page);
			return page;
		}

		@Override
		public int getCount() {
			return mPageContents.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView((TextView) object);
		}

	}

}

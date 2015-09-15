package info.androidhive.tabsswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TopRatedFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_top_rated, container, false);
		
		return rootView;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		Log.i("tag", "onSaveInstanceState");
		super.onSaveInstanceState(outState);
	}
}

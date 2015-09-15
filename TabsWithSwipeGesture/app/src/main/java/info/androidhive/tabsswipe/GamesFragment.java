package info.androidhive.tabsswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GamesFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {


		return inflater.inflate(R.layout.fragment_games, container, false);
        //View rootView = inflater.inflate(R.layout.fragment_games, container, false);
		//return rootView;
	}
}

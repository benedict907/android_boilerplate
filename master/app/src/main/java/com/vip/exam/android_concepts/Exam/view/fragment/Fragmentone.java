package com.vip.exam.android_concepts.Exam.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vipin.kotlindemo.R;
import com.example.vipin.kotlindemo.adapter.NotificationAdapter;
import com.example.vipin.kotlindemo.contract.NotificationContract;
import com.example.vipin.kotlindemo.model.pojo_model.Notification_;
import com.example.vipin.kotlindemo.presenter.PresenterNotification;

import java.util.ArrayList;
import java.util.List;


public class Fragmentone extends Fragment implements NotificationContract.View {



	RecyclerView recyclerView;

	PresenterNotification mPresenter;

	TextView noDataList;

	NotificationAdapter notificationAdapter;
	public List<Notification_> notificationDataList = new ArrayList<>();
	private LinearLayoutManager mLayoutManager;

	public static Fragmentone newInstance() {return new Fragmentone(); }

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragmentone, container, false);
		return view;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		onInit(view);

	}

	public void onInit(View view) {

		Recyclerinit(view);

		if (mPresenter == null) {
			//mPresenter = new PresenterNotification(this,getActivity());
			//mPresenter.CallNotification(0);
		}
	}

	private void Recyclerinit(View view) {


		noDataList = view.findViewById(R.id.no_data_list);
		recyclerView = view.findViewById(R.id.notificationRecycler);

		recyclerView.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(mLayoutManager);
		//notificationAdapter = new NotificationAdapter(this,getActivity(), notificationDataList);
		recyclerView.setAdapter(notificationAdapter);
	}


	@Override
	public void showDialogbox() {

	}

	@Override
	public void hideDialogbox() {

	}

	@Override
	public void showerrorSnak(String message) {

		noDataList.setVisibility(View.VISIBLE);

	}

	@Override
	public void SetNotification(List<Notification_> data) {

		try {

			this.notificationDataList.addAll(data);

			if (notificationDataList.size() > 0 ) {

				if (notificationDataList != null) {

					noDataList.setVisibility(View.GONE);

					notificationAdapter.notifyDataSetChanged();

				}} else {
				noDataList.setVisibility(View.VISIBLE);

			}

		} catch (Exception e) {
		}
	}

	@Override
	public void GotoDetailsPage(int position, String type) {

		Log.e("click _ ",""+position);

		Toast.makeText(getActivity(),"Click: "+position,Toast.LENGTH_SHORT).show();


	}
}

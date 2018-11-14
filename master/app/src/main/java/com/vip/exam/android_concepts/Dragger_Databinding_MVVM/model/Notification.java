package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Notification {

	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("notifications")
	@Expose
	private List<Notification_> notifications = null;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Notification_> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification_> notifications) {
		this.notifications = notifications;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

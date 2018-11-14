package com.vip.exam.android_concepts.Dragger_Databinding_MVVM.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Notification_ {

	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("reference_id")
	@Expose
	private Integer referenceId;
	@SerializedName("action_key_word")
	@Expose
	private String actionKeyWord;
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("notification_text")
	@Expose
	private String notificationText;
	@SerializedName("send_at")
	@Expose
	private String sendAt;
	@SerializedName("is_seen")
	@Expose
	private Boolean isSeen;
	@SerializedName("is_read")
	@Expose
	private Boolean isRead;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Integer referenceId) {
		this.referenceId = referenceId;
	}

	public String getActionKeyWord() {
		return actionKeyWord;
	}

	public void setActionKeyWord(String actionKeyWord) {
		this.actionKeyWord = actionKeyWord;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotificationText() {
		return notificationText;
	}

	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
	}

	public String getSendAt() {
		return sendAt;
	}

	public void setSendAt(String sendAt) {
		this.sendAt = sendAt;
	}

	public Boolean getIsSeen() {
		return isSeen;
	}

	public void setIsSeen(Boolean isSeen) {
		this.isSeen = isSeen;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}


}

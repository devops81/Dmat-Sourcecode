package com.devopps.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notification_mapping")
public class NotificationMappingEntity {
	
	private int notificationId;
	
	private int actionId;
	
	private int notifyAssessor;
	
	private int notifyLeadAssessor;

	/**
	 * @return the notificationId
	 */
	@Id
	@Column(name="notification_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getNotificationId() {
		return notificationId;
	}

	/**
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	/**
	 * @return the actionId
	 */
	@Column(name="action_id")
	public int getActionId() {
		return actionId;
	}

	/**
	 * @param actionId the actionId to set
	 */
	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	/**
	 * @return the notifyAssessor
	 */
	@Column(name="notify_assessor")
	public int getNotifyAssessor() {
		return notifyAssessor;
	}

	/**
	 * @param notifyAssessor the notifyAssessor to set
	 */
	public void setNotifyAssessor(int notifyAssessor) {
		this.notifyAssessor = notifyAssessor;
	}

	/**
	 * @return the notifyLeadAssessor
	 */
	@Column(name="notify_lead_assessor  ")
	public int getNotifyLeadAssessor() {
		return notifyLeadAssessor;
	}

	/**
	 * @param notifyLeadAssessor the notifyLeadAssessor to set
	 */
	public void setNotifyLeadAssessor(int notifyLeadAssessor) {
		this.notifyLeadAssessor = notifyLeadAssessor;
	}

}

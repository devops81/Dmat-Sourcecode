package com.devopps.portal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.AccountDetails;
import com.devopps.portal.model.AddAccountsRequestBody;
import com.devopps.portal.model.NotificationMappingEntity;
import com.devopps.portal.model.SaveNotificationRequestBody;
import com.devopps.portal.model.UserProfileEntity;
import com.devopps.portal.model.UserProfileRequestBody;

@Component("IProfileDao")
public class ProfileDaoImpl implements IProfileDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void saveUserProfile(UserProfileRequestBody userProfileRequestBody) {
		
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		if (userProfileRequestBody.getSaveOrUpdate() == 1) {
			
			UserProfileEntity profileEntity = new UserProfileEntity();
			profileEntity.setAccountId(userProfileRequestBody.getAccountId());
			profileEntity.setName(userProfileRequestBody.getName());
			profileEntity.setPassword(userProfileRequestBody.getPassword());
			profileEntity.setRoleId(userProfileRequestBody.getRoleId());
			//profileEntity.setId(userProfileRequestBody.getEmployeeId());
			profileEntity.setPassword(userProfileRequestBody.getPassword());
			profileEntity.setUserId(String.valueOf(userProfileRequestBody.getEmployeeId()));
			profileEntity.setIsActive(userProfileRequestBody.isActive() == true ? 1 : 0);
			session.save(profileEntity);
		} else {
			
			UserProfileEntity profileEntity = (UserProfileEntity) session.load(UserProfileEntity.class, Integer.parseInt(userProfileRequestBody.getEmployeeId()));
			List existingProfile = session.createCriteria(UserProfileEntity.class).add(Restrictions.eq("id",Integer.parseInt(userProfileRequestBody.getEmployeeId()))).list();
			if (existingProfile.size() > 0) {
				
				profileEntity.setAccountId(userProfileRequestBody.getAccountId());
				profileEntity.setName(userProfileRequestBody.getName());
				profileEntity.setPassword(userProfileRequestBody.getPassword());
				profileEntity.setRoleId(userProfileRequestBody.getRoleId());
				
				profileEntity.setId(Integer.parseInt(userProfileRequestBody.getEmployeeId()));
				profileEntity.setPassword(userProfileRequestBody.getPassword());
				//profileEntity.setUserId(Integer.parseInt(userProfileRequestBody.getEmployeeId()));
				profileEntity.setIsActive(userProfileRequestBody.isActive() == true ? 1 : 0);
				session.update(profileEntity);
			}
		}
		tx.commit();
		session.close();
	}
	
	
	@Override
	public void saveNotifications(
			SaveNotificationRequestBody saveNotificationRequestBody) throws NoRecordsFoundException {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		if (saveNotificationRequestBody.getSaveOrUpdate() == 1) {//save
		NotificationMappingEntity notificationEntity = new NotificationMappingEntity();
			notificationEntity.setActionId(saveNotificationRequestBody.getActionId());
			notificationEntity.setNotifyAssessor(saveNotificationRequestBody.isNotifyAssessor() == true ? 1 : 0);
			notificationEntity.setNotifyLeadAssessor(saveNotificationRequestBody.isNotifyLeadAssessor() == true ? 1: 0);
			session.save(notificationEntity);
		} else {
			NotificationMappingEntity notificationEntity = (NotificationMappingEntity) session.load(NotificationMappingEntity.class, saveNotificationRequestBody.getActionId());
			List existingNotifications = session.createCriteria(NotificationMappingEntity.class).add(Restrictions.eq("actionId",saveNotificationRequestBody.getActionId())).list();
			if (existingNotifications.size() > 0) {
			notificationEntity.setActionId(saveNotificationRequestBody.getActionId());
			notificationEntity.setNotifyAssessor(saveNotificationRequestBody.isNotifyAssessor() == true ? 1 : 0);
			notificationEntity.setNotifyLeadAssessor(saveNotificationRequestBody.isNotifyLeadAssessor() == true ? 1: 0);
			session.update(notificationEntity);
			} else {
				throw new NoRecordsFoundException("NO Records Found");
			}
		}
		tx.commit();
		session.close();
	}
		
}

package com.devopps.portal.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devopps.portal.controller.DisplayController;
import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.AccountDetails;
import com.devopps.portal.model.AccountEntity;
import com.devopps.portal.model.AddAccountsRequestBody;
import com.devopps.portal.model.AddRolesRequestBody;
import com.devopps.portal.model.ApplicationDetailEntity;
import com.devopps.portal.model.ApplicationDetails;
import com.devopps.portal.model.ApplicationRequestBody;
import com.devopps.portal.model.BusinessUnitDetails;
import com.devopps.portal.model.QuestionScoreEntity;
import com.devopps.portal.model.RoleDetails;
import com.devopps.portal.model.RoleEntity;
import com.devopps.portal.model.UserProfileDetails;
import com.devopps.portal.util.IHibernateQueries;
import com.devopps.portal.util.Log;
import com.devopps.portal.util.LogFactory;
import com.sun.istack.logging.Logger;

@Component("IDisplayDao")
public class DisplayDaoImpl implements IDisplayDao {
	
	private static final Log LOGGER = LogFactory.getLog(DisplayDaoImpl.class);
	

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RoleDetails> getRoleDetails() {
		Session session = getSessionFactory().openSession();
		List<RoleEntity> roleEntityList = null;
		Query query =  session.createQuery("from RoleEntity");
		roleEntityList = (List<RoleEntity>)query.list();
		List<RoleDetails> roleDetailsList = new ArrayList <RoleDetails>();		
		Iterator<RoleEntity> roleEntityItr = roleEntityList.iterator();
		RoleEntity roleEntity = null;
		RoleDetails role = null;
		while(null != roleEntityItr && roleEntityItr.hasNext()){
			roleEntity = roleEntityItr.next();
			role = new RoleDetails();
			role.setRoleId(roleEntity.getRoleId());
			role.setRole(roleEntity.getRoleName());
			role.setActive(roleEntity.getIsActive() == 1 ? true : false);
			roleDetailsList.add(role);
        }
		if (roleDetailsList != null && roleDetailsList.size() == 1 ) {
			role = new RoleDetails();
			role.setRole("");
			role.setRoleId(-1);
			role.setActive(false);
			roleDetailsList.add(role);
		}
		session.close();
		return roleDetailsList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AccountDetails> getAccountDetails() {
		Session session = getSessionFactory().openSession();
		List<AccountEntity> accountEntityList = null;
		Query query =  session.createQuery("SELECT p FROM AccountEntity p");
		accountEntityList = (List<AccountEntity>)query.list();
		List<AccountDetails> accountDetailsList = new ArrayList <AccountDetails>();		
		Iterator<AccountEntity> accountEntityItr = accountEntityList.iterator();
		AccountEntity accountEntity = null;
		AccountDetails accountDetail = null;
		int questionScoreCount = -1;
		while(null != accountEntityItr && accountEntityItr.hasNext()){
			accountEntity = accountEntityItr.next();
			accountDetail = new AccountDetails();
			accountDetail.setAccountId(accountEntity.getAccountId());
			accountDetail.setAccount(accountEntity.getAccountName());
			accountDetail.setActive(accountEntity.getIsActive() == 1 ? true : false);
			questionScoreCount = session.createCriteria(QuestionScoreEntity.class).add(Restrictions.eq("accountId",accountEntity.getAccountId())).list().size();
			accountDetail.setEditAllowed(questionScoreCount > 0 ? false : true);
			accountDetailsList.add(accountDetail);
        }
		 
		if (accountDetailsList != null && accountDetailsList.size() == 1) {
			accountDetail = new AccountDetails();
			accountDetail.setAccountId(-1);
			accountDetail.setAccount("");
			accountDetail.setActive(false);
			accountDetailsList.add(accountDetail);
		}
		session.close();
		return accountDetailsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationDetails> getApplicationDetails(ApplicationRequestBody applicationRequestBody) {
		Session session = getSessionFactory().openSession();
		List<Object[]> applicationInfo = null;
		int questionScoreCount = -1;
		applicationInfo=  session.createQuery(IHibernateQueries.GET_APPLICATION_INFO).list();
		if (applicationRequestBody.isShowDistinctVals()) {
			applicationInfo=  session.createQuery(IHibernateQueries.GET_DISTINCT_APPLICATIONS).list();
		} 
		List<ApplicationDetails> appDetailsList = new ArrayList <ApplicationDetails>();
		ApplicationDetails appDetail = null;
		int activeFlag = -1;
		for (Object[] appUnit : applicationInfo) {
			appDetail = new ApplicationDetails();
			if (applicationRequestBody.isShowDistinctVals()) {
				appDetail.setApplicationId((Integer)appUnit[0]);
				appDetail.setApplicationName((String)appUnit[1]);
			} else {
			appDetail.setApplicationId((Integer)appUnit[0]);
			appDetail.setApplicationName((String)appUnit[1]);
			appDetail.setBusinessUnit((Integer)appUnit[2]);
			appDetail.setBusinessName((String)appUnit[3]);
			activeFlag = (Integer)appUnit[4];
			questionScoreCount = session.createCriteria(QuestionScoreEntity.class).add(Restrictions.eq("businessUnitId",(Integer)appUnit[2])).
					add(Restrictions.eq("applicationId",(Integer)appUnit[0])).list().size();
			appDetail.setActive(activeFlag == 1 ? true : false);
			appDetail.setEditAllowed(questionScoreCount > 0 ? false: true);
			}
			appDetailsList.add(appDetail);
		}
		
		if(appDetailsList != null && appDetailsList.size() == 1) {
			appDetail =  new ApplicationDetails();
			appDetail.setApplicationId(-1);
			appDetail.setApplicationName("");
			appDetail.setBusinessUnit(-1);
			appDetail.setBusinessName("");
			appDetail.setActive(false);
		}
		session.close();
		return appDetailsList;
	}
		
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserProfileDetails> getUserProfileDetails() {
		Session session = getSessionFactory().openSession();
		List<Object[]> userEntityList = null;
		Query query =  session.createQuery(IHibernateQueries.FETCH_USER_PROFILES);
		userEntityList = (List<Object[]>)query.list();
		List<UserProfileDetails> userProfileDetailsList = new ArrayList <UserProfileDetails>();		
		Iterator<Object[]> userEntityItr = userEntityList.iterator();
		Object[] userEntity = null;
		UserProfileDetails userDetail = null;
		while(null != userEntityItr && userEntityItr.hasNext()){
			userEntity = userEntityItr.next();
			userDetail = new UserProfileDetails();
			userDetail.setEmployeeId((Integer)userEntity[0]);
			userDetail.setName((String)userEntity[1]);
			userDetail.setRoleId((Integer)userEntity[2]);
			userDetail.setAccountId((Integer)userEntity[3]);
			userDetail.setPassword((String)userEntity[4]);
			userDetail.setRoleName((String)userEntity[5]);
			userDetail.setAccountName((String)userEntity[6]);
			userDetail.setActiveFlag((Integer)userEntity[7]);
			userDetail.setUserId((String)userEntity[8]);
			System.out.println((String)userEntity[8]);
			userProfileDetailsList.add(userDetail);
        }
		if (userProfileDetailsList.size() == 1) {
			userDetail = new UserProfileDetails();
			userDetail.setEmployeeId(-1);
			userDetail.setAccountId(-1);
			userDetail.setAccountName("");
			userDetail.setActiveFlag(0);
			userDetail.setName("");
			userDetail.setPassword("");
			userDetail.setRoleId(-1);
			userDetail.setRoleName("");
			userDetail.setUserId("");
			userProfileDetailsList.add(userDetail);
		}
		session.close();
		System.out.println(userProfileDetailsList.toString());
		return userProfileDetailsList;
	}
	
	@Override
	public int saveAccountDetails(AddAccountsRequestBody accountRequestBody) throws DuplicateAreasException,NoRecordsFoundException {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		int accountId = -1;
		if (accountRequestBody.getSaveOrUpdate() == 1) {//save
				AccountEntity accountEntity = new AccountEntity();
				accountEntity.setAccountName(accountRequestBody.getAccountName());
				accountEntity.setIsActive(accountRequestBody.isActive() ? 1 : 0);
				accountId = accountEntity.getAccountId();
				session.save(accountEntity);
			} else {
				AccountEntity accountEntity = (AccountEntity) session.load(AccountEntity.class, accountRequestBody.getAccountId());
				List existingAccounts = session.createCriteria(AccountEntity.class).add(Restrictions.eq("accountId",accountRequestBody.getAccountId())).list();
				if (existingAccounts != null && existingAccounts.size() > 0) {
					accountEntity.setAccountId(accountRequestBody.getAccountId());
					accountEntity.setAccountName(accountRequestBody.getAccountName());
					accountEntity.setIsActive(accountRequestBody.isActive() ? 1 : 0);
				    accountId = accountRequestBody.getAccountId();
					session.update(accountEntity);
				} else {
					throw new NoRecordsFoundException("NO Records Found");
				}
			}
			tx.commit();
			session.close();
			return accountId;
	}
	
	
	@Override
	public int saveRoleDetails(AddRolesRequestBody rolesRequestBody) throws  NoRecordsFoundException {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		int roleId = -1;
		if (rolesRequestBody.getSaveOrUpdate() == 1) {//save
				RoleEntity roleEntity = new RoleEntity();
				roleEntity.setRoleName(rolesRequestBody.getRoleName());
				roleEntity.setIsActive(rolesRequestBody.isActive() ? 1 : 0);
				roleId = roleEntity.getRoleId();
				session.save(roleEntity);
			} else {
				RoleEntity roleEntity = (RoleEntity) session.load(RoleEntity.class, rolesRequestBody.getRoleId());
				List existingRoles = session.createCriteria(RoleEntity.class).add(Restrictions.eq("roleId",rolesRequestBody.getRoleId())).list();
				if (existingRoles.size() > 0) {
					roleEntity.setRoleId(rolesRequestBody.getRoleId());
					roleEntity.setRoleName(rolesRequestBody.getRoleName());
					roleEntity.setIsActive(rolesRequestBody.isActive() ? 1 : 0);
					roleId = rolesRequestBody.getRoleId();
					session.update(roleEntity);
				} else {
					throw new NoRecordsFoundException("NO Records Found");
				}
			}
			tx.commit();
			session.close();
			return roleId;
	}
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

}

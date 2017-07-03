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

import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.AccountDetails;
import com.devopps.portal.model.AccountEntity;
import com.devopps.portal.model.AddAccountsRequestBody;
import com.devopps.portal.model.AddRolesRequestBody;
import com.devopps.portal.model.ApplicationDetailEntity;
import com.devopps.portal.model.ApplicationDetails;
import com.devopps.portal.model.RoleDetails;
import com.devopps.portal.model.RoleEntity;
import com.devopps.portal.model.UserProfileDetails;
import com.devopps.portal.util.IHibernateQueries;

@Component("IDisplayDao")
public class DisplayDaoImpl implements IDisplayDao {

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
		while(null != accountEntityItr && accountEntityItr.hasNext()){
			accountEntity = accountEntityItr.next();
			accountDetail = new AccountDetails();
			accountDetail.setAccountId(accountEntity.getAccountId());
			accountDetail.setAccount(accountEntity.getAccountName());
			accountDetail.setActive(accountEntity.getIsActive() == 1 ? true : false);
			accountDetailsList.add(accountDetail);
        }
		session.close();
		return accountDetailsList;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationDetails> getApplicationDetails() {
		Session session = getSessionFactory().openSession();
		List<ApplicationDetailEntity> appEntityList = null;
		Query query =  session.createQuery("SELECT p FROM ApplicationDetailEntity p");
		appEntityList = (List<ApplicationDetailEntity>)query.list();
		List<ApplicationDetails> appDetailsList = new ArrayList <ApplicationDetails>();		
		Iterator<ApplicationDetailEntity> appEntityItr = appEntityList.iterator();
		ApplicationDetailEntity appEntity = null;
		ApplicationDetails appDetail = null;
		while(null != appEntityItr && appEntityItr.hasNext()){
			appEntity = appEntityItr.next();
			appDetail = new ApplicationDetails();
			appDetail.setApplicationId(appEntity.getApplicationId());
			appDetail.setApplicationName(appEntity.getApplicationName());
			appDetail.setActive(appEntity.getActiveFlag() == 1? true : false);
			appDetailsList.add(appDetail);
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
			userProfileDetailsList.add(userDetail);
        }
		session.close();
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
				if (existingAccounts.size() > 0) {
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

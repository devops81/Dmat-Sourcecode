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
import com.devopps.portal.model.ApplicationDetailEntity;
import com.devopps.portal.model.ApplicationEntity;
import com.devopps.portal.model.ISaveApplicationServiceParameters;
import com.devopps.portal.model.SaveApplicationRequestBody;
import com.devopps.portal.util.IHibernateQueries;

@Component("IApplicationDao")
public class ApplicationDaoImpl implements IApplicationDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveApplicationDetails(ISaveApplicationServiceParameters saveApplicationServiceParams) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<String> applicationIds = saveApplicationServiceParams.getSaveApplicationRequest().getApplicationIds();
		for (String application : applicationIds) {
			ApplicationEntity appEntity = new ApplicationEntity();
			//appEntity.setUserId(saveApplicationServiceParams.getSaveApplicationRequest().getUserId());
			//appEntity.setApplicationId(application);
			session.persist(appEntity);
		}
		tx.commit();
		session.close();
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
	@Override
	public int saveApplication(SaveApplicationRequestBody saveApplicationRequestBody) throws DuplicateAreasException, NoRecordsFoundException {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		int applicationId = -1;
		
		if (saveApplicationRequestBody.getApplicationId() == -1) {
			checkDuplicateApplication(saveApplicationRequestBody, session);
			ApplicationDetailEntity appEntity = new ApplicationDetailEntity();
			appEntity.setApplicationName(saveApplicationRequestBody.getApplicationName());
			appEntity.setActiveFlag(saveApplicationRequestBody.isActive() ? 1 : 0);
			session.save(appEntity);
			applicationId = appEntity.getApplicationId();
		} else {
			List existingApplications = session.createCriteria(ApplicationDetailEntity.class).add(Restrictions.eq("applicationId",saveApplicationRequestBody.getApplicationId())).list();
			if (existingApplications.size() > 0) {
				ApplicationDetailEntity appEntity = (ApplicationDetailEntity)session.load(ApplicationDetailEntity.class, saveApplicationRequestBody.getApplicationId());
				appEntity.setApplicationName(saveApplicationRequestBody.getApplicationName());
				appEntity.setActiveFlag(saveApplicationRequestBody.isActive() ? 1 : 0);
				applicationId = saveApplicationRequestBody.getApplicationId();
				session.update(appEntity);
			} else {
				throw new NoRecordsFoundException("NO Records Found");
			}
		}
		tx.commit();
		session.close();
		return applicationId;
	}
	
	private void checkDuplicateApplication(
			SaveApplicationRequestBody saveApplicationRequestBody,
			Session session) throws DuplicateAreasException {
		@SuppressWarnings("unchecked")
		List<ApplicationDetailEntity> queryResult =  session.createQuery(IHibernateQueries.SELECT_APPLICATION_AREAS).setParameter("applicationName", saveApplicationRequestBody.getApplicationName()).list();
		 for (ApplicationDetailEntity applicationDetails : queryResult) {
			 if (applicationDetails.getApplicationName().equalsIgnoreCase(saveApplicationRequestBody.getApplicationName())) {
				 throw new DuplicateAreasException("Duplicate Categories");
			 }
		 }
		
	}

}

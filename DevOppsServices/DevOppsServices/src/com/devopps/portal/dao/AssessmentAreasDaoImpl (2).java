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
import com.devopps.portal.model.AssessmentEntity;
import com.devopps.portal.model.SaveAssessmentRequestBody;
import com.devopps.portal.util.IHibernateQueries;

@Component("IAssessmentAreasDao")
public class AssessmentAreasDaoImpl implements IAssessmentAreasDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AssessmentEntity> getAssessmentAreas() {
		Session session = getSessionFactory().openSession();
		List<AssessmentEntity> assessmentAreaDetails = session.createQuery("from AssessmentEntity").list();
		session.close();
		return assessmentAreaDetails;
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
	public void setAssessmentArea(SaveAssessmentRequestBody saveAssessmentRequestBody ) throws DuplicateAreasException, NoRecordsFoundException {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		 
		if(saveAssessmentRequestBody.getAssessmentId() != -1) {
			// Update Assessment Area
			AssessmentEntity assessmentEntity = (AssessmentEntity) session.load(AssessmentEntity.class, saveAssessmentRequestBody.getAssessmentId());
			List existingAssessment = session.createCriteria(AssessmentEntity.class).add(Restrictions.eq("assessmentId",saveAssessmentRequestBody.getAssessmentId())).list();
				if (existingAssessment.size() > 0) {
					assessmentEntity.setAssessmentAreaName(saveAssessmentRequestBody.getAssessmentName());
					assessmentEntity.setWeightage(saveAssessmentRequestBody.getWeightage());
					assessmentEntity.setActiveFlag(saveAssessmentRequestBody.isActive() ? 1 : 0);
					session.update(assessmentEntity);
				} else {
					throw new NoRecordsFoundException("NO Records Found");
				}
			
		} else {
			// Create Assessment Area
			chechDuplicateAssessmentArea(saveAssessmentRequestBody,session);
			AssessmentEntity assessmentEntity = new AssessmentEntity();
			assessmentEntity.setAssessmentAreaName(saveAssessmentRequestBody.getAssessmentName());
			assessmentEntity.setWeightage(saveAssessmentRequestBody.getWeightage());
			assessmentEntity.setActiveFlag(saveAssessmentRequestBody.isActive() ? 1 : 0);
			session.save(assessmentEntity);
		}
		tx.commit();
		session.close();
	}
	
	private void chechDuplicateAssessmentArea(SaveAssessmentRequestBody saveAssessmentRequestBody, Session session) throws DuplicateAreasException {
		@SuppressWarnings("unchecked")
		List<AssessmentEntity> queryResult =  session.createQuery(IHibernateQueries.SELECT_ASSESSMENT_AREAS).setParameter("assessmentAreaName", saveAssessmentRequestBody.getAssessmentName()).list();
		 for (AssessmentEntity assessmentDetails : queryResult) {
			 if (assessmentDetails.getAssessmentAreaName().equalsIgnoreCase(saveAssessmentRequestBody.getAssessmentName())) {
				 throw new DuplicateAreasException("Duplicate Assessment Areas");
			 }
		 }
	}
}
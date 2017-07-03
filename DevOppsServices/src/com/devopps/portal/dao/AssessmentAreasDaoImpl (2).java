package com.devopps.portal.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devopps.portal.exception.DuplicateAreasException;
import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.AssessmentApplicationDetails;
import com.devopps.portal.model.AssessmentApplicationEntity;
import com.devopps.portal.model.AssessmentEntity;
import com.devopps.portal.model.QuestionEntity;
import com.devopps.portal.model.SaveAssessmentRequestBody;
import com.devopps.portal.util.IHibernateQueries;

@Component("IAssessmentAreasDao")
public class AssessmentAreasDaoImpl implements IAssessmentAreasDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AssessmentApplicationDetails> getAssessmentAreas(Boolean isMappingRequired) {
		Session session = getSessionFactory().openSession();
		List<Object[]> assessmentInfo = null;
		final List<AssessmentApplicationDetails> assessmentAreaDetails = new ArrayList <AssessmentApplicationDetails>();
		AssessmentApplicationDetails assessmentApplicationInfo = null;
		int questionScoreCount = -1;
		if (isMappingRequired) {
		assessmentInfo = session.createQuery(IHibernateQueries.GET_ASSESSMENT_AREAS_INFO).list();
		int activeFlag = -1;
		for (Object[] assessmentArea : assessmentInfo) {
			assessmentApplicationInfo = new AssessmentApplicationDetails();
			assessmentApplicationInfo.setAssessmentId((Integer)assessmentArea[0]);
			assessmentApplicationInfo.setAssessmentAreaName((String)assessmentArea[1]);
			assessmentApplicationInfo.setWeightage((Integer)assessmentArea[2]);
			assessmentApplicationInfo.setApplicationId((Integer)assessmentArea[3]);
			assessmentApplicationInfo.setApplicationName((String)assessmentArea[4]);
			activeFlag = (Integer)assessmentArea[5];
			assessmentApplicationInfo.setActive(activeFlag == 1 ? true : false);
			assessmentAreaDetails.add(assessmentApplicationInfo);
		}} else {
			assessmentInfo = session.createQuery(IHibernateQueries.GET_ASSESSMENT_AREAS).list();
			int activeFlag = -1;
			for (Object[] assessmentArea : assessmentInfo) {
				assessmentApplicationInfo = new AssessmentApplicationDetails();
				assessmentApplicationInfo.setAssessmentId((Integer)assessmentArea[0]);
				assessmentApplicationInfo.setAssessmentAreaName((String)assessmentArea[1]);
				assessmentApplicationInfo.setWeightage((Integer)assessmentArea[2]);
				activeFlag = (Integer)assessmentArea[3];
				assessmentApplicationInfo.setActive(activeFlag == 1 ? true : false);
				questionScoreCount = session.createCriteria(QuestionEntity.class).add(Restrictions.eq("assessmentId",(Integer)assessmentArea[0])).list().size();
				assessmentApplicationInfo.setEditAllowed(questionScoreCount > 0 ? false : true);
				assessmentAreaDetails.add(assessmentApplicationInfo);
		}}
		if (assessmentAreaDetails.size() == 1) {
			assessmentApplicationInfo = new AssessmentApplicationDetails();
			assessmentApplicationInfo.setAssessmentId(-1);
			assessmentApplicationInfo.setAssessmentAreaName("");
			assessmentApplicationInfo.setWeightage(-1);
			assessmentApplicationInfo.setActive(false);
			assessmentAreaDetails.add(assessmentApplicationInfo);
		}
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
		boolean isAssessmentUpdated = false;
		if(saveAssessmentRequestBody.getAssessmentId() != -1) {
			// Update Assessment Area
			AssessmentEntity assessmentEntity = (AssessmentEntity) session.load(AssessmentEntity.class, saveAssessmentRequestBody.getAssessmentId());
			AssessmentApplicationEntity assessmentApplicationEntity = (AssessmentApplicationEntity)session.load(AssessmentApplicationEntity.class, saveAssessmentRequestBody.getAssessmentId());
			List existingAssessment = session.createCriteria(AssessmentEntity.class).add(Restrictions.eq("assessmentId",saveAssessmentRequestBody.getAssessmentId())).list();
				if (existingAssessment.size() > 0) {
					assessmentEntity.setAssessmentAreaName(saveAssessmentRequestBody.getAssessmentName());
					assessmentEntity.setWeightage(saveAssessmentRequestBody.getWeightage());
					assessmentEntity.setActiveFlag(saveAssessmentRequestBody.isActive() ? 1 : 0);
					assessmentApplicationEntity.setApplicationId(saveAssessmentRequestBody.getApplicationId());
					assessmentApplicationEntity.setActiveFlag(saveAssessmentRequestBody.isActive() ? 1 : 0);
					session.update(assessmentEntity);
					//session.update(assessmentApplicationEntity);
				} else {
					throw new NoRecordsFoundException("NO Records Found");
				}
			
		} else {
			// Create Assessment Area
			/*isAssessmentUpdated = createAssessmentApplicationMapping(saveAssessmentRequestBody,session);
			if (isAssessmentUpdated) {
				tx.commit();
				session.close();
				return;
			}*/
			AssessmentEntity assessmentEntity = new AssessmentEntity();
			AssessmentApplicationEntity assessmentApplicationEntity = new AssessmentApplicationEntity();
			assessmentEntity.setAssessmentAreaName(saveAssessmentRequestBody.getAssessmentName());
			assessmentEntity.setWeightage(saveAssessmentRequestBody.getWeightage());
			assessmentEntity.setActiveFlag(saveAssessmentRequestBody.isActive() ? 1 : 0);
			session.save(assessmentEntity);
			assessmentApplicationEntity.setAssessmentId(assessmentEntity.getAssessmentId());
			assessmentApplicationEntity.setApplicationId(saveAssessmentRequestBody.getApplicationId());
			assessmentApplicationEntity.setActiveFlag(saveAssessmentRequestBody.isActive() ? 1 : 0);
		//	session.save(assessmentApplicationEntity);
		}
		tx.commit();
		session.close();
	}
	
	private boolean createAssessmentApplicationMapping(SaveAssessmentRequestBody saveAssessmentRequestBody, Session session) throws DuplicateAreasException {
		@SuppressWarnings("unchecked")
		boolean isAssessmentUpdated = false;
		AssessmentApplicationEntity assessmentApplicationEntity = new AssessmentApplicationEntity();
		List<AssessmentEntity> queryResult =  session.createQuery(IHibernateQueries.SELECT_ASSESSMENT_AREAS).setParameter("assessmentAreaName", saveAssessmentRequestBody.getAssessmentName()).list();
		 for (AssessmentEntity assessmentDetails : queryResult) {
			 if (assessmentDetails.getAssessmentAreaName().equalsIgnoreCase(saveAssessmentRequestBody.getAssessmentName())) {
					assessmentApplicationEntity.setApplicationId(saveAssessmentRequestBody.getApplicationId());
					assessmentApplicationEntity.setAssessmentId(assessmentDetails.getAssessmentId());
					assessmentApplicationEntity.setActiveFlag(saveAssessmentRequestBody.isActive() ? 1 : 0);
					session.save(assessmentApplicationEntity);
					isAssessmentUpdated = true;
			 }
		 }
		 return isAssessmentUpdated;
	}
}
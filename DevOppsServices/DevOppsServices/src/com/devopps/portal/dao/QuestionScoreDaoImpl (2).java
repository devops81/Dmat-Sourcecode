package com.devopps.portal.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devopps.portal.exception.NoRecordsFoundException;
import com.devopps.portal.model.FeedbackFormDetails;
import com.devopps.portal.model.FeedbackFormEntity;
import com.devopps.portal.model.FeedbackFormRequest;
import com.devopps.portal.model.QuestionInputScore;
import com.devopps.portal.model.QuestionResponseDetails;
import com.devopps.portal.model.QuestionScoreEntity;
import com.devopps.portal.model.SaveQuestionScoreRequest;
import com.devopps.portal.model.ViewQuestionScoreRequestBody;
import com.devopps.portal.util.IConstants;
import com.devopps.portal.util.IHibernateQueries;

@Component("IQuestionScoreDao")
public class QuestionScoreDaoImpl implements IQuestionScoreDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<QuestionResponseDetails> getQuestionScoreResponse(ViewQuestionScoreRequestBody viewQuestionScoreRequestBody) {
		Session session = getSessionFactory().openSession();
		List<Object[]> questionInfo = null;
		if (viewQuestionScoreRequestBody.getApplicationId() != -1) {
			questionInfo = (List<Object[]>)session.createQuery(IHibernateQueries.FETCH_QUESTION_REPORT_APPL_ID).setParameter("applicationId", viewQuestionScoreRequestBody.getApplicationId()).list();
		} else {
			questionInfo = (List<Object[]>)session.createQuery(IHibernateQueries.FETCH_QUESTION_REPORT).list();
		}
		
		List<QuestionResponseDetails> questionReport = new ArrayList <QuestionResponseDetails>();
		for (Object[] question : questionInfo) {
			QuestionResponseDetails questionResponseDetails = new QuestionResponseDetails();
			questionResponseDetails.setID((Integer)question[0]);
			questionResponseDetails.setApplicationId((Integer)question[1]);
			questionResponseDetails.setApplicationName((String)question[2]);
			questionResponseDetails.setAssessmentId((Integer)question[3]);
			questionResponseDetails.setAssessmentArea((String)question[4]);
			questionResponseDetails.setCategoryId((Integer)question[5]);
			questionResponseDetails.setCategory((String)question[6]);
			questionResponseDetails.setSubCategoryId((Integer)question[7]);
			questionResponseDetails.setSubCategory((String)question[8]);
			questionResponseDetails.setAssessmentCriteria((String)question[9]);
			questionResponseDetails.setOptionOneVal((String)question[10]);
			questionResponseDetails.setOptionTwoVal((String)question[11]);
			questionResponseDetails.setOptionThreeVal((String)question[12]);
			questionResponseDetails.setOptionFourVal((String)question[13]);
			questionResponseDetails.setOptionFiveVal((String)question[14]);
			questionResponseDetails.setScoreAdmin((Integer)question[15]);
			questionResponseDetails.setScoreUser((Integer)question[16]);
			questionResponseDetails.setComments((String)question[17]);
			questionResponseDetails.setSubmittedBy((String)question[18]);
			questionReport.add(questionResponseDetails);
		}
		session.close();
		return questionReport;
		
		
	}
	

	@Override
	public void saveQuestionScore(SaveQuestionScoreRequest questionScoreRequest) {

		Session session = getSessionFactory().openSession();
		List<QuestionInputScore> questionScoreData = questionScoreRequest.getQuestionScoreInfo();
		String userType = questionScoreRequest.getUserType();
		for (QuestionInputScore questionInputScore : questionScoreData) {
		Transaction tx = session.beginTransaction();
		QuestionScoreEntity questionScoreEntity = (QuestionScoreEntity)session.load(QuestionScoreEntity.class, questionInputScore.getQuestionId());
		List existingScores = session.createCriteria(QuestionScoreEntity.class).add(Restrictions.eq("questionId",questionInputScore.getQuestionId())).list();
		if (existingScores.size() < 1) {
			questionScoreEntity = new QuestionScoreEntity();
			questionScoreEntity.setQuestionId(questionInputScore.getQuestionId());
			setScores(questionScoreEntity, questionInputScore, userType);
			questionScoreEntity.setComments(questionInputScore.getComments());
			session.save(questionScoreEntity);
		} else {
			setScores(questionScoreEntity, questionInputScore, userType);
			questionScoreEntity.setComments(questionInputScore.getComments());
			session.update(questionScoreEntity);
		}
		tx.commit();
		}
		session.close();
	}
	
	private void setScores(QuestionScoreEntity questionScoreEntity, QuestionInputScore questionInputScore, String userType) {
		if (userType.equalsIgnoreCase(IConstants.type_assessor)) {
			questionScoreEntity.setScoreUser(questionInputScore.getScore());
		}
		if (userType.equalsIgnoreCase(IConstants.type_lead_assessor)) {
			questionScoreEntity.setScoreAdmin(questionInputScore.getScore());
		}
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
	public int  saveFreeFormFeedback(FeedbackFormRequest feedbackFormRequest) throws NoRecordsFoundException {
		
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		int feedbackId = -1;
		if (feedbackFormRequest.getFeedbackId() == -1) {
				FeedbackFormEntity feedbackEntity = new FeedbackFormEntity();
				feedbackEntity.setAccountId(feedbackFormRequest.getAccountId());
				feedbackEntity.setApplicationId(feedbackFormRequest.getApplicationId());
				feedbackEntity.setEmployeeId(feedbackFormRequest.getEmployeeId());
				feedbackEntity.setFeedback(feedbackFormRequest.getFeedback());
				feedbackEntity.setFilePath(feedbackFormRequest.getFilePath());
				session.save(feedbackEntity);
				feedbackId = feedbackEntity.getFeedbackId();
		} else {
			List existingFeedback = session.createCriteria(FeedbackFormEntity.class).add(Restrictions.eq("feedbackId",feedbackFormRequest.getFeedbackId())).list();
			if (existingFeedback.size() > 0) {
				FeedbackFormEntity feedbackEntity = (FeedbackFormEntity) session.load(FeedbackFormEntity.class, feedbackFormRequest.getFeedbackId());
				feedbackEntity.setAccountId(feedbackFormRequest.getAccountId());
				feedbackEntity.setApplicationId(feedbackFormRequest.getApplicationId());
				feedbackEntity.setEmployeeId(feedbackFormRequest.getEmployeeId());
				feedbackEntity.setFeedback(feedbackFormRequest.getFeedback());
				feedbackEntity.setFilePath(feedbackFormRequest.getFilePath());
				feedbackId = feedbackFormRequest.getFeedbackId();
				session.update(feedbackEntity); 
				} else {
					throw new NoRecordsFoundException("NO Records Found");
				}
				
		}
		tx.commit();
		session.close();
		return feedbackId;
	}


	@Override
	public List<FeedbackFormDetails> viewFreeFormFeedback(
			FeedbackFormRequest feedbackFormRequest) {
		Session session = getSessionFactory().openSession();
		List<Object[]> feedbackFormInfo = null;
		feedbackFormInfo = (List<Object[]>)session.createQuery(IHibernateQueries.FETCH_FEEDBACK_FORM_INFO).list();
		final List<FeedbackFormDetails> feedbackDetails = new ArrayList <FeedbackFormDetails>();
		for (Object[] feedbackData : feedbackFormInfo) {
			FeedbackFormDetails feedbackFormDetails = new FeedbackFormDetails();
			feedbackFormDetails.setFeedbackId((Integer)feedbackData[0]);
			feedbackFormDetails.setApplicationName((String)feedbackData[1]);
			feedbackFormDetails.setEmployeeId((Integer)feedbackData[2]);
			feedbackFormDetails.setAccountName((String)feedbackData[3]);
			feedbackFormDetails.setRoleName((String)feedbackData[4]);
			feedbackFormDetails.setFeedback((String)feedbackData[5]);
			feedbackFormDetails.setFilePath((String)feedbackData[6]);
			feedbackDetails.add(feedbackFormDetails);
		}
		session.close();
		return feedbackDetails;
		}
}	

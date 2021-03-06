package com.devopps.portal.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.LongToIntFunction;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
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
	
	
	@SuppressWarnings("unchecked")
	//@OneToOne(fetch=FetchType.EAGER)
	@Override
	public List<QuestionResponseDetails> getQuestionScoreResponse(ViewQuestionScoreRequestBody viewQuestionScoreRequestBody) throws IllegalArgumentException, IllegalAccessException {
		Session session = getSessionFactory().openSession();
//		Transaction tx = session.beginTransaction();
		int count=0;
		QuestionResponseDetails questionResponseDetails = null;
		List<Object[]> questionInfo = null;
		Query sqlQuery = null;
		if (viewQuestionScoreRequestBody.getApplicationId() != -1) {
			sqlQuery = session.createSQLQuery(IHibernateQueries.FETCH_QUESTION_REPORT_APPL_ID)
					 .addScalar("ID",StandardBasicTypes.INTEGER)
					.addScalar("questionId",StandardBasicTypes.INTEGER)
					.addScalar("application_Id",StandardBasicTypes.INTEGER)
					.addScalar("application_Name",StandardBasicTypes.STRING)
					.addScalar("assessment_Id",StandardBasicTypes.INTEGER)
					.addScalar("assessment_Name",StandardBasicTypes.STRING)
					.addScalar("category_id",StandardBasicTypes.INTEGER)
					.addScalar("category_Name",StandardBasicTypes.STRING)
					.addScalar("subCategory_Id",StandardBasicTypes.INTEGER)
					.addScalar("subCategory_Name",StandardBasicTypes.STRING)
					.addScalar("question_description",StandardBasicTypes.STRING)
					.addScalar("option1Val",StandardBasicTypes.STRING)
					.addScalar("option2Val",StandardBasicTypes.STRING)
					.addScalar("option3Val",StandardBasicTypes.STRING)
					.addScalar("option4Val",StandardBasicTypes.STRING)
					.addScalar("option5Val",StandardBasicTypes.STRING)
					.addScalar("score_admin",StandardBasicTypes.INTEGER)
					.addScalar("score_user",StandardBasicTypes.INTEGER)
					.addScalar("comments",StandardBasicTypes.STRING)
					.addScalar("submitted_By",StandardBasicTypes.STRING)
					.addScalar("report_id",StandardBasicTypes.INTEGER)
					.addScalar("business_unit_id",StandardBasicTypes.INTEGER)
					.addScalar("business_unit_name",StandardBasicTypes.STRING)
					.addScalar("account_id",StandardBasicTypes.INTEGER)
					.addScalar("account_name",StandardBasicTypes.STRING)
					.setInteger(0,  viewQuestionScoreRequestBody.getQuestionnaireType())
					.setInteger(1,  viewQuestionScoreRequestBody.getApplicationId());
					
			questionInfo = (List<Object[]>)sqlQuery.list();
		}  else {
			 sqlQuery  = session.createSQLQuery(IHibernateQueries.FETCH_QUESTION_REPORT)
					 .addScalar("ID",StandardBasicTypes.INTEGER)
					.addScalar("questionId",StandardBasicTypes.INTEGER)
					.addScalar("application_Id",StandardBasicTypes.INTEGER)
					.addScalar("application_Name",StandardBasicTypes.STRING)
					.addScalar("assessment_Id",StandardBasicTypes.INTEGER)
					.addScalar("assessment_Name",StandardBasicTypes.STRING)
					.addScalar("category_id",StandardBasicTypes.INTEGER)
					.addScalar("category_Name",StandardBasicTypes.STRING)
					.addScalar("subCategory_Id",StandardBasicTypes.INTEGER)
					.addScalar("subCategory_Name",StandardBasicTypes.STRING)
					.addScalar("question_description",StandardBasicTypes.STRING)
					.addScalar("option1Val",StandardBasicTypes.STRING)
					.addScalar("option2Val",StandardBasicTypes.STRING)
					.addScalar("option3Val",StandardBasicTypes.STRING)
					.addScalar("option4Val",StandardBasicTypes.STRING)
					.addScalar("option5Val",StandardBasicTypes.STRING)
					.addScalar("score_admin",StandardBasicTypes.INTEGER)
					.addScalar("score_user",StandardBasicTypes.INTEGER)
					.addScalar("comments",StandardBasicTypes.STRING)
					.addScalar("submitted_By",StandardBasicTypes.STRING)
					.addScalar("report_id",StandardBasicTypes.INTEGER)
					.addScalar("business_unit_id",StandardBasicTypes.INTEGER)
					.addScalar("business_unit_name",StandardBasicTypes.STRING)
					.addScalar("account_id",StandardBasicTypes.INTEGER)
					.addScalar("account_name",StandardBasicTypes.STRING);
			 System.err.println(":: Time Before Executing Query :: "+System.currentTimeMillis());
			 questionInfo = (List<Object[]>)sqlQuery.list();
		}
		     System.err.println(" :: Time After Executing Query :: "+System.currentTimeMillis());
		int countQuestions=0;
		List<QuestionResponseDetails> questionReport = new ArrayList <QuestionResponseDetails>();
		int tempQuestionInfoSize= questionInfo.size();
		while (count<tempQuestionInfoSize) {
			Object[] question=questionInfo.get(count);
			questionResponseDetails = new QuestionResponseDetails();
			List<Field> fields = new ArrayList<Field>();
		    fields.addAll(Arrays.asList(questionResponseDetails.getClass().getDeclaredFields()));
			countQuestions=0;
			int tempFieldSize = fields.size();
		    while(countQuestions<tempFieldSize){
		    	Field field=fields.get(countQuestions);
		    	if(question[countQuestions] instanceof Integer){
		    		field.setAccessible(true);
		    		field.set(questionResponseDetails, ((Integer)question[countQuestions] == null ? -1 : (Integer)question[countQuestions]));
		    		countQuestions++;
		    	}else if(question[countQuestions] instanceof String){
		    		field.setAccessible(true);
		    		field.set(questionResponseDetails, ((String)question[countQuestions]));
		    		countQuestions++;
		    	}
		    	else{
		    		countQuestions++;
		    	}
	        }
//			questionResponseDetails.setID((Integer)question[0] == null ? -1 : (Integer)question[0]);
//			questionResponseDetails.setQuestionId((Integer)question[1]);
//			questionResponseDetails.setApplicationId((Integer)question[2] == null ? -1 : (Integer)question[2] );
//			questionResponseDetails.setApplicationName((String)question[3]);
//			questionResponseDetails.setAssessmentId((Integer)question[4] == null ? -1 : (Integer)question[4]);
//			questionResponseDetails.setAssessmentArea((String)question[5]);
//			questionResponseDetails.setCategoryId((Integer)question[6] == null ? -1 : (Integer)question[6]);
//			questionResponseDetails.setCategory((String)question[7]);
//			questionResponseDetails.setSubCategoryId((Integer)question[8] == null ? -1 : (Integer)question[8]);
//			questionResponseDetails.setSubCategory((String)question[9]);
//			questionResponseDetails.setAssessmentCriteria((String)question[10]);
//			questionResponseDetails.setOptionOneVal((String)question[11]);
//			questionResponseDetails.setOptionTwoVal((String)question[12]);
//			questionResponseDetails.setOptionThreeVal((String)question[13]);
//			questionResponseDetails.setOptionFourVal((String)question[14]);
//			questionResponseDetails.setOptionFiveVal((String)question[15]);
//			questionResponseDetails.setScoreAdmin((Integer)question[16] == null ? 0: (Integer)question[16] );
//			questionResponseDetails.setScoreUser((Integer)question[17] == null ? 0: (Integer)question[17] );
//			questionResponseDetails.setComments((String)question[18]);
//			questionResponseDetails.setSubmittedBy((String)question[19]);
//			questionResponseDetails.setReportId((Integer)question[20] == null ? -1 : (Integer)question[20]);
//			questionResponseDetails.setBusinessUnitId((Integer)question[21] == null ? -1 : (Integer)question[21]);
//			questionResponseDetails.setBusinessUnitName((String)question[22]);
//			questionResponseDetails.setAccountId((Integer)question[23] == null ? -1 : (Integer)question[23]);
//			questionResponseDetails.setAccountName((String)question[24]);
			questionReport.add(questionResponseDetails);
			count++;
			//break;
		}
		int tempReportCount = questionReport.size();
		if (tempReportCount == 1) {
			questionResponseDetails = new QuestionResponseDetails();
			questionResponseDetails.setID(-1);
			questionResponseDetails.setQuestionId(-1);
			questionResponseDetails.setApplicationId(-1);
			questionResponseDetails.setApplicationName("");
			questionResponseDetails.setAssessmentId(-1);
			questionResponseDetails.setAssessmentArea("");
			questionResponseDetails.setCategoryId(-1);
			questionResponseDetails.setCategory("");
			questionResponseDetails.setSubCategoryId(-1);
			questionResponseDetails.setSubCategory("");
			questionResponseDetails.setAssessmentCriteria("");
			questionResponseDetails.setOptionOneVal("");
			questionResponseDetails.setOptionTwoVal("");
			questionResponseDetails.setOptionThreeVal("");
			questionResponseDetails.setOptionFourVal("");
			questionResponseDetails.setOptionFiveVal("");
			questionResponseDetails.setScoreAdmin(-1 );
			questionResponseDetails.setScoreUser(-1);
			questionResponseDetails.setComments("");
			questionResponseDetails.setSubmittedBy("");
			questionResponseDetails.setReportId(-1);
			questionResponseDetails.setBusinessUnitId(-1);
			questionResponseDetails.setBusinessUnitName("");
			questionResponseDetails.setAccountId(-1);
			questionResponseDetails.setAccountName("");
			questionReport.add(questionResponseDetails);
		}
		System.out.println("Before commit-->"+System.currentTimeMillis());
//		tx.commit();
		System.out.println("After commit-->"+System.currentTimeMillis());
		session.close();
		System.out.println("After session close-->"+System.currentTimeMillis());
		
		return questionReport;
		
		
	}
	

	@Override
	public void saveQuestionScore(SaveQuestionScoreRequest questionScoreRequest) {

		Session session = getSessionFactory().openSession();
		List<QuestionInputScore> questionScoreData = questionScoreRequest.getQuestionScoreInfo();
		String userType = questionScoreRequest.getUserType();
		for (QuestionInputScore questionInputScore : questionScoreData) {
		Transaction tx = session.beginTransaction();
		QuestionScoreEntity questionScoreEntity = (QuestionScoreEntity)session.load(QuestionScoreEntity.class, questionInputScore.getId());
		List existingScores = session.createCriteria(QuestionScoreEntity.class).add(Restrictions.eq("applicationId",questionInputScore.getApplicationId()))
				.add(Restrictions.eq("questionId",questionInputScore.getQuestionId()))
				.list();
		if (existingScores.size() < 1) {
			questionScoreEntity = new QuestionScoreEntity();
			questionScoreEntity.setQuestionId(questionInputScore.getQuestionId());
			questionScoreEntity.setApplicationId(questionInputScore.getApplicationId());
			setScores(questionScoreEntity, questionInputScore, userType);
			questionScoreEntity.setComments(questionInputScore.getComments()  == null ? "":questionInputScore.getComments());
			questionScoreEntity.setSubmittedBy("Allen");
			session.save(questionScoreEntity);
		} else {
			setScores(questionScoreEntity, questionInputScore, userType);
			questionScoreEntity.setComments(questionInputScore.getComments() == null ? "":questionInputScore.getComments());
			questionScoreEntity.setSubmittedBy("Allen");
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

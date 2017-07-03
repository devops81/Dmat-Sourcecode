package com.devopps.portal.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devopps.portal.model.QuestionDetails;
import com.devopps.portal.model.QuestionEntity;
import com.devopps.portal.model.QuestionIndicatorValuesEntity;
import com.devopps.portal.model.QuestionScoreEntity;
import com.devopps.portal.model.SaveQuestionRequestBody;
import com.devopps.portal.util.IHibernateQueries;

@Component("IQuestionDao")
public class QuestionDaoImpl implements IQuestionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveQuestion(SaveQuestionRequestBody saveQuestionRequestBody){
		
		QuestionEntity questionEntity = null;
		QuestionIndicatorValuesEntity indicatorValues = null;
		QuestionScoreEntity questionScoreEntity = null;
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		if (saveQuestionRequestBody.getQuestionId() == -1 ) {
			questionEntity = new QuestionEntity();
			indicatorValues = new QuestionIndicatorValuesEntity();
			questionScoreEntity = new QuestionScoreEntity();
			questionEntity.setAssessmentId(saveQuestionRequestBody.getAssessmentId());
			questionEntity.setCategoryId(saveQuestionRequestBody.getCategoryId());
			questionEntity.setSubcategoryId(saveQuestionRequestBody.getSubCategoryId());
			questionEntity.setQuestionText(saveQuestionRequestBody.getQuestionText());
			questionEntity.setIsActive(saveQuestionRequestBody.isActive() ? 1 : 0 );
			questionEntity.setApplicationId(1);
			questionEntity.setReportId(1);
			session.save(questionEntity);
			indicatorValues.setQuestionId(questionEntity.getQuestionId());
			indicatorValues.setOptionOneVal(saveQuestionRequestBody.getOptionOne());
			indicatorValues.setOptionTwoVal(saveQuestionRequestBody.getOptionTwo());
			indicatorValues.setOptionThreeVal(saveQuestionRequestBody.getOptionThree());
			indicatorValues.setOptionFourVal(saveQuestionRequestBody.getOptionFour());
			indicatorValues.setOptionFiveVal(saveQuestionRequestBody.getOptionFive());
			session.save(indicatorValues);
			questionScoreEntity.setQuestionId(questionEntity.getQuestionId());
			questionScoreEntity.setScoreAdmin(0);
			questionScoreEntity.setScoreUser(0);
			questionScoreEntity.setComments("");
			questionScoreEntity.setSubmittedBy("Allen D");
			session.save(questionScoreEntity);
		} else {
			questionEntity = (QuestionEntity)session.load(QuestionEntity.class,saveQuestionRequestBody.getQuestionId());
			indicatorValues = (QuestionIndicatorValuesEntity)session.load(QuestionIndicatorValuesEntity.class, saveQuestionRequestBody.getQuestionId());
			questionScoreEntity = (QuestionScoreEntity)session.load(QuestionScoreEntity.class, saveQuestionRequestBody.getQuestionId());
			questionEntity.setAssessmentId(saveQuestionRequestBody.getAssessmentId());
			questionEntity.setCategoryId(saveQuestionRequestBody.getCategoryId());
			questionEntity.setSubcategoryId(saveQuestionRequestBody.getSubCategoryId());
			questionEntity.setQuestionId(saveQuestionRequestBody.getQuestionId());
			questionEntity.setQuestionText(saveQuestionRequestBody.getQuestionText());
			questionEntity.setIsActive(saveQuestionRequestBody.isActive() ? 1 : 0 );
			questionEntity.setApplicationId(1);
			questionEntity.setReportId(1);
			indicatorValues.setQuestionId(questionEntity.getQuestionId());
			indicatorValues.setOptionOneVal(saveQuestionRequestBody.getOptionOne());
			indicatorValues.setOptionTwoVal(saveQuestionRequestBody.getOptionTwo());
			indicatorValues.setOptionThreeVal(saveQuestionRequestBody.getOptionThree());
			indicatorValues.setOptionFourVal(saveQuestionRequestBody.getOptionFour());
			indicatorValues.setOptionFiveVal(saveQuestionRequestBody.getOptionFive());
			questionScoreEntity.setQuestionId(questionEntity.getQuestionId());
			questionScoreEntity.setScoreAdmin(0);
			questionScoreEntity.setScoreUser(0);
			questionScoreEntity.setComments("");
			questionScoreEntity.setSubmittedBy("Allen D");
			session.update(questionEntity);
			session.update(indicatorValues);
			session.update(questionScoreEntity);
		}
	
		tx.commit();
		session.close();
		return questionEntity.getQuestionId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionDetails> getQuestionDetails() {
		Session session = getSessionFactory().openSession();
		List<Object[]> questionInfo = null;
		questionInfo = (List<Object[]>)session.createQuery(IHibernateQueries.FETCH_QUESTION_DATA).list();
		
		List<QuestionDetails> questionData = new ArrayList <QuestionDetails>();
		for (Object[] question : questionInfo) {
			QuestionDetails questionDetails = new QuestionDetails();
			questionDetails.setQuestionId((Integer)question[0]);
			questionDetails.setAssessmentId((Integer)question[1]);
			questionDetails.setAssessmentArea((String)question[2]);
			questionDetails.setCategoryId((Integer)question[3]);
			questionDetails.setCategory((String)question[4]);
			questionDetails.setSubcategoryId((Integer)question[5]);
			questionDetails.setSubCategory((String)question[6]);
			questionDetails.setQuestionName((String)question[7]);
			questionDetails.setOptionOneVal((String)question[8]);
			questionDetails.setOptionTwoVal((String)question[9]);
			questionDetails.setOptionThreeVal((String)question[10]);
			questionDetails.setOptionFourVal((String)question[11]);
			questionDetails.setOptionFiveVal((String)question[12]);
			questionDetails.setActive((Integer)question[13] == 1 ? true : false);
			questionData.add(questionDetails);
		}
		session.close();
		return questionData;
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
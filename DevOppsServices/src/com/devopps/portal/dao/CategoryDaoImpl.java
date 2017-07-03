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
import com.devopps.portal.model.AssessmentCategoryDetails;
import com.devopps.portal.model.AssessmentCategoryEntity;
import com.devopps.portal.model.CategoryEntity;
import com.devopps.portal.model.QuestionEntity;
import com.devopps.portal.model.SaveCategoriesRequestBody;
import com.devopps.portal.util.IHibernateQueries;

@Component("ICategoriesDao")
public class CategoryDaoImpl implements ICategoryDao {

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AssessmentCategoryDetails> getCategories(int assessmentId, int questionnaireType) {
		Session session = getSessionFactory().openSession();
		List<Object[]> categoryInfo = null;
		int questionScoreCount = -1;
		if (assessmentId == 0) {
			System.out.println(questionnaireType);
				//categoryInfo = (List<Object[]>)session.createQuery(IHibernateQueries.FETCH_CATEGORIES).setMaxResults(35).list();
			categoryInfo = (List<Object[]>)session.createQuery(IHibernateQueries.FETCH_CATEGORIES).setParameter("questionnaireType",questionnaireType ).list();
			System.out.println("hello");
			System.out.println(categoryInfo);
		} else {
			 	categoryInfo = (List<Object[]>)session.createQuery(IHibernateQueries.FETCH_CATEGORIES_FILTERED).setParameter("assessmentId",assessmentId ).setParameter("questionnaireType",questionnaireType ).list();
		}
		final List<AssessmentCategoryDetails> categoryDetails = new ArrayList <AssessmentCategoryDetails>();
		AssessmentCategoryDetails assessmentCategoryInfo  = null;
		int activeFlag = -1;
		for (Object[] category : categoryInfo) {
			assessmentCategoryInfo = new AssessmentCategoryDetails();
			assessmentCategoryInfo.setAssessmentId((Integer)category[0]);
			assessmentCategoryInfo.setAssessmentAreaName((String)category[1]);
			assessmentCategoryInfo.setCategoryId((Integer)category[2]);
			assessmentCategoryInfo.setCategoryName((String)category[3]);
			assessmentCategoryInfo.setWeightage((Integer)category[4]);
			activeFlag = (Integer)category[5];
			assessmentCategoryInfo.setActive(activeFlag == 1 ? true : false);
			questionScoreCount = session.createCriteria(QuestionEntity.class).add(Restrictions.eq("assessmentId",(Integer)category[0]))
					.add(Restrictions.eq("categoryId",(Integer)category[2]))
					.list().size();
			assessmentCategoryInfo.setEditAllowed(questionScoreCount > 0 ? false : true);
			categoryDetails.add(assessmentCategoryInfo);
		}
		if (categoryDetails.size() == 1) {
			assessmentCategoryInfo = new AssessmentCategoryDetails();
			assessmentCategoryInfo.setAssessmentId(-1);
			assessmentCategoryInfo.setAssessmentAreaName("");
			assessmentCategoryInfo.setCategoryId(-1);
			assessmentCategoryInfo.setCategoryName("");
			assessmentCategoryInfo.setWeightage(-1);
			assessmentCategoryInfo.setActive(false);
			categoryDetails.add(assessmentCategoryInfo);
		}
		session.close();
		return categoryDetails;
		
	}
	
	
	@Override
	public int saveCategory(SaveCategoriesRequestBody saveCategoryRequestBody) throws DuplicateAreasException, NoRecordsFoundException{
		
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		int categoryId = -1;
		if(saveCategoryRequestBody.getCategoryId()!= -1) {
			
			List existingCategories = session.createCriteria(CategoryEntity.class).add(Restrictions.eq("categoryId",saveCategoryRequestBody.getCategoryId())).list();
			if (existingCategories.size() > 0) {
	
				// Update Category Table
				CategoryEntity categoryEntity = (CategoryEntity) session.load(CategoryEntity.class, saveCategoryRequestBody.getCategoryId());
				categoryEntity.setCategoryName(saveCategoryRequestBody.getCategoryName());
				categoryEntity.setActiveFlag(saveCategoryRequestBody.isActive() ? 1 : 0);
				categoryEntity.setCategoryWeightage(saveCategoryRequestBody.getWeightage());
				categoryEntity.setQuestionnaireTypeId(saveCategoryRequestBody.getQuestionnaireType());
				categoryId = saveCategoryRequestBody.getCategoryId();
				session.update(categoryEntity);
				
				// Update Category-Assessment Mapping
				AssessmentCategoryEntity assessmentCategoryEntity = (AssessmentCategoryEntity) session.load(AssessmentCategoryEntity.class, saveCategoryRequestBody.getCategoryId());
				assessmentCategoryEntity.setCategoryId(saveCategoryRequestBody.getCategoryId());
				assessmentCategoryEntity.setAssessmentId(saveCategoryRequestBody.getAssessmentId());
				assessmentCategoryEntity.setCategoryWeightage(saveCategoryRequestBody.getWeightage());
				session.update(assessmentCategoryEntity);
			} else {
				throw new NoRecordsFoundException("NO Records Found");
			}
		} else {
			// Create Category 
			checkDuplicateCategories(saveCategoryRequestBody, session);
			CategoryEntity categoryEntity = new CategoryEntity();
			categoryEntity.setCategoryName(saveCategoryRequestBody.getCategoryName());
			categoryEntity.setCategoryWeightage(saveCategoryRequestBody.getWeightage());
			categoryEntity.setActiveFlag(saveCategoryRequestBody.isActive() ? 1 : 0);
			categoryEntity.setQuestionnaireTypeId(saveCategoryRequestBody.getQuestionnaireType());
			session.save(categoryEntity);
			
			// Create Category-Assessment Mapping
			AssessmentCategoryEntity assessmentCategoryEntity = new AssessmentCategoryEntity();
			assessmentCategoryEntity.setCategoryId(categoryEntity.getCategoryId());
			assessmentCategoryEntity.setAssessmentId(saveCategoryRequestBody.getAssessmentId());
			assessmentCategoryEntity.setCategoryWeightage(saveCategoryRequestBody.getWeightage());
			categoryId = categoryEntity.getCategoryId();
			session.save(assessmentCategoryEntity);
		}
		tx.commit();
		session.close();
		return categoryId;
	}
	
	private void checkDuplicateCategories(SaveCategoriesRequestBody saveCategoryRequestBody, Session session) throws DuplicateAreasException {
		@SuppressWarnings("unchecked")
		List<CategoryEntity> queryResult =  session.createQuery(IHibernateQueries.SELECT_CATEGORIES).setParameter("categoryName", saveCategoryRequestBody.getCategoryName()).list();
		 for (CategoryEntity categoryDetails : queryResult) {
			 if (categoryDetails.getCategoryName().equalsIgnoreCase(saveCategoryRequestBody.getCategoryName())) {
				 throw new DuplicateAreasException("Duplicate Categories");
			 }
		 }
	}
	
}

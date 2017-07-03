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
import com.devopps.portal.model.AssessmentEntity;
import com.devopps.portal.model.CategoryEntity;
import com.devopps.portal.model.CategorySubCategoryDetails;
import com.devopps.portal.model.CategorySubCategoryEntity;
import com.devopps.portal.model.SaveCategoriesRequestBody;
import com.devopps.portal.model.SaveSubCategoriesRequest;
import com.devopps.portal.model.SubCategoryEntity;
import com.devopps.portal.util.IHibernateQueries;

@Component("ISubCategoryDao")
public class SubCategoryDaoImpl implements ISubCategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CategorySubCategoryDetails> getSubCategories(int categoryId) {
		Session session = getSessionFactory().openSession();
		List<Object[]> subCategoryInfo = null;
		if (categoryId == 0) {
			subCategoryInfo = (List<Object[]>)session.createQuery(IHibernateQueries.FETCH_SUB_CATEGORIES).list();
		} else {
			subCategoryInfo = (List<Object[]>)session.createQuery(IHibernateQueries.FETCH_SUB_CATEGORIES_FILTERED).setParameter("categoryId", categoryId).list();
		}
		final List<CategorySubCategoryDetails> subCategoryDetails = new ArrayList <CategorySubCategoryDetails>();
		int activeFlag = -1;
		for (Object[] subCategory : subCategoryInfo) {
			CategorySubCategoryDetails categorySubCategoryInfo = new CategorySubCategoryDetails();
			categorySubCategoryInfo.setCategoryId((Integer)subCategory[0]);
			categorySubCategoryInfo.setCategoryName((String)subCategory[1]);
			categorySubCategoryInfo.setSubcategoryId((Integer)subCategory[2]);
			categorySubCategoryInfo.setSubCategoryName((String)subCategory[3]);
			categorySubCategoryInfo.setWeightage((Integer)subCategory[4]);
			activeFlag = (Integer)subCategory[5];
			categorySubCategoryInfo.setActive(activeFlag == 1 ? true : false);
			subCategoryDetails.add(categorySubCategoryInfo);
		}
		session.close();
		return subCategoryDetails;
		
	}
	
	@Override
	public int saveSubCategory(SaveSubCategoriesRequest saveSubCategoriesRequest) throws DuplicateAreasException, NoRecordsFoundException {
		
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		int subCategoryId = -1;
		if(saveSubCategoriesRequest.getSubCategoryId() != -1){
			
			List existingSubCategories = session.createCriteria(SubCategoryEntity.class).add(Restrictions.eq("subCategoryId",saveSubCategoriesRequest.getSubCategoryId())).list();
			if (existingSubCategories.size() > 0) {
			// Update Sub Category Table
			SubCategoryEntity subCategoryEntity = (SubCategoryEntity) session.load(SubCategoryEntity.class, saveSubCategoriesRequest.getSubCategoryId());
			subCategoryEntity.setSubCategoryName(saveSubCategoriesRequest.getSubCategoryName());
			subCategoryEntity.setActiveFlag(saveSubCategoriesRequest.isActive() ? 1 : 0);
			subCategoryEntity.setSubCategoryWeightage(saveSubCategoriesRequest.getWeightage());
			subCategoryId = saveSubCategoriesRequest.getSubCategoryId();
			session.update(subCategoryEntity);
			
			// Update SubCategory-Category Mapping
			CategorySubCategoryEntity categorySubCategoryEntity = (CategorySubCategoryEntity) session.load(CategorySubCategoryEntity.class, saveSubCategoriesRequest.getSubCategoryId());
			categorySubCategoryEntity.setSubCategoryId(saveSubCategoriesRequest.getSubCategoryId());
			categorySubCategoryEntity.setCategoryId(saveSubCategoriesRequest.getCategoryId());
			session.update(categorySubCategoryEntity);
			} else {
				throw new NoRecordsFoundException("NO Records Found");
			}
			
		}else{
			// Create Category 
			checkDuplicateSubCategories(saveSubCategoriesRequest, session);
			SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
			subCategoryEntity.setSubCategoryName(saveSubCategoriesRequest.getSubCategoryName());
			subCategoryEntity.setActiveFlag(saveSubCategoriesRequest.isActive() ? 1 : 0);
			subCategoryEntity.setSubCategoryWeightage(saveSubCategoriesRequest.getWeightage());
			session.save(subCategoryEntity);
			
			// Create SubCategory-Category Mapping
			CategorySubCategoryEntity categorySubCategoryEntity =  new CategorySubCategoryEntity();
			categorySubCategoryEntity.setSubCategoryId( subCategoryEntity.getSubCategoryId());
			categorySubCategoryEntity.setCategoryId(saveSubCategoriesRequest.getCategoryId());
			subCategoryId = subCategoryEntity.getSubCategoryId();
			session.save(categorySubCategoryEntity);
		}
		tx.commit();
		session.close();
		return subCategoryId;
	}
	
	
	private void checkDuplicateSubCategories(SaveSubCategoriesRequest saveSubCategoriesRequest, Session session) throws DuplicateAreasException {
		@SuppressWarnings("unchecked")
		List<SubCategoryEntity> queryResult =  session.createQuery(IHibernateQueries.SELECT_SUB_CATEGORIES).setParameter("subCategoryName", saveSubCategoriesRequest.getSubCategoryName()).list();
		 for (SubCategoryEntity subCategoryDetails : queryResult) {
			 if (subCategoryDetails.getSubCategoryName().equalsIgnoreCase(saveSubCategoriesRequest.getSubCategoryName())) {
				 throw new DuplicateAreasException("Duplicate Categories");
			 }
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
	
	

}

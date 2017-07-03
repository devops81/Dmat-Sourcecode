package com.devopps.portal.util;

public interface IHibernateQueries {
	
	public static final String FETCH_CATEGORIES = "select a.assessmentId, b.assessmentAreaName, a.categoryId , c.categoryName, c.categoryWeightage, c.activeFlag from  " +
												   "AssessmentCategoryEntity a , AssessmentEntity b, CategoryEntity c " +
												   "where a.assessmentId = b.assessmentId and a.categoryId = c.categoryId";

	public static final String FETCH_CATEGORIES_FILTERED = "select a.assessmentId, b.assessmentAreaName, a.categoryId , c.categoryName , c.categoryWeightage, c.activeFlag  from " +
	   "AssessmentCategoryEntity a , AssessmentEntity b, CategoryEntity c " +
	   "where a.assessmentId = b.assessmentId and a.categoryId = c.categoryId and b.assessmentId = :assessmentId";
	
	public static final String FETCH_SUB_CATEGORIES = "select c.categoryId, a.categoryName, c.subCategoryId , b.subCategoryName, b.subCategoryWeightage, b.activeFlag from  " +
	   "CategoryEntity a , SubCategoryEntity b, CategorySubCategoryEntity c " +
	   "where a.categoryId = c.categoryId and b.subCategoryId = c.subCategoryId";
	
	public static final String FETCH_SUB_CATEGORIES_FILTERED = "select c.categoryId, a.categoryName, c.subCategoryId ,b.subCategoryName, b.subCategoryWeightage, b.activeFlag from  " +
	   "CategoryEntity a , SubCategoryEntity b, CategorySubCategoryEntity c " +
	   "where a.categoryId = c.categoryId and b.subCategoryId = c.subCategoryId and a.categoryId = :categoryId";
	
	
	public static final String FETCH_USER_PROFILES = "select u.id, u.name, u.roleId, u.accountId ,u.password, r.roleName,a.accountName, u.isActive  from  " +
	   "UserProfileEntity u , RoleEntity r, AccountEntity a " +
	   "where u.roleId = r.roleId and u.accountId = a.accountId";

	public static final String FETCH_QUESTION_DATA = "select d.questionId, a.assessmentId, a.assessmentAreaName , b.categoryId, b.categoryName, c.subCategoryId, c.subCategoryName,  "
			+ "d.questionText , e.optionOneVal , e.optionTwoVal, e.optionThreeVal, e.optionFourVal, e.optionFiveVal, d.isActive  "
			+ "from AssessmentEntity a , CategoryEntity b, SubCategoryEntity c , QuestionEntity d , QuestionIndicatorValuesEntity e "
			+ "where a.assessmentId = d.assessmentId and b.categoryId = d.categoryId and c.subCategoryId = d.subcategoryId and "
			+ "d.questionId = e.questionId"; 
	
	public static final String FETCH_QUESTION_REPORT = "select d.questionId, g.applicationId, g.applicationName, a.assessmentId, a.assessmentAreaName , b.categoryId, b.categoryName, c.subCategoryId, c.subCategoryName,  "
			+ "d.questionText , e.optionOneVal , e.optionTwoVal, e.optionThreeVal, e.optionFourVal, e.optionFiveVal, f.scoreAdmin,f.scoreUser, f.comments,f.submittedBy "
			+ "from AssessmentEntity a , CategoryEntity b, SubCategoryEntity c , QuestionEntity d , QuestionIndicatorValuesEntity e, QuestionScoreEntity f, ApplicationEntity g "
			+ "where g.applicationId = d.applicationId and a.assessmentId = d.assessmentId and b.categoryId = d.categoryId and c.subCategoryId = d.subcategoryId and d.questionId = f.questionId and "
			+ "d.questionId = e.questionId"; 
	
	public static final String FETCH_QUESTION_REPORT_APPL_ID = "select d.questionId, g.applicationId, g.applicationName, a.assessmentId, a.assessmentAreaName , b.categoryId, b.categoryName, c.subCategoryId, c.subCategoryName,  "
			+ "d.questionText , e.optionOneVal , e.optionTwoVal, e.optionThreeVal, e.optionFourVal, e.optionFiveVal, f.scoreAdmin,f.scoreUser, f.comments,f.submittedBy "
			+ "from AssessmentEntity a , CategoryEntity b, SubCategoryEntity c , QuestionEntity d , QuestionIndicatorValuesEntity e, QuestionScoreEntity f, ApplicationEntity g "
			+ "where g.applicationId = :applicationId and g.applicationId = d.applicationId and a.assessmentId = d.assessmentId and b.categoryId = d.categoryId and c.subCategoryId = d.subcategoryId and d.questionId = f.questionId and "
			+ "d.questionId = e.questionId"; 
	
	public static final String SELECT_ASSESSMENT_AREAS = "from AssessmentEntity a where a.assessmentAreaName = :assessmentAreaName";
	
	public static final String SELECT_CATEGORIES = "from CategoryEntity a where a.categoryName = :categoryName";
	
	public static final String SELECT_SUB_CATEGORIES = "from SubCategoryEntity a where a.subCategoryName = :subCategoryName";
	
	public static final String SELECT_APPLICATION_AREAS = "from ApplicationDetailEntity a where a.applicationName = :applicationName ";
	
	public static final String FETCH_FEEDBACK_FORM_INFO = "select a.feedbackId, b.applicationName, a.employeeId, c.accountName, d.roleName, "
			+ "a.feedback, a.filePath from FeedbackFormEntity a , ApplicationDetailEntity b , AccountEntity c, RoleEntity d "
			+ " where a.applicationId = b.applicationId and a.accountId = c.accountId and a.roleId = d.roleId ";
}

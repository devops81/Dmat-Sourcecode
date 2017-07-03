package com.devopps.portal.util;

public interface IHibernateQueries {
	
	public static final String FETCH_CATEGORIES = "select a.assessmentId, b.assessmentAreaName, a.categoryId , c.categoryName, c.categoryWeightage, c.activeFlag from  " +
												   "AssessmentCategoryEntity a , AssessmentEntity b, CategoryEntity c " +
												   "where a.assessmentId = b.assessmentId and a.categoryId = c.categoryId and c.questionnaireTypeId = :questionnaireType  ";

	public static final String FETCH_CATEGORIES_FILTERED = "select a.assessmentId, b.assessmentAreaName, a.categoryId , c.categoryName , c.categoryWeightage, c.activeFlag  from " +
	   "AssessmentCategoryEntity a , AssessmentEntity b, CategoryEntity c " +
	   "where a.assessmentId = b.assessmentId and a.categoryId = c.categoryId and b.assessmentId = :assessmentId and c.questionnaireTypeId = :questionnaireType";
	
	public static final String FETCH_SUB_CATEGORIES = "select c.categoryId, a.categoryName, c.subCategoryId , b.subCategoryName, b.subCategoryWeightage, b.activeFlag from  " +
	   "CategoryEntity a , SubCategoryEntity b, CategorySubCategoryEntity c " +
	   "where a.categoryId = c.categoryId and b.subCategoryId = c.subCategoryId and b.questionnaireTypeId = :questionnaireType";
	
	public static final String FETCH_SUB_CATEGORIES_FILTERED = "select c.categoryId, a.categoryName, c.subCategoryId ,b.subCategoryName, b.subCategoryWeightage, b.activeFlag from  " +
	   "CategoryEntity a , SubCategoryEntity b, CategorySubCategoryEntity c " +
	   "where a.categoryId = c.categoryId and b.subCategoryId = c.subCategoryId and a.categoryId = :categoryId and b.questionnaireTypeId = :questionnaireType";
	
	
	public static final String FETCH_USER_PROFILES = "select u.id, u.name, u.roleId, u.accountId ,u.password, r.roleName,a.accountName, u.isActive , u.userId from  " +
	   "UserProfileEntity u , RoleEntity r, AccountEntity a " +
	   "where u.roleId = r.roleId and u.accountId = a.accountId";

	public static final String FETCH_QUESTION_DATA = "select d.questionId,f.questionTypeName, a.assessmentId, a.assessmentAreaName , b.categoryId, b.categoryName, c.subCategoryId, c.subCategoryName,  "
			+ "d.questionText , e.optionOneVal , e.optionTwoVal, e.optionThreeVal, e.optionFourVal, e.optionFiveVal, d.isActive "
			+ "from AssessmentEntity a , CategoryEntity b, SubCategoryEntity c , QuestionEntity d , QuestionIndicatorValuesEntity e,QuestionnaireTypeEntity f "
			+ "where a.assessmentId = d.assessmentId and b.categoryId = d.categoryId and c.subCategoryId = d.subcategoryId and "
			+ "d.questionId = e.questionId and d.questionnaireType = f.questionTypeId  "
			+ "and d.questionnaireType = :questionnaireType "; 
	
	/*public static final String FETCH_QUESTION_REPORT = "select d.questionId, g.applicationId, g.applicationName, a.assessmentId, a.assessmentAreaName , b.categoryId, b.categoryName, c.subCategoryId, c.subCategoryName,  "
			+ "d.questionText , e.optionOneVal , e.optionTwoVal, e.optionThreeVal, e.optionFourVal, e.optionFiveVal, f.scoreAdmin,f.scoreUser, f.comments,f.submittedBy,d.reportId, h.businessUnitId "
			+ "from AssessmentEntity a , CategoryEntity b, SubCategoryEntity c , QuestionEntity d , QuestionIndicatorValuesEntity e, QuestionScoreEntity f, ApplicationEntity g, BusinessUnitEntity h "
			+ "where g.applicationId = d.applicationId and a.assessmentId = d.assessmentId and b.categoryId = d.categoryId and c.subCategoryId = d.subcategoryId and d.questionId = f.questionId and "
			+ "d.questionId = e.questionId and h.businessUnitId = d.businessUnitId"; */
	
	/*public static final String FETCH_QUESTION_REPORT_APPL_ID = "select d.questionId, g.applicationId, g.applicationName, a.assessmentId, a.assessmentAreaName , b.categoryId, b.categoryName, c.subCategoryId, c.subCategoryName,  "
			+ "d.questionText , e.optionOneVal , e.optionTwoVal, e.optionThreeVal, e.optionFourVal, e.optionFiveVal, f.scoreAdmin,f.scoreUser, f.comments,f.submittedBy,d.reportId, h.businessUnitId "
			+ "from AssessmentEntity a , CategoryEntity b, SubCategoryEntity c , QuestionEntity d , QuestionIndicatorValuesEntity e, QuestionScoreEntity f, ApplicationEntity g, BusinessUnitEntity h "
			+ "where g.applicationId = :applicationId and g.applicationId = d.applicationId and a.assessmentId = d.assessmentId and b.categoryId = d.categoryId and c.subCategoryId = d.subcategoryId and d.questionId = f.questionId and "
			+ "d.questionId = e.questionId and h.businessUnitId = d.businessUnitId"; */
	
	public static final String FETCH_QUESTION_REPORT = "select  f.ID, a.questionId, f.application_Id, g.application_Name, b.assessment_Id,"
			+ " b.assessment_Name , c.category_id, c.category_Name, d.subCategory_Id, d.subCategory_Name, "
			+ "a.question_description , e.option1Val , e.option2Val, e.option3Val, e.option4Val, e.option5Val,f.score_admin,"
			+ "f.score_user,f.comments,f.submitted_By,f.report_Id, f.business_Unit_Id,i.business_unit_name, f.account_id, h.account_name "+
			"from question_master a " + 
			"LEFT OUTER JOIN assessment_master b ON a.assessment_id = b.assessment_id "+
			" LEFT OUTER JOIN category_master c ON a.category_id = c.category_id "+
			" LEFT OUTER JOIN subcategory_master d ON a.subcategory_id = d.subcategory_id "+
			" LEFT OUTER JOIN question_indicative_values e ON a.questionId = e.questionId "+
			" LEFT OUTER JOIN question_score f ON a.questionId = f.questionId " +
			" LEFT OUTER JOIN application_master g ON g.application_id = f.application_id "+
			" LEFT OUTER JOIN account_master h ON h.account_id = f.account_id "+	
			" LEFT OUTER JOIN business_unit_master i ON i.business_unit_id = f.business_unit_id ";
	
	public static final String FETCH_QUESTION_REPORT_APPL_ID = "select f.ID, a.questionId, f.application_Id, g.application_Name, b.assessment_Id,"
			+ " b.assessment_Name , c.category_id, c.category_Name, d.subCategory_Id, d.subCategory_Name, "
			+ "a.question_description , e.option1Val , e.option2Val, e.option3Val, e.option4Val, e.option5Val,f.score_admin,"
			+ "f.score_user,f.comments,f.submitted_By,f.report_Id, f.business_Unit_Id,i.business_unit_name, f.account_id, h.account_name "+
			"from question_master a " + 
			"LEFT OUTER JOIN assessment_master b ON a.assessment_id = b.assessment_id "+
			" LEFT OUTER JOIN category_master c ON a.category_id = c.category_id "+
			" LEFT OUTER JOIN subcategory_master d ON a.subcategory_id = d.subcategory_id "+
			" LEFT OUTER JOIN question_indicative_values e ON a.questionId = e.questionId "+
			" LEFT OUTER JOIN question_score f ON a.questionId = f.questionId " +
			" LEFT OUTER JOIN application_master g ON g.application_id = f.application_id "+
			" LEFT OUTER JOIN account_master h ON h.account_id = f.account_id "+	
			" LEFT OUTER JOIN business_unit_master i ON i.business_unit_id = f.business_unit_id "+	
			" where a.questionnaire_type = ? and (f.application_id = ? or f.application_id IS NULL)   ";
	
	public static final String SELECT_ASSESSMENT_AREAS = "from AssessmentEntity a where a.assessmentAreaName = :assessmentAreaName";
	
	public static final String SELECT_CATEGORIES = "from CategoryEntity a where a.categoryName = :categoryName";
	
	public static final String SELECT_SUB_CATEGORIES = "from SubCategoryEntity a where a.subCategoryName = :subCategoryName";
	
	public static final String SELECT_APPLICATION_AREAS = "from ApplicationDetailEntity a where a.applicationName = :applicationName ";
	
	public static final String SELECT_QUESTION_MASTER_DATA = "from QuestionEntity";
	
	public static final String SELECT_ACCOUNT_ID = "from BusinessUnitAccountEntity a where a.businessUnitId = :businessUnitId ";
	
	public static final String FETCH_FEEDBACK_FORM_INFO = "select a.feedbackId, b.applicationName, a.employeeId, c.accountName, d.roleName, "
			+ "a.feedback, a.filePath from FeedbackFormEntity a , ApplicationDetailEntity b , AccountEntity c, RoleEntity d "
			+ " where a.applicationId = b.applicationId and a.accountId = c.accountId and a.roleId = d.roleId ";
	
	public static final String GET_ASSESSMENT_AREAS_INFO = "select a.assessmentId,a.assessmentAreaName, a.weightage,b.applicationId,c.applicationName,b.activeFlag "
			+ "from AssessmentEntity a, AssessmentApplicationEntity b, ApplicationEntity c where a.assessmentId = b.assessmentId and b.applicationId = c.applicationId ";

	public static final String GET_ASSESSMENT_AREAS = "select a.assessmentId,a.assessmentAreaName, a.weightage, a.activeFlag "
			+ "from AssessmentEntity a ";

	
	public static final String GET_BUSINESS_UNITS = "select a.businessUnitId, a.businessUnitName , b.accountId,c.accountName, b.isActive from BusinessUnitEntity a , BusinessUnitAccountEntity b, "
			+ " AccountEntity c where a.businessUnitId = b.businessUnitId and b.accountId = c.accountId ";
	
	public static final String GET_DISTINCT_BUSINESS_UNITS = "select businessUnitId,businessUnitName from BusinessUnitEntity";

	public static final String SELECT_BUSINESS_UNITS = "from BusinessUnitEntity a where a.businessUnitName = :businessUnitName ";
	
	public static final String GET_APPLICATION_INFO = "select a.applicationId, a.applicationName, b.businessUnitId, c.businessUnitName , b.isActive "
			+ "from ApplicationDetailEntity a ,  ApplicationBusinessUnitEntity b , BusinessUnitEntity c where "
			+ " a.applicationId = b.applicationId and b.businessUnitId = c.businessUnitId ";
	
	public static final String GET_DISTINCT_APPLICATIONS = "select a.applicationId, a.applicationName from ApplicationDetailEntity a ";
	
	
	public static final String GET_AUDIT_MAPPING_DATA = "select distinct a.account_id,b.account_name, a.business_unit_id,c.business_unit_name, "
			+ "a.assessment_id, d.assessment_name,a.isAssessmentIdActive, a.application_id , e.application_name "
			+" from question_score a INNER JOIN account_master b on a.account_id = b.account_id "
			+ "INNER JOIN business_unit_master c on a.business_unit_id = c.business_unit_id "
			+ "INNER JOIN assessment_master d on a.assessment_id = d.assessment_id  "
			+ "INNER JOIN application_master e ON a.application_id = e.application_id ";

}


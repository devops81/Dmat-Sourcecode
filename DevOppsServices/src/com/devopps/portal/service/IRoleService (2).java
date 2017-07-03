package com.devopps.portal.service;

import com.devopps.portal.model.AddRolesRequestBody;
import com.devopps.portal.model.RoleServiceResponse;

public interface IRoleService {

	RoleServiceResponse handleRoles(AddRolesRequestBody rolesRequestBody);
}

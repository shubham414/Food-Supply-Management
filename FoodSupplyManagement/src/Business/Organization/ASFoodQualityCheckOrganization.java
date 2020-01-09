/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.QualityChecker;
import java.util.HashSet;

/**
 *
 * @author
 */
public class ASFoodQualityCheckOrganization extends Organization {

    public ASFoodQualityCheckOrganization() {
        super(Organization.Type.ASFoodQualityCheck.getValue());
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles = new HashSet<>();
        roles.add(new QualityChecker());
        return roles;
    }

}

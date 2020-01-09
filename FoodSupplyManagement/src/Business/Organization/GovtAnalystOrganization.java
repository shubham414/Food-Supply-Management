/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.GovtAnalyst;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author
 */
public class GovtAnalystOrganization extends Organization {

    public GovtAnalystOrganization() {
        super(Organization.Type.GovtAnalyst.getValue());
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles = new HashSet<>();

        roles.add(new GovtAnalyst());
        return roles;
    }

}

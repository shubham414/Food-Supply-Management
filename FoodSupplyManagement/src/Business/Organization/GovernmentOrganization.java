/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FoodMinister;

import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author
 */
public class GovernmentOrganization extends Organization {

    public GovernmentOrganization() {
        super(Organization.Type.Government.getValue());
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles = new HashSet<>();
        roles.add(new FoodMinister());

        return roles;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Organization.Type type) {
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.NGO.getValue())) {
            organization = new NGOOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Government.getValue())) {
            organization = new GovernmentOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.ASFoodQualityCheck.getValue())) {
            organization = new ASFoodQualityCheckOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Supplier.getValue())) {
            organization = new SupplierOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.GovtAnalyst.getValue())) {
            organization = new GovtAnalystOrganization();
            organizationList.add(organization);
        }

        return organization;
    }

}

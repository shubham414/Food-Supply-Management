/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.GovernmentEnterprise) {
            enterprise = new GoernmentEnterprise(name);
            System.out.println("Government Enterprise created");
            enterpriseList.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.NGO) {
            enterprise = new NGOEnterprise(name);
            System.out.println("NGO Enterprise created");
            enterpriseList.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.Supplier) {
            enterprise = new SupplierEnterprise(name);
            System.out.println("Supplier Enterprise created");
            enterpriseList.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.QualityCheckEnterprise) {
            enterprise = new QualityCheckEnterprise(name);
            System.out.println("Quality Check Enterprise created");
            enterpriseList.add(enterprise);
        }

        return enterprise;
    }

}

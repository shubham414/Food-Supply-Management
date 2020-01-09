/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;

import Business.Organization.Organization;

import Business.UserAccount.UserAccount;
import UserInterface.SupplierRole.SupplierWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author
 */
public class Supplier extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        System.out.println(business);
        return new SupplierWorkAreaJPanel(userProcessContainer, account, organization, business);
    }

    @Override
    public String toString() {
        System.out.println(RoleType.Supplier.getValue());
        return RoleType.Supplier.getValue();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;

import Business.Food.FoodCatalog;
import Business.Network.Network;
import Business.Order.MasterOrderCatalog;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdmin;
import Business.Supplier.SupplierDirectory;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author
 */
public class EcoSystem extends Organization {

    private static EcoSystem system;
    private ArrayList<Network> networkList;
    private FoodCatalog foodCatalog;
    private MasterOrderCatalog masterOrderCatalog;

    private SupplierDirectory supplierCatalog;

    public static EcoSystem getInstance() {
        if (system == null) {
            system = new EcoSystem();
        }
        return system;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<Network>();
        foodCatalog = new FoodCatalog();
        masterOrderCatalog = new MasterOrderCatalog();
        supplierCatalog = new SupplierDirectory();
    }

    public SupplierDirectory getSupplierCatalog() {
        return supplierCatalog;
    }

    public void setSupplierCatalog(SupplierDirectory supplierCatalog) {
        this.supplierCatalog = supplierCatalog;
    }

    public static EcoSystem getSystem() {
        return system;
    }

    public static void setSystem(EcoSystem system) {
        EcoSystem.system = system;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }

    public FoodCatalog getFoodCatalog() {
        return foodCatalog;
    }

    public void setFoodCatalog(FoodCatalog foodCatalog) {
        this.foodCatalog = foodCatalog;
    }

    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    public void setMasterOrderCatalog(MasterOrderCatalog masterOrderCatalog) {
        this.masterOrderCatalog = masterOrderCatalog;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new SystemAdmin());
        return roles;
    }

    public static boolean checkIfUsernameIsUnique(String username) {

        for (Network network : system.getNetworkList()) {

            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    if (ua.getUsername().equals(username)) {
                        return false;
                    }
                }

                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                        if (ua.getUsername().equals(username)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author
 */
public class QualityCheckEnterprise extends Enterprise {

    public QualityCheckEnterprise(String name) {
        super(name, EnterpriseType.QualityCheckEnterprise);
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        return null;

    }

}

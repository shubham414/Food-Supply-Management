/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import Business.Food.FoodCatalog;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author
 */
public class Supplier {

    private String supplierName;
    private static int sCount;
    private String supplierId;
    private FoodCatalog foodList;
    private WorkQueue workQueue;

    public Supplier() {
        supplierId = "SID" + (++sCount);
        foodList = new FoodCatalog();
        workQueue = new WorkQueue();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public FoodCatalog getFoodList() {
        return foodList;
    }

    public void setFoodList(FoodCatalog foodList) {
        this.foodList = foodList;
    }

    @Override
    public String toString() {
        return supplierName;
    }

}

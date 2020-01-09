/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author
 */
public class FoodRequest extends WorkRequest {

    private int requestQuantity;
    private int requestId;
    private static int count = 0;

    private String nextDateforLoanPanel;
    private String dateOfPurchaseInString;

    private Date dateOfPurchase;

    public FoodRequest() {
        count++;
        requestId = count;
    }

    public String getNextDateforLoanPanel() {
        return nextDateforLoanPanel;
    }

    public void setNextDateforLoanPanel(String nextDateforLoanPanel) {
        this.nextDateforLoanPanel = nextDateforLoanPanel;
    }

    public int getRequestQuantity() {
        return requestQuantity;
    }

    public void setRequestQuantity(int requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    public int getRequestId() {
        return requestId;
    }

    public String getDateOfPurchaseInString() {
        return dateOfPurchaseInString;
    }

    public void setDateOfPurchaseInString(String dateOfPurchaseInString) {
        this.dateOfPurchaseInString = dateOfPurchaseInString;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Override
    public String toString() {
        return String.valueOf(this.requestQuantity);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Food;

import java.util.Date;

/**
 *
 * @author
 */
public class Food {

    private String code;
    private static int count = 100;
    private String name;
    private String type;
    private int quantity;

    private Date dateOfPurchase;
    private Date dateOfEntry;
    private String dateOfPurchaseInString;
    private String dateOfEntryInString;

    private boolean flag;
    private boolean recommend;

    public enum FoodType {
        Cereals("Cereals"),
        Beans("Beans"),
        Vegetables("Vegetables"),
        Fruits("Fruits"),
        MeatandPoultry("Meat and polutry"),
        Seafood("SeaFood");

        private String value;

        private FoodType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Food() {
        code = "M" + count;
        count++;

    }

    public String getDateOfPurchaseInString() {
        return dateOfPurchaseInString;
    }

    public void setDateOfPurchaseInString(String dateOfPurchaseInString) {
        this.dateOfPurchaseInString = dateOfPurchaseInString;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public String getDateOfEntryInString() {
        return dateOfEntryInString;
    }

    public void setDateOfEntryInString(String dateOfEntryInString) {
        this.dateOfEntryInString = dateOfEntryInString;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return name;
    }

}

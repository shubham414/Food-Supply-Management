/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Food;

import java.util.ArrayList;

/**
 *
 * @author
 */
public class FoodCatalog {

    private ArrayList<Food> FoodCatalog;

    public FoodCatalog() {
        FoodCatalog = new ArrayList<Food>();

    }

    public ArrayList<Food> getFoodCatalog() {
        return FoodCatalog;
    }

    public void setFoodCatalog(ArrayList<Food> foodCatalog) {
        this.FoodCatalog = foodCatalog;
    }

    public Food addFood() {
        Food food = new Food();
        FoodCatalog.add(food);
        return food;
    }

    public void removeFood(Food food) {
        FoodCatalog.remove(food);
    }

}

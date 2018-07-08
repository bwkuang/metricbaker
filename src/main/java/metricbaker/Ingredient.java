package metricbaker;

import jdk.nashorn.internal.runtime.regexp.joni.ast.QuantifierNode;
import metricbaker.IngredientDensity;
import metricbaker.Quantity;
import metricbaker.UnitOfMass;
import metricbaker.UnitOfVolume;

public class Ingredient {

    protected String name;
    protected float amount;
    protected Quantity quantity;

    protected Ingredient(String name, Quantity quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public int getWeight(){
        return quantity.getWeight(IngredientDensity.getDensityByIngredient(this.name));
    }

    public static Ingredient breadFlour(Quantity quantity){
        return new Ingredient("bread flour", quantity);
    }

    public static Ingredient sugar(Quantity quantity){
        return new Ingredient("sugar", quantity);
    }

    public static Ingredient butter(Quantity quantity){
        return new Ingredient("butter", quantity);
    }

}
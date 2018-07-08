package metricbaker;

import jdk.nashorn.internal.runtime.regexp.joni.ast.QuantifierNode;
import metricbaker.IngredientDensity;
import metricbaker.Quantity;
import metricbaker.UnitOfMass;
import metricbaker.UnitOfVolume;

public class Ingredient {

    private String name;
    private float amount;
    private Quantity quantity;
    private UnitOfVolume unitOfVolume = UnitOfVolume.none;
    private UnitOfMass unitOfMass = UnitOfMass.none;

    private Ingredient(String name, Quantity quantity){
        this.name = name;
        this.quantity = quantity;
    }

    private Ingredient(String name, float amount, UnitOfVolume unitOfVolume){
        this.name = name;
        this.amount = amount;
        this.unitOfVolume = unitOfVolume;
    }

    private Ingredient(String name, float amount, UnitOfMass unitOfMass){
        this.name = name;
        this.amount = amount;
        this.unitOfMass = unitOfMass;
    }

    public int getWeight(){
        float volume = unitOfVolume.getVolumeInMl();
        float density = IngredientDensity.getDensityByIngredient(name);

        float unitMassInGram = unitOfMass.getMassInGrams();

        return quantity.getWeight(IngredientDensity.getDensityByIngredient(this.name));

        // return  Math.max(Math.round(volume * density), Math.round(amount * unitMassInGram));
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
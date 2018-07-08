package metricbaker;

import metricbaker.UnitOfMass;
import metricbaker.UnitOfVolume;

public class Ingredient {

    private String name;
    private float amount;
    private UnitOfVolume unitOfVolume = UnitOfVolume.none;
    private UnitOfMass unitOfMass = UnitOfMass.none;

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
        float volume = UnitOfVolume.getVolumeByUnit(unitOfVolume.getUnitName());
        float density = IngredientDensity.getDensityByIngredient(name);

        float unitMassInGram = UnitOfMass.getGramsByMassUnit(unitOfMass.getUnitName());

        return  Math.max(Math.round(volume * density), Math.round(amount * unitMassInGram));
    }

    public static Ingredient breadFlour(float amount, UnitOfVolume unitOfVolume){
        return new Ingredient("bread flour", amount, unitOfVolume);
    }

    public static Ingredient sugar(float amount, UnitOfVolume unitOfVolume){
        return new Ingredient("sugar", amount, unitOfVolume);
    }

    public static Ingredient butter(float amount, UnitOfMass unitOfMass){
        return new Ingredient("butter", amount, unitOfMass);
    }

}
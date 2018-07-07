package metricbaker;

public class Ingredient {

    private String name;
    private float amount;
    private UnitOfVolume unitOfVolume;

    private Ingredient(String name, float amount, UnitOfVolume unitOfVolume){
        this.name = name;
        this.amount = amount;
        this.unitOfVolume = unitOfVolume;
    }

    public int getWeight(){
        float volume = UnitOfVolume.getVolumeByUnit(unitOfVolume.getUnitName());
        float density = IngredientDensity.getDensityByIngredient(name);
        return  Math.round(volume * density);
    }

    public static Ingredient breadFlour(float amount, UnitOfVolume unitOfVolume){
        return new Ingredient("bread flour", amount, unitOfVolume);
    }

    public static Ingredient sugar(float amount, UnitOfVolume unitOfVolume){
        return new Ingredient("sugar", amount, unitOfVolume);
    }
}
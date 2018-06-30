public class Ingredient{

    private String name;
    private float amount;
    private UnitOfVolume unitOfVolume;

    private Ingredient(String name, float amount, UnitOfVolume unitOfVolume){
        this.name = name;
        this.amount = amount;
        this.unitOfVolume = unitOfVolume;
    }

    public static Ingredient breadFlour(float amount, UnitOfVolume unitOfVolume){
        return new Ingredient("Bread Flour", amount, unitOfVolume);
    }

    public int getWeight(){
        return  137;
    }
}
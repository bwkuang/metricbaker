package metricbaker;

public class CountableIngredient extends Ingredient{

	private String countableIngredientName="";
	private float mass=0f;

	private CountableIngredient(String countableIngredientName, float mass){
		super(countableIngredientName, new Quantity(1f, UnitOfMass.kilogram));
		this.countableIngredientName=countableIngredientName;
		this.mass=mass;
	}
	
	public String getCountableIngredientName() {return countableIngredientName;}
	public int getWeight() {return (int)mass;}

	public static CountableIngredient largeEgg(int amount){
		return new CountableIngredient("large egg", (float)amount * 60f);
	}

	public static float getMassByCountable(String ingredient){
		return 60f;
	}
}
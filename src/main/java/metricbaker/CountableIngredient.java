package metricbaker;

public enum CountableIngredient{

	largeEgg("large egg", 60f);

	private String countableIngredientName="";
	private float mass=0f;

	private CountableIngredient(String countableIngredientName, float mass){
		this.countableIngredientName=countableIngredientName;
		this.mass=mass;
	}
	
	public String getCountableIngredientName() {return countableIngredientName;}
	public float getMass() {return mass;}

	public static float getMassByCountable(String ingredient){
		float mass = 0f;
		
		for(CountableIngredient c : CountableIngredient.values()){
		  if(c.getCountableIngredientName().compareToIgnoreCase(ingredient) == 0){
			mass = c.getMass();
		  }
		}	
		return mass;
	  }
}
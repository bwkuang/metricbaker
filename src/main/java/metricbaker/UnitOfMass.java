package metricbaker;

public enum UnitOfMass{
  
	pound("pound",453.592f),
	kilogram("kilogram", 1000f),
	ounce("ounce",28.3495f),
	gram("gram", 1f);
	
	private String unitName = "";
	private float massInGrams = 0f;
	
	private UnitOfMass(String unitName, float massInGrams){
		this.massInGrams = massInGrams;
		this.unitName = unitName;
	}
	
	public String getUnitName(){ return unitName;}
	
	public float getMassInGrams(){ return massInGrams;}

	public static float getGramsByMassUnit(String unit){
		float mass = 0f;
		
		for(UnitOfMass u : UnitOfMass.values()){
		  if(u.getUnitName().compareToIgnoreCase(unit) == 0){
			mass = u.getMassInGrams();
		  }
		}	
		return mass;
	}

}
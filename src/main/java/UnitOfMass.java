public enum UnitOfMass{
  
	pound("pound",453.592f),
	kilogram("kilogram", 1000f),
	ounce("ounce",28.3495f),
	gram("gram", 1f);
	
	private String massName = "";
	private float massInGrams = 0f;
	
	public UnitOfMass(String massName, float massInGrams){
		this.massInGrams = massInGrams;
		this.massName = massName;
	}
	
	public void String getMassName(){ return massName;}
	public void String getMassInGrams(){ return massInGrams;}
	
}
public enum UnitOfMass{

	
	
	private String massName = "";
	private float massInGrams = 0f;
	
	public UnitOfMass(String massName, float massInGrams){
		this.massInGrams = massInGrams;
		this.massName = massName;
	}
	
	public void String getMassName(){ return massName;}
	public void String getMassInGrams(){ return massInGrams;}
	
}
public enum UnitOfVolume{

  cup("cup", 236),
  teaSpoonVolume("teaspoon",5f),
  tablespoonVolume("tablespoon",15f),
  fluidOzVolume("fluid oz",30f),
  literVolume("l",1000f),
  ml("ml",1f);

  String unitName = "";
  float volume = 0f;

  private UnitOfVolume(String unitName, float volume){
    this.unitName = unitName;
    this.volume = volume;
  }

  public String getUnitName(){
    return unitName;
  }

  public float getVolume(){
    return volume;
  }

}

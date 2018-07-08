package metricbaker;

public enum UnitOfVolume{

  none("none", 0f),
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

  public float getVolumeInMl(){
    return volume;
  }

  public static float getVolumeByUnit(String unit){
    float volume = 0f;

    for(UnitOfVolume u : UnitOfVolume.values()){
      if(u.getUnitName().compareToIgnoreCase(unit) == 0){
        volume = u.getVolumeInMl();
      }
    }
    
    return volume;
  }

}

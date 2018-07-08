package metricbaker;

import metricbaker.UnitOfMass;
import metricbaker.UnitOfVolume;

public class Quantity{
    private UnitOfMass unitOfMass = UnitOfMass.none;
    private UnitOfVolume unitOfVolume = UnitOfVolume.none;
    private float amount;

    public Quantity(float amount, UnitOfMass unitOfMass){
        this.amount = amount;
        this.unitOfMass = unitOfMass;
    }

    public Quantity(float amount, UnitOfVolume unitOfVolume){
        this.amount = amount;
        this.unitOfVolume = unitOfVolume;
    }

    public int getWeight(float density){
        float volumeInMl = unitOfVolume.getVolumeInMl();
        float massInGrams = unitOfMass.getMassInGrams();
        return Math.max(Math.round(volumeInMl * density), Math.round(amount * massInGrams));
    }
}
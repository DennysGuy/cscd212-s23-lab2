package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television>{

    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution ) throws IllegalArgumentException{

        if (model == null || model.isBlank() || screenSize < 32 || resolution < 720|| make == null || make.isBlank()){
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }

        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
        this.fourK = (resolution == 2160);


    }
    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make) {
        this(make, model, smart, screenSize, resolution);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + this.resolution + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
    }

    public int getScreenSize(){
        return this.screenSize;
    }

    public int getResolution(){
        return this.resolution;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    @Override
    public String toString() {
        if (this.fourK) {
            return getMake() + "-" + getModel() + ", " + getScreenSize() + " inch tv with 4K resolution";

        }
        else if (this.fourK && this.smart){
            return getMake() + "-" + getModel() + ", " + getScreenSize() + " inch smart tv with 4k resolution";
        }
        else if (this.smart){
            return getMake() + "-" + getModel() + ", " + getScreenSize() + " inch smart tv with " + getResolution() + " resolution";
        }
        else {
            return getMake() + "-" + getModel() + ", " + getScreenSize() + " inch tv with " + getResolution() + " resolution";
        }
    }


    @Override
    public int compareTo(Television another) throws IllegalArgumentException{
        if (another == null){
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }

        if (this.make.equals(another.make)){
            if (this.model.equals(another.model)){
                return this.screenSize-another.screenSize;
            }
            return this.model.compareTo(another.model);
        }

        return this.make.compareTo(another.make);
    }
}

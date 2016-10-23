package model;

import java.util.Observable;

import android.graphics.Color;
/**
 * The model Holds the data.
 *
 * Model Color
 * Based on Hue , Saturation and , Value_light
 *
 * HUE: Float values in the domain range of 0 to 359
 * SATURATION: Float values in the domain range of 0 to 100%
 * VALUE_LIGHTNESS: Float values in the domain range of 0 to 100%
 *
 * Created by crisdalessio on 2016-10-20.
 */

//when i refer to value i actually mean value_lightness
//class HSVModel inherits from Java's class Observable
public class HSVModel  extends Observable{


    //CLASS VARIABLES and also constants since they will not change their value
    public static final Float MAX_HUE = 359f;
    public static final Float MIN_HUE = 0f;

    public static final Float MAX_SATURATION = 100f;
    public static final Float MIN_SATURATION = 0f;

    public static final Float MAX_VALUE = 100f;
    public static final Float MIN_VALUE = 0f;


    //INSTANCE VARIABLES
    private Float hue;
    private Float saturation;
    private Float value;



    //CONSTRUCTORS
    public HSVModel() {
        this(MAX_HUE, MIN_SATURATION, MIN_VALUE);
    }

    public HSVModel(Float hue, Float saturation, Float value){

        super();

        this.hue = hue;
        this.saturation = saturation;
        this.value = value;
        //THIS references my instance variables



    }

    //INSTANCE METHODS

    //HSL Value for black is 0, 0%, 0%
    public void asBlack()   { this.setHSV( MIN_HUE, MIN_SATURATION, MIN_VALUE ); }

    // HSL Value for red is 0 , 100%, 100%
    public void asRed(){ this.setHSV(MAX_HUE,MAX_SATURATION,MAX_VALUE);}

    //HSL Value for lime is 120,100%,100%
    public void asLime(){ this.setHSV(120f,MAX_SATURATION,MAX_VALUE);}

    //HSL Value for blue is 240, 100%, 100%
    public void asBlue(){ this.setHSV(240f,MAX_SATURATION,MAX_VALUE);}

    //HSL Value for yellow is 60,100%,50.4%
    public void asYellow(){this.setHSV(60f,MAX_SATURATION,MAX_VALUE);}

    //HSL Value for Cyan is 180,100%,50%
    public void asCyan(){this.setHSV(180f,MAX_SATURATION,MAX_VALUE);}

    //HSL Value for Magenta is 300,100%,50%
    public void asMagenta(){this.setHSV(300f,MAX_SATURATION,MAX_VALUE);}

    //HSL Value for Silver is 0, 0%, 75%
    public void asSilver(){this.setHSV(MIN_HUE,80f,MIN_VALUE);}

    //HSL Value for gray is 6,100,50.4
    public void asGray(){this.setHSV(MIN_HUE,MAX_SATURATION/2,MIN_VALUE);}

    //HSL Value for maroon is 0,100%,25%
    public void asMaroon(){this.setHSV(MIN_HUE,MAX_SATURATION/2,MAX_VALUE);}

    //HSL Value for olive is 60,100%,25%
    public void asOlive(){this.setHSV(70f,MAX_SATURATION/2,MAX_VALUE/2);}

    //HSL Value for green is 120, 100%, 25%
    public void asGreen(){this.setHSV(120f,MAX_SATURATION/2,MAX_VALUE);}

    //HSL Value for purple is 300,100%,25%
    public void asPurple(){this.setHSV(300f,MAX_SATURATION/2,75f);}

    //HSL Value for teal is 0,100%,25%
    public void asTeal(){this.setHSV(MAX_HUE/2,MAX_SATURATION/2,MAX_VALUE);}

    //HSL Value for navy is 240,100%,25%
    public void asNavy(){this.setHSV(240f,MAX_SATURATION/2,MAX_VALUE);}


    //GET METHODS


    //public Float getColor(){ Color.HSVToColor(new float[]{hue,saturation,value};)}

    public Float getHue(){ return hue;}
    public Float getSaturation(){ return saturation/100f;}
    public Float getValue(){ return value/100f;}


    //SET METHODS

    public void setHue(Float hue){

        this.hue = hue;

        this.updateObservers();
    }

    public void setSaturation(Float saturation){

        this.saturation = saturation;

        this.updateObservers();
    }

    public void setValue(Float value){

        this.value = value;

        this.updateObservers();
    }

    public void setHSV(Float hue, Float saturation, Float value){

            this.hue = hue;
            this.saturation = saturation;
            this.value = value;

        this.updateObservers();
    }

    @Override
    public String toString() {
        return "HSV [H=" + hue + " S=" + saturation + " V=" + value + "]";
    }


    //After toString define helper utility instance method:

    /**
     * The model's state has changed!
     *
     * Notify all registered observers that this model has changed
     * state, and the registered observers should change too.
     */

    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }


    // Proof that my model is independent of any view.
    public static void main( String[] args ) {
        HSVModel model = new HSVModel( 300f, 100f, 50f);

        System.out.println( model );
    }

}

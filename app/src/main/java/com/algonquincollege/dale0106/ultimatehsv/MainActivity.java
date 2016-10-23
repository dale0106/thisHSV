package com.algonquincollege.dale0106.ultimatehsv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Observable;
import java.util.Observer;

import model.HSVModel;

/**
 * Controller for HSVModel.
 *
 * As the Controller:
 *   a) event handler for the View
 *   b) observer of the Model (HSVModel)
 *
 * Features the Update / React Strategy.
 *
 * @author Cristobal Dalessio (dale0106)
 * @version 1.0
 *
 */
public class MainActivity extends AppCompatActivity implements Observer
        , SeekBar.OnSeekBarChangeListener
{

    //CLASS VARIABLES
    private static final String ABOUT_DIALOG_TAG = "About";
    private static final String LOG_TAG = "HSV";



    //INSTANCE VARIABLES
    private SeekBar mHueSB;
    private SeekBar mSaturationSB;
    private SeekBar mValueSB;
    private TextView mColorWatch;
    private HSVModel mModel;
    private AboutDialogFragment mAboutDialog;
    private TextView mHueHandle;
    private TextView mValueHandle;
    private TextView mSaturationHandle;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a new AboutDialogFragment()
        // but do not show it (yet)
        mAboutDialog = new AboutDialogFragment();

        // Instantiate a new HSV model
        mModel = new HSVModel(HSVModel.MIN_HUE, HSVModel.MIN_SATURATION,HSVModel.MIN_VALUE);
        mModel.addObserver(this);

        //Reference each view component
        mHueSB = (SeekBar) findViewById( R.id.hueSB );
        mSaturationSB = (SeekBar) findViewById(R.id.saturationSB);
        mValueSB = (SeekBar) findViewById(R.id.valueLightSB);
        mColorWatch = (TextView) findViewById(R.id.colorSwatch);
        mValueHandle = (TextView) findViewById(R.id.valueHandle);
        mHueHandle = (TextView) findViewById(R.id.hueHandle);
        mSaturationHandle = (TextView) findViewById(R.id.saturationHandle);


        // set the domain (i.e. max) for each component.
        mHueSB.setMax( Math.round(HSVModel.MAX_HUE) );
        mSaturationSB.setMax(Math.round(HSVModel.MAX_SATURATION));
        mValueSB.setMax(Math.round(HSVModel.MAX_VALUE));

       // Register the event handlers for each <SeekBar>:
        mHueSB.setOnSeekBarChangeListener( this );
        mSaturationSB.setOnSeekBarChangeListener(this);
        mValueSB.setOnSeekBarChangeListener(this);

        //Register the event handlers for each <TextView>
       // mHueHandle.setOnEditorActionListener(this);
        this.updateView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    public void setClicked(View view){


        switch (view.getId() ){

        // this function will capture the current id of button (view) and update the model based on the case selected
            case R.id.blackBtn:
                mModel.asBlack();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString() + "\u00B0" +  " Saturation:" +  Math.round(mModel.getSaturation()) * 100 + "%" + " Value: " + Math.round(mModel.getValue()) * 100 + "%" , Toast.LENGTH_SHORT).show();
                //return true;
                break;

            case R.id.redBtn:
                mModel.asRed();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString() +  "\u00B0"  + " Saturation:" +  Math.round(mModel.getSaturation()) * 100 + "%" + " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                //return true;
                break;

            case R.id.limeBtn:
                mModel.asLime();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString()  + "\u00B0" + " Saturation:" +  Math.round(mModel.getSaturation()) * 100 + "%" + " Value: " + Math.round(mModel.getValue()) * 100 + "%" , Toast.LENGTH_SHORT).show();
                //return true
                break;

            case R.id.blueBtn:
                mModel.asBlue();
                Toast.makeText(this, "Hue:" + mModel.getHue().toString() + "\u00B0" + " Saturation:" +  Math.round(mModel.getSaturation()) * 100 + "%" + " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                //return true;
                break;

            case R.id.yellowBtn:
                mModel.asYellow();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString()  + "\u00B0" + " Saturation:" +   Math.round(mModel.getSaturation()) * 100 + "%" +  " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                //return true;
                break;

            case R.id.cyanBtn:
                mModel.asCyan();
                Toast.makeText(this, "Hue " + mModel.getHue().toString() + "\u00B0" + " Saturation:" +  Math.round(mModel.getSaturation()) * 100 + "%" + " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                //return true;

                break;

            case R.id.magentaBtn:
                mModel.asMagenta();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString() + "\u00B0" + " Saturation:" + Math.round(mModel.getSaturation()) * 100 + "%" + " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                //return true
                break;

            case R.id.silverBtn:
                mModel.asSilver();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString() + "\u00B0" + " Saturation:" +  Math.round(mModel.getSaturation()) * 100 + "%" + " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                //return true;
                break;

            case R.id.grayBtn:
                mModel.asGray();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString() + "\u00B0" + " Saturation:" + Math.round(mModel.getSaturation()) * 100 + "%" + " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                //return true;

                break;

            case R.id.maroonBtn:
                mModel.asMaroon();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString() + "\u00B0" + " Saturation:" +  Math.round(mModel.getSaturation()) * 100 + "%" + " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                //return true;

                break;

            case R.id.oliveBtn:
                mModel.asOlive();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString() + "\u00B0" + " Saturation:" +  Math.round(mModel.getSaturation()) * 100 + "%" + " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                //return true;
                break;

            case R.id.greenBtn:
                mModel.asGreen();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString() + "\u00B0" + " Saturation:" +  Math.round(mModel.getSaturation()) * 100 + "%" + " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                //return true;
                break;

            case R.id.purpleBtn:
                mModel.asPurple();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString() + "\u00B0" + " Saturation:" +  Math.round(mModel.getSaturation()) * 100 + "%" +  " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                //return true;
                break;

            case R.id.tealBtn:
                mModel.asTeal();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString() + "\u00B0" + " Saturation:" + Math.round(mModel.getSaturation()) * 100 + "%" +  " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                //return true;
                break;

            case R.id.navyBtn:
                mModel.asNavy();
                Toast.makeText(this, "Hue: " + mModel.getHue().toString() + "\u00B0" + " Saturation:" + Math.round(mModel.getSaturation()) * 100 + "%" + " Value: " + Math.round(mModel.getValue()) * 100 + "%", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "A button was clicked: ", Toast.LENGTH_SHORT).show();
                //return super.onOptionsItemSelected(btn);

        }



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem btn) {

        //So this will not work because its connecting to the menu
        // Handle presses on the action bar items. I need to link a function that will run everytime one of the buttons are clicked
        switch ( btn.getItemId() ) {

            case R.id.action_about:
                mAboutDialog.show( getFragmentManager(), ABOUT_DIALOG_TAG );
                return true;


            default:
                Toast.makeText(this, "MenuItem: " + btn.getTitle(), Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(btn);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if ( fromUser == false ) {


            return;
        }

        switch( seekBar.getId() ) {

            case R.id.hueSB:
               //mModel.setHue(mHueSB.getProgress());
                mModel.setHue((float) mHueSB.getProgress());
                mHueHandle.setText("Hue: {progress}".toUpperCase());
                break;

            case R.id.saturationSB:
                //mModel.setSaturation(mSaturationSB.getProgress());
                mModel.setSaturation((float) mSaturationSB.getProgress());
                mSaturationHandle.setText("Saturation: {progress}".toUpperCase());
                break;

            case R.id.valueLightSB:
                //mModel.setValue(mValueSB.getProgress());
                mModel.setValue((float) mValueSB.getProgress());
                mSaturationHandle.setText("Value: {progress}".toUpperCase());
                break;
        }



    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        // No-Operation
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        // No-Operation
    }

    @Override
    public void update(Observable observable, Object data) {
        this.updateView();
    }

    private void updateHueSB() {
        //mHueSB.setProgress( mModel.getHue() );
        mHueSB.setProgress(Math.round(mModel.getHue()));
    }

    private void updateSaturationSB() {
       // mSaturationSB.setProgress( mModel.getSaturation() );
        mSaturationSB.setProgress(Math.round(mModel.getSaturation()*100f));
    }

    private void updateValueSB(){
        //mValueSB.setProgress(mModel.getValue());
        mValueSB.setProgress(Math.round(mModel.getValue()*100f));
    }

    private void updateColorSwatch(){
        mColorWatch.setBackgroundColor(Color.HSVToColor(new float[]{mModel.getHue(), mModel.getValue(), mModel.getSaturation()}));
    }


    // Synchronize each View component with the current state of the Model.
    public void updateView() {
        this.updateHueSB();
        this.updateSaturationSB();
        this.updateValueSB();
        this.updateColorSwatch();
    }

}

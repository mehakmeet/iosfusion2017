package com.adgvit.iosfusion2017;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView arrow;
    private GestureDetectorCompat gestureObject;
    private IntentIntegrator qrScan;
    private ImageView swipeButton;
    public String name, regno,mobile,email;
    public boolean login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeButton = (ImageView) findViewById(R.id.arrow);
        swipeButton.setOnClickListener(this);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());

        qrScan = new IntentIntegrator(this);
        
        arrow = (ImageView) findViewById(R.id.arrow);
        SharedPreferences sp = getSharedPreferences("key", 0);
        login=Boolean.parseBoolean(sp.getString("datavalue",""));
        Log.i("value of login",String.valueOf(login));
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login==true)
                {
                    Intent i=new Intent(MainActivity.this,NavDraActivity.class);
                    startActivity(i);

                }
                else
                /* add if case
                if authenticated, intent should go to NavDraActivity rather than QrActivity */
                qrScan.initiateScan();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        if(login==true)
        {
            Intent i=new Intent(MainActivity.this,NavDraActivity.class);
            startActivity(i);

        }
        else
        //check for authentication
        qrScan.initiateScan();
    }

    public class LearnGesture extends GestureDetector.SimpleOnGestureListener {

        //SimpleGestureListener is the listener for what type of swipe we want

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
            if (login == true) {
                Intent i = new Intent(MainActivity.this, NavDraActivity.class);
                startActivity(i);

            } else {
                if (event2.getY() < event1.getY()) {
                    //down to up swipe
                    //check for authentication here
                    qrScan.initiateScan();
                } else if (event2.getY() > event1.getY()) {
                    //up to down swipe
                }
                return true;
            }
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                //if qrCode is empty
                Toast.makeText(this, "Result not found", Toast.LENGTH_LONG).show();
            } else {
                //if qrCode has data
                try {


                    //converting the data to JSON
                    JSONObject obj = new JSONObject(result.getContents());
                    //set the values that are returned to the text views
                    name = obj.getString("name");
                    regno = obj.getString("regno");
                    mobile = obj.getString("mobile");
                    email = obj.getString("email");
                    login=true;
                    SharedPreferences sp = getSharedPreferences("key", 0);
                    SharedPreferences.Editor sedt = sp.edit();
                    sedt.putString("datavalue", String.valueOf(login));
                    sedt.commit();
                    Intent intent=new Intent(MainActivity.this,NavDraActivity.class);
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                    //If control comes here
                    //It means that encoded format doesn't match
                    //ie, User scanned a QR code which isn't in our DB
                    Toast.makeText(this, "Wrong QR Code", Toast.LENGTH_LONG).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

package com.haibuzou.hellojni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTxt = (TextView) findViewById(R.id.result);
        resultTxt.setText(stringFromJNI());
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.protocol:
                resultTxt.setText(urlprotocolinfo());
                break;
            case R.id.format:
                resultTxt.setText(avformatinfo());
                break;
            case R.id.codec:
                resultTxt.setText(avcodecinfo());
                break;
            case R.id.filter:
                resultTxt.setText(avfilterinfo());
                break;
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String urlprotocolinfo();
    public native String avformatinfo();
    public native String avcodecinfo();
    public native String avfilterinfo();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}

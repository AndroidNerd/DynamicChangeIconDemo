package com.example.by.dynamicicon;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ComponentName mDefault;
    private ComponentName testMVP;
    private ComponentName testIOS;
    private PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDefault=getComponentName();
        testMVP=new ComponentName(getBaseContext(),"com.example.by.dynamicicon.TestMVP");
        testIOS=new ComponentName(getBaseContext(),"com.example.by.dynamicicon.TestIOS");
        packageManager=getApplicationContext().getPackageManager();
    }

    public void setDefaultIcon(View view){
        enableComponent(mDefault);
        disableComponent(testMVP);
        disableComponent(testIOS);
    }
    public void setMVPIcon(View view){
        enableComponent(testMVP);
        disableComponent(mDefault);
        disableComponent(testIOS);
    }
    public void setIOSIcon(View view){
        enableComponent(testIOS);
        disableComponent(mDefault);
        disableComponent(testMVP);
    }


    private void enableComponent(ComponentName componentName) {
        packageManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }
    private void disableComponent(ComponentName componentName) {
        packageManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}

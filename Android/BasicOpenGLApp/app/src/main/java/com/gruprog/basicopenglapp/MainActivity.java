package com.gruprog.basicopenglapp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GLSurfaceView glSurfaceView;
    private boolean rendererSet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);

        final boolean es2Supported = isES2Supported();

        if(es2Supported) {
            glSurfaceView.setEGLContextClientVersion(2);
            glSurfaceView.setRenderer(new CustomRenderer());
            rendererSet = true;
        } else {
            Toast.makeText(this, "OpenGL ES 2.0 is not supported on this device", Toast.LENGTH_LONG).show();
        }

        setContentView(glSurfaceView);
    }

    private boolean isES2Supported() {
        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();

        return configurationInfo.reqGlEsVersion >= 0x20000;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(rendererSet) {
            glSurfaceView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(rendererSet) {
            glSurfaceView.onPause();
        }
    }
}

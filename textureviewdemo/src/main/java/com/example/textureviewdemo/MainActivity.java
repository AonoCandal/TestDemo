package com.example.textureviewdemo;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.TextureView;
import android.widget.FrameLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private TextureView.SurfaceTextureListener mySurfaceTextureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            mCamera = Camera.open();
            Camera.Size previewSize = mCamera.getParameters().getPreviewSize();
            textureView.setLayoutParams(new FrameLayout.LayoutParams(previewSize.width,previewSize.height, Gravity.CENTER));
            try {
                mCamera.setPreviewTexture(surface);
            } catch (IOException e) {
                e.printStackTrace();
            }
            mCamera.startPreview();
            textureView.setAlpha(1.0f);
            textureView.setRotation(90f);


        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            mCamera.stopPreview();
            mCamera.release();
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {

        }
    };
    private Camera mCamera;
    private TextureView textureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textureView = new TextureView(this);
        textureView.setSurfaceTextureListener(mySurfaceTextureListener);
        setContentView(textureView);
        System.out.println(BuildConfig.BASE_URL);
    }
}

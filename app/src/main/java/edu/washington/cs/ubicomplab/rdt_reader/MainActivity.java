package edu.washington.cs.ubicomplab.rdt_reader;

import static edu.washington.cs.ubicomplab.rdt_reader.Constants.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SettingDialogFragment.SettingDialogListener {

    private Button mExpDateButton;
    private Button mImageQualityButton;
    private Button mTestCamera2Button;
    private Button mSettingsyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("RDT Image Capture");

        mExpDateButton = findViewById(R.id.expdateButton);
        mImageQualityButton = findViewById(R.id.imagequalButton);
        mTestCamera2Button = findViewById(R.id.camera2TestButton);
        mSettingsyButton = findViewById(R.id.settingsButton);

        mExpDateButton.setOnClickListener(this);
        mImageQualityButton.setOnClickListener(this);
        mTestCamera2Button.setOnClickListener(this);
        mSettingsyButton.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    MY_CAMERA_REQUEST_CODE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                SettingDialogFragment dialog = new SettingDialogFragment();
                dialog.show(getFragmentManager(), "Setting Dialog");
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.expdateButton) {
            Intent intent = new Intent(this, ExpirationDateActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.imagequalButton) {
            Intent intent = new Intent(this, ImageQualityActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.camera2TestButton) {
            Intent intent = new Intent(this, Camera2TestActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.settingsButton) {
            SettingDialogFragment dialog = new SettingDialogFragment();
            dialog.show(getFragmentManager(), "Setting Dialog");
        }
    }

    @Override
    public void onClickPositiveButton() {
    }
}

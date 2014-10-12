package com.nishgtm.torch;

import android.support.v7.app.ActionBarActivity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;


public class MainActivity extends ActionBarActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Switch btn=(Switch) findViewById(R.id.switch1);
        
        btn.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			private Camera cam;

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				
				if(arg1){
					this.cam= Camera.open();
					Camera.Parameters p=this.cam.getParameters();
					p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
					this.cam.setParameters(p);
					this.cam.startPreview();
				}else{
					//Camera cam = Camera.open();
					//Camera.Parameters p=cam.getParameters();
					//p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
					//Camera cam=Camera.open();
					this.cam.stopPreview();
					this.cam.release();
				}
				
			}
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

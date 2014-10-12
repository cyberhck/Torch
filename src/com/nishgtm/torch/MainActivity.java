package com.nishgtm.torch;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;

import android.support.v7.app.ActionBarActivity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;


public class MainActivity extends ActionBarActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
			try{
			AdView av=(AdView)findViewById(R.id.adView);
			AdRequest ar=new AdRequest.Builder().build();
			av.loadAd(ar);
		}catch (Exception e){
			Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
		}

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
					this.cam.stopPreview();
					this.cam.release();
				}
				
			}
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

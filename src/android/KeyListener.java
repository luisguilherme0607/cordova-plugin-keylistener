package com.bool.cordova.plugin;
// The native Toast API
import android.widget.Toast;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.KeyEvent.Callback;
import android.content.Context;

public class KeyListener extends CordovaPlugin implements KeyEvent.Callback  {

    private CallbackContext buttonCallbackContext;
  
  @Override
   public boolean execute(String action, JSONArray args,
    final CallbackContext callbackContext) {

     Context context = cordova.getActivity().getApplicationContext();
        if(action.equals("startListening")) {

			Toast.makeText(cordova.getActivity(), "Started listening" , Toast.LENGTH_SHORT).show();

            this.buttonCallbackContext= callbackContext;
			//this.webView.getView().setOnKeyListener(this);

			PluginResult pluginResult= new PluginResult(PluginResult.Status.NO_RESULT);
			pluginResult.setKeepCallback(true);
			this.buttonCallbackContext.sendPluginResult(pluginResult);

            return true;
        } 
        if(action.equals("stopListening")){

            this.buttonCallbackContext= null;
			//this.webView.getView().setOnKeyListener(null);
            callbackContext.success();

            return true;
        }
        return false;

	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){

		Toast.makeText(cordova.getActivity(), keyCode, Toast.LENGTH_LONG ).show();
		return false;
	}

	public boolean onKeyMultiple(int keyCode, int count, KeyEvent event){
		return true;
	}

	public boolean onKeyLongPress(int keyCode, KeyEvent event){
		return true;
	}


	public boolean onKeyUp(int keyCode, KeyEvent event){
		return true;
	}

/*
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
		// Check if the event is equal to KEY_DOWN
		if( keyEvent.getAction() == KeyEvent.ACTION_DOWN )
        {

            Toast.makeText(cordova.getActivity(), keyEvent.getKeyCode() , Toast.LENGTH_SHORT).show();


            /*
			// Check what button has been pressed
			if( keyCode == KeyEvent.KEYCODE_VOLUME_UP ){

				// Create a new JSONObject with the information and send it
				JSONObject info= new JSONObject();
				try{
					info.put("signal", new String("volume-up"));
					sendSignal(info, true);
					return true;
				}
				catch(JSONException ex){
					Log.e(LOG, ex.getMessage());
				}
			}
			else if( keyCode == KeyEvent.KEYCODE_VOLUME_DOWN  ){
				// Create a new JSONObject with the information and send it
				JSONObject info= new JSONObject();
				try{
					info.put("signal", new String("volume-down"));
					sendSignal(info, true);
					return true;
				}
				catch(JSONException ex){
					Log.e(LOG, ex.getMessage());
				}
			}
			else if( keyCode == KeyEvent.KEYCODE_HEADSETHOOK  ){
				// Create a new JSONObject with the information and send it
				JSONObject info= new JSONObject();
				try{
					info.put("signal", new String("headset-hook"));
					sendSignal(info, true);
					return true;
				}
				catch(JSONException ex){
					Log.e(LOG, ex.getMessage());
				}
			}else{
				Log.d(LOG, "Unmapped key received: "+keyCode);
            }
		}
		
		return false;
	}
	*/
	

}




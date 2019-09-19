package almotech.co.androidtemplate.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveData {

    Context ctx;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    public SaveData(Context ctx1){
        this.ctx = ctx1;
        preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = preferences.edit();
    }

    public void clearAll(){
        editor.clear();
        editor.commit();
    }

    public void setUserData(String userToken){
        editor.putString("userData",userToken);
        editor.commit();
    }

    public String getUserData(){
        return preferences.getString("userData","");
    }
}

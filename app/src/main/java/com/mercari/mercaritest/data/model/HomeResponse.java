package com.mercari.mercaritest.data.model;


import android.app.Activity;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class HomeResponse {

    public String responseData(Activity activity){
        String json = null;
        try {
            InputStream is = activity.getAssets().open("all.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    public Response getResponse(Activity activity, Gson gson){
        Response responseData = null;
        InputStream is = null ;
        try {
        is = activity.getAssets().open("all.json");
        } catch (IOException ex) {
            ex.printStackTrace();
            is= null;
        }
        if(is==null) return responseData;


        return  gson.fromJson(new InputStreamReader(is),Response.class);


    }
}

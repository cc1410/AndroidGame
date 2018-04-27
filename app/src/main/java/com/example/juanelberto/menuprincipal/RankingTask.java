package com.example.juanelberto.menuprincipal;

import android.os.AsyncTask;

import com.example.juanelberto.menuprincipal.model.RankingResponse;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by chen on 14/02/2018.
 */

public class RankingTask extends AsyncTask<String, Void, RankingResponse> {

    @Override
    protected RankingResponse doInBackground(String... strings) {
        //String search = strings[0];
        try {
            //search = URLEncoder.encode(search, "UTF-8");
            String url = "http://stucom.flx.cat/game/api/game/1";
            InputStream is = (new URL(url)).openConnection().getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String json = "";
            String line;
            while ((line = reader.readLine()) != null) json += line; //Change to String Builder
            is.close();
            Gson gson = new Gson();
            return gson.fromJson(json,RankingResponse.class);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    protected void onPostExecute (RankingResponse rankingResponse){
        if(listener != null){
            listener.updated(rankingResponse);
        }
    }

    public interface OnRankingListener{
        void updated(RankingResponse rankingResponse);
    }

    private OnRankingListener listener;
    public void setOnRankingListener(OnRankingListener listener){
        this.listener = listener;
    }

}

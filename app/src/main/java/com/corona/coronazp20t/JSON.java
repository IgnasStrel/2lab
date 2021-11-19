package com.corona.coronazp20t;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class JSON {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static JSONArray getJSONArray(JSONObject json) throws JSONException {
        // removing from JSON all unnecessary information and leaving only covid19Stats array
        int jsonLength = json.toString().length();
        String margaritaStats = "{" + json.toString().substring(96, jsonLength) + "}";

        // String to JSONObject
        JSONObject jsonObject = new JSONObject(margaritaStats);
        //JSONObject to JSONArray
        JSONArray jsonArray = jsonObject.getJSONArray("margaritaStats");

        return jsonArray;
    }

    public static ArrayList<Margarita> getList(JSONObject json_data) throws JSONException {
        ArrayList<Margarita> margaritaList = new ArrayList<Margarita>();
        // Extract data from json and store into ArrayList as class objects
        //for (int i = 0; i < jsonArray.length(); i++){
        //JSONObject json_data = jsonArray.getJSONObject(i);
        Margarita margarita = new Margarita(
                json_data.getInt("id"),
                json_data.getString("name"),
                json_data.getString("tags"),
                json_data.getString("category"),
                json_data.getString("glass")

        );
        margaritaList.add(margarita);
        //}
        return margaritaList;
    }

    public static ArrayList<Margarita> getMargaritaListByName(ArrayList<Margarita> margaritaArrayList, String name) {
        ArrayList<Margarita> margaritaArrayList1 = new ArrayList<Margarita>();
        for (Margarita margarita : margaritaArrayList1) {
            if (margarita.getName().contains(name)) {
                margaritaArrayList1.add(margarita);
            }
        }
        return margaritaArrayList1;
    }

}

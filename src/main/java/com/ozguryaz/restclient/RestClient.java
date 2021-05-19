package com.ozguryaz.restclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ozguryaz.core.domain.Film;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RestClient {

    public List<Film> findAllFilmFromRest() {

        String jsonAsStr = "";

        try {

            URL url = new URL("http://localhost:5858/api/film/findAll");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            System.out.println("Output from Server .... \n");
            String str;
            while ((str = br.readLine()) != null) {
                jsonAsStr += str;
            }

            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().create();
        Type filmListType = new TypeToken<List<Film>>() {
        }.getType();
        List<Film> filmList = gson.fromJson(jsonAsStr, filmListType);
        return filmList;
    }
}

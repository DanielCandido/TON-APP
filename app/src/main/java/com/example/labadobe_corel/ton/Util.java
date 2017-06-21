package com.example.labadobe_corel.ton;

/**
 * Created by Lab. Adobe_Corel on 21/06/2017.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Willian on 21/06/2017.
 */

public class Util {

    public static String streamToString(InputStream is){
        BufferedReader br;
        StringBuilder sb = new StringBuilder();

        br = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while((line = br.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static User JSONToVendedor(String jsonFile){

        JSONObject mainObj;
        User user = new User();

        try {
            mainObj = new JSONObject(jsonFile);

            user = new User();

            user.setFristName(mainObj.getString("FIRSTNAME"));
            user.setLastName(mainObj.getString("LASTNAME"));
            user.setEmail(mainObj.getString("EMAIL"));
            user.setRg(mainObj.getString("RG"));
            user.setCpf(mainObj.getString("CPF"));
            user.setPhone(mainObj.getString("PHONE"));
            user.setCellphone(mainObj.getString("CELLPHONE"));
            user.setAndress(mainObj.getString("ANDRESS"));
            user.setCep(mainObj.getString("CEP"));
            user.setPassoword(mainObj.getString("PASSOWORD"));
            user.setProvaider(mainObj.getString("PROVAIDER"));
        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            return user;
        }
    }

}
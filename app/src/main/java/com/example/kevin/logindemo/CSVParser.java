package com.example.kevin.logindemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Nick on 2/26/2018.
 */

public class CSVParser {

    private InputStream inputStream;

    public CSVParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public ArrayList getShelters() {
        ArrayList<Shelter> shelterArrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            if (inputStream != null) {
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    shelterArrayList.add(new Shelter(line.split(",")));
                }
            }
        } catch (IOException e) {

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {

            }
        }
        return shelterArrayList;
    }
}

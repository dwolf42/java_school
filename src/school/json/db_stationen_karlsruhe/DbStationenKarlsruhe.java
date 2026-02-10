package school.json.db_stationen_karlsruhe;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.json.*;

public class DbStationenKarlsruhe {
	private static JSONObject jo;

	public DbStationenKarlsruhe() {
		try {
			// Das ganze JSON-File mache ich zu einem JSONObject
			/* step 1*/
			jo = new JSONObject(
				new JSONTokener(
					new FileReader("src/school/json/db_stationen_karlsruhe/DBStationen_Karlsruhe.json")));

			// Aus dem JSON-Object hole ich mir das JSONArray, das die Length von 1 hat.
			/* step 2*/
			JSONArray stopPlacesArr = jo.getJSONArray("stopPlaces");

			// Aus dem JSONArray an Index 0 hole ich mir das darin enthaltene JSONObject und nenne es haltestellenObj1
			/* step 3*/
			JSONObject haltestellenObj1 = stopPlacesArr.getJSONObject(0);

			// Aus dem JSONObject hole ich mir namentlich das JSONArray "availableTransports"
			/* step 4*/
			JSONArray availTransp = haltestellenObj1.getJSONArray("availableTransports");

			// Im aus dem JSONArray hole ich mir dann final das gewünschte 1. Element "CITY_TRAIN"
			/* step 5*/
			System.out.println(availTransp.get(0));
			for (Object obj : availTransp) {
				System.out.println(obj);
			}
			/*
			Step 1: Also, zuerst brauch ich eine Variable "JSONObject jo", dem ich per "JSONTokener" und "FileReader" den Inhalt der "JSON-Datei" zuweise.
			Step 2: Dann ist "stopPlaces" ein JSONArray in dem JSONObject, das weise ich der Variable "JSONArray stopPlacesArr" per "jo.getJSONArray("stopPlaces")" zu
			Step 3: Aus dem "JSONArray stopPlacesArr" hol ich mir dann den Index 0, was wiederum ein JSONObject ist und weise es der Variable "JSONObject haltestellenObj1"
			mit "stopPlacesArr.getJSONObject(0)" zu.
			Step 4: Aus dem "JSONObject haltestellenObj1" hol ich mir dann das JSONArray availableTransports, in dem ich der Variable "JSONArray availTransp" per
			"haltestellenObj1.getJSONArray("availableTransports")" das Array zuweise.
			*/

			langnamenAllerHaltestellen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void langnamenAllerHaltestellen() {

			JSONObject langNamen = (JSONObject) jo.query("/stopPlaces/0/names/DE/");
	}

	public static void main(String[] args) {
		new DbStationenKarlsruhe();
	}
}
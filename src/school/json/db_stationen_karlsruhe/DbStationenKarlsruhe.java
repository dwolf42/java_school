package school.json.db_stationen_karlsruhe;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.json.*;

public class DbStationenKarlsruhe {
	JSONObject jo;

	public DbStationenKarlsruhe() {
		try {
			// Hier hab ich ein JSONObject aus der JSON File erstellt
			jo = new JSONObject(
				new JSONTokener(
					new FileReader("src/school/json/db_stationen_karlsruhe/DBStationen_Karlsruhe.json")));

			System.out.println("jo.length(): " + jo.length());
			// System.out.println(jo.getNames());
			System.out.println("getNames(): " + Arrays.toString(JSONObject.getNames(jo)));

			// Ich will an das JSONObject "names" kommen
			System.out.println(jo.getJSONObject("names"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DbStationenKarlsruhe();
	}
}
package school.json.db_stationen_karlsruhe;

import java.io.FileReader;
import java.io.IOException;

import org.json.*;

public class DbStationenKarlsruhe {
	JSONObject jo;

	public DbStationenKarlsruhe() {
		try {
			jo = new JSONObject(
				new JSONTokener(
					new FileReader("src/school/json/db_stationen_karlsruhe/DBStationen_Karlsruhe.json")));
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

	public static void main(String[] args) {
		new DbStationenKarlsruhe();
	}
}
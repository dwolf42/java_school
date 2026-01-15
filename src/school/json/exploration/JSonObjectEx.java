package school.json.exploration;

import org.json.JSONObject;

import java.util.HashMap;

public class JSonObjectEx {
	public static void main(String[] args) {
		jsnObjToJsnString();
		jsnObjFromMap();
		jsnParse();
	}

	public static void jsnObjToJsnString() {
		// Creating a JSONObject and transform it into JSON string.
		JSONObject user = new JSONObject();
		user.put("name", "John Doe");
		user.put("occupation", "gardener");
		user.put("siblings", Integer.valueOf(2));
		user.put("height", Double.valueOf(172.35));
		user.put("married", Boolean.TRUE);

		var userJson = user.toString();

		System.out.println(userJson);
		// {"siblings":2,"occupation":"gardener","name":"John Doe","married":true,"height":172.34};
	}

	public static void jsnObjFromMap() {
		// Create a JSONObject from a Map
		HashMap<String, String> data = new HashMap<>();
		data.put("name", "John Doe");
		data.put("occupation", "gardener");
		data.put("siblings", "2");
		data.put("height", "172.35");
		data.put("married", "true");

		JSONObject user = new JSONObject(data);
		String userJson = user.toString();

		System.out.println("\n" + userJson);
	}

	public static void jsnParse() {
		// Parse JSON string to JSONObject
		String data = """
				{"name": "John Doe",
				"occupation": "gardener",
				"siblings": "2",
				"height": "172.35",
				"married": "true"}""";

		JSONObject user = new JSONObject(data);
		// Retrieve 3 objects
		System.out.println("\n" + user.get("name"));
		System.out.println(user.get("occupation"));
		System.out.println(user.get("siblings"));
	}
}

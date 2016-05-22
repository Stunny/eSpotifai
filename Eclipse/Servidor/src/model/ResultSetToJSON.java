package model;

import java.sql.ResultSet;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ResultSetToJSON {

	public static JsonArray convertToJSON(ResultSet resultSet) throws Exception {

		JsonArray jsonArray = new JsonArray();
		while (resultSet.next()) {
			int total_rows = resultSet.getMetaData().getColumnCount();
			JsonObject obj = new JsonObject();
			for (int i = 0; i < total_rows; i++) {
				obj.addProperty(resultSet.getMetaData().getColumnLabel(i + 1)
						.toLowerCase(), (String) resultSet.getObject(i + 1));
				jsonArray.add(obj);
			}
		}
		return jsonArray;
	}

}

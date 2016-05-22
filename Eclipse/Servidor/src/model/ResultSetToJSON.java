package model;

import java.sql.ResultSet;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
/**
 * Tradueix les respostes de la base de dades a JSON
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see JsonObject
 * @see JsonArray
 * @see database.DDBBConnection
 * @see database.DataBase
 *
 */
public class ResultSetToJSON {
	/**
	 * Traductor de les respostes de la base de dades en format <i>ResultSet</i> a JSON.
	 * @param resultSet
	 * @return JsonArray amb els objectes de la resposta de la base de dades
	 * @throws Exception
	 */
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


package main;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class RequestBuilder {
	/**
	 * @param El atributo request únicamente se utilizará en el momento en el que se quiera repetir
	 * 		una request.
	 */
	private String request;
	/**
	 * @param El atributo obj servirá para almacenar todos los objetos que se quieran pasar a JSON.
	 */
	private JsonArray obj;
	private String requestType;

	public RequestBuilder(){
		request = "";
		obj = null;
		requestType = "";
	}
	public RequestBuilder(String request){
		this.request = request;
	}

	public String getRequest(){
		return this.request;
	}
	public void setRequest(String request){
		this.request = request;
	}
	public JsonArray getObj() {
		return obj;
	}
	public void setObj(JsonArray obj) {
		this.obj = obj;
	}
	public void setrequestType(String r){
		requestType = r;
	}
	public String getRequestType(){
		return requestType;
	}

	public String validateUserRequest(String userName, String password) throws IOException{

		JsonObject user = new JsonObject();

		this.requestType = "validateUser";
		user.addProperty("userName", userName);
		user.addProperty("password", password);
		obj = null;
		obj = new JsonArray();
		obj.add(user);

		return this.build();
	}
	public String build() throws IOException{
		Gson gson = new Gson();
		JsonObject r = new JsonObject();

		r.addProperty("requestType", requestType);
		r.add("obj", obj);

		return (gson.fromJson(r, String.class));
	}

}

package com.comcast.crm.generic.fileutility;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonUtility 
{
	    public String getDataFromJsonFile(String key) throws IOException, ParseException {
        // Create a FileReader instance for the JSON file
        FileReader fileR = new FileReader("./configAppData/NewProject.json");
        
        // Create a JSONParser instance
        JSONParser jsonparser = new JSONParser();
        
        // Parse the file content into an Object
        Object obj = jsonparser.parse(fileR);
        
        // Convert the Object to a JSONObject
        JSONObject jsonObject = (JSONObject) obj;
        
        // Retrieve the value associated with the given key
        String data = (String) jsonObject.get(key);
        
        // Close the file reader
        fileR.close();
        
        // Return the retrieved data
        return data;
    }

}

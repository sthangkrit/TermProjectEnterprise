/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author sthang
 */
import static java.lang.Integer.parseInt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;


public class handle {
    
   public static String ParseJsonResponse(String select){
        try {
            String api = "";
            int doc = parseInt(select);
            switch(doc) {
                case 1:
                    api = "https://opend.data.go.th/get-ckan/datastore_search?resource_id=39e9ec41-8837-4341-97bd-d17aa1aa9e72";
//                    Top ten country/regional sources of visitors to ASEAN                    
                     break;

                case 2:
                    api = "https://opend.data.go.th/get-ckan/datastore_search?resource_id=f0c4c836-02eb-484b-9ea3-58c312f7160f";
                    //Unemployment rate
                    break;
            }
            URL url = new URL(api);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            //adding header
            httpURLConnection.setRequestProperty("api-key", "pAfII4I8qFlIJISJn0isAEwWIRabhbFH");

           String line = "";
            InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null){
                response.append(line);
            }
            bufferedReader.close();
            JSONObject json = new JSONObject(response.toString());
//            return json.toString(4);
            return json.getJSONObject("result").toString(4);
            //return json.getJSONObject("result").getJSONArray("records").toString(4);
//            return json.getJSONObject("result").getJSONArray("records").toString();
            //return json.getJSONObject("result").getJSONArray("records").optJSONObject(0).get("REGION_NAME").toString(); 
        }
        catch (Exception e){
            return "Error: " + e;
        }
    }
   
}


//{"total":10,"records":[
//                        {"2018":9.2,"2017":6.9,"2015":6.9,"2014":6.9,"2013":1.7,"2012":1.7,"Country":"Brunei Darussalam","2011":2.6,"_id":1}
//                        ,{"2018":1.1,"2017":0.2,"2015":0.5,"2014":0.2,"2013":0.3,"2012":0.2,"Country":"Cambodia","2011":0.2,"_id":2}
//                        ,{"2018":5.3,"2017":4.1,"2015":6.2,"2014":5.9,"2013":6.2,"2012":6.1,"Country":"Indonesia","2011":5,"_id":3}
//                        ,{"2018":0.6,"2017":0.7,"2015":1.9,"2014":1.9,"2013":1.9,"2012":1.4,"Country":"Lao PDR","2011":1.4,"_id":4}
//                        ,{"2018":3.3,"2017":3.4,"2015":3.2,"2014":2.9,"2013":3.1,"2012":3,"Country":"Malaysia","2011":3.1,"_id":5}
//                        ,{"2018":1,"2017":0.8,"2015":4,"2014":4,"2013":4,"2012":4,"Country":"Myanmar","2011":4,"_id":6}
//                        ,{"2018":5.4,"2017":2.7,"2015":6.5,"2014":6.7,"2013":6.4,"2012":6.8,"Country":"Philippines","2011":6.4,"_id":7}
//                        ,{"2018":2.9,"2017":1.8,"2015":2.8,"2014":2,"2013":2.9,"2012":2.8,"Country":"Singapore","2011":2.9,"_id":8}
//                        ,{"2018":1.1,"2017":0.9,"2015":0.8,"2014":0.8,"2013":0.7,"2012":0.7,"Country":"Thailand","2011":0.7,"_id":9}
//                        ,{"2018":2.2,"2017":2.1,"2015":2.3,"2014":2.1,"2013":3.6,"2012":3.2,"Country":"Vietnam","2011":2.3,"_id":10}]
//                        ,"_links":  
//                                {"next":"/api/3/action/datastore_search?offset=100&resource_id=f0c4c836-02eb-484b-9ea3-58c312f7160f","start":"/api/3/action/datastore_search?resource_id=f0c4c836-02eb-484b-9ea3-58c312f7160f"}
//                                ,"include_total":true,"resource_id":"f0c4c836-02eb-484b-9ea3-58c312f7160f","fields":
//                                    [{"id":"_id","type":"int"}
//                                    ,{"id":"Country","type":"text"}
//                                    ,{"id":"2011","type":"numeric"}
//                                    ,{"id":"2012","type":"numeric"}
//                                    ,{"id":"2013","type":"numeric"}
//                                    ,{"id":"2014","type":"numeric"}
//                                    ,{"id":"2015","type":"numeric"}
//                                    ,{"id":"2017","type":"numeric"}
//                                    ,{"id":"2018","type":"numeric"}
//                                ],"records_format":"objects"}
///////////////////////////////
//         TOC HW3           //
// 		  F74001137          //	
//////////////////////////////

import org.json.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class TocHw3 {
	public static void main(String[] args) {
		String json = new String();
		String line = new String();
		int price = 0;
		int count = 0;
        try {  
            URL url = new URL(args[0]);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));	
            while ((line = br.readLine()) != null) {
            	json += line;              
            }
            
            JSONTokener jsonParser = new JSONTokener(json);                
            JSONArray arr = new JSONArray(jsonParser);    
            int i;
            for (i=0 ; i<=10000000 ; i++ ){
            	if ( arr.getJSONObject(i).getString("鄉鎮市區").equals(args[1]) ){
            		if ( arr.getJSONObject(i).getString("土地區段位置或建物區門牌").indexOf(args[2]) != -1 && Integer.toString( arr.getJSONObject(i).getInt("交易年月") ).indexOf(args[3]) != -1 ){
            			price += arr.getJSONObject(i).getInt("總價元");
            			count++;
            			System.out.println(arr.getJSONObject(i).getString("鄉鎮市區") + '\t' + arr.getJSONObject(i).getString("土地區段位置或建物區門牌") + '\t' + arr.getJSONObject(i).getInt("交易年月") + '\t' + arr.getJSONObject(i).getInt("總價元") );           	
            		}
            	}
            }
            
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (JSONException e) {
        	if ( count!=0 ){
        		System.out.println( "Output:\t" + price/count );
        	}  
        }
	}
}

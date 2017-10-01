package Json;
//Classes necessárias

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Model.ModelAgendamento;
import TO.TOAgendamento;

public class JSONEventoCalendario {

	public String jsonCalendario;
	
	public JSONEventoCalendario(){
		
	}
		
	@SuppressWarnings("unchecked")
	public void fillCalendario(ArrayList<TOAgendamento> listaEvento) {
		
		//Cria um Objeto JSON
	
		JSONArray jsonArray = new JSONArray();
		
		FileWriter writeFile = null;
		
		for (int i = 0 ; i < listaEvento.size() ; i++){
			//Armazena dados em um Objeto JSON

			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("id", String.valueOf(listaEvento.get(i).getCodAgendamento()));
			jsonObject.put("title", listaEvento.get(i).getDataHoraComeco().toString());
			jsonObject.put("start", listaEvento.get(i).getDataHoraComeco().toString());
			jsonObject.put("end", listaEvento.get(i).getDataHoraFim().toString());
			
			jsonArray.add(jsonObject);
			
			try{
				writeFile = new FileWriter("fc-eventsTeste.json");
				//Escreve no arquivo conteudo do Objeto JSON
				writeFile.write(jsonArray.toJSONString());
				writeFile.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		//Imprimne na Tela o Objeto JSON para vizualização
		System.out.println("Json: " + jsonArray);
		
		jsonCalendario = jsonArray.toJSONString();
		
		System.out.println("String: " + jsonCalendario);
	}
	
}

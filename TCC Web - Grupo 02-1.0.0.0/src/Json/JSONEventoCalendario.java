package Json;
//Classes necessárias

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			//format.format(format.parse(rs.getString("dataAgendamentoComeco")))
			
			jsonObject.put("codAgendamento", String.valueOf(listaEvento.get(i).getCodAgendamento()));
			jsonObject.put("codMedico", String.valueOf(listaEvento.get(i).getCodMedico()));
			jsonObject.put("codPaciente", String.valueOf(listaEvento.get(i).getCodPaciente()));
			jsonObject.put("title", format.format(listaEvento.get(i).getDataHoraComeco()));
			jsonObject.put("start", format.format(listaEvento.get(i).getDataHoraComeco()));
			jsonObject.put("end", format.format(listaEvento.get(i).getDataHoraFim()));
			
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
		//System.out.println("Json: " + jsonArray);
		
		jsonCalendario = jsonArray.toJSONString();
		
		//System.out.println("String: " + jsonCalendario);
	}
	
}

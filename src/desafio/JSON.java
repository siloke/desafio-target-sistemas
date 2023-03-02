package desafio;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class JSON {
 
    public static void main(String[] args) {

        try {
            List<HashMap<String, Double>> dados = new ArrayList<HashMap<String, Double>>();
            String strDadosFaturamento;
            
            //Gson
            Gson gson = new Gson();
            TypeToken<List<HashMap<String, Double>>> tipoCollection = new TypeToken<List<HashMap<String, Double>>>() {};
            
            //Lê o arquivo dados.json.
            Path filePath = Path.of("dados.json");           
            strDadosFaturamento = Files.readString(filePath);
                        
            dados = gson.fromJson(strDadosFaturamento, tipoCollection);
      
            System.out.printf("Maior faturamento: %.2f\n", calculaMaiorFaturamento(dados));
            System.out.printf("Menor faturamento: %.2f\n", calculaMenorFaturamento(dados));
            System.out.printf("Media mensal: %.2f\n", calculaMediaFaturamento(dados));
            System.out.println("Quantidade de dias com faturamento superior à média mensal: " + calculaDias(dados));
            
        }
        catch(IOException e) {
            
            e.printStackTrace();
            
        }
  
    }
    
    static double calculaMaiorFaturamento(List<HashMap<String, Double>> dados) {
        double maiorFaturamento = 0;
        
        for (HashMap<String, Double> item : dados) {
            double valor = item.get("valor");
            
            maiorFaturamento = valor > maiorFaturamento ? valor : maiorFaturamento;
        }
        
        return maiorFaturamento;
    }
    
    static double calculaMenorFaturamento(List<HashMap<String, Double>> dados) {
        double menorFaturamento = dados.get(0).get("valor");
        
        for (HashMap<String, Double> item : dados) {
            double valor = item.get("valor");
            
            if (valor != 0) {
                menorFaturamento = valor < menorFaturamento ? valor : menorFaturamento;
            }
        }
        
        return menorFaturamento;
    }
    
    static double calculaMediaFaturamento(List<HashMap<String, Double>> dados) {        
        int count = 0;
        double soma = 0;
        
        for (HashMap<String, Double> item: dados) {
            double valor = item.get("valor");
            
            if (valor > 0) {
                soma += valor;
                count++;
            }
        }
        
        return soma / count;
    }
    
    static int calculaDias(List<HashMap<String, Double>> dados) {
        double mediaMensal = calculaMediaFaturamento(dados);
        int quantidadeDias = 0;
        
        for (HashMap<String, Double> item: dados) {
            double valor = item.get("valor");
            
            quantidadeDias = valor > mediaMensal ? ++quantidadeDias : quantidadeDias;
            
        }
        
        return quantidadeDias;
    
    }
}

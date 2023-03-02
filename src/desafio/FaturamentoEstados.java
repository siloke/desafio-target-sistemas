package desafio;

import java.util.HashMap;
import java.util.Map;

public class FaturamentoEstados {

    static double total = 0;
    
    public static void main(String[] args) {
        
        HashMap<String, Double> estados = new HashMap<String, Double>();
        
        estados.put("SP", 67.83643);
        estados.put("RJ", 36.67866);
        estados.put("MG", 29.22988);
        estados.put("ES", 27.16548);
        estados.put("Outros", 19.84953);
        
        for (Map.Entry<String, Double> i : estados.entrySet()){
            total = total + i.getValue();
        } 
        
        System.out.println("Valor total da distribuidora: " + total + "\n");
        
        for (Map.Entry<String, Double> i : estados.entrySet()){
            double resultado = calculaPercentual(i.getValue());
            System.out.print(i.getKey() + ": ");
            System.out.printf("%.2f%%\n", resultado);
        } 
        
        
    }
    
    static double calculaPercentual(double valor) {
        return (valor * 100) / total;
    }
    
}

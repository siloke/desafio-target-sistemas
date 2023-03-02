package desafio;

public class ReverterString {

    public static void main(String[] args) {
        
        String str = "Target Sistemas";      
       
        //Transforma a string em um array para facilitar acesso ao index.
        char[] strArray = str.toCharArray();
        
        int count = strArray.length;
        
        //Imprime a string.
        System.out.println(strArray);
        
        for (int i = 0; i < count; i++) {
            
            char temp = strArray[count - 1];
            strArray[count - 1] = strArray[i];
            strArray[i] = temp;
            count = count - 1;
        
        }
        
        //Imprime a string invertida.
        System.out.println(strArray);
    }
    
}

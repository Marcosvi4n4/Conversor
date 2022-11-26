import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class moedas {
    public static double last(String in, String out){
        try {
            String getmoeda = "https://economia.awesomeapi.com.br/last/" + in + "-" + out;
            URL url = new URL( getmoeda);//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader entrada = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(entrada);
            String output;
            StringBuffer json = new StringBuffer();
            while ((output = br.readLine()) != null) {
                json.append(output);
            }
            String[] jstring = json.toString().replace("(","").replace("{","").split(":");
            String[] septring = jstring[5].split(",");
            String dinheiro = septring[0];
            String cash = dinheiro.substring(1,dinheiro.length()-1);
            Double grana = Double.parseDouble(cash);
            conn.disconnect();
            return grana;

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            return -1;
        }
    }


    public String getSigla(String nomeMoeda){
        String sigla = "";
        if (nomeMoeda.equals("Dolar")){
            sigla = "USD";

        }else if (nomeMoeda.equals("Euro")){
            sigla = "EUR";
        }else if(nomeMoeda.equals("Real")){
            sigla = "BRL";
        } else if (nomeMoeda.equals("Bitcoin")) {
            sigla = "BTC";
        }

        return sigla;

    }
}


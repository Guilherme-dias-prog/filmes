package br.com.alura.screenmatch.Principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca="";
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        List<Titulo> titulos=new ArrayList<>();
        while(!busca.equalsIgnoreCase("sair")){
            System.out.println("qual filme deseja escolher ");
            busca = leitura.nextLine();
            if(busca.equalsIgnoreCase("sair")){
                break;
            }
            try {

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://www.omdbapi.com/?t="+busca+"&apikey=484b6e37"))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                String json= response.body();
                System.out.println(json);

                TituloOmdb meutTituloomdb=gson.fromJson(json, TituloOmdb.class);
                System.out.println(meutTituloomdb);
                //try{
                Titulo meutTitulo=new Titulo(meutTituloomdb);

                System.out.println("titulo ja convertido");
                System.out.println(meutTitulo);
                titulos.add(meutTitulo);
            }catch (NumberFormatException e){
                System.out.println("houve um erro");
                System.out.println(e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("erro de digitção");
            }
        }
        System.out.println(titulos);
        FileWriter escrita=new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();



    }
}

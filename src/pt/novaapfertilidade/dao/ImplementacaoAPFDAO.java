package pt.novaapfertilidade.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import pt.novaapfertilidade.apf.Parceiro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImplementacaoAPFDAO implements ApfDAO {
    private String armazenamento;

    public ImplementacaoAPFDAO(String armazenamento) {
        this.armazenamento = armazenamento;
    }

    @Override
    public List<Parceiro> getParceiros() {
        List<Parceiro> parceiros = new ArrayList<>();
        Gson gson = new GsonBuilder().create();
        JsonReader leitor;
        try {
            leitor = new JsonReader(new FileReader(armazenamento));
            JsonParser parser = new JsonParser();
            JsonElement elementoJson = parser.parse(leitor);

            if (elementoJson.isJsonArray())
                for (JsonElement elemento : elementoJson.getAsJsonArray()) {
                    parceiros.add(gson.fromJson(elemento, Parceiro.class));
                }
            else if (elementoJson.isJsonObject())
                parceiros.add(gson.fromJson(elementoJson.getAsJsonObject(), Parceiro.class));

            leitor.close();
        } catch (FileNotFoundException e) {
            System.err.print(e.getMessage());
        } catch (IOException e2) {
            System.err.print(e2.getMessage());
        }

        return null;
    }

    @Override
    public void setParceiros(List<Parceiro> parceiros) {
        Gson gson = new GsonBuilder().create();

        JsonWriter writer;
        try {
            writer = new JsonWriter(new FileWriter(armazenamento));
            gson.toJson(gson.toJsonTree(parceiros), writer);
            writer.close();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }

}

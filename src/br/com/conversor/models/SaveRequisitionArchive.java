package br.com.conversor.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveRequisitionArchive {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String date;
    private String hour;
    private String datehour;

    public void saveJson(CreateRequisitionArchive archive) throws IOException {
        this.date = archive.getDate();
        this.hour = archive.getHour();
        datehour = date + "-" + hour .replace(":", "-");
        FileWriter escrita = new FileWriter(datehour + ".json");
        escrita.write(gson.toJson(archive));
        escrita.close();
    }


    public void saveList(List<CreateRequisitionArchive> consult) {
    }
}

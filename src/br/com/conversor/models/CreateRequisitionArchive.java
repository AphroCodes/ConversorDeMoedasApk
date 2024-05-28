package br.com.conversor.models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateRequisitionArchive {
    private String inputCurrency;
    private String outputCurrency;
    private String value;
    private String date;
    private String hour;
    private String convertedValue;


    public void define(){
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        date = today.format(formatterDate);
        hour = today.format(formatterHora);
    }

    public String getInputCurrency() {
        return inputCurrency;
    }

    public String getOutputCurrency() {
        return outputCurrency;
    }

    public String getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public CreateRequisitionArchive(String inputCurrency, String outputCurrency, String value, String convertedValue) {
        this.inputCurrency = inputCurrency;
        this.outputCurrency = outputCurrency;
        this.value = value;
        define();
        this.date = getDate();
        this.hour = getHour();
        this.convertedValue = convertedValue;

    }



    @Override
    public String toString() {
        return "{Input: '" + inputCurrency + '\'' +
                ", Output: '" + outputCurrency + '\'' +
                ", Value: " + value + '\'' +
                ", Result: " + convertedValue + '}';
    }
}

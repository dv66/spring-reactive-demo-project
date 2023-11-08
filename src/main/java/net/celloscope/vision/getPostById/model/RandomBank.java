package net.celloscope.vision.getPostById.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.GsonBuilder;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RandomBank {
    private String id;
    private String uid;

    @JsonProperty("account_number")
    private String accountNumber;

    private String iban;

    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("routing_number")
    private String routingNumber;

    @JsonProperty("swift_bic")
    private String swiftBic;

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}

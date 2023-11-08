package net.celloscope.common.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ErrorResponse {

    @JsonProperty
    private String error;

    @JsonProperty
    private String message;

    @JsonProperty
    private int status;

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}

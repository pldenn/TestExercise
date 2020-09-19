package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class JsonObject {
    String status;
    String message;


    @Override
    public String toString() {
        return "JsonObject{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class JsonEntity {
    private String status;
    private String message;
}

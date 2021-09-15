package bek.dev.appsalessystem.payload;

import bek.dev.appsalessystem.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    @Enumerated(EnumType.STRING)
    private Status message;
    private Object object;
    private Integer number;
    private boolean success;

    public Result(Status message, Object object) {
        this.message = message;
        this.object = object;
    }

    public Result(Status message, Integer number) {
        this.message = message;
        this.number = number;
    }

    public Result(Status message, boolean success) {
        this.message = message;
        this.success = success;
    }
}

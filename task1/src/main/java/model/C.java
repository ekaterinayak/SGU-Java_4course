package model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public abstract class C {
    protected abstract D createD();

    public void sayHiFromD() {
        createD().sayHi();
    }
}

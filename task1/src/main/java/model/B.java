package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
    private A field;

    @Autowired
    public B(A field) {
        this.field = field;
    }
}

package gfg.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}

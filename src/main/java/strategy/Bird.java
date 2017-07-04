package strategy;

import strategy.interfaces.ItFlys;

public class Bird extends Animal {

    public void beRude() {
        System.out.println("You are fat, boy!");
    }

    public Bird() {
        super();

        setSound("Bloop");

        flyingType = new ItFlys();
    }
}

package strategy;

import strategy.interfaces.CantFly;

public class Dog extends Animal {
	public void digHole() {
		System.out.print("Dug a hole");
	}

	public Dog() {
		super();

		setSound("Bark");

		flyingType = new CantFly();
	}
}

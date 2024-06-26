package Boxing_Game;

public class Ring {
	Fighter f1;
	Fighter f2;
	int minWeight;
	int maxWeight;

	public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
		this.f1 = f1;
		this.f2 = f2;
		this.minWeight = minWeight;
		this.maxWeight = maxWeight;
	}

	public void run() {

		if (checkWeight()) {
			Fighter firstFighter = determineFirstFighter();
			Fighter secondFighter = (firstFighter == f1) ? f2 : f1;

			while (f1.health > 0 && f2.health > 0) {
				System.out.println("======== NEW ROUND ===========");
				secondFighter.health = firstFighter.hit(secondFighter);
				if (isWin()) {
					break;
				}
				firstFighter.health = secondFighter.hit(firstFighter);
				if (isWin()) {
					break;
				}
				printScore();
			}

		} else {
			System.out.println("The weights of the fighters do not match.");
		}
	}

	public boolean checkWeight() {
		return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
	}

	public boolean isWin() {
		if (f1.health == 0) {
			System.out.println("Winner of the match: " + f2.name);
			return true;
		} else if (f2.health == 0) {
			System.out.println("Winner of the match: " + f1.name);
			return true;
		}

		return false;
	}

	public void printScore() {
		System.out.println("------------");
		System.out.println(f1.name + " Remaining Health: " + f1.health);
		System.out.println(f2.name + " Remaining Health: " + f2.health);
	}

	public Fighter determineFirstFighter() {
		double randomValue = Math.random();
		if (randomValue < 0.5) {
			System.out.println(f1.name + " starts the fight!");
			return f1;
		} else {
			System.out.println(f2.name + " starts the fight!");
			return f2;
		}
	}
}

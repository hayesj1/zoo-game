package menagerie.objects.animals;

public class Animal {

	protected AnimalStats stats;
	protected float damage;

	public Animal(AnimalStats stats) {
		this.stats = stats;
		this.damage = 0.00f;
	}

	public boolean isDead() {
		return damage >= stats.getStat("HEALTH_POINTS");
	}

	public AnimalStats getStats() {
		return stats;
	}

	public float getDamage() {
		return damage;
	}

	public boolean receiveDamage(float damage) {
		damage -= stats.getStat("ARMOR");
		this.damage += Math.max(0.00f, damage);

		return damage >= stats.getStat("HEALTH_POINTS");
	}

	public boolean receiveHealth(float health) {
		this.damage -= Math.max(0.00f, health);

		return this.damage == 0.00f;
	}


}

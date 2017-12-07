package tests.menagerie.objects.animals;

import menagerie.objects.animals.Animal;
import menagerie.objects.animals.AnimalStats;
import org.junit.Test;
import util.TestUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnimalTest {

	private final float[] goodStats1 = new float[] { 2.00f, 0.00f, 10.00f, 3.00f, 0.50f, 0.25f };
	private final float[] goodStats2 = new float[] { 5.55f, 1.00f, 5.50f, 6.75f, 0.55f, 4.56f };
	private final float[] goodStats3 = new float[] { 5.55f, 0.00f, 50.00f, 6.75f, 0.55f, 4.56f };
	private final AnimalStats animalStats1 = new AnimalStats(goodStats1);
	private final AnimalStats animalStats2 = new AnimalStats(goodStats2);
	private final AnimalStats animalStats3 = new AnimalStats(goodStats3);

	@Test
	public void receiveDamage() {
		Animal a = new Animal(animalStats1);
		Animal b = new Animal(animalStats2);

		a.receiveDamage(1.00f);
		b.receiveDamage(3.00f);

		TestUtils.testEquals(1.00f, a.getDamage());
		TestUtils.testEquals(2.00f, b.getDamage());
	}

	@Test
	public void isDead() {
		Animal a = new Animal(animalStats1);
		Animal b = new Animal(animalStats2);
		Animal c = new Animal(animalStats3);

		a.receiveDamage(10.50f);
		b.receiveDamage(7.50f);
		c.receiveDamage(49.00f);

		assertTrue(a.isDead());
		assertTrue(b.isDead());

		assertFalse(c.isDead());

	}
}
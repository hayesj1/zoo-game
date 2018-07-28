package tests.menagerie.objects.animals;

import menagerie.objects.animals.AnimalStats;
import org.junit.Test;
import tests.util.TestUtils;


public class AnimalStatsTest {

	private final float[] goodStats = new float[] { 2.0f, 0.0f, 10.0f, 3.0f, 0.5f, 0.25f };
	private final float[] goodStats2 = new float[] { 5.55f, 2.50f, 5.50f, 6.75f, 0.55f, 4.56f };
	private final float[] outOfBoundsMinStats = new float[] { -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f };
	private final float[] outOfBoundsMaxStats = new float[] { 200.0f, 100.0f, 100.0f, 300.0f, 100.5f, 100.25f };
	private final float[] boundsMinStats = new float[] { 0.10f, 0.00f, 5.00f, 2.00f, 0.10f, 0.10f };
	private final float[] boundsMaxStats = new float[] { 10.00f, 9.00f, 50.00f, 10.00f, 0.90f, 10.00f };

	@Test
	public void getStats() {
		float[] actual = new AnimalStats(goodStats).getStats();
		TestUtils.testArrayEquals(goodStats, actual);

		actual = new AnimalStats(outOfBoundsMinStats).getStats();
		TestUtils.testArrayEquals(boundsMinStats, actual);

		actual = new AnimalStats(outOfBoundsMaxStats).getStats();
		TestUtils.testArrayEquals(boundsMaxStats, actual);
	}

	@Test
	public void getStat() {
		float actual = new AnimalStats(goodStats).getStat(0);
		TestUtils.testEquals(goodStats[0], actual);
		actual = new AnimalStats(outOfBoundsMinStats).getStat(2);
		TestUtils.testEquals(boundsMinStats[2], actual);

		actual = new AnimalStats(outOfBoundsMaxStats).getStat(4);
		TestUtils.testEquals(boundsMaxStats[4], actual);


		actual = new AnimalStats(goodStats).getStat("ARMOR");
		TestUtils.testEquals(goodStats[1], actual);

		actual = new AnimalStats(outOfBoundsMinStats).getStat("ARMOR_POINTS");
		TestUtils.testEquals(boundsMinStats[3], actual);

		actual = new AnimalStats(outOfBoundsMaxStats).getStat("FLAIR");
		TestUtils.testEquals(boundsMaxStats[5], actual);
	}

	@Test
	public void setStats() {
		AnimalStats animalStats = new AnimalStats(goodStats);
		animalStats.setStats(goodStats);
		float[] actual = animalStats.getStats();
		TestUtils.testArrayEquals(goodStats, actual);

		animalStats.setStats(outOfBoundsMinStats);
		actual = animalStats.getStats();
		TestUtils.testArrayEquals(boundsMinStats, actual);

		animalStats.setStats(outOfBoundsMaxStats);
		actual = animalStats.getStats();
		TestUtils.testArrayEquals(boundsMaxStats, actual);
	}

	@Test
	public void setStat() {
		AnimalStats animalStats = new AnimalStats(goodStats);
		animalStats.setStat(0, goodStats2[0]);
		float actual = animalStats.getStat(0);
		TestUtils.testEquals(goodStats2[0], actual);

		animalStats.setStat(2, outOfBoundsMinStats[2]);
		actual = animalStats.getStat(2);
		TestUtils.testEquals(boundsMinStats[2], actual);

		animalStats.setStat(4, outOfBoundsMaxStats[4]);
		actual = animalStats.getStat(4);
		TestUtils.testEquals(boundsMaxStats[4], actual);


		animalStats.setStat("ARMOR", goodStats2[1]);
		actual = animalStats.getStat("ARMOR");
		TestUtils.testEquals(goodStats2[1], actual);

		animalStats.setStat("ARMOR_POINTS", outOfBoundsMinStats[3]);
		actual = animalStats.getStat("ARMOR_POINTS");
		TestUtils.testEquals(boundsMinStats[3], actual);

		animalStats.setStat("FLAIR", outOfBoundsMaxStats[5]);
		actual = animalStats.getStat("FLAIR");
		TestUtils.testEquals(boundsMaxStats[5], actual);
	}
}
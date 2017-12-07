package menagerie.objects.animals;

public class AnimalStats {
	private static final int NUM_STATS = 6;
	private static float[][] bounds = new float[NUM_STATS][2];

	static {
		bounds[0][0] = 0.10f;
		bounds[0][1] = 10.00f;
		bounds[1][0] = 0.00f;
		bounds[1][1] = 9.00f;
		bounds[2][0] = 5.00f;
		bounds[2][1] = 50.00f;
		bounds[3][0] = 2.00f;
		bounds[3][1] = 10.00f;
		bounds[4][0] = 0.10f;
		bounds[4][1] = 0.90f;
		bounds[5][0] = 0.10f;
		bounds[5][1] = 10.00f;
	}

	private float ATTACK;
	private float ARMOR;
	private float HEALTH_POINTS;
	private float ARMOR_POINTS;
	private float ACCURACY;
	private float FLAIR;

	public AnimalStats() {
	}

	public AnimalStats(float[] values) {
		this.ATTACK = values[0];
		this.ARMOR = values[1];
		this.HEALTH_POINTS = values[2];
		this.ARMOR_POINTS = values[3];
		this.ACCURACY = values[4];
		this.FLAIR = values[5];

		ensureBoundsRespected();
	}

	public AnimalStats(float attack, float armor, float healthPoints, float armorPoints, float accuracy, float flair) {
		this.ATTACK = attack;
		this.ARMOR = armor;
		this.HEALTH_POINTS = healthPoints;
		this.ARMOR_POINTS = armorPoints;
		this.ACCURACY = accuracy;
		this.FLAIR = flair;

		ensureBoundsRespected();
	}

	public float[] getStats() {
		return new float[] { ATTACK, ARMOR, HEALTH_POINTS, ARMOR_POINTS, ACCURACY, FLAIR };
	}


	public void setStats(float[] newValues) {
		this.ATTACK = newValues[0];
		this.ARMOR = newValues[1];
		this.HEALTH_POINTS = newValues[2];
		this.ARMOR_POINTS = newValues[3];
		this.ACCURACY = newValues[4];
		this.FLAIR = newValues[5];

		ensureBoundsRespected();
	}

	public float getStat(int index) {
		float ret;
		switch (index) {
			case 0:
				ret = this.ATTACK;
				break;
			case 1:
				ret = this.ARMOR;
				break;
			case 2:
				ret = this.HEALTH_POINTS;
				break;
			case 3:
				ret = this.ARMOR_POINTS;
				break;
			case 4:
				ret = this.ACCURACY;
				break;
			case 5:
				ret = this.FLAIR;
				break;

			default:
				ret = -1;
				break;
		}
		return ret;
	}

	public float getStat(String name) {
		float ret;
		switch (name) {
			case "ATTACK":
				ret = this.ATTACK;
				break;
			case "ARMOR":
				ret = this.ARMOR;
				break;
			case "HEALTH_POINTS":
				ret = this.HEALTH_POINTS;
				break;
			case "ARMOR_POINTS":
				ret = this.ARMOR_POINTS;
				break;
			case "ACCURACY":
				ret = this.ACCURACY;
				break;
			case "FLAIR":
				ret = this.FLAIR;
				break;

			default:
				ret = -1;
				break;
		}
		return ret;
	}

	public void setStat(int index, float newValue) {
		switch (index) {
			case 0:
				this.ATTACK = newValue;
				break;
			case 1:
				this.ARMOR = newValue;
				break;
			case 2:
				this.HEALTH_POINTS = newValue;
				break;
			case 3:
				this.ARMOR_POINTS = newValue;
				break;
			case 4:
				this.ACCURACY = newValue;
				break;
			case 5:
				this.FLAIR = newValue;
				break;

			default:
				break;
		}

		ensureBoundsRespected();
	}

	public void setStat(String name, float newValue) {
		switch (name) {
			case "ATTACK":
				this.ATTACK = newValue;
				break;
			case "ARMOR":
				this.ARMOR = newValue;
				break;
			case "HEALTH_POINTS":
				this.HEALTH_POINTS = newValue;
				break;
			case "ARMOR_POINTS":
				this.ARMOR_POINTS = newValue;
				break;
			case "ACCURACY":
				this.ACCURACY = newValue;
				break;
			case "FLAIR":
				this.FLAIR = newValue;
				break;

			default:
				break;
		}

		ensureBoundsRespected();
	}

	private void ensureBoundsRespected() {
		float[] stats = getStats();
		for (int i = 0; i < NUM_STATS; i++) {
			if (stats[i] < bounds[i][0]) {
				setStat(i, bounds[i][0]);
			} else if (stats[i] > bounds[i][1]) {
				setStat(i, bounds[i][1]);
			}
		}
	}
}

package tests.genetics;

import genetics.Allele;
import genetics.AlleleGroup;
import genetics.IAllele;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings( { "unchecked" } )
public class AlleleGroupTest {
	@Test
	public void createAlleleGroup() {
		AlleleGroup<String> actualAG = new AlleleGroup<>();
		assertEquals(actualAG.toString(), "");
		assertEquals(AlleleGroup.DEFAULT_CAPACITY, actualAG.getCapacity());

		int testCapacity = 1;
		actualAG = new AlleleGroup<>(testCapacity);
		assertEquals(AlleleGroup.DEFAULT_CAPACITY, actualAG.getCapacity());

		testCapacity = AlleleGroup.DEFAULT_CAPACITY * 2;
		actualAG = new AlleleGroup<>(testCapacity);
		assertEquals(testCapacity, actualAG.getCapacity());

		IAllele[] testAlleles = { new Allele<>("A"), new Allele<>("B") };
		actualAG = new AlleleGroup<>(testAlleles);
		assertEquals("A,B,", actualAG.toString());
		assertEquals(AlleleGroup.DEFAULT_CAPACITY, actualAG.getCapacity());

		IAllele[] testAlleles2 = { new Allele<>("A"), new Allele<>("B"), new Allele<>("C"), new Allele<>("D") };
		actualAG = new AlleleGroup<>(testAlleles2);
		assertEquals("A,B,C,D,", actualAG.toString());
		assertEquals(testAlleles2.length * 2, actualAG.getCapacity());
	}

	@Test
	public void addAllele() {
		AlleleGroup<String> actualAG = new AlleleGroup<>();
		actualAG.addAllele(new Allele<>("A"));
		assertEquals("A,", actualAG.toString());

		actualAG.addAllele(null);
		assertEquals("A,", actualAG.toString());
	}

	@Test
	public void addAlleles() {
		IAllele[] testAlleles = { new Allele<>("A"), new Allele<>("B") };
		AlleleGroup<String> actualAG = new AlleleGroup<>();
		actualAG.addAlleles(testAlleles);
		assertEquals("A,B,", actualAG.toString());
	}

	@Test
	public void removeAllele() {
		IAllele[] testAlleles = { new Allele<>("A"), new Allele<>("B") };
		AlleleGroup<String> actualAG = new AlleleGroup<>(testAlleles);
		IAllele<String> rem = actualAG.removeAllele("A");
		assertEquals("B,", actualAG.toString());
		assertEquals("A", rem.getData());
	}

	@Test
	public void removeAlleles() {
		IAllele[] testAlleles = { new Allele<>("A"), new Allele<>("B"), new Allele<>("C") };
		String[] expectedRems = new String[] { "A", "C" };
		AlleleGroup<String> actualAG = new AlleleGroup<>(testAlleles);
		IAllele<String>[] rems = actualAG.removeAlleles(expectedRems);
		assertEquals("B,", actualAG.toString());

		for (int i = 0; i < rems.length; i++) {
			assertEquals(expectedRems[i], rems[i].getData());
		}
	}

	@Test
	public void pickAllele() {
		IAllele<String>[] testAlleles = new Allele[] { new Allele<>("A"), new Allele<>("B"), new Allele<>("C") };
		AlleleGroup<String> actualAG = new AlleleGroup<>(testAlleles);
		actualAG.setSeed(7L);
		IAllele ret = actualAG.pickAllele(null, null);
		//System.out.println(actualAG.find((String) ret.getData()));
		assertEquals(testAlleles[1], ret);

		ret = actualAG.pickAllele(testAlleles[0], null);
		assertEquals(testAlleles[0], ret);

		ret = actualAG.pickAllele(null, testAlleles[2]);
		assertEquals(testAlleles[2], ret);

		ret = actualAG.pickAllele(testAlleles[0], testAlleles[1]);
		System.out.println(actualAG.find((String) ret.getData()));
		assertEquals(testAlleles[0], ret);
	}
}

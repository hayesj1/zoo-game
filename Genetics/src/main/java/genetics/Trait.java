package genetics;

public class Trait<T extends Comparable<T>> implements ITrait<T> {

	private IAllele<T> allele;

	private AlleleGroup<T> possibleAlleles;

	@Override
	public AlleleGroup<T> getPossibleAlleles() {
		return this.possibleAlleles;
	}

	@Override
	public IAllele<T> getAllele() {
		return this.allele;
	}

	@Override
	public void setAllele(IAllele<T> newAllele) {
		this.allele = newAllele;
	}
}

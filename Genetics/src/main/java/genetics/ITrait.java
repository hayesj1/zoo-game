package genetics;

public interface ITrait<T extends Comparable<T>> {


	AlleleGroup<T> getPossibleAlleles();

	IAllele<T> getAllele();

	void setAllele(IAllele<T> newAllele);
}

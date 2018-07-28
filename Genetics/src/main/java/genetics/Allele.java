package genetics;

public class Allele<T> implements IAllele<T> {
	private T data;

	public Allele(T data) {
		this.data = data;
	}

	@Override
	public T getData() {
		return this.data;
	}

	private void setData(T newData) {
		this.data = newData;
	}
}

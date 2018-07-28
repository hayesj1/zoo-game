package genetics;

import java.util.Random;

@SuppressWarnings( { "unchecked" } )
public class AlleleGroup<T extends Comparable<T>> {
	public static final int DEFAULT_CAPACITY = 5;

	private IAllele<T>[] data;
	private int capacity;
	private int pos;
	private Random rand;

	public AlleleGroup() {
		this(DEFAULT_CAPACITY);
	}

	public AlleleGroup(int capacity) {
		if (capacity < DEFAULT_CAPACITY) {
			this.capacity = DEFAULT_CAPACITY;
		} else {
			this.capacity = capacity;
		}

		this.pos = 0;
		this.data = new IAllele[capacity];
		this.rand = new Random();
	}

	public AlleleGroup(IAllele[] alleles) {
		if (alleles.length * 2 < DEFAULT_CAPACITY) {
			this.capacity = DEFAULT_CAPACITY;
		} else {
			this.capacity = alleles.length * 2;
		}

		this.pos = alleles.length;
		this.data = new IAllele[this.capacity];
		System.arraycopy(alleles, 0, this.data, 0, alleles.length);
		this.rand = new Random();
	}

	public void addAllele(IAllele<T> allele) {
		if (allele == null) {
			return;
		}
		this.ensureCapacity();
		this.data[pos++] = allele;
	}

	public void addAlleles(IAllele<T>[] alleles) {
		for (IAllele<T> allele : alleles) {
			this.addAllele(allele);
		}
	}

	public IAllele<T> removeAllele(T data) {
		IAllele<T> ret = null;
		int index = this.find(data);
		if (index != -1) {
			ret = this.data[index];
			this.shiftData(-1, index);
		}
		return ret;
	}

	public IAllele[] removeAlleles(T[] data) {
		IAllele[] ret = new IAllele[data.length];
		int i = 0;
		for (T datum : data) {
			ret[i++] = this.removeAllele(datum);
		}

		return ret;
	}

	public int find(T data) {
		if (data.equals(this.data[0].getData())) {
			return 0;
		} else {
			return _find(data, this.pos / 2, 0);
		}
	}

	private int _find(T data, int index, int last_index) {
		if (index == 0 || index == pos || index == last_index) {
			return -1;
		}

		int res = data.compareTo(this.data[index].getData());
		if (res == 0) {
			return index;
		} else if (res > 0) {
			return _find(data, pos - ( index / 2 ), index);
		} else {
			return _find(data, index / 2, index);
		}
	}

	public IAllele<T> pickAllele(IAllele<T> parent0, IAllele<T> parent1) {
		if (parent0 == null && parent1 == null) { // pick from entire group
			int index = rand.nextInt(pos);
			return this.data[index];
		} else if (parent0 == null) { // pick parent1
			return parent1;
		} else if (parent1 == null) { // pick parent0
			return parent0;
		} else { // 50/50 between parent0 and parent1
			int index = rand.nextInt(2);
			return ( new IAllele[] { parent0, parent1 } )[index];
		}
	}

	private void ensureCapacity() {
		if (pos == capacity) {
			this.ensureCapacity(this.capacity * 2);
		}
	}

	private void ensureCapacity(int newCapacity) {
		if (newCapacity <= this.capacity) {
			return;
		}

		IAllele[] tmp = new IAllele[newCapacity];
		System.arraycopy(this.data, 0, tmp, 0, this.pos);
		this.data = tmp;
		this.capacity = newCapacity;
	}

	private void shiftData(int direction, int hole) {
		int update = 0;
		int start = 0;
		if (direction > 0) { // Shift right
			this.ensureCapacity();
			update = -1;
			start = pos - 1;
		} else { // Shift left
			update = 1;
			start = hole + 1;
		}

		for (int i = start; i < pos && i >= hole; i += update) {
			this.data[i - update] = this.data[i];
		}

		pos -= update;
	}

	@Override
	public String toString() {
		StringBuilder bldr = new StringBuilder(this.pos);
		for (int i = 0; i < pos; i++) {
			bldr.append(this.data[i].getData());
			bldr.append(',');
		}

		return bldr.toString();
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int newCapacity) {
		this.ensureCapacity(newCapacity);
	}

	public void setSeed(long seed) {
		this.rand.setSeed(seed);
	}
}

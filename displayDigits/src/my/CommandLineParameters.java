package my;

import java.util.List;

public class CommandLineParameters {

	private final List<Integer> values;
	private final int size;

	public CommandLineParameters(List<Integer> values, int size) {
		this.values = values;
		this.size = size;
	}
	
	public List<Integer> values() {
		return values;
	}
	
	public boolean areValid() {
		return !values.isEmpty();
	}

	@Override
	public boolean equals(Object anObject) {
		CommandLineParameters parameter = (CommandLineParameters) anObject;
		return values.equals(parameter.values) & size == parameter.size;
	}
	
	@Override
	public int hashCode() {
		return values.hashCode();
	}
	
	@Override
	public String toString() {
		return "[CommandLineParameters: values " + values + ", size " + size + " ]";
	}

	public int size() {
		return size;
	}


}

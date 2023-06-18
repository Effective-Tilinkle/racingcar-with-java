package step2;

import java.util.HashMap;
import java.util.Map;

public enum Operator {
	ADD("+") {
		public int apply(int x, int y) { return x + y; }
	},
	SUBTRACT("-") {
		public int apply(int x, int y) { return x - y; }
	},
	MULTIPLY("*") {
		public int apply(int x, int y) { return x * y; }
	},
	DIVIDE("/") {
		public int apply(int x, int y) {
			if (y != 0) {
				return x / y;
			} else {
				throw new IllegalArgumentException("Cannot divide by zero!");
			}
		}
	};

	private final String symbol;
	private static final Map<String, Operator> BY_SYMBOL = new HashMap<>();

	static {
		for (Operator op : values()) {
			BY_SYMBOL.put(op.symbol, op);
		}
	}

	Operator(String symbol) {
		this.symbol = symbol;
	}

	public abstract int apply(int x, int y);

	public static Operator getOperatorFromString(String symbol) {
		Operator operator = BY_SYMBOL.get(symbol);
		if (operator == null) {
			throw new IllegalArgumentException("Invalid operator!");
		}
		return operator;
	}

}

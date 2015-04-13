package webcalculator;

public class NumberOperation {
	private int operandOne;
	private int operandTwo;
	private String operation;
	private int result;
	
	public NumberOperation() {
	}
	
	public void setOperandOne(int operandOne) {
		this.operandOne = operandOne;
	}
	
	public void setOperandTwo(int operandTwo) {
		this.operandTwo = operandTwo;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
	
	public int getOperandOne() {
		return operandOne;
	}
	
	public int getOperandTwo() {
		return operandTwo;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public int getResult() {
		return result;
	}
	
	public void calculate(){
		if("ADD".equals(operation))
			this.result = operandOne + operandTwo;
		if("SUB".equals(operation))
			this.result = operandOne - operandTwo;
	}
	
}

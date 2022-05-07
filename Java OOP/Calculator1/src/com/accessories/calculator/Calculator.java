package com.accessories.calculator;

public class Calculator {

		private Double operandOne;
		private Double operandTwo;
		private char operation; 
		
		
		public Double getOperandOne() {
			return operandOne;
		}
		
		public void setOperandOne(Double operandOne) {
			this.operandOne = operandOne;
		}
		
		public Double getOperandTwo() {
			return operandTwo;
		}
		
		public void setOperandTwo(Double operandTwo) {
			this.operandTwo = operandTwo;
		}
		
		public char getOperation() {
			return operation;
		}
		
		public void setOperation(char operation) {
			this.operation = operation;
		}
		
		public Double performOperation() {
			Double result=0.0;
			Double x=getOperandOne();
			Double y=getOperandTwo();
			char oper=getOperation();
			if(oper=='+') {
				result=x+y;
			}
			else if(oper=='-') {
				result=x-y;
			}
			return result;
		}
		
		public void getResults() {
			double results=performOperation();
			System.out.println("the result is: "+results);
		}
		
		
}

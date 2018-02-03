package io.github.ekardnam.sertraline.data;

public class ArrayProvider implements DataProvider {

	protected double inputs[];
	
	protected double outputs[];
	
	protected int inputDim;
	
	protected int outputDim;
	
	protected int i;
	
	public ArrayProvider(double inputs[], double outputs[], int inputDim, int outputDim) {
		//do some input validation here
		//TODO improve the messages
		if (inputDim == 0 || outputDim == 0) throw new IllegalArgumentException("You have to have some inputs and outputs");
		if (inputs.length % inputDim != 0 || inputs.length == 0) throw new IllegalArgumentException("Inputs array has a wrong number of elements");
		if (outputs.length % outputDim != 0 || outputs.length == 0) throw new IllegalArgumentException("Outputs array has a wrong number of elements");
		
		//all good then
		this.inputs = inputs;
		this.outputs = outputs;
		this.inputDim = inputDim;
		this.outputDim = outputDim;
		i = 0;
	}
	
	public DataUnit getNext() {
		double input[] = new double[inputDim];
		double output[] = new double[outputDim];
		System.arraycopy(inputs, (i * inputDim) % inputs.length, input, 0, inputDim);
		System.arraycopy(outputs, (i * outputDim) % outputs.length, output, 0, outputDim);
		return new DataUnit(new Vector(inputDim, input), new Vector(outputDim, output));
	}

}

package application;

public class HiddenLayer {
	
	int hiddenSize,inputSize,i,j;
	double output[];
	double weights[][]; // weights from input to firsts layer

	public HiddenLayer(int inputSize, int hiddenSize) { //Constructor
			this.hiddenSize = hiddenSize;
			this.inputSize = inputSize;
			this.output = new double[hiddenSize]; // output
			this.weights = new double[inputSize][hiddenSize]; // weights from input to layer
			// Initialize weights randomly with values between -1 and 1
			for (i = 0; i < inputSize; i++) {
				for (j = 0; j < hiddenSize; j++) {
					weights[i][j] = (Math.random() * 2 - 1);
				}
			}
	}
}

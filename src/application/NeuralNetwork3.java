package application;

public class NeuralNetwork3 {

	private static final double LEARNING_RATE = 0.1;
	private static final int EPOCHS = 1000;

	private double[][] hiddenLayerError;

	public HiddenLayer[] layers;
	public int numberOfLayers;
	int[] layersSize;

	public NeuralNetwork3(int numberOfLayers,int[] layersSize) { //Constructor
		//layers = new HiddenLayer[]
		//create the layers
		this.numberOfLayers = numberOfLayers;
		this.layersSize = layersSize;
		layers = new HiddenLayer[numberOfLayers];
		for(int i =0;i<numberOfLayers;i++) {
			layers[i] = new HiddenLayer(layersSize[i],layersSize[i+1]);
			hiddenLayerError = new double [numberOfLayers][layersSize[i+1]];

		}
	}

	public double[] calculateLayer(double[] input, int layerSize, double weights[][]) {
		double[] output = new double[layerSize];
		int i,j;
		double weightedSum;
		for (i = 0; i < layerSize; i++) {
			weightedSum = 0;
			for (j = 0; j < input.length; j++) {
				weightedSum += input[j] * weights[j][i];
			}
			//output[i] = tanhx(weightedSum);
			output[i] = sigmoid(weightedSum);
			//output[i] = relu(weightedSum);
		}

		return output;
	}

	public void mutation() {
		// Calculate error for output layer
		double randomNumber = 0;
		for (int i = 0; i < numberOfLayers; i++) {
			for (int j = 0; j < layersSize[i]; j++) {
				for (int k = 0; k < layersSize[i+1]; k++) {
					randomNumber=(Math.random()*2 - 1)*0.01;
					if(Math.abs(layers[i].weights[j][k]+randomNumber)<1)
					{
						layers[i].weights[j][k] +=  randomNumber;
					}
				}
			}
		}
	}

	public double[] predict(double[] input) {
		int i;
		for(i=0;i<numberOfLayers;i++) {
			if(i==0) {
				// Calculate values of first layer

				layers[i].output = calculateLayer(input,layers[i].hiddenSize, layers[i].weights);
			}else {
				// Calculate values of others layers
				layers[i].output = calculateLayer(layers[i-1].output,layers[i].hiddenSize, layers[i].weights);
			}
		}
		return layers[numberOfLayers-1].output;
	}

	public double[][] updateWeights(double[] hidden1,HiddenLayer hidden2, double[] layerError) {
		int j,k;
		for (j = 0; j < hidden2.hiddenSize; j++) {
			for (k = 0; k < hidden1.length; k++) {
				hidden2.weights[k][j] += LEARNING_RATE * layerError[j] * hidden1[k];
			}
		}
		return hidden2.weights;

	}

	public double[] calculateError(HiddenLayer hidden1,HiddenLayer hidden2, double[] outputError) {
		int j,k;
		double error;
		double[] layerError = new double [hidden1.hiddenSize];
		for (j = 0; j < hidden1.hiddenSize; j++) {
			error = 0;
			for (k = 0; k < outputError.length; k++) {
				error += outputError[k] * hidden2.weights[j][k];
			}
			layerError[j] = sigmoidDerivative(hidden1.output[j]) * error;

		}
		return layerError;
	}


	public void train(double[][] inputs, double[][] targets) {

		int i,j,k,l;
		double error;

		for (int epoch = 0; epoch < EPOCHS; epoch++) {
			for (i = 0; i < inputs.length; i++) {
				layers[hiddenLayerError.length-1].output = predict(inputs[i]);

				// Calculate error for output layer
				error = 0;
				for (j = 0; j < layers[hiddenLayerError.length-1].output.length; j++) {
					error = targets[i][j] - layers[hiddenLayerError.length-1].output[j];
					hiddenLayerError[hiddenLayerError.length-1][j] = sigmoidDerivative(layers[hiddenLayerError.length-1].output[j]) * error;
					for (k = 0; k < layers[hiddenLayerError.length-2].hiddenSize; k++) {
						layers[hiddenLayerError.length-1].weights[k][j] += LEARNING_RATE * hiddenLayerError[hiddenLayerError.length-1][j] * layers[hiddenLayerError.length-2].output[k];
					}

				}
				for(l=hiddenLayerError.length-1;l>=2;l--) {
					// Calculate error for third layer
					hiddenLayerError[l-1] = calculateError(layers[l-1],layers[l], hiddenLayerError[l]);
					layers[l-1].weights = updateWeights( layers[l-2].output, layers[l-1], hiddenLayerError[l-1]);
				}

				// Calculate error for first layer
				hiddenLayerError[0] = calculateError(layers[0],layers[1], hiddenLayerError[1]);
				layers[0].weights = updateWeights( inputs[i], layers[0], hiddenLayerError[0]);
			}
		}
		//System.out.println(inputs.length);

		//for (i = 0; i < weights1[0].length; i++) {
		//System.out.println(weights1[0][i]);
		//}
	}
	public void train2(double[] input, double[] target) {

		int j,k,l;
		double error;

		for (int epoch = 0; epoch < EPOCHS; epoch++) {
			layers[hiddenLayerError.length-1].output = predict(input);

			// Calculate error for output layer
			error = 0;
			for (j = 0; j < layers[hiddenLayerError.length-1].output.length; j++) {
				error = target[j] - layers[hiddenLayerError.length-1].output[j];
				hiddenLayerError[hiddenLayerError.length-1][j] = sigmoidDerivative(layers[hiddenLayerError.length-1].output[j]) * error;
				for (k = 0; k < layers[hiddenLayerError.length-2].hiddenSize; k++) {
					layers[hiddenLayerError.length-1].weights[k][j] += LEARNING_RATE * hiddenLayerError[hiddenLayerError.length-1][j] * layers[hiddenLayerError.length-2].output[k];
				}

			}
			for(l=hiddenLayerError.length-1;l>=2;l--) {
				// Calculate error for third layer
				hiddenLayerError[l-1] = calculateError(layers[l-1],layers[l], hiddenLayerError[l]);
				layers[l-1].weights = updateWeights( layers[l-2].output, layers[l-1], hiddenLayerError[l-1]);
			}

			// Calculate error for first layer
			hiddenLayerError[0] = calculateError(layers[0],layers[1], hiddenLayerError[1]);
			layers[0].weights = updateWeights( input, layers[0], hiddenLayerError[0]);

		}
		//System.out.println(inputs.length);

		//for (i = 0; i < weights1[0].length; i++) {
		//System.out.println(weights1[0][i]);
		//}
	}

	public double verifyError(double[][] inputs, double[][] targets) {
		double totalError = 0.0;
		//int asciiDecimalCode1 = 0;
		//int asciiDecimalCode2 = 0;

		double[] output = new double [targets[0].length];
		for (int i = 0; i < inputs.length; i++) {
			output = predict(inputs[i]);
			for (int j = 0; j < output.length; j++) {
				//System.out.println(output[j]);
				totalError += Math.abs( output[j] - targets[i][j]);
			}
		}
		//System.out.println("error is " + totalError);
		return totalError;
	}
	private double sigmoidDerivative(double x) {
		return x * (1 - x);
	}
	private double relu(double x) {
		if(x<=0)
			x=0;
		return x;
	}
	private double reluDerivative(double x) {
		if(x<=0)
			x=0;
		return 1;	
	}
	private double tanhx(double x) {
		return Math.tanh(x);
	}

	private double sigmoid(double x) {
		return 1.0 / (1.0 + Math.exp(-x));
	}

}
package application;
public class Principal2 {

	private static void printOutput(double[] output) {
		// Convert the binary code to a decimal integer
		int asciiDecimalCode = 0;
		for (int j = 0; j < 8; j++) {
			//System.out.println(Math.round(output[j]));
			output[j]=Math.round(output[j]);
			asciiDecimalCode += (int) output[j] * Math.pow(2, 7 - j);
		}

		// Convert the decimal code to its corresponding character
		char asciiChar = (char) asciiDecimalCode;

		// Print the character to the console
		//System.out.print(Arrays.toString(inputs[i]) + " = ");
		System.out.println(asciiChar);// prints "A");
	}

	public static void main(String[] args) {
		double[][] inputs = {
				{
					0,0,0,1,1,0,0,0,
					0,0,1,0,0,1,0,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,1,1,1,1,1,1,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0
				},
				{
					0,1,1,1,1,1,0,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,1,1,1,1,1,0,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,1,1,1,1,1,0,0
				},
				{
					0,0,1,1,1,1,0,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,1,0,
					0,0,1,1,1,1,0,0
				},
				{
					0,1,1,1,1,0,0,0,
					0,1,0,0,0,1,0,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,1,0,0,
					0,1,1,1,1,0,0,0
				},
				{
					0,1,1,1,1,1,1,0,
					0,1,0,0,0,0,0,0,
					0,1,1,1,1,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,1,1,1,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,1,1,1,1,1,0
				},
				{
					0,1,1,1,1,1,1,0,
					0,1,0,0,0,0,0,0,
					0,1,1,1,1,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,1,1,1,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0
				},
				{
					0,0,1,1,1,1,0,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,1,1,1,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,0,1,1,1,1,0,0

				},
				{
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,1,1,1,1,1,1,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0,
					0,1,0,0,0,0,1,0

				},
				{
					0,0,1,1,1,1,0,0,
					0,0,0,1,0,0,0,0,
					0,0,0,1,0,0,0,0,
					0,0,0,1,0,0,0,0,
					0,0,0,1,0,0,0,0,
					0,0,0,1,0,0,0,0,
					0,0,0,1,0,0,0,0,
					0,0,1,1,1,1,0,0

				},
				{
					0,0,0,0,0,0,1,1,
					0,0,0,0,0,0,0,1,
					0,0,0,0,0,0,0,1,
					0,0,0,0,0,0,0,1,
					0,0,0,0,0,0,0,1,
					0,1,0,0,0,0,0,1,
					0,1,0,0,0,0,0,1,
					0,0,1,1,1,1,0,0
				},
				{
					0,1,0,0,0,1,0,0,
					0,1,0,0,1,0,0,0,
					0,1,0,1,0,0,0,0,
					0,1,1,0,0,0,0,0,
					0,1,0,1,0,0,0,0,
					0,1,0,0,1,0,0,0,
					0,1,0,0,0,1,0,0,
					0,1,0,0,0,0,1,0

				},
				{
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,1,1,1,1,1,0

				},
				{
					1,0,0,0,0,0,0,1,
					1,1,0,0,0,1,1,1,
					1,0,1,0,1,0,0,1,
					1,0,0,1,0,0,0,1,
					1,0,0,0,0,0,0,1,
					1,0,0,0,0,0,0,1,
					1,0,0,0,0,0,0,1,
					1,0,0,0,0,0,0,1
				}

		};

		double[][] targets = {
				{0,1,0,0,0,0,0,1},	
				{0,1,0,0,0,0,1,0}, 	
				{0,1,0,0,0,0,1,1}, 	
				{0,1,0,0,0,1,0,0}, 	
				{0,1,0,0,0,1,0,1}, 	
				{0,1,0,0,0,1,1,0}, 	
				{0,1,0,0,0,1,1,1}, 	
				{0,1,0,0,1,0,0,0}, 	
				{0,1,0,0,1,0,0,1}, 	
				{0,1,0,0,1,0,1,0}, 	
				{0,1,0,0,1,0,1,1}, 	
				{0,1,0,0,1,1,0,0}, 	
				{0,1,0,0,1,1,0,1} 
		};

		int [] layersSize = {64,25,15,15,10,8};
		double error = 0;
		NeuralNetwork3 neuralNetwork = new NeuralNetwork3(5,layersSize);

		for (int i = 0; i < 100; i++) {
			neuralNetwork.train(inputs, targets);
		}
		error = neuralNetwork.verifyError(inputs, targets);
		System.out.println("Total error is:" + error);

		/*
		for (int j = 0; j < neuralFamilyMember[position].layersSize[neuralFamilyMember[position].numberOfLayers-1]; j++) {
			for (int k = 0; k < neuralFamilyMember[position].layersSize[neuralFamilyMember[position].numberOfLayers]; k++) {
				System.out.println(neuralFamilyMember[position].layers[neuralFamilyMember[position].numberOfLayers-1].weights[j][k]);
			}

		}
		 */

		for (int i = 0; i < inputs.length; i++) {
			printOutput(neuralNetwork.predict(inputs[i]));
		}
		double[][] inputs2 = {
				{
					1,0,0,1,1,0,0,0,
					1,0,1,0,0,1,0,0,
					1,1,0,0,0,0,1,0,
					1,1,0,0,0,0,1,0,
					0,0,0,0,0,1,1,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,0,0,0,0,
					0,1,0,0,1,1,1,0
				}};
		printOutput(neuralNetwork.predict(inputs2[0]));

	}
}

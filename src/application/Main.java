package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

	public Main() {
		// Add any initialization code here
	}

	private static final int CIRCLE_RADIUS = 5;
	private static final int COLUMN_SPACING = 140;
	private static final int ROW_SPACING = 35;
	private static final double MAX_LINE_WIDTH = 0.1;

	/*
    private int numColumns = 5;
    private int[] numElementsPerColumn = {6, 2, 3, 7, 8};

	 */
	private double[][][] weights = {
			{{0.5, 0.2, 0.4, 0.1, 0.6, 2.3},{0.5, 0.2, 0.4, 0.1, 0.6, 0.3}},
			{{0.8, 0.6},{0.8, 0.6},{0.8, 0.6}},
			{{0.3, 0.9, 0.2},{0.3, 0.9, 0.2},{0.3, 0.9, 0.2},{0.3, 0.9, 0.2},{0.3, 0.9, 0.2},{0.3, 0.9, 0.2},{0.3, 0.9, 0.2}},
			{{0.5, 0.1, 0.2, 0.8, 0.4, 0.7, 0.6},{0.5, 0.1, 0.2, 0.8, 0.4, 0.7, 0.6},{0.5, 0.1, 0.2, 0.8, 0.4, 0.7, 0.6},
				{0.5, 0.1, 0.2, 0.8, 0.4, 0.7, 0.6},{0.5, 0.1, 0.2, 0.8, 0.4, 0.7, 0.6},{0.5, 0.1, 0.2, 0.8, 0.4, 0.7, 0.6},{0.5, 0.1, 0.2, 0.8, 0.4, 0.7, 0.6},{0.5, 0.1, 0.2, 0.8, 0.4, 0.7, 0.6}}
	};


	private static int numColumns = 7;
	private static int[] numElementsPerColumn = {64,15,15,15,15,20,8};

	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();

		double centerX = COLUMN_SPACING + CIRCLE_RADIUS;
		double centerY = ROW_SPACING + CIRCLE_RADIUS;

		Circle[][] circles = new Circle[numColumns][];
		for (int col = 0; col < numColumns; col++) {
			circles[col] = new Circle[numElementsPerColumn[col]];
			for (int row = 0; row < numElementsPerColumn[col]; row++) {
				Circle circle = new Circle(centerX, centerY, CIRCLE_RADIUS, Color.BLACK);
				root.getChildren().add(circle);
				circles[col][row] = circle;
				centerY += ROW_SPACING;
			}
			centerX += COLUMN_SPACING;
			centerY = ROW_SPACING + CIRCLE_RADIUS;
		}

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

		NeuralNetwork3 neuralNetwork = new NeuralNetwork3(numColumns-1,numElementsPerColumn);

		//for (int i = 0; i < 100; i++) {

		//neuralNetwork.train(inputs, targets);
		//}

		for (int col = 0; col < numColumns - 1; col++) {
			for (int row1 = 0; row1 < numElementsPerColumn[col]; row1++) {
				Circle circle1 = circles[col][row1];
				double x1 = circle1.getCenterX();
				double y1 = circle1.getCenterY();
				for (int row2 = 0; row2 < numElementsPerColumn[col + 1]; row2++) {
					Circle circle2 = circles[col + 1][row2];
					double x2 = circle2.getCenterX();
					double y2 = circle2.getCenterY();

					//double weight = weights[col][row2][row1];  
					double weight = 1;  


					Line line = new Line(x1, y1, x2, y2);
					line.setStrokeWidth(MAX_LINE_WIDTH * weight);
					root.getChildren().add(line);
				}
			}
		}
		
		
		Scene scene = new Scene(root, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				
				neuralNetwork.train(inputs, targets);
				
				for (int col = 0; col < numColumns - 1; col++) {
					for (int row1 = 0; row1 < numElementsPerColumn[col]; row1++) {
						Circle circle1 = circles[col][row1];
						double x1 = circle1.getCenterX();
						double y1 = circle1.getCenterY();
						for (int row2 = 0; row2 < numElementsPerColumn[col + 1]; row2++) {
							Circle circle2 = circles[col + 1][row2];
							double x2 = circle2.getCenterX();
							double y2 = circle2.getCenterY();

							//double weight = weights[col][row2][row1];  
							double weight = neuralNetwork.layers[col].weights[row1][row2];  


							Line line = new Line(x1, y1, x2, y2);
							line.setStrokeWidth(MAX_LINE_WIDTH * weight);
							root.getChildren().add(line);
						}
					}
				}


				//error = neuralNetwork.verifyError(inputs, targets);
				//System.out.println("Total error is:" + error);
				
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
		};
		timer.start();








	}
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


		launch(args);
	}
}
# NeuralNetwork

A visual interpretation of a neural network using JavaFX.  
This project demonstrates and visualizes the structure, weight calculations, and behaviors of a feedforward neural network (FNN) with multiple layers and many neurons per layer.

---

## Features

- **Feedforward Neural Network (FNN):**  
  Supports arbitrary numbers of layers and neurons per layer, with customizable topology.

- **Visualization:**  
  JavaFX-based interactive visual display of neurons (nodes) and their weighted connections.

- **Weight Calculation & Mutation:**  
  Implements logic for forward propagation, weight updates (including mutation for experimentation), and error calculation.

- **Example Data & Output:**  
  Includes example input data and output decoding, demonstrating the FNN's ability to process and interpret patterns.

---

## Screenshots

<!-- If you have screenshots, add them here! Example: -->
<!-- ![Neural Network Visualization](images/screenshot1.png) -->

---

## Getting Started

### Requirements

- Java 17 or higher
- JavaFX SDK (compatible with your Java version)
- (Optional) Eclipse IDE (for `.settings` compatibility)

### Running the Project

1. **Clone the repository:**
   ```bash
   git clone https://github.com/victorhkr/NeuralNetwork.git
   cd NeuralNetwork
   ```

2. **Compile and Run (CLI):**
   Ensure JavaFX is on your module path. Example:
   ```bash
   javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls -d out src/application/*.java src/module-info.java
   java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls -cp out application.Main
   ```

3. **Run in IDE:**
   - Import the project as a Java project.
   - Set up JavaFX libraries in your run configuration.
   - Run `application.Main`.

---

## Project Structure

```
src/
  application/
    Main.java           # JavaFX entry point, draws and animates network visualization
    NeuralNetwork3.java # FNN implementation: layers, weights, propagation, mutation
    HiddenLayer.java    # Single hidden layer representation with weights and outputs
    Principal2.java     # Example/test class for input/output workflow
    application.css     # (Optional) JavaFX styling
  module-info.java      # Java module descriptor for JavaFX
.settings/              # Eclipse project settings (optional)
```

---

## How It Works

### Network Topology

- **Flexible Layers:**  
  The number and size of layers are set via arrays, e.g.:
  ```java
  private static int numColumns = 7;
  private static int[] numElementsPerColumn = {64, 15, 15, 15, 15, 20, 8};
  ```
- **Weights:**  
  Each layer's weights are initialized randomly (`HiddenLayer.java`) and updated during training or via mutation (`NeuralNetwork3.java`).

### Forward Propagation

- Inputs are fed through each layer in sequence using weighted sums and an activation function (e.g., sigmoid).
- Outputs of the last layer represent the network's prediction.

### Visualization

- Each neuron is drawn as a circle.
- Connections (weights) are drawn as lines, with properties (e.g., width/color) representing weight magnitude.
- Visualization logic is handled in `Main.java` using JavaFX's graphics primitives.

### Example Usage

- Run `Principal2.java` for console-based demonstrations (e.g., decoding output to ASCII).

---

## Contributing

Pull requests and issues are welcome!  
For major changes, please open an issue first to discuss what you would like to change.

---

## License

[MIT License](LICENSE)  
(c) victorhkr

---

## References

- JavaFX documentation: https://openjfx.io/
- Feedforward neural network concepts: [Wikipedia](https://en.wikipedia.org/wiki/Feedforward_neural_network)

---

*This project is for educational and visualization purposes. Contributions and suggestions are encouraged!*

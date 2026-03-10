package com.josh.ai;

/**
 * Perceptron - Simple Neural Network
 * 
 * A Perceptron is the basic building block of neural networks.
 * It learns to classify inputs into two categories.
 */
public class Perceptron {
    private double[] weights;
    private double bias;
    private double learningRate;
    
    // Constructor
    public Perceptron(int inputSize, double learningRate) {
        this.learningRate = learningRate;
        this.weights = new double[inputSize];
        
        // Initialize weights randomly
        for (int i = 0; i < inputSize; i++) {
            weights[i] = Math.random() - 0.5;
        }
        bias = Math.random() - 0.5;
    }
    
    // Activation function (step function)
    private int activate(double x) {
        return x >= 0 ? 1 : 0;
    }
    
    // Predict output for given inputs
    public int predict(double[] inputs) {
        double sum = bias;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        return activate(sum);
    }
    
    // Train the perceptron
    public void train(double[][] trainingData, int[] labels, int epochs) {
        for (int e = 0; e < epochs; e++) {
            for (int i = 0; i < trainingData.length; i++) {
                double[] inputs = trainingData[i];
                int label = labels[i];
                
                // Calculate error
                int prediction = predict(inputs);
                int error = label - prediction;
                
                // Update weights and bias
                for (int j = 0; j < inputs.length; j++) {
                    weights[j] += learningRate * error * inputs[j];
                }
                bias += learningRate * error;
            }
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("\n<🎇 По– Perceptron - Simple Neural Network");
        System.out.println("===================================\n");
        
        // Create a perceptron with 2 inputs
        Perceptron p = new Perceptron(2, 0.1);
        
        // Training data for AND gate
        double[][] trainingData = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
        };
        int[] labels = {0, 0, 0, 1}; // AND gate
        
        // Train
        System.out.println("Training...");
        p.train(trainingData, labels, 100);
        System.out.println("Training complete!\n");
        
        // Test
        System.out.println("Testing AND gate:");
        for (int i = 0; i < trainingData.length; i++) {
            double[] input = trainingData[i];
            int result = p.predict(input);
            System.out.println("  " + input[0] + " AND " + input[1] + " = " + result);
        }
    }
}

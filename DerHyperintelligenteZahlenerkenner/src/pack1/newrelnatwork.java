package pack1;

import java.util.Random;

public class newrelnatwork {

	double[][] neuron, bias;
	double[][][] weight;

	public newrelnatwork(int... layers) {

		neuron = new double[layers.length][];
		for (int i = 0; i < neuron.length; i++) {
			neuron[i] = new double[layers[i]];
		}

		bias = new double[layers.length - 1][];
		for (int i = 0; i < bias.length; i++) {
			bias[i] = new double[layers[i + 1]];
		}

		weight = new double[layers.length - 1][][];
		for (int i = 0; i < weight.length; i++) {
			weight[i] = new double[layers[i + 1]][layers[i]];
		}
	}

	public static void main(String[] args) {
		newrelnatwork n = new newrelnatwork(28 * 28, 16, 16, 10);
		n.fillRandomly();
	}

	public double sigmoid(double x) {
		return (1 / (1 + Math.pow(Math.E, -x)));
	}

	public double calculateNeuron(double bias, double[] neuron, double[] weight) {
		double erg = 0;
		for (int i = 0; i < neuron.length; i++) {
			erg += weight[i] * neuron[i];
		}
		return sigmoid(erg + bias);
	}

	public void calculateNeurons() {
		for (int i = 1; i < neuron.length; i++) {
			for (int j = 0; j < neuron[i].length; j++) {
				neuron[i][j] = calculateNeuron(bias[i - 1][j], neuron[i - 1], weight[i - 1][j]);
			}
		}
	}

	public void setInput(double[] n) {
		neuron[0] = n;
	}

	public void fillRandomly() {

		Random r = new Random();

		for (int i = 0; i < bias.length; i++) {
			for (int j = 0; j < bias[i].length; j++) {
				bias[i][j] = r.nextDouble();
			}
		}

		for (int i = 0; i < weight.length; i++) {
			for (int j = 0; j < weight[i].length; j++) {
				for (int k = 0; k < weight[i][j].length; k++) {
					weight[i][j][k] = r.nextDouble();
				}
			}
		}
	}

	public double[] backprop(double[] opt, int layer) {
		double[] newOpt = new double[neuron[layer - 1].length];
		for (int i = 0; i < neuron[layer].length; i++) {
			bias[layer][i] += opt[i];
			for (int j = 0; j < weight[layer - 1][i].length; j++) {
				weight[layer - 1][i][j] += (neuron[layer - 1][j] > 0.5 ? opt[i] : -opt[i]);
			}
			for (int j = 0; j < neuron[layer - 1].length; j++) {
				newOpt[j] += weight[layer - 1][i][j] * opt[j];
			}
			newOpt[i] /= newOpt.length;
		}
		
		return newOpt;
	}

}

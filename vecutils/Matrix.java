package vecutils;

public class Matrix {
	private int[][] items;
	private int rows, columns;
	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.items = new int[rows][columns];
	}
	public int getItem(int rows, int columns) {
		return items[rows][columns];
	}
	public void setItem(int rows, int columns, int value) {
		items[rows][columns] = value;
	}
	public void copy(Matrix b) {
		for (int row = 0; row < this.rows; row++) {
			for (int column = 0; column < this.columns; column++) {
				items[row][columns] = b.items[rows][columns];
			}
		}
	}
	public void add(Matrix b) {
		for (int row = 0; row < this.rows; row++) {
			for (int column = 0; column < this.columns; column++) {
				items[row][columns] += b.items[rows][columns];
			}
		}
	}
	public void sub(Matrix b) {
		for (int row = 0; row < this.rows; row++) {
			for (int column = 0; column < this.columns; column++) {
				items[row][columns] -= b.items[rows][columns];
			}
		}
	}
}

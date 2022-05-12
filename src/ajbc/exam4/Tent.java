package ajbc.exam4;

public class Tent {
	protected int numOfPeople;
	protected double width;
	protected double length;
	protected double height;

	public Tent(int numOfPeople, double width, double length, double height) {
		super();
		this.numOfPeople = numOfPeople;
		this.width = width;
		this.length = length;
		this.height = height;
	}

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Tent [numOfPeople=" + numOfPeople + ", width=" + width + ", length=" + length + ", height=" + height
				+ "]";
	}

}

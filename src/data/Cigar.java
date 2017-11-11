package data;

public class Cigar {
	private String name;
	private String brand;
	private WrapperType wrapper;
	private Shape shape;
	private int amount;
	
	public Cigar() {
		
	}
	public Cigar(String name, String brand, WrapperType wrapper, Shape shape) {
		super();
		this.name = name;
		this.brand = brand;
		this.wrapper = wrapper;
		this.shape = shape;
		amount = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public WrapperType getWrapper() {
		return wrapper;
	}

	public void setWrapper(WrapperType wrapper) {
		this.wrapper = wrapper;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}

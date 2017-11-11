package data;

public class Cigar {
	private String name;
	private String brand;
	private WrapperType wrapper;
	private Shape shape;
	
	public Cigar(String name, String brand, WrapperType wrapper, Shape shape) {
		super();
		this.name = name;
		this.brand = brand;
		this.wrapper = wrapper;
		this.shape = shape;
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
	
}

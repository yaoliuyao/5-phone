package nfit.phone.bean;

public class Phone {
	private int id;
	private String name;
	private float price;
	
	// 构造器
	public Phone () {
		// 如果有其他的构造器的话，这个空的不能省 new Phone()
	}
	public Phone(String name, float price) {
		// new Phone(name, price);
		super();
		this.name = name;
		this.price = price;
	}

	// getter/setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}

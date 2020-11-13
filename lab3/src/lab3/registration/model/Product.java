package lab3.registration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
//	@Id
	/*@GeneratedValue
	private long id;*/
	@Id
	@Column(name = "barcode", unique = true)
	protected int barcode;
	
	@Column(name = "name")
	protected String name;
	
	@Column(name = "colour")
	protected String colour;
	
	@Column(name = "decription")
	protected String description;
	
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
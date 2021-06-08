package motyl.valueobject;

import java.io.Serializable;

public class SpeciesValueObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String cientificName;
	private String commonName;
	private String color;
	private String size;
	private int food;
	private String img;
	private int idPlant;
	private String namePlant;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCientificName() {
		return cientificName;
	}
	public void setCientificName(String cientificName) {
		this.cientificName = cientificName;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getIdPlant() {
		return idPlant;
	}
	public void setIdPlant(int idPlant) {
		this.idPlant = idPlant;
	}
	public String getNamePlant() {
		return namePlant;
	}
	public void setNamePlant(String namePlant) {
		this.namePlant = namePlant;
	}

}

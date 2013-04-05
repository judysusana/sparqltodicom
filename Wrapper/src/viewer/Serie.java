package viewer;

import java.io.Serializable;

public class Serie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3552313672813868521L;
	private String modality;
	private String manufacturer;
	private String description;
	private String bodyPartExamined;
	private String uid;
	private int number;
	private int relatedInstances;
	
	
	
	public Serie() {
		// TODO Auto-generated constructor stub
	}
	public String getModality() {
		return modality;
	}
	public void setModality(String modality) {
		this.modality = modality;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBodyPartExamined() {
		return bodyPartExamined;
	}
	public void setBodyPartExamined(String bodyPartExamined) {
		this.bodyPartExamined = bodyPartExamined;
	}
	
	public String getuID() {
		return uid;
	}
	public void setUID(String uid) {
		this.uid = uid;
	}
	public int getRelatedInstances() {
		return relatedInstances;
	}
	public void setRelatedInstances(int relatedInstances) {
		this.relatedInstances = relatedInstances;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}

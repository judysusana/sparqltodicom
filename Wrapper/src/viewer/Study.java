package viewer;

import java.io.Serializable;

public class Study implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7509524185449186043L;
	private String id;
	
	private String date;
	private String time;
	private String accesionNumber;
	private String referringPhysician;
	private String description;
	private String performingPhysician;
	private String uid;
	private int relatedSeries;
	private int relatedInstances;
	
	

	public Study() {
		// TODO Auto-generated constructor stub
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAccesionNumber() {
		return accesionNumber;
	}
	public void setAccesionNumber(String accesionNumber) {
		this.accesionNumber = accesionNumber;
	}
	public String getReferringPhysician() {
		return referringPhysician;
	}
	public void setReferringPhysician(String referringPhysician) {
		this.referringPhysician = referringPhysician;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPerformingPhysician() {
		return performingPhysician;
	}
	public void setPerformingPhysician(String performingPhysician) {
		this.performingPhysician = performingPhysician;
	}
	public String getuID() {
		return uid;
	}
	public void setuID(String uID) {
		this.uid = uID;
	}
	public int getRelatedSeries() {
		return relatedSeries;
	}
	public void setRelatedSeries(int relatedSeries) {
		this.relatedSeries = relatedSeries;
	}
	public int getRelatedInstances() {
		return relatedInstances;
	}
	public void setRelatedInstances(int relatedInstances) {
		this.relatedInstances = relatedInstances;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

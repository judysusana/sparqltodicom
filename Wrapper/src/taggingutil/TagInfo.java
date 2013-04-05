package taggingutil;

import java.util.ArrayList;

public class TagInfo {
	
	//private int frecuencia;
	//private String firstUser;
	//private String firstDate;
	private ArrayList<Tagging> taggings;
	private String label;
	private ArrayList<String> meanings;
	private ArrayList<String> ontologies;
	/**
	 * 
	 */
	public TagInfo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param frecuencia
	 * @param firstUser
	 * @param firstDate
	 * @param taggings
	 * @param label
	 * @param meanings
	 * @param ontologies
	 */
	public TagInfo(int frecuencia, String firstUser, String firstDate,
			ArrayList<Tagging> taggings, String label,
			ArrayList<String> meanings, ArrayList<String> ontologies) {
		//this.frecuencia = frecuencia;
		//this.firstUser = firstUser;
		//this.firstDate = firstDate;
		this.taggings = taggings;
		this.label = label;
		this.meanings = meanings;
		this.ontologies = ontologies;
	}

	/**
	 * @return the frecuencia
	 */
	//public int getFrecuencia() {
	//	return frecuencia;
	//}
	/**
	 * @param frecuencia the frecuencia to set
	 */
	//public void setFrecuencia(int frecuencia) {
	//	this.frecuencia = frecuencia;
	//}
	/**
	 * @return the firstUser
	 */
	//public String getFirstUser() {
		//return firstUser;
	//}
	/**
	 * @param firstUser the firstUser to set
	 */
	//public void setFirstUser(String firstUser) {
	//	this.firstUser = firstUser;
	//}
	/**
	 * @return the firstDate
	 */
	//public String getFirstDate() {
	//	return firstDate;
	//}
	/**
	 * @param firstDate the firstDate to set
	 */
	//public void setFirstDate(String firstDate) {
	//	this.firstDate = firstDate;
//}
	/**
	 * @return the taggings
	 */
	public ArrayList<Tagging> getTaggings() {
		
		return taggings;
	}
	/**
	 * @param taggings the taggings to set
	 */
	public void setTaggings(ArrayList<Tagging> taggings) {
		this.taggings = taggings;
	}



	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}



	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}



	/**
	 * @return the meanings
	 */
	public ArrayList<String> getMeanings() {
		return meanings;
	}



	/**
	 * @param meanings the meanings to set
	 */
	public void setMeanings(ArrayList<String> meanings) {
		this.meanings = meanings;
	}







	/**
	 * @return the ontologies
	 */
	public ArrayList<String> getOntologies() {
		return ontologies;
	}







	/**
	 * @param ontologies the ontologies to set
	 */
	public void setOntologies(ArrayList<String> ontologies) {
		this.ontologies = ontologies;
	}

	
	
	
	
	

}

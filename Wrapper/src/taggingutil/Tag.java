package taggingutil;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tag {
	
	
	private String tagLabel;
	private String tagCreated;
	@XmlElement(name="tagMeanings")
	private ArrayList<String> tagMeanings;
	private String ontologyURI;
	private String uri;
	
	
	

	public Tag(String tagLabel, String tagCreated, ArrayList<String> tagMeanings, String uri, String ontologyURI) {
		this.tagLabel = tagLabel;
		this.tagCreated = tagCreated;
		this.tagMeanings = tagMeanings;
		this.uri=uri;
		this.ontologyURI = ontologyURI;
	}


	public Tag() {
		// TODO Auto-generated constructor stub
	}


	public String getTagLabel() {
		return tagLabel;
	}


	public void setTagLabel(String tagLabel) {
		this.tagLabel = tagLabel;
	}


	public String getTagCreated() {
		return tagCreated;
	}


	public void setTagCreated(String tagCreated) {
		this.tagCreated = tagCreated;
	}


	public ArrayList<String> getTagMeanings() {
		return tagMeanings;
	}


	public void setTagMeanings(ArrayList<String> tagMeanings) {
		this.tagMeanings = tagMeanings;
	} 
	
	public void addTagMeaning(String tagMeaning){
		this.tagMeanings.add(tagMeaning);
	}

	public String getUri() {
		return uri;
	}


	public void setUri(String uri) {
		this.uri = uri;
	}


	public String getOntologyURI() {
		return ontologyURI;
	}


	public void setOntologyURI(String ontologyURI) {
		this.ontologyURI = ontologyURI;
	}

	
	
	

}

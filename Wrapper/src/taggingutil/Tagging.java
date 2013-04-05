package taggingutil;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Tagging {
	
	/**
	 * 
	 */	
	private String nickUser;
	@XmlElement(name="tags")
	private ArrayList<Tag> tags;
	private String dateCreate;
	@XmlElement(name="roi") 
	private ROI roi;
	private String uri;
	
	public Tagging(){
		nickUser="judy";
		tags=new ArrayList<Tag>();
		roi=new ROI();
		uri="";
	}
	
	

	public Tagging(String nickUser, ArrayList<Tag> tags, String dateCreate,
			ROI roi, String uri) {
		this.nickUser = nickUser;
		this.tags = tags;
		this.dateCreate = dateCreate;
		this.roi = roi;
		this.uri = uri;
	}

	public String getNickUser() {
		return nickUser;
	}

	public void setNickUser(String nickUser) {
		this.nickUser = nickUser;
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}
	
	public void addTag(Tag tag){
		this.tags.add(tag);		
	}

	public String getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(String string) {
		this.dateCreate = string;
	}
	
	public ROI getROI() {
		return roi;
	}

	public void setROI(ROI roi) {
		this.roi = roi;
	}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}



	
	
	
	
	

}

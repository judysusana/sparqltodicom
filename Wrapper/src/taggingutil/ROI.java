package taggingutil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ROI  {
	
	
	/**
	 * 
	 */
	
	
	
	private String uri;
	@XmlElement(name="dicomObject")
	private DicomObject isHavenBy;
	private String descriptor;
	
	
	public ROI(){
		
	}
	
	public ROI(String uri, String descriptor){
		this.uri=uri;
		this.descriptor=descriptor;
	}
	
	public DicomObject getDicomObject(){
		return isHavenBy;
		
	}
	
	public String getURI(){
		return this.uri;
	}
	
	public void setDicomObject(DicomObject isHavenBy){
		this.isHavenBy=isHavenBy;
	}
	
	public void setURI(String uri){
		this.uri=uri;
		
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}
	
	
	
	
	

}

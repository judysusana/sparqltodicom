package taggingutil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DicomObject {
	
	/**
	 * 
	 */
	
	private String patientID;
	private String studyUID;
	private String serieUID;
	private String instanceUID;
	private String uri;
	
	public DicomObject(){
		
	}
	
	public DicomObject(String patientID, String studyUID, String serieUID,
			String instanceUID, String uri) {
		
		this.patientID = patientID;
		this.studyUID = studyUID;
		this.serieUID = serieUID;
		this.instanceUID = instanceUID;
		this.uri = uri;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getStudyUID() {
		return studyUID;
	}

	public void setStudyUID(String studyUID) {
		this.studyUID = studyUID;
	}

	public String getSerieUID() {
		return serieUID;
	}

	public void setSerieUID(String serieUID) {
		this.serieUID = serieUID;
	}

	public String getInstanceUID() {
		return instanceUID;
	}

	public void setInstanceUID(String instanceUID) {
		this.instanceUID = instanceUID;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
	
	

}

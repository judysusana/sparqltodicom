package viewer;

import java.io.Serializable;

public class Patient implements Serializable {

	public Patient() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1175673215062189455L;
	private String name;
	private String id;
	private String birthDate;
	private String sex;
	private int age;
	private int relatedStudies;

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRelatedStudies() {
		return relatedStudies;
	}
	public void setRelatedStudies(int relatedStudies) {
		this.relatedStudies = relatedStudies;
	}
	

}

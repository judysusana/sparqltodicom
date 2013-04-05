package viewer;

import java.io.Serializable;

public class Instance implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8677203071073356659L;
	private int instanceNumber;
	private String url;
	private String modality;
	private double sliceThickness;
	private int rows;
	private int columns;
	private double pixelSpacingRows;
	private double pixelSpacingColumns;
	private String windowCenter;
	private String windowWidth;
	private String instanceUID;
	
	public Instance() {
		// TODO Auto-generated constructor stub
	}
	
	public int getInstanceNumber() {
		return instanceNumber;
	}
	public void setInstanceNumber(int instanceNumber) {
		this.instanceNumber = instanceNumber;
	}
	public String getModality() {
		return modality;
	}
	public void setModality(String modality) {
		this.modality = modality;
	}
	public double getSliceThickness() {
		return sliceThickness;
	}
	public void setSliceThickness(double sliceThickness) {
		this.sliceThickness = sliceThickness;
	}
	public String getURL() {
		return url;
	}
	public void setURL(String uRL) {
		this.url = uRL;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public double getPixelSpacingRows() {
		return pixelSpacingRows;
	}
	public void setPixelSpacingRows(double pixelSpacingRows) {
		this.pixelSpacingRows = pixelSpacingRows;
	}
	public double getPixelSpacingColumns() {
		return pixelSpacingColumns;
	}
	public void setPixelSpacingColumns(double pixelSpacingColumns) {
		this.pixelSpacingColumns = pixelSpacingColumns;
	}
	public String getWindowCenter() {
		return windowCenter;
	}
	public void setWindowCenter(String windowCenter) {
		this.windowCenter = windowCenter;
	}
	public String getWindowWidth() {
		return windowWidth;
	}
	public void setWindowWidth(String windowWidth) {
		this.windowWidth = windowWidth;
	}

	public String getInstanceUID() {
		return instanceUID;
	}

	public void setInstanceUID(String instanceUID) {
		this.instanceUID = instanceUID;
	}
	
	
	

}

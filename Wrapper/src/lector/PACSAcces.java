package lector;

import java.util.ArrayList;
import java.util.List;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.net.UserIdentity;
import org.dcm4che2.tool.dcmqr.DcmQR;
import org.dcm4che2.tool.dcmsnd.DcmSnd;
import viewer.Patient;
import viewer.Study;
import viewer.Serie;
import viewer.Instance;




public class PACSAcces {
	
	DcmQR dcmqr = new DcmQR("object");
	//private static String WADO_HOST="http://50.16.202.132:8080/wado?requestType=WADO";
	private static String WADO_HOST="http://localhost:8080/wado?requestType=WADO";
   //private static String WADO_HOST = "http//websuv.univalle.edu.co:8080/wado?requestType=WADO";
	
	//ArrayList patients[];
	
	ArrayList<Patient> patients;
	ArrayList<Study> studies;
	ArrayList<Serie> series;
	
	public PACSAcces(){
		
	dcmqr.setCalledAET("DCM4CHEE", true);
	char[] pass = {'a', 'd', 'm', 'i', 'n'};
	//dcmqr.setUserIdentity(new UserIdentity.UsernamePasscode("admin", pass)); //estaba comentado
	//dcmqr.setRemoteHost("50.16.202.132");
	dcmqr.setRemoteHost("127.0.0.1");
	//dcmqr.setRemoteHost("websuv.univalle.edu.co");
	dcmqr.setRemotePort(11112);
	dcmqr.configureTransferCapability(true);
	//ArrayList<Patient> patients = new ArrayList<Patient>();
	
	}
	
	public int numberOfPatients(){
		
		dcmqr.setQueryLevel(DcmQR.QueryRetrieveLevel.PATIENT);
		dcmqr.addDefReturnKeys();	
		
		try {
			
			dcmqr.start();
			//System.out.println("started");
			dcmqr.open();
			//System.out.println("opened");
			List<DicomObject> result =  dcmqr.query();
       
			System.out.println("NÃºmero de pacientes = "+result.size());
			dcmqr.close();
			dcmqr.stop();
			return result.size();
			}
			catch (Exception e) {
				//System.out.println(e.getMessage());
			}

		 return -1;
			
			
		
	}
	
/*	public ArrayList<Patient> setPatients(List <consulta> variable) {
		this.name = name;
		this.id = id;
		this.name = name;
		this.name = name;
		this.name = name;
		this.name = name;
		this.name = name;
	}*/
	
	public ArrayList<Patient> getPatients()
	{
		dcmqr.setQueryLevel(DcmQR.QueryRetrieveLevel.PATIENT);
		dcmqr.addDefReturnKeys();
		dcmqr.addReturnKey(new int[]{Tag.PatientAge});
		ArrayList<Patient> patients = new ArrayList<Patient>();
		
		try {
						
			dcmqr.start();		
			dcmqr.open();
		
			List<DicomObject> result = dcmqr.query();
			
			
					
			for(int i=0; i<result.size(); i++)
			{

				Patient patient=new Patient();
				patient.setId(result.get(i).getString(Tag.PatientID));
				patient.setName(result.get(i).getString(Tag.PatientName));
				patient.setBirthDate(result.get(i).getString(Tag.PatientBirthDate));
				patient.setAge(result.get(i).getInt(Tag.PatientAge));
				patient.setSex(result.get(i).getString(Tag.PatientSex));
				patient.setRelatedStudies(result.get(i).getInt(Tag.NumberOfPatientRelatedStudies));
				patients.add(patient);

				//System.out.println("Patient's ToString:  "+result.get(i).toString());
				
			//System.out.println();
		}
			for (int p=0; p<patients.size();p++){
				patients.get(p).getName();
				System.out.println("Patient's name:  "+patients.get(p).getName().toString());
				}
				
			
			dcmqr.close();
			dcmqr.stop();
			
			}
			catch (Exception e) {
				//System.out.println(e.getMessage());
			}
	
		return patients;
		
	}
	
	public ArrayList<Study> getStudies(String patientID)
	{
		
		dcmqr.setQueryLevel(DcmQR.QueryRetrieveLevel.STUDY);
		dcmqr.addDefReturnKeys();	
		int[] tagPath={Tag.PatientID};
		dcmqr.addMatchingKey(tagPath, patientID);
		dcmqr.addReturnKey(new int[]{Tag.StudyDescription});
		dcmqr.addReturnKey(new int[]{Tag.ReferringPhysicianName});
		dcmqr.addReturnKey(new int[]{Tag.PerformingPhysicianName});
		ArrayList<Study> studies= new ArrayList<Study>();
		
		
		try {			
				
			dcmqr.start();			
			dcmqr.open();
			
			List<DicomObject> result = dcmqr.query();
			
			
					
			for(int i=0; i<result.size(); i++)
			{
				Study study=new Study();
				study.setId(result.get(i).getString(Tag.StudyID));
				study.setDate(result.get(i).getString(Tag.StudyDate));
				study.setRelatedSeries(result.get(i).getInt(Tag.NumberOfStudyRelatedSeries));
				study.setRelatedInstances(result.get(i).getInt(Tag.NumberOfStudyRelatedInstances));
				study.setuID(result.get(i).getString(Tag.StudyInstanceUID)); // Este identificador Ãºnico me parece que no es muy bueno para ser mostrado en la interfaz del cliente, sin embargo lo incluyo para poder a partir de Ã©l buscar las series relacionadas.
				study.setPerformingPhysician(result.get(i).getString(Tag.PerformingPhysicianName));
				study.setReferringPhysician(result.get(i).getString(Tag.ReferringPhysicianName));
				//System.out.println("Study's ToString:  "+result.get(i).toString());
				//System.out.println();
				studies.add(study);
				
			}
			
			dcmqr.close();
			dcmqr.stop();
			
			}
			catch (Exception e) {
				//System.out.println(e.getMessage());
			}
		return studies;
	}
	
	public ArrayList<Serie> getSeries(String studyUID)
	{
		
		dcmqr.setQueryLevel(DcmQR.QueryRetrieveLevel.SERIES);
		dcmqr.addDefReturnKeys();		
		int[] tagPathStudyUID={Tag.StudyInstanceUID};
		dcmqr.addReturnKey(new int[]{Tag.Manufacturer});
		dcmqr.addReturnKey(new int[]{Tag.SeriesDescription});
		dcmqr.addReturnKey(new int[]{Tag.BodyPartExamined});
		ArrayList<Serie> series= new ArrayList<Serie>();
		
		
		dcmqr.addMatchingKey(tagPathStudyUID, studyUID);
		
		
		try {
			dcmqr.start();			
			dcmqr.open();
			
			List<DicomObject> result = dcmqr.query();
			
			
					
			for(int i=0; i<result.size(); i++)
			{
				Serie serie=new Serie();
				serie.setNumber(result.get(i).getInt(Tag.SeriesNumber));
				serie.setModality(result.get(i).getString(Tag.Modality));
				serie.setRelatedInstances(result.get(i).getInt(Tag.NumberOfSeriesRelatedInstances));
				serie.setUID(result.get(i).getString(Tag.SeriesInstanceUID));
				serie.setDescription(result.get(i).getString(Tag.SeriesDescription));
				serie.setManufacturer(result.get(i).getString(Tag.Manufacturer));
				serie.setBodyPartExamined(result.get(i).getString(Tag.BodyPartExamined));
				//System.out.println("Study's ToString:  "+result.get(i).toString());
				//System.out.println();
				series.add(serie);
				
			}
			
			dcmqr.close();
			dcmqr.stop();
			
			}
			catch (Exception e) {
				//System.out.println(e.getMessage());
			}
		return series;
	}

	
	public ArrayList<Instance> getInstances(String seriesUID)
	{
		
		dcmqr.setQueryLevel(DcmQR.QueryRetrieveLevel.IMAGE);
		dcmqr.addDefReturnKeys();	
		int[] tagPath={Tag.SeriesInstanceUID};
		dcmqr.addMatchingKey(tagPath, seriesUID);
		dcmqr.addReturnKey(new int[]{Tag.Columns});
		dcmqr.addReturnKey(new int[]{Tag.Rows});
		dcmqr.addReturnKey(new int[]{Tag.SliceThickness});
		dcmqr.addReturnKey(new int[]{Tag.Modality});
		dcmqr.addReturnKey(new int[]{Tag.PixelSpacing});
		dcmqr.addReturnKey(new int[]{Tag.WindowCenter});
		dcmqr.addReturnKey(new int[]{Tag.WindowWidth});
		ArrayList<Instance> instances = new ArrayList<Instance>();
		//System.out.println("Tratando");
		
		try {
			//System.out.println("Tratando1");
			dcmqr.start();			
			dcmqr.open();
			//System.out.println("Tratando2");
			List<DicomObject> result = dcmqr.query();
			
			//System.out.println("Tratando3 "+result.size());
					
			for(int i=0; i<result.size(); i++)
			{
				//System.out.println("Tratando4 "+result.get(i));
				Instance instance = new Instance();
				//System.out.println("Tratando5 "+instance.toString());
				instance.setInstanceNumber(result.get(i).getInt(Tag.InstanceNumber));
				//System.out.println("Tratando6 "+instance.getInstanceNumber());
				instance.setURL(this.WADO_HOST+
									"&studyUID="+result.get(i).getString(Tag.StudyInstanceUID)+
									"&seriesUID="+result.get(i).getString(Tag.SeriesInstanceUID)+
									"&objectUID="+result.get(i).getString(Tag.SOPInstanceUID));
				//System.out.println("Tratando6a "+instance.getURL());
				instance.setColumns(result.get(i).getInt(Tag.Columns));
				//System.out.println("Tratando7"+result.get(i).getInt(Tag.Columns));
				instance.setRows(result.get(i).getInt(Tag.Rows));
				if(result.get(i).getString(Tag.Modality)!=null)
				instance.setModality(result.get(i).getString(Tag.Modality));
				if(result.get(i).getString(Tag.SliceThickness)!=null)
				instance.setSliceThickness(result.get(i).getDouble(Tag.SliceThickness));
				if(result.get(i).getString(Tag.PixelSpacing)!=null)
				instance.setPixelSpacingRows(Double.valueOf(result.get(i).getString(Tag.PixelSpacing)));
				if(result.get(i).getString(Tag.PixelSpacing)!=null)
				instance.setPixelSpacingColumns(Double.valueOf(result.get(i).getString(Tag.PixelSpacing)));
				if(result.get(i).getString(Tag.WindowCenter)!=null)
				instance.setWindowCenter(result.get(i).getString(Tag.WindowCenter));
				if(result.get(i).getString(Tag.WindowWidth)!=null)
				instance.setWindowWidth(result.get(i).getString(Tag.WindowWidth));
				instance.setInstanceUID(result.get(i).getString(Tag.SOPInstanceUID));
				//System.out.println("Image ToString:"+result.get(i).toString());
				//System.out.println();
				instances.add(instance);
				//System.out.println("Tratando6 "+instances.size());
				
			}
			
			dcmqr.close();
			dcmqr.stop();
			
			
			}
			catch (Exception e) {
				System.out.println("Excepción:"+e.getMessage());
			}
		return instances;
	}
	
	/*public Instance getInstance(String instanceUID)
	{
		
		dcmqr.setQueryLevel(DcmQR.QueryRetrieveLevel.IMAGE);
		dcmqr.addDefReturnKeys();	
		int[] tagPath={Tag.SOPInstanceUID};
		dcmqr.addMatchingKey(tagPath, instanceUID);
		Instance instance = new Instance();
		
		try {
			dcmqr.start();			
			dcmqr.open();
			
			List<DicomObject> result = dcmqr.query();
			
			
					
			for(int i=0; i<result.size(); i++)
			{
				
				instance.setInstanceNumber(result.get(i).getInt(Tag.InstanceNumber));
				instance.setURL(this.WADO_HOST+
									"&studyUID="+result.get(i).getString(Tag.StudyInstanceUID)+
									"&seriesUID="+result.get(i).getString(Tag.SeriesInstanceUID)+
									"&objectUID="+result.get(i).getString(Tag.SOPInstanceUID));
				instance.setColumns(result.get(i).getInt(Tag.Columns));
				instance.setRows(result.get(i).getInt(Tag.Rows));
				instance.setSliceThickness(result.get(i).getDouble(Tag.SliceThickness));
				instance.setModality(result.get(i).getString(Tag.Modality));
				instance.setPixelSpacingRows(Double.valueOf(result.get(i).getString(Tag.PixelSpacing).split("/")[0]));
				instance.setPixelSpacingColumns(Double.valueOf(result.get(i).getString(Tag.PixelSpacing).split("/")[1]));
				instance.setWindowCenter(result.get(i).getInt(Tag.WindowCenter));
				instance.setWindowWidth(result.get(i).getInt(Tag.WindowWidth));
				//System.out.println("Image ToString:"+result.get(i).toString());
				//System.out.println();
				
				
			}
			
			dcmqr.close();
			dcmqr.stop();
			
			}
			catch (Exception e) {
				//System.out.println(e.getMessage());
			}
		return instance;
	}*/
	
	public void upload(String filePath){
		
		 String[] args={"DCM4CHEE@172.17.1.13:11112",filePath}; //Se crean los argumentos para la llamada al comando DcmSnd
	     DcmSnd.main(args); //Se realiza el llamado al DcmSnd para enviar el contenido del directorio al servidor.
		
	}
	
	


	
/**
* @param args the command line arguments
*/
	//public static void main(String[] args) {
	
	//PACSAcces consulta =new PACSAcces();
	//System.out.println("*************************Todos los pacientes en PACS**************************");
	//consulta.getPatients();
	//System.out.println("*************************Todos los estudios del paciente con ID=5Yp0E**************************");
	//consulta.getStudies("SOtNwu");
	//System.out.println("*************************Todas las series del estudio con UID=2.16.840.1.113669.632.20.1211.10000357775**************************");
	//consulta.getSeries("2.16.840.1.113669.632.20.1211.10000231621");
	//System.out.println("*************************Todas las imÃ¡genes de la serie con UID=1.3.46.670589.11.0.0.11.4.2.0.8743.5.3800.2006120117110979000**************************");
	//consulta.getInstances("1.3.76.670589.11.0.0.11.4.2.0.8743.5.5396.2006120114262848496"); //cambien el primer 7 era un 4
	//consulta.getInstance("1.3.12.2.1107.5.1.4.54693.30000006053107175587500014745");
	

	

	//}
}

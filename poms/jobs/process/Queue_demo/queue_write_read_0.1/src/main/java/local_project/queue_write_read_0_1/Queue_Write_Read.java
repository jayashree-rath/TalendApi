
package local_project.queue_write_read_0_1;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.DataQuality;
import routines.Relational;
import routines.DataQualityDependencies;
import routines.Mathematical;
import routines.SQLike;
import routines.Numeric;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.DQTechnical;
import routines.StringHandling;
import routines.DataMasking;
import routines.TalendDate;
import routines.DqStringHandling;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: Queue_Write_Read Purpose: <br>
 * Description:  <br>
 * @author jayashree.rath@keyrus.com
 * @version 7.3.1.20210623_0656-patch
 * @status 
 */
public class Queue_Write_Read implements TalendJob {
	static {System.setProperty("TalendJob.log", "Queue_Write_Read.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Queue_Write_Read.class);
	

protected static void logIgnoredError(String message, Throwable cause) {
       log.error(message, cause);

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(filePath != null){
				
					this.setProperty("filePath", filePath.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

public String filePath;
public String getFilePath(){
	return this.filePath;
}
	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "Queue_Write_Read";
	private final String projectName = "LOCAL_PROJECT";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_QHW0EBD9Ee6x06LQ13bVFQ", "0.1");
private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				Queue_Write_Read.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Queue_Write_Read.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tLogRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMomInput_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRowGenerator_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMomOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMomInput_1_Loop_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tMomInput_1_In_error(exception, errorComponent, globalMap);
						
						}
					
			public void tMomInput_1_In_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMomInput_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRowGenerator_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMomInput_1_Loop_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void talendJobLog_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}


	






	
	public static class ContextBean {
		static String evaluate(String context, String contextExpression)
				throws IOException, javax.script.ScriptException {
			boolean isExpression = contextExpression.contains("+") || contextExpression.contains("(");
			final String prefix = isExpression ? "\"" : "";
			java.util.Properties defaultProps = new java.util.Properties();
			java.io.InputStream inContext = Queue_Write_Read.class.getClassLoader()
					.getResourceAsStream("local_project/queue_write_read_0_1/contexts/" + context + ".properties");
			if (inContext == null) {
				inContext = Queue_Write_Read.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + context + ".properties");
			}
			try {
			    defaultProps.load(inContext);
			} finally {
			    inContext.close();
			}
			java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("context.([\\w]+)");
			java.util.regex.Matcher matcher = pattern.matcher(contextExpression);

			while (matcher.find()) {
				contextExpression = contextExpression.replaceAll(matcher.group(0),
						prefix + defaultProps.getProperty(matcher.group(1)) + prefix);
			}
			if (contextExpression.startsWith("/services")) {
				contextExpression = contextExpression.replaceFirst("/services","");
            }
			return isExpression ? evaluateContextExpression(contextExpression) : contextExpression;
		}
		
		public static String evaluateContextExpression(String expression) throws javax.script.ScriptException {
			javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager();
			javax.script.ScriptEngine engine = manager.getEngineByName("nashorn");
			// Add some import for Java
			expression = expression.replaceAll("System.getProperty", "java.lang.System.getProperty");
			return engine.eval(expression).toString();
		}
		
        public static String getContext(String context, String contextName, String jobName) throws Exception {

            String currentContext = null;
            String jobNameStripped = jobName.substring(jobName.lastIndexOf(".") + 1);

            boolean inOSGi = routines.system.BundleUtils.inOSGi();

            if (inOSGi) {
                java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobNameStripped);

                if (jobProperties != null) {
                    currentContext = (String)jobProperties.get("context");
                }
            }

            return contextName.contains("context.") ? evaluate(currentContext == null ? context : currentContext, contextName) : contextName;
        }
	}


public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_Queue_Write_Read = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_Queue_Write_Read = new byte[0];

	
			    public String message;

				public String getMessage () {
					return this.message;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_Queue_Write_Read.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_Queue_Write_Read.length == 0) {
   					commonByteArray_LOCAL_PROJECT_Queue_Write_Read = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_Queue_Write_Read = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_Queue_Write_Read, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_Queue_Write_Read, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_Queue_Write_Read) {

        	try {

        		int length = 0;
		
					this.message = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.message,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("message="+message);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class output_xmlStruct implements routines.system.IPersistableRow<output_xmlStruct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_Queue_Write_Read = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_Queue_Write_Read = new byte[0];

	
			    public String message;

				public String getMessage () {
					return this.message;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_Queue_Write_Read.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_Queue_Write_Read.length == 0) {
   					commonByteArray_LOCAL_PROJECT_Queue_Write_Read = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_Queue_Write_Read = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_Queue_Write_Read, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_Queue_Write_Read, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_Queue_Write_Read) {

        	try {

        		int length = 0;
		
					this.message = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.message,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("message="+message);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(output_xmlStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_Queue_Write_Read = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_Queue_Write_Read = new byte[0];

	
			    public String message;

				public String getMessage () {
					return this.message;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_Queue_Write_Read.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_Queue_Write_Read.length == 0) {
   					commonByteArray_LOCAL_PROJECT_Queue_Write_Read = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_Queue_Write_Read = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_Queue_Write_Read, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_Queue_Write_Read, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_Queue_Write_Read) {

        	try {

        		int length = 0;
		
					this.message = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.message,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("message="+message);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tRowGenerator_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();
output_xmlStruct output_xml = new output_xmlStruct();
output_xmlStruct row4 = output_xml;






	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row4");
			
		int tos_count_tDBOutput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBOutput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
                    log4jParamters_tDBOutput_1.append("Parameters:");
                            log4jParamters_tDBOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DB_VERSION" + " = " + "V9_X");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("HOST" + " = " + "\"host.docker.internal\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("PORT" + " = " + "\"5432\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DBNAME" + " = " + "\"postgres\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("SCHEMA_DB" + " = " + "\"finance\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USER" + " = " + "\"postgres\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:Hds9DQpLiMDZbRuLVMiWTM6COjdnNN6aeaxxqXzcYRPPRA5WKQ==").substring(0, 4) + "...");     
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"messagequeue\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "CREATE_IF_NOT_EXISTS");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "INSERT");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_SPATIAL_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("PROPERTIES" + " = " + "\"\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("COMMIT_EVERY" + " = " + "10000");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("ADD_COLS" + " = " + "[]");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("SUPPORT_NULL_WHERE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("CONVERT_COLUMN_TABLE_TO_LOWERCASE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_BATCH_SIZE" + " = " + "true");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("BATCH_SIZE" + " = " + "10000");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlOutput");
                        log4jParamters_tDBOutput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + (log4jParamters_tDBOutput_1) );
                    } 
                } 
            new BytesLimit65535_tDBOutput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBOutput_1", "tDBOutput_1", "tPostgresqlOutput");
				talendJobLogProcess(globalMap);
			}
			





String dbschema_tDBOutput_1 = null;
	dbschema_tDBOutput_1 = "finance";
	

String tableName_tDBOutput_1 = null;
if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
	tableName_tDBOutput_1 = ("messagequeue");
} else {
	tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + ("messagequeue");
}


int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

boolean whetherReject_tDBOutput_1 = false;

java.sql.Connection conn_tDBOutput_1 = null;
String dbUser_tDBOutput_1 = null;

	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Driver ClassName: ")  + ("org.postgresql.Driver")  + (".") );
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_1 = "jdbc:postgresql://"+"host.docker.internal"+":"+"5432"+"/"+"postgres";
    dbUser_tDBOutput_1 = "postgres";
 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:BPo3tPMHApB7NiurJwO1U0ffPjFmd15LR33Bjs+ihFAMw13qkA==");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;

                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection attempts to '")  + (url_tDBOutput_1)  + ("' with the username '")  + (dbUser_tDBOutput_1)  + ("'.") );
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection to '")  + (url_tDBOutput_1)  + ("' has succeeded.") );
	
	resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection is set auto commit to '")  + (conn_tDBOutput_1.getAutoCommit())  + ("'.") );


   int batchSize_tDBOutput_1 = 10000;
   int batchSizeCounter_tDBOutput_1=0;

int count_tDBOutput_1=0;
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_1 = conn_tDBOutput_1.getMetaData();
                                boolean whetherExist_tDBOutput_1 = false;
                                try (java.sql.ResultSet rsTable_tDBOutput_1 = dbMetaData_tDBOutput_1.getTables(null, null, null, new String[]{"TABLE"})) {
                                    String defaultSchema_tDBOutput_1 = "public";
                                    if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
                                        try(java.sql.Statement stmtSchema_tDBOutput_1 = conn_tDBOutput_1.createStatement();
                                            java.sql.ResultSet rsSchema_tDBOutput_1 = stmtSchema_tDBOutput_1.executeQuery("select current_schema() ")) {
                                            while(rsSchema_tDBOutput_1.next()){
                                                defaultSchema_tDBOutput_1 = rsSchema_tDBOutput_1.getString("current_schema");
                                            }
                                        }
                                    }
                                    while(rsTable_tDBOutput_1.next()) {
                                        String table_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_NAME");
                                        String schema_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_SCHEM");
                                        if(table_tDBOutput_1.equals(("messagequeue"))
                                            && (schema_tDBOutput_1.equals(dbschema_tDBOutput_1) || ((dbschema_tDBOutput_1 ==null || dbschema_tDBOutput_1.trim().length() ==0) && defaultSchema_tDBOutput_1.equals(schema_tDBOutput_1)))) {
                                            whetherExist_tDBOutput_1 = true;
                                            break;
                                        }
                                    }
                                }
                                if(!whetherExist_tDBOutput_1) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Creating")  + (" table '")  + (tableName_tDBOutput_1)  + ("'.") );
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE \"" + tableName_tDBOutput_1 + "\"(\"message\" VARCHAR(255)  )");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Create")  + (" table '")  + (tableName_tDBOutput_1)  + ("' has succeeded.") );
                                    }
                                }
	    String insert_tDBOutput_1 = "INSERT INTO \"" + tableName_tDBOutput_1 + "\" (\"message\") VALUES (?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
	    resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
	    

 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMomOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMomOutput_1", false);
		start_Hash.put("tMomOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tMomOutput_1";

	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"output_xml");
			
		int tos_count_tMomOutput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMomOutput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMomOutput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMomOutput_1 = new StringBuilder();
                    log4jParamters_tMomOutput_1.append("Parameters:");
                            log4jParamters_tMomOutput_1.append("USE_CONNECTION" + " = " + "false");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("FAILOVER" + " = " + "false");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("STATIC" + " = " + "false");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("SERVER" + " = " + "ActiveMQ");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("USE_SSL" + " = " + "false");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("SERVERADDRESS" + " = " + "\"host.docker.internal\"");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("SERVERPORT" + " = " + "61616");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("USER" + " = " + "\"admin\"");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:PUwJwJp9YC12OKgNYvp6Q9SguPdzTgcGGgvLYVG7vqg+").substring(0, 4) + "...");     
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("TO" + " = " + "\"customerData\"");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("MSGTYPE" + " = " + "Queue");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("MESSAGE_BODY_TYPE" + " = " + "Text");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("IS_TRANSACTED" + " = " + "false");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("IS_USE_MESSAGE_ID" + " = " + "false");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("DELIVERY_MODE" + " = " + "N_PERSISTENT");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("SET_JMS_HEADER" + " = " + "false");
                        log4jParamters_tMomOutput_1.append(" | ");
                            log4jParamters_tMomOutput_1.append("SET_JMS_PROPERTIES" + " = " + "false");
                        log4jParamters_tMomOutput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMomOutput_1 - "  + (log4jParamters_tMomOutput_1) );
                    } 
                } 
            new BytesLimit65535_tMomOutput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMomOutput_1", "tMomOutput_1", "tMomOutput");
				talendJobLogProcess(globalMap);
			}
			

	java.util.Hashtable props_tMomOutput_1=new java.util.Hashtable();
	int nb_line_tMomOutput_1 = 0;

		
				String url_tMomOutput_1 ="";
				String endParam_tMomOutput_1="";
 			
				url_tMomOutput_1 = "tcp://"+"host.docker.internal"+":"+61616;
				
			
			System.out.println("Connecting to URL: " + url_tMomOutput_1);
			System.out.println("Producing " + (false ? "topic" : "queue") + ": " + "customerData");
			
				
				log.info("tMomOutput_1 - Attempt to create connection from URL: " + url_tMomOutput_1 + ".");
			
			org.apache.activemq.ActiveMQConnectionFactory factory_tMomOutput_1 = 
				new org.apache.activemq.ActiveMQConnectionFactory(url_tMomOutput_1);
			
				
		
		
			

			 
	final String decryptedPassword_tMomOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:5vxC/cly/LNYtzcNKzjjDDYj3Bm/FsLjM6lKHKPBsHEJ");
				
			javax.jms.Connection connection_tMomOutput_1 = factory_tMomOutput_1.createConnection("admin",decryptedPassword_tMomOutput_1);
			
			log.info("tMomOutput_1 - Created connection successfully.");
			log.info("tMomOutput_1 - Activating the connection...");
		
		connection_tMomOutput_1.start();
			
			log.info("tMomOutput_1 - Activate successfully.");
			log.info("tMomOutput_1 - Creating a session...");
		
		javax.jms.Session session_tMomOutput_1 = connection_tMomOutput_1.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
			
			log.info("tMomOutput_1 - Created session successfully.");
		
		javax.jms.Destination des_tMomOutput_1;
		
			des_tMomOutput_1 = session_tMomOutput_1.createQueue("customerData");
		
		javax.jms.MessageProducer producer_tMomOutput_1 = session_tMomOutput_1.createProducer(des_tMomOutput_1);
		
		
			producer_tMomOutput_1.setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);
		
			
			log.info("tMomOutput_1 - Start to produce " + (false ? "topic" : "queue") + ": " + "customerData");
		
			globalMap.put("producer_tMomOutput_1",producer_tMomOutput_1);
			globalMap.put("session_tMomOutput_1",session_tMomOutput_1);
			globalMap.put("connection_tMomOutput_1",connection_tMomOutput_1);
		
	

 



/**
 * [tMomOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row2");
			
		int tos_count_tMap_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMap_1 = new StringBuilder();
                    log4jParamters_tMap_1.append("Parameters:");
                            log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_tMap_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + (log4jParamters_tMap_1) );
                    } 
                } 
            new BytesLimit65535_tMap_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMap_1", "tMap_1", "tMap");
				talendJobLogProcess(globalMap);
			}
			




// ###############################
// # Lookup's keys initialization
		int count_row2_tMap_1 = 0;
		
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_output_xml_tMap_1 = 0;
				
output_xmlStruct output_xml_tmp = new output_xmlStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tRowGenerator_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRowGenerator_1", false);
		start_Hash.put("tRowGenerator_1", System.currentTimeMillis());
		
	
	currentComponent="tRowGenerator_1";

	
		int tos_count_tRowGenerator_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tRowGenerator_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tRowGenerator_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tRowGenerator_1 = new StringBuilder();
                    log4jParamters_tRowGenerator_1.append("Parameters:");
                if(log.isDebugEnabled())
            log.debug("tRowGenerator_1 - "  + (log4jParamters_tRowGenerator_1) );
                    } 
                } 
            new BytesLimit65535_tRowGenerator_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tRowGenerator_1", "tRowGenerator_1", "tRowGenerator");
				talendJobLogProcess(globalMap);
			}
			


int nb_line_tRowGenerator_1 = 0;
int nb_max_row_tRowGenerator_1 = 50;


class tRowGenerator_1Randomizer {
	public String getRandommessage() {
		
		return TalendDataGenerator.getUsCity();
		
	}
}
	tRowGenerator_1Randomizer randtRowGenerator_1 = new tRowGenerator_1Randomizer();
	
    	log.info("tRowGenerator_1 - Generating records.");
	for (int itRowGenerator_1=0; itRowGenerator_1<nb_max_row_tRowGenerator_1 ;itRowGenerator_1++) {
		row2.message = randtRowGenerator_1.getRandommessage();
		nb_line_tRowGenerator_1++;
		
			log.debug("tRowGenerator_1 - Retrieving the record " + nb_line_tRowGenerator_1 + ".");
		

 



/**
 * [tRowGenerator_1 begin ] stop
 */
	
	/**
	 * [tRowGenerator_1 main ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

 


	tos_count_tRowGenerator_1++;

/**
 * [tRowGenerator_1 main ] stop
 */
	
	/**
	 * [tRowGenerator_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

 



/**
 * [tRowGenerator_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row2","tRowGenerator_1","tRowGenerator_1","tRowGenerator","tMap_1","tMap_1","tMap"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

output_xml = null;


// # Output table : 'output_xml'
count_output_xml_tMap_1++;

output_xml_tmp.message = row2.message ;
output_xml = output_xml_tmp;
log.debug("tMap_1 - Outputting the record " + count_output_xml_tMap_1 + " of the output table 'output_xml'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "output_xml"
if(output_xml != null) { 



	
	/**
	 * [tMomOutput_1 main ] start
	 */

	

	
	
	currentComponent="tMomOutput_1";

	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"output_xml","tMap_1","tMap_1","tMap","tMomOutput_1","tMomOutput_1","tMomOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("output_xml - " + (output_xml==null? "": output_xml.toLogString()));
    			}
    		

					log.debug("tMomOutput_1 - Writing the record: " + (nb_line_tMomOutput_1+1) + ".");
				
						String msgBody_tMomOutput_1 = String.valueOf(output_xml.message);
							javax.jms.TextMessage message_tMomOutput_1 = session_tMomOutput_1.createTextMessage( msgBody_tMomOutput_1);

						producer_tMomOutput_1.send(message_tMomOutput_1);
	
	nb_line_tMomOutput_1++;

		

 
     row4 = output_xml;


	tos_count_tMomOutput_1++;

/**
 * [tMomOutput_1 main ] stop
 */
	
	/**
	 * [tMomOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMomOutput_1";

	

 



/**
 * [tMomOutput_1 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row4","tMomOutput_1","tMomOutput_1","tMomOutput","tDBOutput_1","tDBOutput_1","tPostgresqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row4 - " + (row4==null? "": row4.toLogString()));
    			}
    		



        whetherReject_tDBOutput_1 = false;
                    if(row4.message == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(1, row4.message);
}

			
    		pstmt_tDBOutput_1.addBatch();
    		nb_line_tDBOutput_1++;
    		  
    		  
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Adding the record ")  + (nb_line_tDBOutput_1)  + (" to the ")  + ("INSERT")  + (" batch.") );
    		  batchSizeCounter_tDBOutput_1++;
    		  
    			if ((batchSize_tDBOutput_1 > 0) && (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
                try {
						int countSum_tDBOutput_1 = 0;
						    
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
				    	
				    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
            	    	batchSizeCounter_tDBOutput_1 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
				    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
				    	String errormessage_tDBOutput_1;
						if (ne_tDBOutput_1 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
							errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
						}else{
							errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
						}
				    	
				    	int countSum_tDBOutput_1 = 0;
						for(int countEach_tDBOutput_1: e_tDBOutput_1.getUpdateCounts()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
						
				    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
            log.error("tDBOutput_1 - "  + (errormessage_tDBOutput_1) );
				    	System.err.println(errormessage_tDBOutput_1);
				    	
					}
    			}
    		
    		    commitCounter_tDBOutput_1++;
                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
                if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {
                try {
                		int countSum_tDBOutput_1 = 0;
                		    
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
            	    	
            	    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
            	    	
                batchSizeCounter_tDBOutput_1 = 0;
               }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
			    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
			    	String errormessage_tDBOutput_1;
					if (ne_tDBOutput_1 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
						errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
					}else{
						errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
					}
			    	
			    	int countSum_tDBOutput_1 = 0;
					for(int countEach_tDBOutput_1: e_tDBOutput_1.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					
			    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
			    	
            log.error("tDBOutput_1 - "  + (errormessage_tDBOutput_1) );
			    	System.err.println(errormessage_tDBOutput_1);
			    	
				}
            }
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection starting to commit ")  + (commitCounter_tDBOutput_1)  + (" record(s).") );
                	conn_tDBOutput_1.commit();
                	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection commit has succeeded.") );
                	commitCounter_tDBOutput_1=0;
                }

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */



	
	/**
	 * [tMomOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMomOutput_1";

	

 



/**
 * [tMomOutput_1 process_data_end ] stop
 */

} // End of branch "output_xml"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tRowGenerator_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

 



/**
 * [tRowGenerator_1 process_data_end ] stop
 */
	
	/**
	 * [tRowGenerator_1 end ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

}
globalMap.put("tRowGenerator_1_NB_LINE",nb_line_tRowGenerator_1);
	log.info("tRowGenerator_1 - Generated records count:" + nb_line_tRowGenerator_1 + " .");

 
                if(log.isDebugEnabled())
            log.debug("tRowGenerator_1 - "  + ("Done.") );

ok_Hash.put("tRowGenerator_1", true);
end_Hash.put("tRowGenerator_1", System.currentTimeMillis());




/**
 * [tRowGenerator_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'output_xml': " + count_output_xml_tMap_1 + ".");





			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row2",2,0,
			 			"tRowGenerator_1","tRowGenerator_1","tRowGenerator","tMap_1","tMap_1","tMap","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Done.") );

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tMomOutput_1 end ] start
	 */

	

	
	
	currentComponent="tMomOutput_1";

	

				log.info("tMomOutput_1 - Closing connection...");
			 // if no commmit or rollback component exists - close session
 			System.out.println("Closing connection");
            session_tMomOutput_1.close();
            connection_tMomOutput_1.close();
			
				log.info("tMomOutput_1 - Closed successfully.");
			
                log.info("tMomOutput_1 - Closing producer...");
            producer_tMomOutput_1.close();
                log.info("tMomOutput_1 - Closed successfully.");
	log.info("tMomOutput_1 - Written records count: "+ nb_line_tMomOutput_1 + " .");

    globalMap.put("tMomOutput_1_NB_LINE",nb_line_tMomOutput_1);
			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"output_xml",2,0,
			 			"tMap_1","tMap_1","tMap","tMomOutput_1","tMomOutput_1","tMomOutput","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tMomOutput_1 - "  + ("Done.") );

ok_Hash.put("tMomOutput_1", true);
end_Hash.put("tMomOutput_1", System.currentTimeMillis());




/**
 * [tMomOutput_1 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



	    try {
				int countSum_tDBOutput_1 = 0;
				if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {
						
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
					for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
						
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
				}
		    	
		    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
	    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
	    	String errormessage_tDBOutput_1;
			if (ne_tDBOutput_1 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
				errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
			}else{
				errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
			}
	    	
	    	int countSum_tDBOutput_1 = 0;
			for(int countEach_tDBOutput_1: e_tDBOutput_1.getUpdateCounts()) {
				countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
			}
			
	    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
	    	
            log.error("tDBOutput_1 - "  + (errormessage_tDBOutput_1) );
	    	System.err.println(errormessage_tDBOutput_1);
	    	
		}
	    
        if(pstmt_tDBOutput_1 != null) {
        		
            pstmt_tDBOutput_1.close();
            resourceMap.remove("pstmt_tDBOutput_1");
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection starting to commit ")  + (commitCounter_tDBOutput_1)  + (" record(s).") );
			conn_tDBOutput_1.commit();
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection commit has succeeded.") );
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Closing the connection to the database.") );
    	conn_tDBOutput_1 .close();
    	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection to the database has closed.") );
    	resourceMap.put("finish_tDBOutput_1", true);
    	

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Has ")  + ("inserted")  + (" ")  + (nb_line_inserted_tDBOutput_1)  + (" record(s).") );


			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row4",2,0,
			 			"tMomOutput_1","tMomOutput_1","tMomOutput","tDBOutput_1","tDBOutput_1","tPostgresqlOutput","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Done.") );

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */









				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRowGenerator_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tMomInput_1_LoopProcess(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRowGenerator_1 finally ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

 



/**
 * [tRowGenerator_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tMomOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tMomOutput_1";

	


 



/**
 * [tMomOutput_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Closing the connection to the database.") );
                    ctn_tDBOutput_1.close();
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection to the database has closed.") );
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
            log.error("tDBOutput_1 - "  + (errorMessage_tDBOutput_1) );
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
        }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */









				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", 1);
	}
	


public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_Queue_Write_Read = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_Queue_Write_Read = new byte[0];

	
			    public String from;

				public String getFrom () {
					return this.from;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_Queue_Write_Read.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_Queue_Write_Read.length == 0) {
   					commonByteArray_LOCAL_PROJECT_Queue_Write_Read = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_Queue_Write_Read = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_Queue_Write_Read, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_Queue_Write_Read, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_Queue_Write_Read) {

        	try {

        		int length = 0;
		
					this.from = readString(dis);
					
					this.message = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.from,dos);
					
					// String
				
						writeString(this.message,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("from="+from);
		sb.append(",message="+message);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(from == null){
        					sb.append("<null>");
        				}else{
            				sb.append(from);
            			}
            		
        			sb.append("|");
        		
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tMomInput_1_LoopProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMomInput_1_Loop_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
		String currentVirtualComponent = null;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row3Struct row3 = new row3Struct();



	
	/**
	 * [tMomInput_1_Loop begin ] start
	 */

				
			int NB_ITERATE_tMomInput_1_In = 0; //for statistics
			

	
		
		ok_Hash.put("tMomInput_1_Loop", false);
		start_Hash.put("tMomInput_1_Loop", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tMomInput_1";
	
	currentComponent="tMomInput_1_Loop";

	
		int tos_count_tMomInput_1_Loop = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMomInput_1_Loop - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMomInput_1_Loop{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMomInput_1_Loop = new StringBuilder();
                    log4jParamters_tMomInput_1_Loop.append("Parameters:");
                            log4jParamters_tMomInput_1_Loop.append("KEEPLISTENING" + " = " + "false");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("USE_CONNECTION" + " = " + "false");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("STARTSERVER" + " = " + "false");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("USEMAX" + " = " + "false");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("FAILOVER" + " = " + "false");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("STATIC" + " = " + "false");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("TIMEOUT" + " = " + "1");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("SERVER" + " = " + "ActiveMQ");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("USE_SSL" + " = " + "false");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("SERVERADDRESS" + " = " + "\"host.docker.internal\"");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("SERVERPORT" + " = " + "\"61616\"");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("USER" + " = " + "\"admin\"");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:yTJQ/L0QimSQP8kVAkknOMKBNbiVMJvUKbmybad+LZ/O").substring(0, 4) + "...");     
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("FROM" + " = " + "\"customerData\"");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("MSGTYPE" + " = " + "Queue");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("MESSAGE_BODY_TYPE" + " = " + "Text");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                            log4jParamters_tMomInput_1_Loop.append("ACKNOWLEDGMENT_MODE" + " = " + "AUTO_ACKNOWLEDGE");
                        log4jParamters_tMomInput_1_Loop.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMomInput_1_Loop - "  + (log4jParamters_tMomInput_1_Loop) );
                    } 
                } 
            new BytesLimit65535_tMomInput_1_Loop().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMomInput_1_Loop", "tMomInput_1_Loop", "tMomInputLoop");
				talendJobLogProcess(globalMap);
			}
			
					runStat.updateStatAndLog(execStat,enableLogStash,iterateId,0,0,"row3");
					
	

	int nb_line_tMomInput_1 = 0;
	javax.jms.Connection connection_tMomInput_1 = null;
	
		javax.jms.Session session_tMomInput_1 = null;
		javax.jms.MessageConsumer consumer_tMomInput_1 = null;
	
	try {

					String url_tMomInput_1 ="";
	      		String endParam_tMomInput_1="";
 				
					url_tMomInput_1 = "tcp://"+"host.docker.internal"+":"+"61616";
							
	
				
				System.out.println("Connecting to URL: " + url_tMomInput_1);
				System.out.println("Consuming " + (false ? "topic" : "queue") + ": " + "customerData");
					
					log.info("tMomInput_1 - Attempt to create connection from URL: " + url_tMomInput_1 + ".");
				
				org.apache.activemq.ActiveMQConnectionFactory factory_tMomInput_1 = new org.apache.activemq.ActiveMQConnectionFactory(url_tMomInput_1);
			
			
				
	
				 
	final String decryptedPassword_tMomInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:KRSybRE/SWs7I4P7BIP2piOmn3S9KN35svKpoA3oHDmg");
			
				connection_tMomInput_1 = factory_tMomInput_1.createConnection("admin",decryptedPassword_tMomInput_1);
				
				log.info("tMomInput_1 - Created connection successfully.");
				log.info("tMomInput_1 - Activating the connection...");
			
			connection_tMomInput_1.start();
				
				log.info("tMomInput_1 - Activate successfully.");
				log.info("tMomInput_1 - Creating a session...");
			
			session_tMomInput_1 = connection_tMomInput_1.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
				
				log.info("tMomInput_1 - Created session successfully.");
			
			javax.jms.Destination des_tMomInput_1 = null;
	
	
	
			
				des_tMomInput_1 = session_tMomInput_1.createQueue("customerData");
			
			javax.jms.MessageProducer replyProducer_tMomInput_1 = session_tMomInput_1.createProducer(null);
			replyProducer_tMomInput_1.setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);
				
			consumer_tMomInput_1 = session_tMomInput_1.createConsumer(des_tMomInput_1);
			
			
				globalMap.put("session_tMomInput_1",session_tMomInput_1);
				globalMap.put("connection_tMomInput_1",connection_tMomInput_1);
	       	
	
				
						log.info("tMomInput_1 - Listening to receive messages...");
						log.info("tMomInput_1 - Listening time last for:  " + 1*1000 + " ms, and then stop.");
					
				    System.out.println("We will wait for messages within: " + 1*1000 + " ms, and then we will shutdown");
				    javax.jms.Message message_tMomInput_1;
				    while ((message_tMomInput_1 = consumer_tMomInput_1.receive(1*1000)) != null) {
	
					
				
					javax.jms.TextMessage txtMsg_tMomInput_1 = (javax.jms.TextMessage) message_tMomInput_1;
					String msg_tMomInput_1 = txtMsg_tMomInput_1.getText();
				
				
		
		


		

 



/**
 * [tMomInput_1_Loop begin ] stop
 */
	
	/**
	 * [tMomInput_1_Loop main ] start
	 */

	

	
	
		currentVirtualComponent = "tMomInput_1";
	
	currentComponent="tMomInput_1_Loop";

	
				resourceMap.put("inIterateVComp", true);
			

 


	tos_count_tMomInput_1_Loop++;

/**
 * [tMomInput_1_Loop main ] stop
 */
	
	/**
	 * [tMomInput_1_Loop process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tMomInput_1";
	
	currentComponent="tMomInput_1_Loop";

	

 



/**
 * [tMomInput_1_Loop process_data_begin ] stop
 */
	NB_ITERATE_tMomInput_1_In++;
	
	
				if(execStat){
					runStat.updateStatOnConnection("Iterate", 1, "exec" + NB_ITERATE_tMomInput_1_In);
					//Thread.sleep(1000);
				}				
			


	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_1", false);
		start_Hash.put("tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_1";

	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row3");
			
		int tos_count_tLogRow_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tLogRow_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
                    log4jParamters_tLogRow_1.append("Parameters:");
                            log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "true");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("FIELDSEPARATOR" + " = " + "\"|\"");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("PRINT_HEADER" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("PRINT_UNIQUE_NAME" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("PRINT_COLNAMES" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("USE_FIXED_LENGTH" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
                        log4jParamters_tLogRow_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + (log4jParamters_tLogRow_1) );
                    } 
                } 
            new BytesLimit65535_tLogRow_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tLogRow_1", "tLogRow_1", "tLogRow");
				talendJobLogProcess(globalMap);
			}
			

	///////////////////////
	
		final String OUTPUT_FIELD_SEPARATOR_tLogRow_1 = "|";
		java.io.PrintStream consoleOut_tLogRow_1 = null;	

 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



/**
 * [tLogRow_1 begin ] stop
 */



	
	/**
	 * [tMomInput_1_In begin ] start
	 */

	

	
		
		ok_Hash.put("tMomInput_1_In", false);
		start_Hash.put("tMomInput_1_In", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tMomInput_1";
	
	currentComponent="tMomInput_1_In";

	
		int tos_count_tMomInput_1_In = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMomInput_1_In - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMomInput_1_In{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMomInput_1_In = new StringBuilder();
                    log4jParamters_tMomInput_1_In.append("Parameters:");
                            log4jParamters_tMomInput_1_In.append("USE_CONNECTION" + " = " + "false");
                        log4jParamters_tMomInput_1_In.append(" | ");
                            log4jParamters_tMomInput_1_In.append("SERVER" + " = " + "ActiveMQ");
                        log4jParamters_tMomInput_1_In.append(" | ");
                            log4jParamters_tMomInput_1_In.append("FROM" + " = " + "\"customerData\"");
                        log4jParamters_tMomInput_1_In.append(" | ");
                            log4jParamters_tMomInput_1_In.append("MESSAGE_BODY_TYPE" + " = " + "Text");
                        log4jParamters_tMomInput_1_In.append(" | ");
                            log4jParamters_tMomInput_1_In.append("GET_JMS_HEADER" + " = " + "false");
                        log4jParamters_tMomInput_1_In.append(" | ");
                            log4jParamters_tMomInput_1_In.append("GET_JMS_PROPERTIES" + " = " + "false");
                        log4jParamters_tMomInput_1_In.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMomInput_1_In - "  + (log4jParamters_tMomInput_1_In) );
                    } 
                } 
            new BytesLimit65535_tMomInput_1_In().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMomInput_1_In", "tMomInput_1_In", "tMomInputIn");
				talendJobLogProcess(globalMap);
			}
			
						resourceMap.remove("inIterateVComp");
					

 



/**
 * [tMomInput_1_In begin ] stop
 */
	
	/**
	 * [tMomInput_1_In main ] start
	 */

	

	
	
		currentVirtualComponent = "tMomInput_1";
	
	currentComponent="tMomInput_1_In";

	

	
		log.debug("tMomInput_1 - Retrieving the record " + (nb_line_tMomInput_1+1) + ".");
	
					row3.from="customerData";	
				
					row3.message=msg_tMomInput_1;	
					    
	
	
	nb_line_tMomInput_1++;

		

 


	tos_count_tMomInput_1_In++;

/**
 * [tMomInput_1_In main ] stop
 */
	
	/**
	 * [tMomInput_1_In process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tMomInput_1";
	
	currentComponent="tMomInput_1_In";

	

 



/**
 * [tMomInput_1_In process_data_begin ] stop
 */

	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row3","tMomInput_1_In","tMomInput_1_In","tMomInputIn","tLogRow_1","tLogRow_1","tLogRow"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row3 - " + (row3==null? "": row3.toLogString()));
    			}
    		
///////////////////////		
						



				strBuffer_tLogRow_1 = new StringBuilder();




   				
	    		if(row3.from != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(row3.from)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(row3.message != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(row3.message)							
				);


							
	    		} //  			
 

                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    	log.info("tLogRow_1 - Content of row "+(nb_line_tLogRow_1+1)+": " + strBuffer_tLogRow_1.toString());
                    consoleOut_tLogRow_1.println(strBuffer_tLogRow_1.toString());
                    consoleOut_tLogRow_1.flush();
                    nb_line_tLogRow_1++;
//////

//////                    
                    
///////////////////////    			

 


	tos_count_tLogRow_1++;

/**
 * [tLogRow_1 main ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_begin ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_end ] stop
 */



	
	/**
	 * [tMomInput_1_In process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tMomInput_1";
	
	currentComponent="tMomInput_1_In";

	

 



/**
 * [tMomInput_1_In process_data_end ] stop
 */
	
	/**
	 * [tMomInput_1_In end ] start
	 */

	

	
	
		currentVirtualComponent = "tMomInput_1";
	
	currentComponent="tMomInput_1_In";

	
						resourceMap.put("inIterateVComp", true);
					

 
                if(log.isDebugEnabled())
            log.debug("tMomInput_1_In - "  + ("Done.") );

ok_Hash.put("tMomInput_1_In", true);
end_Hash.put("tMomInput_1_In", System.currentTimeMillis());




/**
 * [tMomInput_1_In end ] stop
 */

	
	/**
	 * [tLogRow_1 end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	


//////
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);
                if(log.isInfoEnabled())
            log.info("tLogRow_1 - "  + ("Printed row count: ")  + (nb_line_tLogRow_1)  + (".") );

///////////////////////    			

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row3",2,0,
			 			"tMomInput_1_In","tMomInput_1_In","tMomInputIn","tLogRow_1","tLogRow_1","tLogRow","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Done.") );

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());




/**
 * [tLogRow_1 end ] stop
 */



						if(execStat){
							runStat.updateStatOnConnection("Iterate", 2, "exec" + NB_ITERATE_tMomInput_1_In);
						}				
					




	
	/**
	 * [tMomInput_1_Loop process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tMomInput_1";
	
	currentComponent="tMomInput_1_Loop";

	

 



/**
 * [tMomInput_1_Loop process_data_end ] stop
 */
	
	/**
	 * [tMomInput_1_Loop end ] start
	 */

	

	
	
		currentVirtualComponent = "tMomInput_1";
	
	currentComponent="tMomInput_1_Loop";

	
				resourceMap.remove("inIterateVComp");
			

	
        
		}
		
	

} finally {
	
		if(consumer_tMomInput_1!=null){
			consumer_tMomInput_1.close();
		}
		
		
			
			log.info("tMomInput_1 - Closing connection...");
			
		
			
			if (session_tMomInput_1 != null  && connection_tMomInput_1 != null) {
	 			session_tMomInput_1.close();
 		 	}
			
	
	        if (connection_tMomInput_1 != null) {
	         	connection_tMomInput_1.close();
	        }
	        
	        
			log.info("tMomInput_1 - Closed successfully");
			
		
		
}

	log.info("tMomInput_1 - Consumed messages count: "+ nb_line_tMomInput_1 + " .");

	globalMap.put("tMomInput_1_NB_LINE",nb_line_tMomInput_1);

			runStat.updateStatAndLog(execStat,enableLogStash,iterateId,2,0,"row3");
			
 
                if(log.isDebugEnabled())
            log.debug("tMomInput_1_Loop - "  + ("Done.") );

ok_Hash.put("tMomInput_1_Loop", true);
end_Hash.put("tMomInput_1_Loop", System.currentTimeMillis());




/**
 * [tMomInput_1_Loop end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tMomInput_1_Loop finally ] start
	 */

	

	
	
		currentVirtualComponent = "tMomInput_1";
	
	currentComponent="tMomInput_1_Loop";

	

 



/**
 * [tMomInput_1_Loop finally ] stop
 */

	
	/**
	 * [tMomInput_1_In finally ] start
	 */

	

	
	
		currentVirtualComponent = "tMomInput_1";
	
	currentComponent="tMomInput_1_In";

	

 



/**
 * [tMomInput_1_In finally ] stop
 */

	
	/**
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tMomInput_1_Loop_SUBPROCESS_STATE", 1);
	}
	

public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [talendJobLog begin ] start
	 */

	

	
		
		ok_Hash.put("talendJobLog", false);
		start_Hash.put("talendJobLog", System.currentTimeMillis());
		
	
	currentComponent="talendJobLog";

	
		int tos_count_talendJobLog = 0;
		

	for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
		org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
			.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid).custom("father_pid", fatherPid).custom("root_pid", rootPid);
		org.talend.logging.audit.Context log_context_talendJobLog = null;
		
		
		if(jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE){
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.sourceId(jcm.sourceId).sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
				.targetId(jcm.targetId).targetLabel(jcm.targetLabel).targetConnectorType(jcm.targetComponentName)
				.connectionName(jcm.current_connector).rows(jcm.row_count).duration(duration).build();
			auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
			auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
		
			log_context_talendJobLog = builder_talendJobLog
				.timestamp(jcm.moment).duration(duration).status(jcm.status).build();
			auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label).build();
			auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {//log current component input line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {//log current component output/reject line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
		}
		
		
		
	}

 



/**
 * [talendJobLog begin ] stop
 */
	
	/**
	 * [talendJobLog main ] start
	 */

	

	
	
	currentComponent="talendJobLog";

	

 


	tos_count_talendJobLog++;

/**
 * [talendJobLog main ] stop
 */
	
	/**
	 * [talendJobLog process_data_begin ] start
	 */

	

	
	
	currentComponent="talendJobLog";

	

 



/**
 * [talendJobLog process_data_begin ] stop
 */
	
	/**
	 * [talendJobLog process_data_end ] start
	 */

	

	
	
	currentComponent="talendJobLog";

	

 



/**
 * [talendJobLog process_data_end ] stop
 */
	
	/**
	 * [talendJobLog end ] start
	 */

	

	
	
	currentComponent="talendJobLog";

	

 

ok_Hash.put("talendJobLog", true);
end_Hash.put("talendJobLog", System.currentTimeMillis());




/**
 * [talendJobLog end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [talendJobLog finally ] start
	 */

	

	
	
	currentComponent="talendJobLog";

	

 



/**
 * [talendJobLog finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final Queue_Write_Read Queue_Write_ReadClass = new Queue_Write_Read();

        int exitCode = Queue_Write_ReadClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'Queue_Write_Read' - Done.");
	        }

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

	        if(!"".equals(log4jLevel)){
	        	
				
				
				if("trace".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.OFF);
				}
				org.apache.logging.log4j.core.config.Configurator.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());
				
    	    }
        	log.info("TalendJob: 'Queue_Write_Read' - Start.");
    	
    	
    	
			if(enableLogStash) {
				java.util.Properties properties_talendJobLog = new java.util.Properties();
				properties_talendJobLog.setProperty("root.logger", "audit");
				properties_talendJobLog.setProperty("encoding", "UTF-8");
				properties_talendJobLog.setProperty("application.name", "Talend Studio");
				properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
				properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
				properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
				properties_talendJobLog.setProperty("log.appender", "file");
				properties_talendJobLog.setProperty("appender.file.path", "audit.json");
				properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
				properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
				properties_talendJobLog.setProperty("host", "false");

				System.getProperties().stringPropertyNames().stream()
					.filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()), System.getProperty(key)));

				
				
				
				org.apache.logging.log4j.core.config.Configurator.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);
				
				auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory.createJobAuditLogger(properties_talendJobLog);
			}
		

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }

        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = Queue_Write_Read.class.getClassLoader().getResourceAsStream("local_project/queue_write_read_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Queue_Write_Read.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("filePath", "id_String");
                        if(context.getStringValue("filePath") == null) {
                            context.filePath = null;
                        } else {
                            context.filePath=(String) context.getProperty("filePath");
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("filePath")) {
                context.filePath = (String) parentContextMap.get("filePath");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob




		if(enableLogStash) {
	        talendJobLog.addJobStartMessage();
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }

this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tRowGenerator_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tRowGenerator_1) {
globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", -1);

e_tRowGenerator_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Queue_Write_Read");
        }
		if(enableLogStash) {
	        talendJobLog.addJobEndMessage(startTime, end, status);
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }

    closeJmsConnections();


if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {
    closeJmsConnections();


    }

    private void closeJmsConnections() {
        try {
            Object obj_conn;
            obj_conn = globalMap.remove("connection_tMomInput_1");
            if (null != obj_conn) {
                ((javax.jms.Connection) obj_conn).close();
            }
            obj_conn = globalMap.remove("connection_tMomOutput_1");
            if (null != obj_conn) {
                ((javax.jms.Connection) obj_conn).close();
            }
        } catch (java.lang.Exception e) {
        }
    }













    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
            connections.put("connection_tMomInput_1", globalMap.get("connection_tMomInput_1"));
            connections.put("session_tMomInput_1", globalMap.get("session_tMomInput_1"));
            connections.put("connection_tMomOutput_1", globalMap.get("connection_tMomOutput_1"));
            connections.put("session_tMomOutput_1", globalMap.get("session_tMomOutput_1"));






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     118301 characters generated by Talend Cloud Real-Time Big Data Platform 
 *     on the 26 June 2023 12:36:44 BST
 ************************************************************************************************/
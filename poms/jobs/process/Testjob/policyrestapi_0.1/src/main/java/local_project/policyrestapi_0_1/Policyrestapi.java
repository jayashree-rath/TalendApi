
package local_project.policyrestapi_0_1;

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

//the import part of tJavaRow_1
//import java.util.List;

//the import part of tJavaRow_2
//import java.util.List;

@SuppressWarnings("unused")

/**
 * Job: Policyrestapi Purpose: <br>
 * Description: <br>
 * 
 * @author jayashree.rath@keyrus.com
 * @version 7.3.1.20210623_0656-patch
 * @status
 */
public class Policyrestapi implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "Policyrestapi.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(Policyrestapi.class);

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

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
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

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (transactiontypecode != null) {

				this.setProperty("transactiontypecode", transactiontypecode.toString());

			}

			if (sql_query != null) {

				this.setProperty("sql_query", sql_query.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String transactiontypecode;

		public String getTransactiontypecode() {
			return this.transactiontypecode;
		}

		public String sql_query;

		public String getSql_query() {
			return this.sql_query;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "Policyrestapi";
	private final String projectName = "LOCAL_PROJECT";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName,
			"_Grh-4CDMEe6sQrDe__YbWg", "0.1");
	private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

	private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
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

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
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
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					Policyrestapi.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Policyrestapi.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tPrejob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBConnection_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJavaRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBRow_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBCommit_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBRow_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJavaRow_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBRow_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBRow_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBCommit_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBRow_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTRequest_1_Loop_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tRESTRequest_1_In_error(exception, errorComponent, globalMap);

	}

	public void tRESTRequest_1_In_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPrejob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBRow_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBRow_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRESTRequest_1_Loop_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	private boolean runInTalendEsbRuntimeContainer = false;

	public void setRunInTalendEsbRuntimeContainer(boolean flag) {
		runInTalendEsbRuntimeContainer = flag;
	}

	protected String restEndpoint;

	public void setRestEndpoint(String restEndpoint) {
		this.restEndpoint = restEndpoint;
	}

	public String getRestEndpoint() {
		return "http://localhost:9000/Agreementstatus";
	}

	private boolean runInDaemonMode = true;

	public void setRunInDaemonMode(boolean flag) {
		runInDaemonMode = flag;
	}

	private boolean restTalendJobAlreadyStarted = false;

	/**
	 * REST provider implementation
	 */
	@javax.ws.rs.Path("/")
	public static class RestServiceProviderImpl4TalendJob {

		@javax.ws.rs.core.Context
		private org.apache.cxf.jaxrs.ext.MessageContext messageContext;

		private final Policyrestapi job;

		public RestServiceProviderImpl4TalendJob(Policyrestapi job) {
			this.job = job;
		}

		private void populateRequestWithJobContext(java.util.Map<String, Object> requestGlobalMap, Policyrestapi job) {
			// pass job DataSources
			java.util.Map<String, routines.system.TalendDataSource> talendDataSources = (java.util.Map<String, routines.system.TalendDataSource>) job.globalMap
					.get(KEY_DB_DATASOURCES);
			if (null != talendDataSources) {
				java.util.Map<String, routines.system.TalendDataSource> restDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
				for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry : talendDataSources
						.entrySet()) {
					restDataSources.put(talendDataSourceEntry.getKey(),
							new routines.system.TalendDataSource(talendDataSourceEntry.getValue().getRawDataSource()));
				}
				requestGlobalMap.put(KEY_DB_DATASOURCES, restDataSources);
			}

			if (null != job.globalMap.get(KEY_DB_DATASOURCES_RAW)) {
				requestGlobalMap.put(KEY_DB_DATASOURCES_RAW, job.globalMap.get(KEY_DB_DATASOURCES_RAW));
			}

			// pass job shared connections
			requestGlobalMap.putAll(job.getSharedConnections4REST());

			// pass job concurrent map
			requestGlobalMap.put("concurrentHashMap", job.globalMap.get("concurrentHashMap"));

			requestGlobalMap.putAll(job.globalMap);
		}

		private void closePassedDataSourceConnections(java.util.Map<String, Object> requestGlobalMap) {
			// close connections in passed job DataSources
			try {
				java.util.Map<String, routines.system.TalendDataSource> restDataSources = (java.util.Map<String, routines.system.TalendDataSource>) requestGlobalMap
						.get(KEY_DB_DATASOURCES);
				if (null != restDataSources) {
					for (routines.system.TalendDataSource restDataSource : restDataSources.values()) {
						restDataSource.close();
					}
				}
			} catch (Throwable e) {
				e.printStackTrace(System.err);
			}
		}

		private javax.ws.rs.core.Response processRequest(java.util.Map<String, Object> request) {

			final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();

			try {
				globalMap.put("restRequest", request);

				populateRequestWithJobContext(globalMap, job);

				job.tRESTRequest_1_LoopProcess(globalMap);

				java.util.Map<String, Object> response = (java.util.Map<String, Object>) globalMap.get("restResponse");

				Object responseBody = null;
				Integer status = null;
				java.util.Map<String, String> headers = null;
				if (null != response) {
					Object dropJsonRootProp = response.get("drop.json.root.element");
					Boolean dropJsonRoot = (null == dropJsonRootProp) ? false : (Boolean) dropJsonRootProp;
					messageContext.put("drop.json.root.element", dropJsonRoot.toString());

					responseBody = response.get("BODY");
					status = (Integer) response.get("STATUS");
					headers = (java.util.Map<String, String>) response.get("HEADERS");
				}
				if (null == status) {
					status = (request.containsKey("STATUS")) ? (Integer) request.get("STATUS") : 404;
				}

				javax.ws.rs.core.Response.ResponseBuilder responseBuilder = javax.ws.rs.core.Response.status(status)
						.entity(responseBody);
				if (headers != null) {
					for (java.util.Map.Entry<String, String> header : headers.entrySet()) {
						responseBuilder.header(header.getKey(), header.getValue());
					}
				}

				return responseBuilder.build();

			} catch (Throwable ex) {
				ex.printStackTrace();
				throw new javax.ws.rs.WebApplicationException(ex, 500);
			} finally {
				// close DB connections
				closePassedDataSourceConnections(globalMap);
			}
		}

		private javax.ws.rs.core.Response processStreamingResponseRequest(final java.util.Map<String, Object> request) {

			javax.ws.rs.core.StreamingOutput streamingOutput = new javax.ws.rs.core.StreamingOutput() {
				public void write(java.io.OutputStream output) {

					final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();

					try {
						globalMap.put("restResponseStream", output);

						globalMap.put("restRequest", request);

						populateRequestWithJobContext(globalMap, job);

						job.tRESTRequest_1_LoopProcess(globalMap);

						if (globalMap.containsKey("restResponseWrappingClosure")) {
							output.write(((String) globalMap.get("restResponseWrappingClosure")).getBytes());
						}
					} catch (Throwable ex) {
						ex.printStackTrace();
						throw new javax.ws.rs.WebApplicationException(ex, 500);
					} finally {
						// close DB connections
						closePassedDataSourceConnections(globalMap);
					}
				}
			};

			return javax.ws.rs.core.Response.ok().entity(streamingOutput).build();
		}

		@javax.ws.rs.GET()

		@javax.ws.rs.Path("renewal/{transactiontypecode}/")
		@javax.ws.rs.Produces({ "application/xml", "text/xml", "application/json" })
		public javax.ws.rs.core.Response renewalagreement(

				@javax.ws.rs.PathParam("transactiontypecode") String transactiontypecode

		) {
			java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
			request_tRESTRequest_1.put("VERB", "GET");
			request_tRESTRequest_1.put("OPERATION", "renewalagreement");
			request_tRESTRequest_1.put("PATTERN", "renewal/{transactiontypecode}/");

			populateRequestInfo(request_tRESTRequest_1, messageContext);

			java.util.Map<String, Object> parameters_tRESTRequest_1 = new java.util.HashMap<String, Object>();

			parameters_tRESTRequest_1.put("PATH:transactiontypecode:id_String", transactiontypecode);

			request_tRESTRequest_1.put("PARAMS", parameters_tRESTRequest_1);

			return processRequest(request_tRESTRequest_1);
		}

		@javax.ws.rs.GET()

		@javax.ws.rs.Path("new/{transactiontypecode}/")
		@javax.ws.rs.Produces({ "application/xml", "text/xml", "application/json" })
		public javax.ws.rs.core.Response newagreement(

				@javax.ws.rs.PathParam("transactiontypecode") String transactiontypecode

		) {
			java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
			request_tRESTRequest_1.put("VERB", "GET");
			request_tRESTRequest_1.put("OPERATION", "newagreement");
			request_tRESTRequest_1.put("PATTERN", "new/{transactiontypecode}/");

			populateRequestInfo(request_tRESTRequest_1, messageContext);

			java.util.Map<String, Object> parameters_tRESTRequest_1 = new java.util.HashMap<String, Object>();

			parameters_tRESTRequest_1.put("PATH:transactiontypecode:id_String", transactiontypecode);

			request_tRESTRequest_1.put("PARAMS", parameters_tRESTRequest_1);

			return processRequest(request_tRESTRequest_1);
		}

		public javax.ws.rs.core.Response handleWrongRequest(org.apache.cxf.jaxrs.ext.MessageContext context, int status,
				String error) {

			// System.out.println("wrong call [uri: " + context.getUriInfo().getPath() + " ;
			// method: " + context.getRequest().getMethod() + " ; status: " + status + " ;
			// error: " + error + "]");

			java.util.Map<String, Object> wrongRequest = new java.util.HashMap<String, Object>();

			wrongRequest.put("ERROR", error);
			wrongRequest.put("STATUS", status);
			wrongRequest.put("VERB", context.getRequest().getMethod());
			wrongRequest.put("URI", context.getUriInfo().getPath());
			wrongRequest.put("URI_BASE", context.getUriInfo().getBaseUri().toString());
			wrongRequest.put("URI_ABSOLUTE", context.getUriInfo().getAbsolutePath().toString());
			wrongRequest.put("URI_REQUEST", context.getUriInfo().getRequestUri().toString());

			return processRequest(wrongRequest);
		}

		private void populateRequestInfo(java.util.Map<String, Object> request,
				org.apache.cxf.jaxrs.ext.MessageContext context) {
			final javax.ws.rs.core.UriInfo ui = context.getUriInfo();

			request.put("URI", ui.getPath());
			request.put("URI_BASE", ui.getBaseUri().toString());
			request.put("URI_ABSOLUTE", ui.getAbsolutePath().toString());
			request.put("URI_REQUEST", ui.getRequestUri().toString());

			request.put("ALL_HEADER_PARAMS", context.getHttpHeaders().getRequestHeaders());
			request.put("ALL_QUERY_PARAMS", ui.getQueryParameters());

			javax.ws.rs.core.SecurityContext securityContext = context.getSecurityContext();
			if (null != securityContext && null != securityContext.getUserPrincipal()) {
				request.put("PRINCIPAL_NAME", securityContext.getUserPrincipal().getName());
			}

			request.put("CorrelationID", context.get("CorrelationID"));

			request.put("MESSAGE_CONTEXT", context);
		}

		private void populateMultipartRequestInfo(java.util.Map<String, Object> request,
				org.apache.cxf.jaxrs.ext.MessageContext context, java.util.List<String> partNames) {
			java.util.Map<String, String> attachmentFilenames = new java.util.HashMap<String, String>();

			java.util.Map<String, java.util.Map<String, java.util.List<String>>> attachmentHeaders = new java.util.HashMap<String, java.util.Map<String, java.util.List<String>>>();

			for (String partName : partNames) {
				org.apache.cxf.jaxrs.ext.multipart.Attachment attachment = getFirstMatchingPart(context, partName);
				if (null != attachment) {
					attachmentHeaders.put(partName, attachment.getHeaders());
					if (null != attachment.getContentDisposition()) {
						String filename = attachment.getContentDisposition().getParameter("filename");
						if (null != filename) {
							attachmentFilenames.put(partName, filename);
						}
					}
				}
			}

			request.put("ATTACHMENT_HEADERS", attachmentHeaders);
			request.put("ATTACHMENT_FILENAMES", attachmentFilenames);
		}

		private static org.apache.cxf.jaxrs.ext.multipart.Attachment getFirstMatchingPart(
				org.apache.cxf.jaxrs.ext.MessageContext context, String partName) {
			List<org.apache.cxf.jaxrs.ext.multipart.Attachment> attachments = org.apache.cxf.jaxrs.utils.multipart.AttachmentUtils
					.getAttachments(context);
			for (org.apache.cxf.jaxrs.ext.multipart.Attachment attachment : attachments) {
				if (partName.equals(attachment.getContentId())) {
					return attachment;
				}
				org.apache.cxf.jaxrs.ext.multipart.ContentDisposition cd = attachment.getContentDisposition();
				if (null != cd && partName.equals(cd.getParameter("name"))) {
					return attachment;
				}
			}
			// unexpected
			throw new javax.ws.rs.InternalServerErrorException();
		}
	}

	public static class ExceptionMapper4TalendJobRestService
			extends org.apache.cxf.jaxrs.impl.WebApplicationExceptionMapper {

		@javax.ws.rs.core.Context
		private org.apache.cxf.jaxrs.ext.MessageContext messageContext;

		private RestServiceProviderImpl4TalendJob provider;

		public ExceptionMapper4TalendJobRestService(RestServiceProviderImpl4TalendJob provider) {
			this.provider = provider;
		}

		public javax.ws.rs.core.Response toResponse(javax.ws.rs.WebApplicationException ex) {
			String error = null;
			javax.ws.rs.core.Response response = ex.getResponse();
			if (null != response && null != response.getEntity()) {
				error = response.getEntity().toString();
			}
			response = super.toResponse(ex);
			if (null == error) {
				if (null != response && null != response.getEntity()) {
					error = response.getEntity().toString();
				} else {
					error = null == ex.getCause() ? ex.getMessage() : ex.getCause().getMessage();
				}
			}
			response = provider.handleWrongRequest(messageContext, response.getStatus(), error);

			java.util.List<javax.ws.rs.core.MediaType> accepts = messageContext.getHttpHeaders()
					.getAcceptableMediaTypes();
			javax.ws.rs.core.MediaType responseType = accepts.isEmpty() ? null : accepts.get(0);

			if (responseType == null
					|| !responseType.getSubtype().equals("xml") && !responseType.getSubtype().equals("json")) {
				responseType = javax.ws.rs.core.MediaType.APPLICATION_XML_TYPE;
			}

			javax.ws.rs.core.Response r = javax.ws.rs.core.Response.status(response.getStatus())
					.entity(response.getEntity()).type(responseType).build();

			if (response.getHeaders() != null) {
				r.getHeaders().putAll(response.getHeaders());
			}

			return r;
		}
	}

	protected String checkEndpointUrl(String url) {
		final String defaultEndpointUrl = "http://127.0.0.1:8090/";

		String endpointUrl = url;
		if (null == endpointUrl || endpointUrl.trim().isEmpty()) {
			endpointUrl = defaultEndpointUrl;
		} else if (!endpointUrl.contains("://")) { // relative
			if (endpointUrl.startsWith("/")) {
				endpointUrl = endpointUrl.substring(1);
			}
			endpointUrl = defaultEndpointUrl + endpointUrl;
		}

		// test for busy
		java.net.URI endpointURI = java.net.URI.create(endpointUrl);
		String host = endpointURI.getHost();
		try {
			if (java.net.InetAddress.getByName(host).isLoopbackAddress()) {
				int port = endpointURI.getPort();
				java.net.ServerSocket ss = null;
				try {
					ss = new java.net.ServerSocket(port);
				} catch (IOException e) {
					// rethrow exception
					throw new IllegalArgumentException(
							"Cannot start provider with uri: " + endpointUrl + ". Port " + port + " already in use.");
				} finally {
					if (ss != null) {
						try {
							ss.close();
						} catch (IOException e) {
							// ignore
						}
					}
				}
				try {
					// ok, let's doublecheck for silent listeners
					java.net.Socket cs = new java.net.Socket(host, port);
					// if succeed - somebody silently listening, fail!
					cs.close();
					// rethrow exception
					throw new IllegalArgumentException(
							"Cannot start provider with uri: " + endpointUrl + ". Port " + port + " already in use.");
				} catch (IOException e) {
					// ok, nobody listens, proceed
				}
			}
		} catch (java.net.UnknownHostException e) {
			// ignore
		}

		return endpointUrl;
	}

	public static class StreamingDOM4JProvider extends org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider {

		public static final String SUPRESS_XML_DECLARATION = "supress.xml.declaration";

		private java.util.Map<String, Object> globalMap = null;

		public void setGlobalMap(java.util.Map<String, Object> globalMap) {
			this.globalMap = globalMap;
		}

		public void writeTo(org.dom4j.Document doc, Class<?> cls, java.lang.reflect.Type type,
				java.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt,
				javax.ws.rs.core.MultivaluedMap<String, Object> headers, java.io.OutputStream os)
				throws java.io.IOException, javax.ws.rs.WebApplicationException {
			if (mt.getSubtype().contains("xml")) {
				org.dom4j.io.XMLWriter writer;
				org.apache.cxf.message.Message currentMessage = null;
				if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
					currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
				} else {
					currentMessage = (org.apache.cxf.message.Message) ((java.util.Map<String, Object>) globalMap
							.get("restRequest")).get("CURRENT_MESSAGE");
				}

				if (currentMessage != null && currentMessage.getExchange() != null
						&& currentMessage.getExchange().containsKey(SUPRESS_XML_DECLARATION)) {
					org.dom4j.io.OutputFormat format = new org.dom4j.io.OutputFormat();
					format.setSuppressDeclaration(true);
					writer = new org.dom4j.io.XMLWriter(os, format);
				} else {
					writer = new org.dom4j.io.XMLWriter(os);
				}
				writer.write(doc);
				writer.flush();
			} else {
				super.writeTo(doc, cls, type, anns, mt, headers, os);
			}
		}
	}

	Thread4RestServiceProviderEndpoint thread4RestServiceProviderEndpoint = null;

	class Thread4RestServiceProviderEndpoint extends Thread {

		private final String endpointUrl;

		private final Policyrestapi job;

		private org.apache.cxf.endpoint.Server server;

		private org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf;

		public Thread4RestServiceProviderEndpoint(Policyrestapi job, String endpointUrl) {
			this.job = job;
			this.endpointUrl = endpointUrl;
			this.sf = new org.apache.cxf.jaxrs.JAXRSServerFactoryBean();
		}

		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		public org.apache.cxf.endpoint.Server getServer() {
			return server;
		}

		public org.apache.cxf.jaxrs.JAXRSServerFactoryBean getJAXRSServerFactoryBean() {
			return sf;
		}

		public void run() {

			try {
				RestServiceProviderImpl4TalendJob provider = new RestServiceProviderImpl4TalendJob(job);

				if (sf.getProperties() == null) {
					sf.setProperties(new java.util.HashMap<String, Object>());
				}

				java.util.List<Object> providers = (java.util.List<Object>) sf.getProviders();
				providers.add(new ExceptionMapper4TalendJobRestService(provider));
				providers.add(new StreamingDOM4JProvider());

				org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider = new org.apache.cxf.jaxrs.provider.json.JSONProvider();
				jsonProvider.setIgnoreNamespaces(true);
				jsonProvider.setAttributesToElements(true);

				jsonProvider.setConvertTypesToStrings(false);

				providers.add(jsonProvider);
				sf.setProviders(providers);
				sf.setTransportId("http://cxf.apache.org/transports/http");
				sf.setResourceClasses(RestServiceProviderImpl4TalendJob.class);
				sf.setResourceProvider(RestServiceProviderImpl4TalendJob.class,
						new org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider(provider));
				sf.setAddress(endpointUrl);

				final java.util.List<org.apache.cxf.feature.Feature> features = sf.getFeatures() == null
						? new java.util.ArrayList<org.apache.cxf.feature.Feature>()
						: sf.getFeatures();

				sf.setFeatures(features);

				server = sf.create();

				// System.out.println("REST service [endpoint: " + endpointUrl + "] published");
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		public void stopEndpoint() {
			if (null != server) {
				server.stop();
				server.destroy();
				// System.out.println("REST service [endpoint: " + endpointUrl + "]
				// unpublished");
			}
		}
	}

	public static class ContextBean {
		static String evaluate(String context, String contextExpression)
				throws IOException, javax.script.ScriptException {
			boolean isExpression = contextExpression.contains("+") || contextExpression.contains("(");
			final String prefix = isExpression ? "\"" : "";
			java.util.Properties defaultProps = new java.util.Properties();
			java.io.InputStream inContext = Policyrestapi.class.getClassLoader()
					.getResourceAsStream("local_project/policyrestapi_0_1/contexts/" + context + ".properties");
			if (inContext == null) {
				inContext = Policyrestapi.class.getClassLoader()
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
				contextExpression = contextExpression.replaceFirst("/services", "");
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
				java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils
						.getJobProperties(jobNameStripped);

				if (jobProperties != null) {
					currentContext = (String) jobProperties.get("context");
				}
			}

			return contextName.contains("context.")
					? evaluate(currentContext == null ? context : currentContext, contextName)
					: contextName;
		}
	}

	public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tPrejob_1 begin ] start
				 */

				ok_Hash.put("tPrejob_1", false);
				start_Hash.put("tPrejob_1", System.currentTimeMillis());

				currentComponent = "tPrejob_1";

				int tos_count_tPrejob_1 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tPrejob_1", "tPrejob_1", "tPrejob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tPrejob_1 begin ] stop
				 */

				/**
				 * [tPrejob_1 main ] start
				 */

				currentComponent = "tPrejob_1";

				tos_count_tPrejob_1++;

				/**
				 * [tPrejob_1 main ] stop
				 */

				/**
				 * [tPrejob_1 process_data_begin ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_begin ] stop
				 */

				/**
				 * [tPrejob_1 process_data_end ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_end ] stop
				 */

				/**
				 * [tPrejob_1 end ] start
				 */

				currentComponent = "tPrejob_1";

				ok_Hash.put("tPrejob_1", true);
				end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tDBConnection_1Process(globalMap);

				/**
				 * [tPrejob_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tPrejob_1 finally ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}

	public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tDBConnection_1 begin ] start
				 */

				ok_Hash.put("tDBConnection_1", false);
				start_Hash.put("tDBConnection_1", System.currentTimeMillis());

				currentComponent = "tDBConnection_1";

				int tos_count_tDBConnection_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBConnection_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBConnection_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBConnection_1 = new StringBuilder();
							log4jParamters_tDBConnection_1.append("Parameters:");
							log4jParamters_tDBConnection_1.append("DB_VERSION" + " = " + "V9_X");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("HOST" + " = " + "\"localhost\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("PORT" + " = " + "\"5432\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("DBNAME" + " = " + "\"postgres\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("SCHEMA_DB" + " = " + "\"finance\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("USER" + " = " + "\"postgres\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:bocbK1B8OiEsPln8mkwL2wpZ3jmSNWTeQeBvfb6UwRyNX1kCOg==")
									.substring(0, 4) + "...");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("USE_SHARED_CONNECTION" + " = " + "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("PROPERTIES" + " = " + "\"\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("AUTO_COMMIT" + " = " + "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1
									.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlConnection");
							log4jParamters_tDBConnection_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBConnection_1 - " + (log4jParamters_tDBConnection_1));
						}
					}
					new BytesLimit65535_tDBConnection_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBConnection_1", "tDBConnection_1", "tPostgresqlConnection");
					talendJobLogProcess(globalMap);
				}

				String dbProperties_tDBConnection_1 = "";
				String url_tDBConnection_1 = "jdbc:postgresql://" + "localhost" + ":" + "5432" + "/" + "postgres";

				if (dbProperties_tDBConnection_1 != null && !"".equals(dbProperties_tDBConnection_1.trim())) {
					url_tDBConnection_1 = url_tDBConnection_1 + "?" + dbProperties_tDBConnection_1;
				}
				String dbUser_tDBConnection_1 = "postgres";

				final String decryptedPassword_tDBConnection_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:bUmqEKz0uivnmy5JKVnt7l7Yb6ImdiOgcCYKXi1b/CQxRlIl9g==");
				String dbPwd_tDBConnection_1 = decryptedPassword_tDBConnection_1;

				java.sql.Connection conn_tDBConnection_1 = null;

				java.util.Enumeration<java.sql.Driver> drivers_tDBConnection_1 = java.sql.DriverManager.getDrivers();
				java.util.Set<String> redShiftDriverNames_tDBConnection_1 = new java.util.HashSet<String>(
						java.util.Arrays.asList("com.amazon.redshift.jdbc.Driver", "com.amazon.redshift.jdbc41.Driver",
								"com.amazon.redshift.jdbc42.Driver"));
				while (drivers_tDBConnection_1.hasMoreElements()) {
					java.sql.Driver d_tDBConnection_1 = drivers_tDBConnection_1.nextElement();
					if (redShiftDriverNames_tDBConnection_1.contains(d_tDBConnection_1.getClass().getName())) {
						try {
							java.sql.DriverManager.deregisterDriver(d_tDBConnection_1);
							java.sql.DriverManager.registerDriver(d_tDBConnection_1);
						} catch (java.lang.Exception e_tDBConnection_1) {
							globalMap.put("tDBConnection_1_ERROR_MESSAGE", e_tDBConnection_1.getMessage());
							// do nothing
						}
					}
				}
				String driverClass_tDBConnection_1 = "org.postgresql.Driver";
				java.lang.Class jdbcclazz_tDBConnection_1 = java.lang.Class.forName(driverClass_tDBConnection_1);
				globalMap.put("driverClass_tDBConnection_1", driverClass_tDBConnection_1);

				log.debug("tDBConnection_1 - Driver ClassName: " + driverClass_tDBConnection_1 + ".");

				log.debug("tDBConnection_1 - Connection attempt to '" + url_tDBConnection_1 + "' with the username '"
						+ dbUser_tDBConnection_1 + "'.");

				conn_tDBConnection_1 = java.sql.DriverManager.getConnection(url_tDBConnection_1, dbUser_tDBConnection_1,
						dbPwd_tDBConnection_1);
				log.debug("tDBConnection_1 - Connection to '" + url_tDBConnection_1 + "' has succeeded.");

				globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
				if (null != conn_tDBConnection_1) {

					log.debug("tDBConnection_1 - Connection is set auto commit to 'false'.");
					conn_tDBConnection_1.setAutoCommit(false);
				}

				globalMap.put("schema_" + "tDBConnection_1", "finance");

				globalMap.put("conn_" + "tDBConnection_1", conn_tDBConnection_1);

				/**
				 * [tDBConnection_1 begin ] stop
				 */

				/**
				 * [tDBConnection_1 main ] start
				 */

				currentComponent = "tDBConnection_1";

				tos_count_tDBConnection_1++;

				/**
				 * [tDBConnection_1 main ] stop
				 */

				/**
				 * [tDBConnection_1 process_data_begin ] start
				 */

				currentComponent = "tDBConnection_1";

				/**
				 * [tDBConnection_1 process_data_begin ] stop
				 */

				/**
				 * [tDBConnection_1 process_data_end ] start
				 */

				currentComponent = "tDBConnection_1";

				/**
				 * [tDBConnection_1 process_data_end ] stop
				 */

				/**
				 * [tDBConnection_1 end ] start
				 */

				currentComponent = "tDBConnection_1";

				if (log.isDebugEnabled())
					log.debug("tDBConnection_1 - " + ("Done."));

				ok_Hash.put("tDBConnection_1", true);
				end_Hash.put("tDBConnection_1", System.currentTimeMillis());

				/**
				 * [tDBConnection_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBConnection_1 finally ] start
				 */

				currentComponent = "tDBConnection_1";

				/**
				 * [tDBConnection_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_Policyrestapi = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[0];

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_Policyrestapi) {

				try {

					int length = 0;

				}

				finally {
				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

			}

			finally {
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

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

	public void tDBRow_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row2Struct row2 = new row2Struct();

				/**
				 * [tDBCommit_1 begin ] start
				 */

				ok_Hash.put("tDBCommit_1", false);
				start_Hash.put("tDBCommit_1", System.currentTimeMillis());

				currentComponent = "tDBCommit_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row2");

				int tos_count_tDBCommit_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBCommit_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBCommit_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBCommit_1 = new StringBuilder();
							log4jParamters_tDBCommit_1.append("Parameters:");
							log4jParamters_tDBCommit_1.append("CONNECTION" + " = " + "tDBConnection_1");
							log4jParamters_tDBCommit_1.append(" | ");
							log4jParamters_tDBCommit_1.append("CLOSE" + " = " + "true");
							log4jParamters_tDBCommit_1.append(" | ");
							log4jParamters_tDBCommit_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlCommit");
							log4jParamters_tDBCommit_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBCommit_1 - " + (log4jParamters_tDBCommit_1));
						}
					}
					new BytesLimit65535_tDBCommit_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBCommit_1", "tDBCommit_1", "tPostgresqlCommit");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tDBCommit_1 begin ] stop
				 */

				/**
				 * [tDBRow_1 begin ] start
				 */

				ok_Hash.put("tDBRow_1", false);
				start_Hash.put("tDBRow_1", System.currentTimeMillis());

				currentComponent = "tDBRow_1";

				int tos_count_tDBRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBRow_1 = new StringBuilder();
							log4jParamters_tDBRow_1.append("Parameters:");
							log4jParamters_tDBRow_1.append("USE_EXISTING_CONNECTION" + " = " + "true");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("CONNECTION" + " = " + "tDBConnection_1");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("QUERY" + " = " + "context.sql_query");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("PROPAGATE_RECORD_SET" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("USE_PREPAREDSTATEMENT" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlRow");
							log4jParamters_tDBRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBRow_1 - " + (log4jParamters_tDBRow_1));
						}
					}
					new BytesLimit65535_tDBRow_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBRow_1", "tDBRow_1", "tPostgresqlRow");
					talendJobLogProcess(globalMap);
				}

				java.sql.Connection conn_tDBRow_1 = null;
				String query_tDBRow_1 = "";
				boolean whetherReject_tDBRow_1 = false;
				conn_tDBRow_1 = (java.sql.Connection) globalMap.get("conn_tDBConnection_1");

				if (conn_tDBRow_1 != null) {
					if (conn_tDBRow_1.getMetaData() != null) {

						log.debug("tDBRow_1 - Uses an existing connection with username '"
								+ conn_tDBRow_1.getMetaData().getUserName() + "'. Connection URL: "
								+ conn_tDBRow_1.getMetaData().getURL() + ".");

					}
				}

				resourceMap.put("conn_tDBRow_1", conn_tDBRow_1);
				java.sql.Statement stmt_tDBRow_1 = conn_tDBRow_1.createStatement();
				resourceMap.put("stmt_tDBRow_1", stmt_tDBRow_1);

				/**
				 * [tDBRow_1 begin ] stop
				 */

				/**
				 * [tDBRow_1 main ] start
				 */

				currentComponent = "tDBRow_1";

				row2 = null;

				query_tDBRow_1 = context.sql_query;
				whetherReject_tDBRow_1 = false;
				log.debug("tDBRow_1 - Executing the query: '" + query_tDBRow_1 + "'.");

				globalMap.put("tDBRow_1_QUERY", query_tDBRow_1);
				try {
					stmt_tDBRow_1.execute(query_tDBRow_1);

					log.debug("tDBRow_1 - Execute the query: '" + query_tDBRow_1 + "' has finished.");

				} catch (java.lang.Exception e) {
					whetherReject_tDBRow_1 = true;

					log.error("tDBRow_1 - " + e.getMessage());

					System.err.print(e.getMessage());

				}

				if (!whetherReject_tDBRow_1) {

					row2 = new row2Struct();

				}

				tos_count_tDBRow_1++;

				/**
				 * [tDBRow_1 main ] stop
				 */

				/**
				 * [tDBRow_1 process_data_begin ] start
				 */

				currentComponent = "tDBRow_1";

				/**
				 * [tDBRow_1 process_data_begin ] stop
				 */
// Start of branch "row2"
				if (row2 != null) {

					/**
					 * [tDBCommit_1 main ] start
					 */

					currentComponent = "tDBCommit_1";

					if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

							, "row2", "tDBRow_1", "tDBRow_1", "tPostgresqlRow", "tDBCommit_1", "tDBCommit_1",
							"tPostgresqlCommit"

					)) {
						talendJobLogProcess(globalMap);
					}

					if (log.isTraceEnabled()) {
						log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
					}

					java.sql.Connection conn_tDBCommit_1 = (java.sql.Connection) globalMap.get("conn_tDBConnection_1");
					if (conn_tDBCommit_1 != null && !conn_tDBCommit_1.isClosed()) {

						try {

							log.debug("tDBCommit_1 - Connection 'tDBConnection_1' starting to commit.");

							conn_tDBCommit_1.commit();

							log.debug("tDBCommit_1 - Connection 'tDBConnection_1' commit has succeeded.");

						} finally {

							log.debug("tDBCommit_1 - Closing the connection 'tDBConnection_1' to the database.");

							conn_tDBCommit_1.close();

							if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_tDBConnection_1"))
									&& routines.system.BundleUtils.inOSGi()) {
								Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
										.getMethod("checkedShutdown").invoke(null, (Object[]) null);
							}

							log.debug("tDBCommit_1 - Connection 'tDBConnection_1' to the database closed.");

						}

					}

					tos_count_tDBCommit_1++;

					/**
					 * [tDBCommit_1 main ] stop
					 */

					/**
					 * [tDBCommit_1 process_data_begin ] start
					 */

					currentComponent = "tDBCommit_1";

					/**
					 * [tDBCommit_1 process_data_begin ] stop
					 */

					/**
					 * [tDBCommit_1 process_data_end ] start
					 */

					currentComponent = "tDBCommit_1";

					/**
					 * [tDBCommit_1 process_data_end ] stop
					 */

				} // End of branch "row2"

				/**
				 * [tDBRow_1 process_data_end ] start
				 */

				currentComponent = "tDBRow_1";

				/**
				 * [tDBRow_1 process_data_end ] stop
				 */

				/**
				 * [tDBRow_1 end ] start
				 */

				currentComponent = "tDBRow_1";

				stmt_tDBRow_1.close();
				resourceMap.remove("stmt_tDBRow_1");
				resourceMap.put("statementClosed_tDBRow_1", true);
				resourceMap.put("finish_tDBRow_1", true);

				if (log.isDebugEnabled())
					log.debug("tDBRow_1 - " + ("Done."));

				ok_Hash.put("tDBRow_1", true);
				end_Hash.put("tDBRow_1", System.currentTimeMillis());

				/**
				 * [tDBRow_1 end ] stop
				 */

				/**
				 * [tDBCommit_1 end ] start
				 */

				currentComponent = "tDBCommit_1";

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row2", 2, 0, "tDBRow_1",
						"tDBRow_1", "tPostgresqlRow", "tDBCommit_1", "tDBCommit_1", "tPostgresqlCommit", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tDBCommit_1 - " + ("Done."));

				ok_Hash.put("tDBCommit_1", true);
				end_Hash.put("tDBCommit_1", System.currentTimeMillis());

				/**
				 * [tDBCommit_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBRow_1 finally ] start
				 */

				currentComponent = "tDBRow_1";

				if (resourceMap.get("statementClosed_tDBRow_1") == null) {
					java.sql.Statement stmtToClose_tDBRow_1 = null;
					if ((stmtToClose_tDBRow_1 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_1")) != null) {
						stmtToClose_tDBRow_1.close();
					}
				}

				/**
				 * [tDBRow_1 finally ] stop
				 */

				/**
				 * [tDBCommit_1 finally ] start
				 */

				currentComponent = "tDBCommit_1";

				/**
				 * [tDBCommit_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 1);
	}

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_Policyrestapi = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[0];

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_Policyrestapi) {

				try {

					int length = 0;

				}

				finally {
				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

			}

			finally {
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

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

	public void tDBRow_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBRow_2_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row3Struct row3 = new row3Struct();

				/**
				 * [tDBCommit_2 begin ] start
				 */

				ok_Hash.put("tDBCommit_2", false);
				start_Hash.put("tDBCommit_2", System.currentTimeMillis());

				currentComponent = "tDBCommit_2";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row3");

				int tos_count_tDBCommit_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBCommit_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBCommit_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBCommit_2 = new StringBuilder();
							log4jParamters_tDBCommit_2.append("Parameters:");
							log4jParamters_tDBCommit_2.append("CONNECTION" + " = " + "tDBConnection_1");
							log4jParamters_tDBCommit_2.append(" | ");
							log4jParamters_tDBCommit_2.append("CLOSE" + " = " + "true");
							log4jParamters_tDBCommit_2.append(" | ");
							log4jParamters_tDBCommit_2.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlCommit");
							log4jParamters_tDBCommit_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBCommit_2 - " + (log4jParamters_tDBCommit_2));
						}
					}
					new BytesLimit65535_tDBCommit_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBCommit_2", "tDBCommit_2", "tPostgresqlCommit");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tDBCommit_2 begin ] stop
				 */

				/**
				 * [tDBRow_2 begin ] start
				 */

				ok_Hash.put("tDBRow_2", false);
				start_Hash.put("tDBRow_2", System.currentTimeMillis());

				currentComponent = "tDBRow_2";

				int tos_count_tDBRow_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBRow_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBRow_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBRow_2 = new StringBuilder();
							log4jParamters_tDBRow_2.append("Parameters:");
							log4jParamters_tDBRow_2.append("USE_EXISTING_CONNECTION" + " = " + "true");
							log4jParamters_tDBRow_2.append(" | ");
							log4jParamters_tDBRow_2.append("CONNECTION" + " = " + "tDBConnection_1");
							log4jParamters_tDBRow_2.append(" | ");
							log4jParamters_tDBRow_2.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBRow_2.append(" | ");
							log4jParamters_tDBRow_2.append("QUERY" + " = " + "context.sql_query");
							log4jParamters_tDBRow_2.append(" | ");
							log4jParamters_tDBRow_2.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBRow_2.append(" | ");
							log4jParamters_tDBRow_2.append("PROPAGATE_RECORD_SET" + " = " + "false");
							log4jParamters_tDBRow_2.append(" | ");
							log4jParamters_tDBRow_2.append("USE_PREPAREDSTATEMENT" + " = " + "false");
							log4jParamters_tDBRow_2.append(" | ");
							log4jParamters_tDBRow_2.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlRow");
							log4jParamters_tDBRow_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBRow_2 - " + (log4jParamters_tDBRow_2));
						}
					}
					new BytesLimit65535_tDBRow_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBRow_2", "tDBRow_2", "tPostgresqlRow");
					talendJobLogProcess(globalMap);
				}

				java.sql.Connection conn_tDBRow_2 = null;
				String query_tDBRow_2 = "";
				boolean whetherReject_tDBRow_2 = false;
				conn_tDBRow_2 = (java.sql.Connection) globalMap.get("conn_tDBConnection_1");

				if (conn_tDBRow_2 != null) {
					if (conn_tDBRow_2.getMetaData() != null) {

						log.debug("tDBRow_2 - Uses an existing connection with username '"
								+ conn_tDBRow_2.getMetaData().getUserName() + "'. Connection URL: "
								+ conn_tDBRow_2.getMetaData().getURL() + ".");

					}
				}

				resourceMap.put("conn_tDBRow_2", conn_tDBRow_2);
				java.sql.Statement stmt_tDBRow_2 = conn_tDBRow_2.createStatement();
				resourceMap.put("stmt_tDBRow_2", stmt_tDBRow_2);

				/**
				 * [tDBRow_2 begin ] stop
				 */

				/**
				 * [tDBRow_2 main ] start
				 */

				currentComponent = "tDBRow_2";

				row3 = null;

				query_tDBRow_2 = context.sql_query;
				whetherReject_tDBRow_2 = false;
				log.debug("tDBRow_2 - Executing the query: '" + query_tDBRow_2 + "'.");

				globalMap.put("tDBRow_2_QUERY", query_tDBRow_2);
				try {
					stmt_tDBRow_2.execute(query_tDBRow_2);

					log.debug("tDBRow_2 - Execute the query: '" + query_tDBRow_2 + "' has finished.");

				} catch (java.lang.Exception e) {
					whetherReject_tDBRow_2 = true;

					log.error("tDBRow_2 - " + e.getMessage());

					System.err.print(e.getMessage());

				}

				if (!whetherReject_tDBRow_2) {

					row3 = new row3Struct();

				}

				tos_count_tDBRow_2++;

				/**
				 * [tDBRow_2 main ] stop
				 */

				/**
				 * [tDBRow_2 process_data_begin ] start
				 */

				currentComponent = "tDBRow_2";

				/**
				 * [tDBRow_2 process_data_begin ] stop
				 */
// Start of branch "row3"
				if (row3 != null) {

					/**
					 * [tDBCommit_2 main ] start
					 */

					currentComponent = "tDBCommit_2";

					if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

							, "row3", "tDBRow_2", "tDBRow_2", "tPostgresqlRow", "tDBCommit_2", "tDBCommit_2",
							"tPostgresqlCommit"

					)) {
						talendJobLogProcess(globalMap);
					}

					if (log.isTraceEnabled()) {
						log.trace("row3 - " + (row3 == null ? "" : row3.toLogString()));
					}

					java.sql.Connection conn_tDBCommit_2 = (java.sql.Connection) globalMap.get("conn_tDBConnection_1");
					if (conn_tDBCommit_2 != null && !conn_tDBCommit_2.isClosed()) {

						try {

							log.debug("tDBCommit_2 - Connection 'tDBConnection_1' starting to commit.");

							conn_tDBCommit_2.commit();

							log.debug("tDBCommit_2 - Connection 'tDBConnection_1' commit has succeeded.");

						} finally {

							log.debug("tDBCommit_2 - Closing the connection 'tDBConnection_1' to the database.");

							conn_tDBCommit_2.close();

							if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_tDBConnection_1"))
									&& routines.system.BundleUtils.inOSGi()) {
								Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
										.getMethod("checkedShutdown").invoke(null, (Object[]) null);
							}

							log.debug("tDBCommit_2 - Connection 'tDBConnection_1' to the database closed.");

						}

					}

					tos_count_tDBCommit_2++;

					/**
					 * [tDBCommit_2 main ] stop
					 */

					/**
					 * [tDBCommit_2 process_data_begin ] start
					 */

					currentComponent = "tDBCommit_2";

					/**
					 * [tDBCommit_2 process_data_begin ] stop
					 */

					/**
					 * [tDBCommit_2 process_data_end ] start
					 */

					currentComponent = "tDBCommit_2";

					/**
					 * [tDBCommit_2 process_data_end ] stop
					 */

				} // End of branch "row3"

				/**
				 * [tDBRow_2 process_data_end ] start
				 */

				currentComponent = "tDBRow_2";

				/**
				 * [tDBRow_2 process_data_end ] stop
				 */

				/**
				 * [tDBRow_2 end ] start
				 */

				currentComponent = "tDBRow_2";

				stmt_tDBRow_2.close();
				resourceMap.remove("stmt_tDBRow_2");
				resourceMap.put("statementClosed_tDBRow_2", true);
				resourceMap.put("finish_tDBRow_2", true);

				if (log.isDebugEnabled())
					log.debug("tDBRow_2 - " + ("Done."));

				ok_Hash.put("tDBRow_2", true);
				end_Hash.put("tDBRow_2", System.currentTimeMillis());

				/**
				 * [tDBRow_2 end ] stop
				 */

				/**
				 * [tDBCommit_2 end ] start
				 */

				currentComponent = "tDBCommit_2";

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row3", 2, 0, "tDBRow_2",
						"tDBRow_2", "tPostgresqlRow", "tDBCommit_2", "tDBCommit_2", "tPostgresqlCommit", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tDBCommit_2 - " + ("Done."));

				ok_Hash.put("tDBCommit_2", true);
				end_Hash.put("tDBCommit_2", System.currentTimeMillis());

				/**
				 * [tDBCommit_2 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBRow_2 finally ] start
				 */

				currentComponent = "tDBRow_2";

				if (resourceMap.get("statementClosed_tDBRow_2") == null) {
					java.sql.Statement stmtToClose_tDBRow_2 = null;
					if ((stmtToClose_tDBRow_2 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_2")) != null) {
						stmtToClose_tDBRow_2.close();
					}
				}

				/**
				 * [tDBRow_2 finally ] stop
				 */

				/**
				 * [tDBCommit_2 finally ] start
				 */

				currentComponent = "tDBCommit_2";

				/**
				 * [tDBCommit_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBRow_2_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_Policyrestapi = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[0];

		public String body;

		public String getBody() {
			return this.body;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_Policyrestapi.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_Policyrestapi.length == 0) {
						commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_Policyrestapi, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_Policyrestapi, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_Policyrestapi) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.body, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + body);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (body == null) {
				sb.append("<null>");
			} else {
				sb.append(body);
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

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_Policyrestapi = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[0];

		public String body;

		public String getBody() {
			return this.body;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_Policyrestapi.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_Policyrestapi.length == 0) {
						commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_Policyrestapi, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_Policyrestapi, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_Policyrestapi) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.body, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + body);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (body == null) {
				sb.append("<null>");
			} else {
				sb.append(body);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

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

	public static class newagreementStruct implements routines.system.IPersistableRow<newagreementStruct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_Policyrestapi = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[0];

		public String transactiontypecode;

		public String getTransactiontypecode() {
			return this.transactiontypecode;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_Policyrestapi.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_Policyrestapi.length == 0) {
						commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_Policyrestapi, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_Policyrestapi, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_Policyrestapi) {

				try {

					int length = 0;

					this.transactiontypecode = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.transactiontypecode, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("transactiontypecode=" + transactiontypecode);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (transactiontypecode == null) {
				sb.append("<null>");
			} else {
				sb.append(transactiontypecode);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(newagreementStruct other) {

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

	public static class renewalagreementStruct implements routines.system.IPersistableRow<renewalagreementStruct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_Policyrestapi = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[0];

		public String transactiontypecode;

		public String getTransactiontypecode() {
			return this.transactiontypecode;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_Policyrestapi.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_Policyrestapi.length == 0) {
						commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_Policyrestapi = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_Policyrestapi, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_Policyrestapi, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_Policyrestapi) {

				try {

					int length = 0;

					this.transactiontypecode = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.transactiontypecode, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("transactiontypecode=" + transactiontypecode);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (transactiontypecode == null) {
				sb.append("<null>");
			} else {
				sb.append(transactiontypecode);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(renewalagreementStruct other) {

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

	public void tRESTRequest_1_LoopProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				newagreementStruct newagreement = new newagreementStruct();
				row1Struct row1 = new row1Struct();
				renewalagreementStruct renewalagreement = new renewalagreementStruct();
				row4Struct row4 = new row4Struct();

				/**
				 * [tRESTRequest_1_Loop begin ] start
				 */

				int NB_ITERATE_tRESTRequest_1_In = 0; // for statistics

				ok_Hash.put("tRESTRequest_1_Loop", false);
				start_Hash.put("tRESTRequest_1_Loop", System.currentTimeMillis());

				currentVirtualComponent = "tRESTRequest_1";

				currentComponent = "tRESTRequest_1_Loop";

				int tos_count_tRESTRequest_1_Loop = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tRESTRequest_1_Loop", "tRESTRequest_1_Loop", "tRESTRequestLoop");
					talendJobLogProcess(globalMap);
				}

				runStat.updateStatAndLog(execStat, enableLogStash, iterateId, 0, 0, "newagreement", "row1",
						"renewalagreement", "row4");

				renewalagreement = null;

				newagreement = null;

				int nb_line_tRESTRequest_1 = 0;

				try {

					java.util.Map<String, Object> requestMessage_tRESTRequest_1 = (java.util.Map<String, Object>) globalMap
							.get("restRequest");

					restEndpoint = getRestEndpoint();

					if (null == requestMessage_tRESTRequest_1) {

						if (restTalendJobAlreadyStarted) {
							throw new RuntimeException("request is not provided");
						} else {
							if (!runInTalendEsbRuntimeContainer && null == thread4RestServiceProviderEndpoint) {
								String endpointUrl_tRESTRequest_1 = checkEndpointUrl(restEndpoint);
								// *** external thread for endpoint initialization
								thread4RestServiceProviderEndpoint = new Thread4RestServiceProviderEndpoint(this,
										endpointUrl_tRESTRequest_1);
								thread4RestServiceProviderEndpoint.start();
								// *** external thread for endpoint initialization
							}

							restTalendJobAlreadyStarted = true;

							if (runInDaemonMode) {
								Thread.currentThread();
								try {
									while (true) {
										Thread.sleep(60000);
									}
								} catch (InterruptedException e_tRESTRequest_1) {
									// e_tRESTRequest_1.printStackTrace();
									// throw new TalendException(e_tRESTRequest_1, "wholeJob", globalMap);
								}
							}
						}
						return;
					}

					requestMessage_tRESTRequest_1.put("CURRENT_MESSAGE",
							org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage());

					Object ctx_tRESTRequest_1 = requestMessage_tRESTRequest_1.get("MESSAGE_CONTEXT");
					if (ctx_tRESTRequest_1 != null
							&& ctx_tRESTRequest_1 instanceof org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext) {
						requestMessage_tRESTRequest_1.put("MESSAGE_CONTEXT",
								((org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext) ctx_tRESTRequest_1).get());
					}

					/**
					 * [tRESTRequest_1_Loop begin ] stop
					 */

					/**
					 * [tRESTRequest_1_Loop main ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_Loop";

					resourceMap.put("inIterateVComp", true);

					tos_count_tRESTRequest_1_Loop++;

					/**
					 * [tRESTRequest_1_Loop main ] stop
					 */

					/**
					 * [tRESTRequest_1_Loop process_data_begin ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_Loop";

					/**
					 * [tRESTRequest_1_Loop process_data_begin ] stop
					 */
					NB_ITERATE_tRESTRequest_1_In++;

					if (execStat) {
						runStat.updateStatOnConnection("Iterate", 1, "exec" + NB_ITERATE_tRESTRequest_1_In);
						// Thread.sleep(1000);
					}

					/**
					 * [tRESTResponse_1 begin ] start
					 */

					ok_Hash.put("tRESTResponse_1", false);
					start_Hash.put("tRESTResponse_1", System.currentTimeMillis());

					currentComponent = "tRESTResponse_1";

					runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

					int tos_count_tRESTResponse_1 = 0;

					if (enableLogStash) {
						talendJobLog.addCM("tRESTResponse_1", "tRESTResponse_1", "tRESTResponse");
						talendJobLogProcess(globalMap);
					}

					/**
					 * [tRESTResponse_1 begin ] stop
					 */

					/**
					 * [tJavaRow_1 begin ] start
					 */

					ok_Hash.put("tJavaRow_1", false);
					start_Hash.put("tJavaRow_1", System.currentTimeMillis());

					currentComponent = "tJavaRow_1";

					runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "newagreement");

					int tos_count_tJavaRow_1 = 0;

					if (enableLogStash) {
						talendJobLog.addCM("tJavaRow_1", "tJavaRow_1", "tJavaRow");
						talendJobLogProcess(globalMap);
					}

					int nb_line_tJavaRow_1 = 0;

					/**
					 * [tJavaRow_1 begin ] stop
					 */

					/**
					 * [tRESTResponse_2 begin ] start
					 */

					ok_Hash.put("tRESTResponse_2", false);
					start_Hash.put("tRESTResponse_2", System.currentTimeMillis());

					currentComponent = "tRESTResponse_2";

					runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row4");

					int tos_count_tRESTResponse_2 = 0;

					if (enableLogStash) {
						talendJobLog.addCM("tRESTResponse_2", "tRESTResponse_2", "tRESTResponse");
						talendJobLogProcess(globalMap);
					}

					/**
					 * [tRESTResponse_2 begin ] stop
					 */

					/**
					 * [tJavaRow_2 begin ] start
					 */

					ok_Hash.put("tJavaRow_2", false);
					start_Hash.put("tJavaRow_2", System.currentTimeMillis());

					currentComponent = "tJavaRow_2";

					runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0,
							"renewalagreement");

					int tos_count_tJavaRow_2 = 0;

					if (enableLogStash) {
						talendJobLog.addCM("tJavaRow_2", "tJavaRow_2", "tJavaRow");
						talendJobLogProcess(globalMap);
					}

					int nb_line_tJavaRow_2 = 0;

					/**
					 * [tJavaRow_2 begin ] stop
					 */

					/**
					 * [tRESTRequest_1_In begin ] start
					 */

					ok_Hash.put("tRESTRequest_1_In", false);
					start_Hash.put("tRESTRequest_1_In", System.currentTimeMillis());

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_In";

					int tos_count_tRESTRequest_1_In = 0;

					if (enableLogStash) {
						talendJobLog.addCM("tRESTRequest_1_In", "tRESTRequest_1_In", "tRESTRequestIn");
						talendJobLogProcess(globalMap);
					}

					resourceMap.remove("inIterateVComp");

					/**
					 * [tRESTRequest_1_In begin ] stop
					 */

					/**
					 * [tRESTRequest_1_In main ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_In";

					if (requestMessage_tRESTRequest_1.containsKey("ERROR")) { // wrong request received
						renewalagreement = null;
						newagreement = null;
					} else { // non-error (not wrong request)

						String matchedUriPattern_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("PATTERN");
						String matchedFlow_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("OPERATION");

						java.util.Map<String, Object> params_tRESTRequest_1 = (java.util.Map<String, Object>) requestMessage_tRESTRequest_1
								.get("PARAMS");
						if (matchedFlow_tRESTRequest_1.equals("renewalagreement")) {
							renewalagreement = new renewalagreementStruct();
							if (params_tRESTRequest_1.containsKey("PATH:transactiontypecode:id_String")) {

								renewalagreement.transactiontypecode = (String) params_tRESTRequest_1
										.get("PATH:transactiontypecode:id_String");

							}
						} else { // non matched flow
							renewalagreement = null;
						}

						if (matchedFlow_tRESTRequest_1.equals("newagreement")) {
							newagreement = new newagreementStruct();
							if (params_tRESTRequest_1.containsKey("PATH:transactiontypecode:id_String")) {

								newagreement.transactiontypecode = (String) params_tRESTRequest_1
										.get("PATH:transactiontypecode:id_String");

							}
						} else { // non matched flow
							newagreement = null;
						}

					}

					globalMap.put("tRESTRequest_1_URI", (String) requestMessage_tRESTRequest_1.get("URI"));
					globalMap.put("tRESTRequest_1_URI_BASE", (String) requestMessage_tRESTRequest_1.get("URI_BASE"));
					globalMap.put("tRESTRequest_1_URI_ABSOLUTE",
							(String) requestMessage_tRESTRequest_1.get("URI_ABSOLUTE"));
					globalMap.put("tRESTRequest_1_URI_REQUEST",
							(String) requestMessage_tRESTRequest_1.get("URI_REQUEST"));
					globalMap.put("tRESTRequest_1_HTTP_METHOD", (String) requestMessage_tRESTRequest_1.get("VERB"));

					globalMap.put("tRESTRequest_1_ATTACHMENT_HEADERS",
							requestMessage_tRESTRequest_1.get("ATTACHMENT_HEADERS"));
					globalMap.put("tRESTRequest_1_ATTACHMENT_FILENAMES",
							requestMessage_tRESTRequest_1.get("ATTACHMENT_FILENAMES"));

					globalMap.put("tRESTRequest_1_PRINCIPAL_NAME",
							(String) requestMessage_tRESTRequest_1.get("PRINCIPAL_NAME"));
					globalMap.put("tRESTRequest_1_CORRELATION_ID",
							(String) requestMessage_tRESTRequest_1.get("CorrelationID"));

					tos_count_tRESTRequest_1_In++;

					/**
					 * [tRESTRequest_1_In main ] stop
					 */

					/**
					 * [tRESTRequest_1_In process_data_begin ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_In";

					/**
					 * [tRESTRequest_1_In process_data_begin ] stop
					 */
// Start of branch "newagreement"
					if (newagreement != null) {

						/**
						 * [tJavaRow_1 main ] start
						 */

						currentComponent = "tJavaRow_1";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "newagreement", "tRESTRequest_1_In", "tRESTRequest_1_In", "tRESTRequestIn",
								"tJavaRow_1", "tJavaRow_1", "tJavaRow"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("newagreement - " + (newagreement == null ? "" : newagreement.toLogString()));
						}

						context.transactiontypecode = newagreement.transactiontypecode;
						context.sql_query = "update finance.agreement set agreementstatus='New' where transactiontypecode="
								+ "'" + newagreement.transactiontypecode + "';";
						System.out.println("Sql query is:" + context.sql_query);
						row1.body = "The request for the new agreement is complete";

						nb_line_tJavaRow_1++;

						tos_count_tJavaRow_1++;

						/**
						 * [tJavaRow_1 main ] stop
						 */

						/**
						 * [tJavaRow_1 process_data_begin ] start
						 */

						currentComponent = "tJavaRow_1";

						/**
						 * [tJavaRow_1 process_data_begin ] stop
						 */

						/**
						 * [tRESTResponse_1 main ] start
						 */

						currentComponent = "tRESTResponse_1";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row1", "tJavaRow_1", "tJavaRow_1", "tJavaRow", "tRESTResponse_1", "tRESTResponse_1",
								"tRESTResponse"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
						}

						java.io.OutputStream outputStream_tRESTResponse_1 = (java.io.OutputStream) globalMap
								.get("restResponseStream");
						boolean responseAlreadySent_tRESTResponse_1 = globalMap.containsKey("restResponse");

						if (null == outputStream_tRESTResponse_1 && responseAlreadySent_tRESTResponse_1) {
							throw new RuntimeException("Rest response already sent.");
						} else if (!globalMap.containsKey("restRequest")) {
							throw new RuntimeException("Not received rest request yet.");
						} else {
							Integer restProviderStatusCode_tRESTResponse_1 = 200;

							Object restProviderResponse_tRESTResponse_1 = null;
							restProviderResponse_tRESTResponse_1 = row1.body;

							java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_1 = new java.util.TreeMap<String, String>(
									String.CASE_INSENSITIVE_ORDER);

							java.util.Map<String, Object> restRequest_tRESTResponse_1 = (java.util.Map<String, Object>) globalMap
									.get("restRequest");
							org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_1 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_1
									.get("MESSAGE_CONTEXT");

							if (null == outputStream_tRESTResponse_1) {
								java.util.Map<String, Object> restResponse_tRESTResponse_1 = new java.util.HashMap<String, Object>();
								restResponse_tRESTResponse_1.put("BODY", restProviderResponse_tRESTResponse_1);
								restResponse_tRESTResponse_1.put("STATUS", restProviderStatusCode_tRESTResponse_1);
								restResponse_tRESTResponse_1.put("HEADERS",
										restProviderResponseHeaders_tRESTResponse_1);
								restResponse_tRESTResponse_1.put("drop.json.root.element", Boolean.valueOf(false));
								globalMap.put("restResponse", restResponse_tRESTResponse_1);

							} else {

								javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_1 = null;
								if (!responseAlreadySent_tRESTResponse_1) {
									org.apache.cxf.message.Message currentMessage = null;
									if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
										currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
									} else {
										currentMessage = ((org.apache.cxf.message.Message) restRequest_tRESTResponse_1
												.get("CURRENT_MESSAGE"));
									}

									if (currentMessage != null && currentMessage.getExchange() != null) {
										currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION,
												true);
									}

									messageContext_tRESTResponse_1.put(org.apache.cxf.message.Message.RESPONSE_CODE,
											restProviderStatusCode_tRESTResponse_1);
									javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_1 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
									for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_1
											.entrySet()) {
										headersMultivaluedMap_tRESTResponse_1.putSingle(multivaluedHeader.getKey(),
												multivaluedHeader.getValue());
									}
									messageContext_tRESTResponse_1.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS,
											headersMultivaluedMap_tRESTResponse_1);

									String responseContentType_tRESTResponse_1 = null;

									if (currentMessage != null && currentMessage.getExchange() != null) {
										responseContentType_tRESTResponse_1 = (String) currentMessage.getExchange()
												.get(org.apache.cxf.message.Message.CONTENT_TYPE);
									}

									if (null == responseContentType_tRESTResponse_1) {
										// this should not be needed, just in case. set it to the first value in the
										// sorted list returned from HttpHeaders
										responseMediaType_tRESTResponse_1 = messageContext_tRESTResponse_1
												.getHttpHeaders().getAcceptableMediaTypes().get(0);
									} else {
										responseMediaType_tRESTResponse_1 = org.apache.cxf.jaxrs.utils.JAXRSUtils
												.toMediaType(responseContentType_tRESTResponse_1);
									}
									globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_1);

									String responseMediaSubType_tRESTResponse_1 = responseMediaType_tRESTResponse_1
											.getSubtype();
									if (responseMediaSubType_tRESTResponse_1.equals("xml")
											|| responseMediaSubType_tRESTResponse_1.endsWith("+xml")) {
										outputStream_tRESTResponse_1.write("<wrapper>".getBytes());
										globalMap.put("restResponseWrappingClosure", "</wrapper>");
									}
									if (responseMediaSubType_tRESTResponse_1.equals("json")
											|| responseMediaSubType_tRESTResponse_1.endsWith("+json")) {
										outputStream_tRESTResponse_1.write("[".getBytes());
										globalMap.put("restResponseWrappingClosure", "]");
									}

									globalMap.put("restResponse", true);
								} else {
									responseMediaType_tRESTResponse_1 = (javax.ws.rs.core.MediaType) globalMap
											.get("restResponseMediaType");
								}

								if (null != restProviderResponse_tRESTResponse_1) {
									String responseMediaSubType_tRESTResponse_1 = responseMediaType_tRESTResponse_1
											.getSubtype();
									if (responseMediaSubType_tRESTResponse_1.equals("json")
											|| responseMediaSubType_tRESTResponse_1.endsWith("+json")) {
										if (globalMap.containsKey("restResponseJsonStarted")) {
											outputStream_tRESTResponse_1.write(",".getBytes());
										} else {
											globalMap.put("restResponseJsonStarted", true);
										}
									}

									Class<? extends Object> responseBodyClass_tRESTResponse_1 = restProviderResponse_tRESTResponse_1
											.getClass();
									javax.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_1 = messageContext_tRESTResponse_1
											.getProviders();
									javax.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_1 = messageBodyProviders_tRESTResponse_1
											.getMessageBodyWriter(responseBodyClass_tRESTResponse_1,
													responseBodyClass_tRESTResponse_1, null,
													responseMediaType_tRESTResponse_1);

									if (messageBodyWriter_tRESTResponse_1 instanceof StreamingDOM4JProvider) {
										((StreamingDOM4JProvider) messageBodyWriter_tRESTResponse_1)
												.setGlobalMap(globalMap);
									}

									messageBodyWriter_tRESTResponse_1.writeTo(restProviderResponse_tRESTResponse_1,
											responseBodyClass_tRESTResponse_1, responseBodyClass_tRESTResponse_1,
											new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_1,
											null, outputStream_tRESTResponse_1);
								}
								// initial variant
								// outputStream_tRESTResponse_1.write(String.valueOf(restProviderResponse_tRESTResponse_1).getBytes());
								outputStream_tRESTResponse_1.flush();
							}
						}

						tos_count_tRESTResponse_1++;

						/**
						 * [tRESTResponse_1 main ] stop
						 */

						/**
						 * [tRESTResponse_1 process_data_begin ] start
						 */

						currentComponent = "tRESTResponse_1";

						/**
						 * [tRESTResponse_1 process_data_begin ] stop
						 */

						/**
						 * [tRESTResponse_1 process_data_end ] start
						 */

						currentComponent = "tRESTResponse_1";

						/**
						 * [tRESTResponse_1 process_data_end ] stop
						 */

						/**
						 * [tJavaRow_1 process_data_end ] start
						 */

						currentComponent = "tJavaRow_1";

						/**
						 * [tJavaRow_1 process_data_end ] stop
						 */

					} // End of branch "newagreement"

// Start of branch "renewalagreement"
					if (renewalagreement != null) {

						/**
						 * [tJavaRow_2 main ] start
						 */

						currentComponent = "tJavaRow_2";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "renewalagreement", "tRESTRequest_1_In", "tRESTRequest_1_In", "tRESTRequestIn",
								"tJavaRow_2", "tJavaRow_2", "tJavaRow"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("renewalagreement - "
									+ (renewalagreement == null ? "" : renewalagreement.toLogString()));
						}

						context.transactiontypecode = renewalagreement.transactiontypecode;
						context.sql_query = "update finance.agreement set agreementstatus='Renewal' where transactiontypecode="
								+ "'" + renewalagreement.transactiontypecode + "';";
						System.out.println("Sql query is:" + context.sql_query);
						row4.body = "The request for the agreementid renewal is complete";

						nb_line_tJavaRow_2++;

						tos_count_tJavaRow_2++;

						/**
						 * [tJavaRow_2 main ] stop
						 */

						/**
						 * [tJavaRow_2 process_data_begin ] start
						 */

						currentComponent = "tJavaRow_2";

						/**
						 * [tJavaRow_2 process_data_begin ] stop
						 */

						/**
						 * [tRESTResponse_2 main ] start
						 */

						currentComponent = "tRESTResponse_2";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row4", "tJavaRow_2", "tJavaRow_2", "tJavaRow", "tRESTResponse_2", "tRESTResponse_2",
								"tRESTResponse"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row4 - " + (row4 == null ? "" : row4.toLogString()));
						}

						java.io.OutputStream outputStream_tRESTResponse_2 = (java.io.OutputStream) globalMap
								.get("restResponseStream");
						boolean responseAlreadySent_tRESTResponse_2 = globalMap.containsKey("restResponse");

						if (null == outputStream_tRESTResponse_2 && responseAlreadySent_tRESTResponse_2) {
							throw new RuntimeException("Rest response already sent.");
						} else if (!globalMap.containsKey("restRequest")) {
							throw new RuntimeException("Not received rest request yet.");
						} else {
							Integer restProviderStatusCode_tRESTResponse_2 = 200;

							Object restProviderResponse_tRESTResponse_2 = null;
							restProviderResponse_tRESTResponse_2 = row4.body;

							java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_2 = new java.util.TreeMap<String, String>(
									String.CASE_INSENSITIVE_ORDER);

							java.util.Map<String, Object> restRequest_tRESTResponse_2 = (java.util.Map<String, Object>) globalMap
									.get("restRequest");
							org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_2 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_2
									.get("MESSAGE_CONTEXT");

							if (null == outputStream_tRESTResponse_2) {
								java.util.Map<String, Object> restResponse_tRESTResponse_2 = new java.util.HashMap<String, Object>();
								restResponse_tRESTResponse_2.put("BODY", restProviderResponse_tRESTResponse_2);
								restResponse_tRESTResponse_2.put("STATUS", restProviderStatusCode_tRESTResponse_2);
								restResponse_tRESTResponse_2.put("HEADERS",
										restProviderResponseHeaders_tRESTResponse_2);
								restResponse_tRESTResponse_2.put("drop.json.root.element", Boolean.valueOf(false));
								globalMap.put("restResponse", restResponse_tRESTResponse_2);

							} else {

								javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_2 = null;
								if (!responseAlreadySent_tRESTResponse_2) {
									org.apache.cxf.message.Message currentMessage = null;
									if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
										currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
									} else {
										currentMessage = ((org.apache.cxf.message.Message) restRequest_tRESTResponse_2
												.get("CURRENT_MESSAGE"));
									}

									if (currentMessage != null && currentMessage.getExchange() != null) {
										currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION,
												true);
									}

									messageContext_tRESTResponse_2.put(org.apache.cxf.message.Message.RESPONSE_CODE,
											restProviderStatusCode_tRESTResponse_2);
									javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_2 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
									for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_2
											.entrySet()) {
										headersMultivaluedMap_tRESTResponse_2.putSingle(multivaluedHeader.getKey(),
												multivaluedHeader.getValue());
									}
									messageContext_tRESTResponse_2.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS,
											headersMultivaluedMap_tRESTResponse_2);

									String responseContentType_tRESTResponse_2 = null;

									if (currentMessage != null && currentMessage.getExchange() != null) {
										responseContentType_tRESTResponse_2 = (String) currentMessage.getExchange()
												.get(org.apache.cxf.message.Message.CONTENT_TYPE);
									}

									if (null == responseContentType_tRESTResponse_2) {
										// this should not be needed, just in case. set it to the first value in the
										// sorted list returned from HttpHeaders
										responseMediaType_tRESTResponse_2 = messageContext_tRESTResponse_2
												.getHttpHeaders().getAcceptableMediaTypes().get(0);
									} else {
										responseMediaType_tRESTResponse_2 = org.apache.cxf.jaxrs.utils.JAXRSUtils
												.toMediaType(responseContentType_tRESTResponse_2);
									}
									globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_2);

									String responseMediaSubType_tRESTResponse_2 = responseMediaType_tRESTResponse_2
											.getSubtype();
									if (responseMediaSubType_tRESTResponse_2.equals("xml")
											|| responseMediaSubType_tRESTResponse_2.endsWith("+xml")) {
										outputStream_tRESTResponse_2.write("<wrapper>".getBytes());
										globalMap.put("restResponseWrappingClosure", "</wrapper>");
									}
									if (responseMediaSubType_tRESTResponse_2.equals("json")
											|| responseMediaSubType_tRESTResponse_2.endsWith("+json")) {
										outputStream_tRESTResponse_2.write("[".getBytes());
										globalMap.put("restResponseWrappingClosure", "]");
									}

									globalMap.put("restResponse", true);
								} else {
									responseMediaType_tRESTResponse_2 = (javax.ws.rs.core.MediaType) globalMap
											.get("restResponseMediaType");
								}

								if (null != restProviderResponse_tRESTResponse_2) {
									String responseMediaSubType_tRESTResponse_2 = responseMediaType_tRESTResponse_2
											.getSubtype();
									if (responseMediaSubType_tRESTResponse_2.equals("json")
											|| responseMediaSubType_tRESTResponse_2.endsWith("+json")) {
										if (globalMap.containsKey("restResponseJsonStarted")) {
											outputStream_tRESTResponse_2.write(",".getBytes());
										} else {
											globalMap.put("restResponseJsonStarted", true);
										}
									}

									Class<? extends Object> responseBodyClass_tRESTResponse_2 = restProviderResponse_tRESTResponse_2
											.getClass();
									javax.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_2 = messageContext_tRESTResponse_2
											.getProviders();
									javax.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_2 = messageBodyProviders_tRESTResponse_2
											.getMessageBodyWriter(responseBodyClass_tRESTResponse_2,
													responseBodyClass_tRESTResponse_2, null,
													responseMediaType_tRESTResponse_2);

									if (messageBodyWriter_tRESTResponse_2 instanceof StreamingDOM4JProvider) {
										((StreamingDOM4JProvider) messageBodyWriter_tRESTResponse_2)
												.setGlobalMap(globalMap);
									}

									messageBodyWriter_tRESTResponse_2.writeTo(restProviderResponse_tRESTResponse_2,
											responseBodyClass_tRESTResponse_2, responseBodyClass_tRESTResponse_2,
											new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_2,
											null, outputStream_tRESTResponse_2);
								}
								// initial variant
								// outputStream_tRESTResponse_2.write(String.valueOf(restProviderResponse_tRESTResponse_2).getBytes());
								outputStream_tRESTResponse_2.flush();
							}
						}

						tos_count_tRESTResponse_2++;

						/**
						 * [tRESTResponse_2 main ] stop
						 */

						/**
						 * [tRESTResponse_2 process_data_begin ] start
						 */

						currentComponent = "tRESTResponse_2";

						/**
						 * [tRESTResponse_2 process_data_begin ] stop
						 */

						/**
						 * [tRESTResponse_2 process_data_end ] start
						 */

						currentComponent = "tRESTResponse_2";

						/**
						 * [tRESTResponse_2 process_data_end ] stop
						 */

						/**
						 * [tJavaRow_2 process_data_end ] start
						 */

						currentComponent = "tJavaRow_2";

						/**
						 * [tJavaRow_2 process_data_end ] stop
						 */

					} // End of branch "renewalagreement"

					/**
					 * [tRESTRequest_1_In process_data_end ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_In";

					/**
					 * [tRESTRequest_1_In process_data_end ] stop
					 */

					/**
					 * [tRESTRequest_1_In end ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_In";

					resourceMap.put("inIterateVComp", true);

					ok_Hash.put("tRESTRequest_1_In", true);
					end_Hash.put("tRESTRequest_1_In", System.currentTimeMillis());

					/**
					 * [tRESTRequest_1_In end ] stop
					 */

					/**
					 * [tJavaRow_1 end ] start
					 */

					currentComponent = "tJavaRow_1";

					globalMap.put("tJavaRow_1_NB_LINE", nb_line_tJavaRow_1);
					if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "newagreement", 2, 0,
							"tRESTRequest_1_In", "tRESTRequest_1_In", "tRESTRequestIn", "tJavaRow_1", "tJavaRow_1",
							"tJavaRow", "output")) {
						talendJobLogProcess(globalMap);
					}

					ok_Hash.put("tJavaRow_1", true);
					end_Hash.put("tJavaRow_1", System.currentTimeMillis());

					if (execStat) {
						runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
					}
					tDBRow_1Process(globalMap);

					/**
					 * [tJavaRow_1 end ] stop
					 */

					/**
					 * [tRESTResponse_1 end ] start
					 */

					currentComponent = "tRESTResponse_1";

					if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
							"tJavaRow_1", "tJavaRow_1", "tJavaRow", "tRESTResponse_1", "tRESTResponse_1",
							"tRESTResponse", "output")) {
						talendJobLogProcess(globalMap);
					}

					ok_Hash.put("tRESTResponse_1", true);
					end_Hash.put("tRESTResponse_1", System.currentTimeMillis());

					/**
					 * [tRESTResponse_1 end ] stop
					 */

					/**
					 * [tJavaRow_2 end ] start
					 */

					currentComponent = "tJavaRow_2";

					globalMap.put("tJavaRow_2_NB_LINE", nb_line_tJavaRow_2);
					if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "renewalagreement",
							2, 0, "tRESTRequest_1_In", "tRESTRequest_1_In", "tRESTRequestIn", "tJavaRow_2",
							"tJavaRow_2", "tJavaRow", "output")) {
						talendJobLogProcess(globalMap);
					}

					ok_Hash.put("tJavaRow_2", true);
					end_Hash.put("tJavaRow_2", System.currentTimeMillis());

					if (execStat) {
						runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
					}
					tDBRow_2Process(globalMap);

					/**
					 * [tJavaRow_2 end ] stop
					 */

					/**
					 * [tRESTResponse_2 end ] start
					 */

					currentComponent = "tRESTResponse_2";

					if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row4", 2, 0,
							"tJavaRow_2", "tJavaRow_2", "tJavaRow", "tRESTResponse_2", "tRESTResponse_2",
							"tRESTResponse", "output")) {
						talendJobLogProcess(globalMap);
					}

					ok_Hash.put("tRESTResponse_2", true);
					end_Hash.put("tRESTResponse_2", System.currentTimeMillis());

					/**
					 * [tRESTResponse_2 end ] stop
					 */

					if (execStat) {
						runStat.updateStatOnConnection("Iterate", 2, "exec" + NB_ITERATE_tRESTRequest_1_In);
					}

					/**
					 * [tRESTRequest_1_Loop process_data_end ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_Loop";

					/**
					 * [tRESTRequest_1_Loop process_data_end ] stop
					 */

					/**
					 * [tRESTRequest_1_Loop end ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_Loop";

					resourceMap.remove("inIterateVComp");

				} catch (Throwable e_tRESTRequest_1) {
					if (e_tRESTRequest_1 instanceof Exception) {
						new TalendException((Exception) e_tRESTRequest_1, currentComponent, globalMap)
								.printStackTrace();
					} else {
						new TalendException(new RuntimeException(e_tRESTRequest_1), currentComponent, globalMap)
								.printStackTrace();
					}
					if (!globalMap.containsKey("restResponse")) {
						java.util.Map<String, Object> restFault_tRESTRequest_1 = new java.util.HashMap<String, Object>();
						restFault_tRESTRequest_1.put("STATUS", 500);
						restFault_tRESTRequest_1.put("BODY", e_tRESTRequest_1.getMessage());
						globalMap.put("restResponse", restFault_tRESTRequest_1);
					}
					return;
				}
				nb_line_tRESTRequest_1++;
				globalMap.put("tRESTRequest_1_NB_LINE", nb_line_tRESTRequest_1);

				runStat.updateStatAndLog(execStat, enableLogStash, iterateId, 2, 0, "newagreement", "row1",
						"renewalagreement", "row4");

				ok_Hash.put("tRESTRequest_1_Loop", true);
				end_Hash.put("tRESTRequest_1_Loop", System.currentTimeMillis());

				/**
				 * [tRESTRequest_1_Loop end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRESTRequest_1_Loop finally ] start
				 */

				currentVirtualComponent = "tRESTRequest_1";

				currentComponent = "tRESTRequest_1_Loop";

				/**
				 * [tRESTRequest_1_Loop finally ] stop
				 */

				/**
				 * [tRESTRequest_1_In finally ] start
				 */

				currentVirtualComponent = "tRESTRequest_1";

				currentComponent = "tRESTRequest_1_In";

				/**
				 * [tRESTRequest_1_In finally ] stop
				 */

				/**
				 * [tJavaRow_1 finally ] start
				 */

				currentComponent = "tJavaRow_1";

				/**
				 * [tJavaRow_1 finally ] stop
				 */

				/**
				 * [tRESTResponse_1 finally ] start
				 */

				currentComponent = "tRESTResponse_1";

				/**
				 * [tRESTResponse_1 finally ] stop
				 */

				/**
				 * [tJavaRow_2 finally ] start
				 */

				currentComponent = "tJavaRow_2";

				/**
				 * [tJavaRow_2 finally ] stop
				 */

				/**
				 * [tRESTResponse_2 finally ] start
				 */

				currentComponent = "tRESTResponse_2";

				/**
				 * [tRESTResponse_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", 1);
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
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [talendJobLog begin ] start
				 */

				ok_Hash.put("talendJobLog", false);
				start_Hash.put("talendJobLog", System.currentTimeMillis());

				currentComponent = "talendJobLog";

				int tos_count_talendJobLog = 0;

				for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
					org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder
							.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
							.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid)
							.custom("father_pid", fatherPid).custom("root_pid", rootPid);
					org.talend.logging.audit.Context log_context_talendJobLog = null;

					if (jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.sourceId(jcm.sourceId)
								.sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
								.targetId(jcm.targetId).targetLabel(jcm.targetLabel)
								.targetConnectorType(jcm.targetComponentName).connectionName(jcm.current_connector)
								.rows(jcm.row_count).duration(duration).build();
						auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
						auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).duration(duration)
								.status(jcm.status).build();
						auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
								.connectorType(jcm.component_name).connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label).build();
						auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {// log current component
																							// input line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {// log current component
																								// output/reject line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
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

				currentComponent = "talendJobLog";

				tos_count_talendJobLog++;

				/**
				 * [talendJobLog main ] stop
				 */

				/**
				 * [talendJobLog process_data_begin ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_begin ] stop
				 */

				/**
				 * [talendJobLog process_data_end ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_end ] stop
				 */

				/**
				 * [talendJobLog end ] start
				 */

				currentComponent = "talendJobLog";

				ok_Hash.put("talendJobLog", true);
				end_Hash.put("talendJobLog", System.currentTimeMillis());

				/**
				 * [talendJobLog end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [talendJobLog finally ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
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
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final Policyrestapi PolicyrestapiClass = new Policyrestapi();

		int exitCode = PolicyrestapiClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'Policyrestapi' - Done.");
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

		if (!"".equals(log4jLevel)) {

			if ("trace".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.OFF);
			}
			org.apache.logging.log4j.core.config.Configurator
					.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());

		}
		log.info("TalendJob: 'Policyrestapi' - Start.");

		if (enableLogStash) {
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

			System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()),
							System.getProperty(key)));

			org.apache.logging.log4j.core.config.Configurator
					.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);

			auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory
					.createJobAuditLogger(properties_talendJobLog);
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
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
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = Policyrestapi.class.getClassLoader()
					.getResourceAsStream("local_project/policyrestapi_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Policyrestapi.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("transactiontypecode", "id_String");
					if (context.getStringValue("transactiontypecode") == null) {
						context.transactiontypecode = null;
					} else {
						context.transactiontypecode = (String) context.getProperty("transactiontypecode");
					}
					context.setContextType("sql_query", "id_String");
					if (context.getStringValue("sql_query") == null) {
						context.sql_query = null;
					} else {
						context.sql_query = (String) context.getProperty("sql_query");
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("transactiontypecode")) {
				context.transactiontypecode = (String) parentContextMap.get("transactiontypecode");
			}
			if (parentContextMap.containsKey("sql_query")) {
				context.sql_query = (String) parentContextMap.get("sql_query");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
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

		this.globalResumeTicket = true;// to run tPreJob

		try {
			errorCode = null;
			tPrejob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tPrejob_1) {
			globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

			e_tPrejob_1.printStackTrace();

		}

		if (enableLogStash) {
			talendJobLog.addJobStartMessage();
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tRESTRequest_1_LoopProcess(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tRESTRequest_1_Loop) {
			globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", -1);

			e_tRESTRequest_1_Loop.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out
					.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Policyrestapi");
		}
		if (enableLogStash) {
			talendJobLog.addJobEndMessage(startTime, end, status);
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {
		closeSqlDbConnections();

	}

	private void closeSqlDbConnections() {
		try {
			Object obj_conn;
			obj_conn = globalMap.remove("conn_tDBConnection_1");
			if (null != obj_conn) {
				((java.sql.Connection) obj_conn).close();
			}
		} catch (java.lang.Exception e) {
		}
	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
		connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));

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
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
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
 * 148246 characters generated by Talend Cloud Real-Time Big Data Platform on
 * the 13 July 2023 15:57:23 BST
 ************************************************************************************************/
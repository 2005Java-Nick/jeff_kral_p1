package trms.model;

public class Reimbursement {
	
	private String id;
	private String firstName;
	private String lastName;
	private String eventName;
	private String eventType;
	private String eventDate;
	private String eventDescription;
	private double eventCost;
	private String eventGradeFormat;
	private String workJustification;
	private String attachment;
	private String eventLocation;
	
	public Reimbursement() {
		
	}
	
	public Reimbursement(
			String id, String firstName, String lastName, String eventName,
			String eventType, String eventDate, String eventDescription,
			double eventCost, String eventGradeFormat, String workJustification, String eventLocation) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.eventDescription = eventDescription;
		this.eventCost = eventCost;
		this.eventGradeFormat = eventGradeFormat;
		this.workJustification = workJustification;
		this.eventLocation = eventLocation;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getEventType() {
		return eventType;
	}
	
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	public String getEventDate() {
		return eventDate;
	}
	
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	public String getEventDescription() {
		return eventDescription;
	}
	
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	public double getEventCost() {
		return eventCost;
	}
	
	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}
	
	public String getEventGradeFormat() {
		return eventGradeFormat;
	}
	
	public void setEventGradeFormat(String eventGradeFormat) {
		this.eventGradeFormat = eventGradeFormat;
	}
	
	public String getWorkJustification() {
		return workJustification;
	}
	
	public void setWorkJustification(String workJustification) {
		this.workJustification = workJustification;
	}
	
	public String getAttachment() {
		return attachment;
	}
	
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	public String getEventLocation() {
		return eventLocation;
	}
	
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	
	@Override
	public String toString() {
		return "Reimbursement{" +
				       "id='" + id + '\'' +
				       ", firstName='" + firstName + '\'' +
				       ", lastName='" + lastName + '\'' +
				       ", eventName='" + eventName + '\'' +
				       ", eventType='" + eventType + '\'' +
				       ", eventDate='" + eventDate + '\'' +
				       ", evenDescription='" + eventDescription + '\'' +
				       ", eventCost=" + eventCost +
				       ", eventGradeFormat='" + eventGradeFormat + '\'' +
				       ", workJustification='" + workJustification + '\'' +
				       ", attachment='" + attachment + '\'' +
				       ", eventLocation='" + eventLocation + '\'' +
				       '}';
	}
}

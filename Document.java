import java.util.Date;


/*
 * NewspaperArtical is a document
 * PublishingLocation is a field of a document
 */


public abstract class Document {

	private String title;
	private String author;
	private Date date;
	private PublishingLocation publishingLocation;

	
	public Document() {
		//super(city, state, postCode);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public Date getDate() {
		return date;
	}
	
	
	public int compareDates(Document document){
		return this.date.compareTo(document.getDate());
	}
	
	
	public int compareWithGeneralDate(Date date){
		return this.date.compareTo(date);
	}
	
	
	public boolean sameAuthor(Document document) {
		return this.getAuthor().equals(document.getAuthor());
	}

	public String getCity() {
		return publishingLocation.getCity();
	}
	
	public String getState() {
		return publishingLocation.getState();
	}
	
	public String getPostCode() {
		return publishingLocation.getPostCode();
	}
	
	
	
	
	
	
	
	
}

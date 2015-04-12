package umkc.edu.cccyt3.temp_mems;


public class Assignment {
	private String assignmentName;
	
	// private key. id will be determined by DB
	// when the record for this course is inserted
	// into the Assignment table
	private int id;
	
	
	public Assignment(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	
	public String toString() {
		return assignmentName;
	}
}
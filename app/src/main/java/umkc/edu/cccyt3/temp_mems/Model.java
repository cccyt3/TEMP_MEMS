package umkc.edu.cccyt3.temp_mems;

import java.util.ArrayList;
import android.content.Context;

public class Model {

	// Singleton design pattern
	private static Model instance = null;

	private CourseGateway courseGateway;
	private DeviceGateway deviceGateway;
	
	private Model(Context context) {
		courseGateway = new CourseGateway(context);
		deviceGateway = new DeviceGateway(context);
	}

    public synchronized static Model instance(Context context) {
        if( instance == null ) {
            instance = new Model(context);
        }
        return instance;
    }
	
	public ArrayList<Course> getCourses() {
		return courseGateway.findAll();
	}
	
	public long insertCourse(String courseName) {
		return courseGateway.insert(courseName);
	}

	public long insertAssignment(long courseID, String assignmentName) {
		return deviceGateway.insert(courseID, assignmentName);
	}

	public ArrayList<Assignment> getAssignments(Course c) {
		return deviceGateway.findForCourse(c);
	}
}

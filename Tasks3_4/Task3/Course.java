package Tasks3_4.Task3;

import java.io.Serializable;

public class Course implements Serializable{
    private String courseCode;
    private String courseName;
    private String instructor;

    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return "Course{courseName='" + courseName + "', courseCode=" + courseCode + ", instructor=" + instructor + "}";
    }
    
}

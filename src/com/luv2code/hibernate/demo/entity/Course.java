package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "title")
    private String courseTitle;

    // a course have manyToOne relationship with instructor, many courses can be taught by one instructor
    // a course will have reference to instructor, column in course table that allow us to find associated instructor
    // @JoinColumn is the column in the course table
    // we did not give CascadeType.REMOVE because we don't want to remove instructor if we delete course
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Course(){
    }

    // select one field because id is auto-generated and we will insert instructor manually
    public Course(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id=" + Id +
                ", courseTitle='" + courseTitle + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}

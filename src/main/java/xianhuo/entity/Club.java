package xianhuo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Entity(name = "club")
@Table(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ID")
    private Long mId;

    @Column(nullable = false, name = "NAME")
    private String mName;

    @ManyToMany
    private List<Student> mStudents;

    @ManyToOne
    private Student mHostStudent;

    @ManyToOne
    private Teacher mHostTeacher;

    @OneToMany(mappedBy = "mClub")
    private List<Activity> mActivities;

    @OneToMany(mappedBy = "mClub")
    private List<File> mFiles;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> mComments;

    public Club(){}

    public Club(String mName, List<Student> mStudents, Student mHostStudent, Teacher mHostTeacher) {
        this.mName = mName;
        this.mStudents = mStudents;
        this.mHostStudent = mHostStudent;
        this.mHostTeacher = mHostTeacher;
    }

    public Teacher getmHostTeacher() {
        return mHostTeacher;
    }

    public void setmHostTeacher(Teacher mHostTeacher) {
        this.mHostTeacher = mHostTeacher;
    }

    public List<Comment> getmComments() {
        return mComments;
    }

    public void setmComments(List<Comment> mComments) {
        this.mComments = mComments;
    }

    public List<File> getmFiles() {
        return mFiles;
    }

    public void setmFiles(List<File> mFiles) {
        this.mFiles = mFiles;
    }

    public List<Activity> getmActivities() {
        return mActivities;
    }

    public void setmActivities(List<Activity> mActivities) {
        this.mActivities = mActivities;
    }

    public Student getmHostStudent() {
        return mHostStudent;
    }

    public void setmHostStudent(Student mHostStudent) {
        this.mHostStudent = mHostStudent;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public List<Student> getmStudents() {
        return mStudents;
    }

    public void setmStudents(List<Student> mStudents) {
        this.mStudents = mStudents;
    }
}

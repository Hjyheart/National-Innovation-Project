package xianhuo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Column(nullable = false, name = "STATE")
    private boolean mState;

    @ManyToMany
    private List<Student> mStudents;

    @ManyToOne
    private Student mHostStudent;

    @ManyToOne
    private Teacher mHostTeacher;

    @OneToMany(mappedBy = "mClub", cascade = CascadeType.ALL)
    private List<Activity> mActivities = new ArrayList<>();

    @OneToMany(mappedBy = "mClub", cascade = CascadeType.ALL)
    private List<File> mFiles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> mComments = new ArrayList<>();

    public Club(){}

    public Club(String mName, Student mHostStudent, Teacher mHostTeacher, boolean mState) {
        this.mName = mName;
        this.mHostStudent = mHostStudent;
        this.mHostTeacher = mHostTeacher;
        this.mState = mState;
    }

    @JsonBackReference
    public Teacher getmHostTeacher() {
        return mHostTeacher;
    }

    public boolean ismState() {
        return mState;
    }

    public void setmState(boolean mState) {
        this.mState = mState;
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

    @JsonBackReference
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

    @JsonBackReference
    public List<Student> getmStudents() {
        return mStudents;
    }

    public void setmStudents(List<Student> mStudents) {
        this.mStudents = mStudents;
    }
}

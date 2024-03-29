package xianhuo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjiayong on 2017/2/13.
 */
@Entity(name = "student")
@Table(name = "student")
public class Student {
    @Id
    @Column(nullable = false, name = "ID")
    private String mId;

    @Column(nullable = false,name = "PASSWORD")
    private String mPassword;

    @Column(nullable = true, name = "NAME")
    private String mName;

    @Column(nullable = true, name = "GRADE")
    private Integer mGrade;

    @Column(nullable = true, name = "MAJOR")
    private String mMajor;

    @Column(nullable = true, name = "CONTACT")
    private String mContact;

    @Column(nullable = true, name = "HEADIMG")
    private String mHeadUrl;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Mail> mMails = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Mail> mSends = new ArrayList<>();

    @OneToMany(mappedBy = "mStudent", cascade = CascadeType.ALL)
    private List<Comment> mComments = new ArrayList<>();

    @OneToMany(mappedBy = "mHostStudent", cascade = CascadeType.ALL)
    private List<Club> mHostClubs = new ArrayList<>();

    @ManyToMany(mappedBy = "mStudents", cascade = CascadeType.ALL)
    private List<Club> mInClubs = new ArrayList<>();

    @ManyToMany(mappedBy = "mStudents")
    private List<Activity> mActivities = new ArrayList<>();

    public Student(){}

    public Student(String mId, String mPassword) {
        this.mId = mId;
        this.mPassword = mPassword;
    }

    public List<Comment> getmComments() {
        return mComments;
    }

    public void setmComments(List<Comment> mComments) {
        this.mComments = mComments;
    }

    public List<Activity> getmActivities() {
        return mActivities;
    }

    public void setmActivities(List<Activity> mActivities) {
        this.mActivities = mActivities;
    }

    public List<Club> getmHostClubs() {
        return mHostClubs;
    }

    public void setmHostClubs(List<Club> mHostClubs) {
        this.mHostClubs = mHostClubs;
    }

    public List<Club> getmInClubs() {
        return mInClubs;
    }

    public void setmInClubs(List<Club> mInClubs) {
        this.mInClubs = mInClubs;
    }

    public List<Mail> getmMails() {
        return mMails;
    }

    public void setmMails(List<Mail> mMails) {
        this.mMails = mMails;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Integer getmGrade() {
        return mGrade;
    }

    public void setmGrade(Integer mGrade) {
        this.mGrade = mGrade;
    }

    public String getmMajor() {
        return mMajor;
    }

    public void setmMajor(String mMajor) {
        this.mMajor = mMajor;
    }

    public String getmContact() {
        return mContact;
    }

    public void setmContact(String mContact) {
        this.mContact = mContact;
    }

    public String getmHeadUrl() {
        return mHeadUrl;
    }

    public void setmHeadUrl(String mHeadUrl) {
        this.mHeadUrl = mHeadUrl;
    }

    public List<Mail> getmSends() {
        return mSends;
    }

    public void setmSends(List<Mail> mSends) {
        this.mSends = mSends;
    }
}

package xianhuo.entity;

import javax.persistence.*;
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

    @Column(nullable = false, name = "NAME")
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
    private List<Mail> mMails;

    @OneToMany(mappedBy = "mHostStudent")
    private List<Club> mHostClubs;

    @ManyToMany(mappedBy = "mStudents")
    private List<Club> mInClubs;

    @ManyToMany(mappedBy = "mStudents")
    private List<Activity> mActivities;

    public Student(String mId, String mPassword, String mName, Integer mGrade, String mMajor, String mContact) {
        this.mId = mId;
        this.mPassword = mPassword;
        this.mName = mName;
        this.mGrade = mGrade;
        this.mMajor = mMajor;
        this.mContact = mContact;
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
}

package xianhuo.entity;

import javax.persistence.*;

/**
 * Created by hongjiayong on 2017/2/13.
 */
@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Student(String mId, String mPassword) {
        this.mId = mId;
        this.mPassword = mPassword;
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

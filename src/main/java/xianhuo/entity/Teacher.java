package xianhuo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Entity(name = "teacher")
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ID")
    private Long mId;

    @Column(nullable = false,name = "PASSWORD")
    private String mPassword;

    @Column(nullable = false, name = "NAME")
    private String mName;

    @Column(nullable = true, name = "MAJOR")
    private String mMajor;

    @Column(nullable = true, name = "CONTACT")
    private String mContact;

    @Column(nullable = true, name = "HEADIMG")
    private String mHeadUrl;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Mail> mMail;

    @OneToMany(mappedBy = "mHostTeacher")
    private List<Club> mClub;

    public Teacher(){}

    public Teacher(String mPassword, String mName, String mMajor, String mContact, String mHeadUrl) {
        this.mPassword = mPassword;
        this.mName = mName;
        this.mMajor = mMajor;
        this.mContact = mContact;
        this.mHeadUrl = mHeadUrl;
    }

    public List<Club> getmClub() {
        return mClub;
    }

    public void setmClub(List<Club> mClub) {
        this.mClub = mClub;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
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

    public List<Mail> getmMail() {
        return mMail;
    }

    public void setmMail(List<Mail> mMail) {
        this.mMail = mMail;
    }
}

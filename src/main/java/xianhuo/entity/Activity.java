package xianhuo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Entity(name = "activity")
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ID")
    private Long mId;

    @Column(nullable = false, name = "NAME")
    private String mName;

    @Column(nullable = false, name = "LOCATION")
    private String mLocation;

    @Column(nullable = false, name = "DATE")
    private Date mDate;

    @Column(nullable = false, name = "STATE")
    private Integer mState;

    @Column(nullable = true, name = "CONTENT")
    private String mContent;

    @Column(nullable = true, name = "IMGURL")
    private String mImgUrl;

    @ManyToOne
    private Club mClub;

    @ManyToMany
    private List<Student> mStudents;

    public Activity(String mName, String mLocation, Date mDate, Integer mState, String mContent, String mImgUrl) {
        this.mName = mName;
        this.mLocation = mLocation;
        this.mDate = mDate;
        this.mState = mState;
        this.mContent = mContent;
        this.mImgUrl = mImgUrl;
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

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public Integer getmState() {
        return mState;
    }

    public void setmState(Integer mState) {
        this.mState = mState;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmImgUrl() {
        return mImgUrl;
    }

    public void setmImgUrl(String mImgUrl) {
        this.mImgUrl = mImgUrl;
    }

    public Club getmClub() {
        return mClub;
    }

    public void setmClub(Club mClub) {
        this.mClub = mClub;
    }

    public List<Student> getmStudents() {
        return mStudents;
    }

    public void setmStudents(List<Student> mStudents) {
        this.mStudents = mStudents;
    }
}
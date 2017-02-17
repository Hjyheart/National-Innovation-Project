package xianhuo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Entity(name = "mail")
@Table(name = "mail")
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ID")
    private Long mId;

    @Column(nullable = false, name = "TYPE")
    private Integer mType;

    @Column(nullable = false, name = "STATE")
    private Boolean mState;

    @Column(nullable = false, name = "SENDER")
    private String mSender;

    @Column(nullable = false, name = "RECEIVER")
    private String mReceiver;

    @Column(nullable = true, name = "CONTENT")
    private String mContent;

    @Column(nullable = false, name = "DATE")
    private Date mDate;

    public Mail(Integer mType, String mSender, String mReceiver, String mContent, Date mDate, Boolean mState) {
        this.mType = mType;
        this.mSender = mSender;
        this.mReceiver = mReceiver;
        this.mContent = mContent;
        this.mDate = mDate;
        this.mState = mState;
    }

    public Boolean getmState() {
        return mState;
    }

    public void setmState(Boolean mState) {
        this.mState = mState;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public Integer getmType() {
        return mType;
    }

    public void setmType(Integer mType) {
        this.mType = mType;
    }

    public String getmSender() {
        return mSender;
    }

    public void setmSender(String mSender) {
        this.mSender = mSender;
    }

    public String getmReceiver() {
        return mReceiver;
    }

    public void setmReceiver(String mReciver) {
        this.mReceiver = mReciver;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }
}

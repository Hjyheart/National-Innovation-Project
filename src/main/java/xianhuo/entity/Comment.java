package xianhuo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Entity(name = "comment")
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ID")
    private Long mId;

    @Column(nullable = true, name = "CONTENT")
    private String mContent;

    @Column(nullable = false, name = "DATE")
    private Date mDate;

    // 0 -> club 1 -> activity
    @Column(nullable = false, name = "TYPE")
    private Integer mType;

    @Column(nullable = false, name = "TARGET")
    private Long mTarget;

    @ManyToOne
    private Student mStudent;

    public Comment(){}

    public Comment(String mContent, Date mDate, Integer mType, Long mTarget, Student mStudent) {
        this.mContent = mContent;
        this.mDate = mDate;
        this.mType = mType;
        this.mTarget = mTarget;
        this.mStudent = mStudent;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
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

    public Integer getmType() {
        return mType;
    }

    public void setmType(Integer mType) {
        this.mType = mType;
    }

    public Long getmTarget() {
        return mTarget;
    }

    public void setmTarget(Long mTarget) {
        this.mTarget = mTarget;
    }

    @JsonBackReference
    public Student getmStudent() {
        return mStudent;
    }

    public void setmStudent(Student mStudent) {
        this.mStudent = mStudent;
    }
}

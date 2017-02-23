package xianhuo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Entity(name = "file")
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ID")
    private Long mId;

    @Column(nullable = false, name = "NAME")
    private String mName;

    @Column(nullable = false, name = "URL")
    private String mUrl;

    @ManyToOne
    private Club mClub;

    public File(String mName, String mUrl) {
        this.mName = mName;
        this.mUrl = mUrl;
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

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    @JsonBackReference
    public Club getmClub() {
        return mClub;
    }

    public void setmClub(Club mClub) {
        this.mClub = mClub;
    }
}

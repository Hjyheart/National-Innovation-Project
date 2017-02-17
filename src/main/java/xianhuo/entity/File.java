package xianhuo.entity;

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
}

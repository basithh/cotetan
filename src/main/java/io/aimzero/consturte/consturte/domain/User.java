package io.aimzero.consturte.consturte.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Set;


@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column
    private String r;

    @OneToMany(mappedBy = "rt")
    private Set<User> rtt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rt_id")
    private User rt;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getR() {
        return r;
    }

    public void setR(final String r) {
        this.r = r;
    }

    public Set<User> getRtt() {
        return rtt;
    }

    public void setRtt(final Set<User> rtt) {
        this.rtt = rtt;
    }

    public User getRt() {
        return rt;
    }

    public void setRt(final User rt) {
        this.rt = rt;
    }

}

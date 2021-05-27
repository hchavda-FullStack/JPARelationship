package io.hitesh.learning.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Student {
    @Id
    @GeneratedValue
    private int id;

    @Column(length = 255,nullable = false)
    private String name;

    @Builder.Default
    private Instant createDate = Instant.now();
    @Builder.Default
    private Instant updateDate = Instant.now();
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private StudentPermit permit;

    @Transient
    private String funnyName;

    @OneToMany(mappedBy = "student")
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();
}

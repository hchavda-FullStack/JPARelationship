package io.hitesh.learning.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
//    @Id
//    @GeneratedValue
    @EmbeddedId
    private ReviewPK reviewPK;

    private String programName;

    private String reviewText;
    @ManyToOne
    private Student student;
}

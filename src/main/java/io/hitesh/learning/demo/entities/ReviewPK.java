package io.hitesh.learning.demo.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ReviewPK implements Serializable {
    @Column
    private Integer courseID;
    @Column
    private Integer reviewID;
}

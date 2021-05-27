package io.hitesh.learning.demo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class Programs {
    @Id
//    @GeneratedValue
    private int id;

    private String name;

    private Long duration;
}

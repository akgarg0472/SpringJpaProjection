package com.akarg.springjpaprojection.engineer;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author Akhilesh Garg
 * @since 16-11-2022
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Engineer implements Serializable {

    @Serial
    private static final long serialVersionUID = -327453476346457L;

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private EngineerType type;
    private Long createdAt;
    private Integer salary;

}

package de.tekup.jpademob.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="library")
public class LibraryEntity {
    @Id
    private int id;
    @Column(length = 50)
    private String name;
    @Column(length = 40,nullable = false,unique = true)
    private String matricule;

}

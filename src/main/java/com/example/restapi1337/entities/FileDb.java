package com.example.restapi1337.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "file_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileDb {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"

    )
    private Long id;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "fileType")
    private String fileType;

    @Column(name = "fileURI")
    private String uri;

    @Column(name = "fileSize")
    private Long size;

    @Column(name = "image")
    private byte[] data;
}

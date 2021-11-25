//package ru.netology.cloudservice.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@Builder
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//public class IncomingFile {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column
//    private String filename;
//    @Column
//    private long size;
////    @ManyToOne(cascade = CascadeType.ALL)
////    private User user;
//
//    public IncomingFile(String filename, long size) {
//        this.filename = filename;
//        this.size = size;
//    }
//}

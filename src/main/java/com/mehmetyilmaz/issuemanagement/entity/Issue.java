package com.mehmetyilmaz.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor // empty constructor
@AllArgsConstructor // constructor for all fields
@ToString // generate this object to string
@EqualsAndHashCode

@Entity // this class is table
@Data //  getter setter
@Table(name = "issue") // this table's properties
public class Issue extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // dynamic id
    private Long id;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING) // how to stash data in table, OPEN like string or 1 like index
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id") // if use relational column, column becomes joincolumn
    @ManyToOne(optional = true, fetch = FetchType.LAZY) // manytoone: iliski tipi, optiinal: user zorunlu degil, fetch: LAZY->Issue select edilirken User get edilirse getirilir, EAGER->Issue select edilirken her zaman getir
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;

}

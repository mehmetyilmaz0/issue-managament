package com.mehmetyilmaz.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Table(name = "issue_history")
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class IssueHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "issuee_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Issue issue;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING) // how to stash data in table, OPEN like string or 1 like index
    private IssueStatus issueStatus;

    @Column(name = "details", length = 4000)
    private String details;

    @JoinColumn(name = "assignee_user_id") // if use relational column, column becomes joincolumn
    @ManyToOne(optional = true, fetch = FetchType.LAZY) // manytoone: iliski tipi, optiinal: user zorunlu degil, fetch: LAZY->Issue select edilirken User get edilirse getirilir, EAGER->Issue select edilirken her zaman getir
    private User assignee;

}

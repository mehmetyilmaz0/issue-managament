package com.mehmetyilmaz.issuemanagement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data // usingType1 : getter setter
// @Getter @Setter // usingType2 : get-set method of these fields
@MappedSuperclass // using by other table
public abstract class BaseEntity implements Serializable {

    // @Getter @Setter // usingType3 : get-set method of this field
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // @Getter @Setter // usingType3 : get-set method of this field
    @Column(name = "created_by", length = 100)
    private String createdBy;

    // @Getter @Setter // usingType3 : get-set method of this field
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // @Getter @Setter // usingType3 : get-set method of this field
    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    // @Getter @Setter // usingType3 : get-set method of this field
    @Column(name = "status")
    private Boolean status;

}

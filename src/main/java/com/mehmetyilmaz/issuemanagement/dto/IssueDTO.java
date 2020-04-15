package com.mehmetyilmaz.issuemanagement.dto;


import com.mehmetyilmaz.issuemanagement.entity.IssueStatus;
import com.mehmetyilmaz.issuemanagement.entity.Project;
import com.mehmetyilmaz.issuemanagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// entity katmanindaki field lar sadece iç modelimi ilgilendiriyor.. bu yuzden biz araya dto dedigimiz bir nesne koyacagiz.
// yani bu servisimi cagiracak clinte 'a bu classdaki fieldlerimi gonderebiliri hepsini gerek yok.
// yani burada disari ile konustugumuz fieldleri koyuyoruz..

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDTO {

    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDTO assignee; // cunku User icindeki password gibi onemli bilgileri gondermemek icin
    private ProjectDTO project;

}

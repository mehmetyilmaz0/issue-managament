package com.mehmetyilmaz.issuemanagement.api;

import com.mehmetyilmaz.issuemanagement.dto.IssueDTO;
import com.mehmetyilmaz.issuemanagement.service.impl.IssueServiceImpl;
import com.mehmetyilmaz.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController (IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDTO> getById (@PathVariable("id") Long id) {
        IssueDTO issueDTO = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDTO);
    }

    @PostMapping()
    public ResponseEntity<IssueDTO> createIssue (@Valid @RequestBody IssueDTO issueDTO) {
        return ResponseEntity.ok(issueServiceImpl.save(issueDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDTO> updateIssue(@PathVariable("id") Long id, @Valid @RequestBody IssueDTO issueDTO) {
        return ResponseEntity.ok(issueServiceImpl.update(id, issueDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIssue (@PathVariable("id") Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }


}

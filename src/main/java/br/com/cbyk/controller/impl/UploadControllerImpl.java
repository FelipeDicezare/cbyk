package br.com.cbyk.controller.impl;

import br.com.cbyk.controller.UploadController;
import br.com.cbyk.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@PreAuthorize("hasAuthority('ROLE_ADMIN','ROLE_USER')")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/conta")
public class UploadControllerImpl implements UploadController {

    private final UploadService uploadFiles;

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity upload(@RequestParam("file") MultipartFile csv) throws Exception {
        uploadFiles.upload(csv.getInputStream());
        return new ResponseEntity(HttpStatus.OK);
    }

}

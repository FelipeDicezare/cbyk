package br.com.cbyk.service;

import java.io.InputStream;

public interface UploadService {

    void upload(InputStream inputStream) throws Exception;

}

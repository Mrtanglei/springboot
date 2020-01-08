package com.lei.tang.demo.controller;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author tanglei
 * @date 2019/12/27
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    private final static String PATH = "/data/files/";

    @PostMapping("/standardServletMultipartResolver")
    public String standardServletMultipartResolver(@RequestParam(name = "file") MultipartFile[] multipartFiles) {
        Assert.isTrue(multipartFiles != null && multipartFiles.length > 0, "请选择文件");
        //获取保存文件磁盘的文件夹，如果不存在则创建
        File directory = buildDirectory();
        for (int i = 0; i < multipartFiles.length; i++) {
            upload(multipartFiles[i], directory);
        }
        return "上传成功！";
    }

    private File buildDirectory() {
        File directory = new File(PATH);
        if (!directory.exists() || !directory.isDirectory()) {
            directory.mkdirs();
        }
        return directory;
    }

    private void upload(MultipartFile multipartFile, File directory) {
        File file = new File(PATH + multipartFile.getOriginalFilename());
        String filename = multipartFile.getOriginalFilename();
        //实际项目中可能会上传重名文件，但内容可能不一致，所以我们需要重置文件名称，否则原文件将丢失
        if (file.exists()) {
            filename = System.currentTimeMillis() + filename;
        }
        try {
            multipartFile.transferTo(new File(directory, filename));
        } catch (IOException e) {
            log.error("上次文件失败", e);
            throw new RuntimeException("上次文件失败");
        }
    }

    @PostMapping("/commonsMultipartResolver")
    public String commonsMultipartResolver(HttpServletRequest request) {
        List<MultipartFile> multipartFiles = getFormMultipartFile(request);
        Assert.isTrue(multipartFiles != null && multipartFiles.size() > 0, "请选择需要上传的文件");
        File directory = buildDirectory();
        multipartFiles.stream().forEach(multipartFile -> {
            upload(multipartFile, directory);
        });
        return "上传成功";
    }

    private List<MultipartFile> getFormMultipartFile(HttpServletRequest request) {
        //将当前上下文初始化给CommonsMutipartResolver多部分解析器）
        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
        //检查form中是否有enctype="multipart/form-data"
        if (resolver.isMultipart(request)) {
            //键名是form表单中上传文件控件的name值
            return multipartRequest.getFiles("files");
        }
        return null;
    }
}

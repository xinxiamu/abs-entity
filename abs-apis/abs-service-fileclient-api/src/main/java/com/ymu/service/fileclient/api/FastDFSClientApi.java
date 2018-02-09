package com.ymu.service.fileclient.api;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Map;

@RestController
public interface FastDFSClientApi {

    /**
     * 上传文件。
     * @param file 文件对象
     * @param fileName 文件名称
     * @return
     */
    String uploadFile(File file, String fileName);

    /**
     * 上传文件。
     * @param file
     * @param fileName
     * @param metaList
     * @return
     */
    String uploadFile(File file, String fileName, Map<String,String> metaList);

    /**
     * 获取文件元数据
     * @param fileId 文件ID
     * @return
     */
    Map<String,String> getFileMetadata(String fileId);

    /**
     * 删除文件
     * @param fileId 文件ID
     * @return 删除失败返回-1，否则返回0
     */
    int deleteFile(String fileId);

    /**
     * 下载文件
     * @param fileId 文件ID（上传文件成功后返回的ID）
     * @param outFile 文件下载保存位置
     * @return
     */
    int downloadFile(String fileId, File outFile);
}

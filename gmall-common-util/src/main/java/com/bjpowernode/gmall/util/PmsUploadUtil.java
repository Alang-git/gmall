package com.bjpowernode.gmall.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * ClassName:PmsUploadUtil
 * Package:com.bjpowernode.gmall.util
 * Description:
 *
 * @date:2020/2/16 1:53)
 * @author:Lan
 */
public class PmsUploadUtil {

    public static String uploadImage(MultipartFile multipartFile) {

        String imgUrl = "http://192.168.217.128";
        try {
            //初始化配置
            ClientGlobal.init("tracker.conf");

            //创建一个tracker客户端
            TrackerClient trackerClient = new TrackerClient();

            //根据tracker客户端，获取trackerServer实例
            TrackerServer trackerServer = trackerClient.getConnection();

            //通过trackerServer实例获取Storage客户端
            StorageClient storageClient = new StorageClient(trackerServer, null);


            byte[] bytes = multipartFile.getBytes();  //获取上传的二进制对象

            //获取文件后缀名
            String originalFilename = multipartFile.getOriginalFilename();  //获取文件名 例如：a.txt a.jpeg
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i + 1);

            //调用Storage客户端的上传文件方法
            String[] uploadIfo = storageClient.upload_file(bytes, extName, null);


            for (String s : uploadIfo) {
                imgUrl += "/" + s;
            }

            //System.out.println(imgUrl);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        return imgUrl;
    }
}

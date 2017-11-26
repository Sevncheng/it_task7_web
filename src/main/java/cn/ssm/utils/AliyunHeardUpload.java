package cn.ssm.utils;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AliyunHeardUpload {

    private String ak;
    private String sk;
    private String bk;


    public void send(InputStream inputStream,String filename) throws FileNotFoundException {
        // endpoint以杭州为例，其它region请按实际情况填写
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, ak,sk);
        // 上传
        ossClient.putObject(bk,filename,inputStream);
        // 关闭client
        ossClient.shutdown();
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public void setBk(String bk) {
        this.bk = bk;
    }
}

package cn.ssm.utils;

import com.aliyun.oss.OSSClient;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.InputStream;

public class HeardUpload {

    private String ak;
    private String sk;
    private String bk;
    private String numb;


    //阿里云的上传
    public void AlisendImage(InputStream inputStream, String filename){
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
    //七牛网的上传
    public void QiniusendImage(byte[] uploadBytes,String filename) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = ak ;
        String secretKey = sk;
        String bucket = bk;
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = filename;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(uploadBytes, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
            }
        }
    }

    public String getNumb() {
        return numb;
    }

    public void setNumb(String numb) {
        this.numb = numb;
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

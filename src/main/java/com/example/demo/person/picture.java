package com.example.demo.person;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by huangmy on 2018/4/19
 */
public class picture {

//    public static InputStream getInputStreamByGet(String url) {
//        try {
//            HttpURLConnection conn = (HttpURLConnection) new URL(url)
//                    .openConnection();
//            conn.setReadTimeout(5000);
//            conn.setConnectTimeout(5000);
//            conn.setRequestMethod("GET");
//
//            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                InputStream inputStream = conn.getInputStream();
//                return inputStream;
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    // 将服务器响应的数据流存到本地文件
//    public static void saveData(InputStream is, File file) {
//        try (BufferedInputStream bis = new BufferedInputStream(is);
//             BufferedOutputStream bos = new BufferedOutputStream(
//                     new FileOutputStream(file));) {
//            byte[] buffer = new byte[1024];
//            int len = -1;
//            while ((len = bis.read(buffer)) != -1) {
//                bos.write(buffer, 0, len);
//                bos.flush();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {
        try {
            // 构造URL
            URL url = new URL("http://ui.51bi.com/opt/siteimg/images/fanbei0923/Mid_07.jpg");
            // 打开连接
            URLConnection con = url.openConnection();
            //设置请求超时为5s
            con.setConnectTimeout(5*1000);
            // 输入流
            InputStream is = con.getInputStream();

            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            File sf=new File("/Users/hmy/Downloads/image/img");
            if(!sf.exists()){
                sf.mkdirs();
            }

            OutputStream os = new FileOutputStream(sf.getPath()+"\\"+"shabi.jpg");
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}

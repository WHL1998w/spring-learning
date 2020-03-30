package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Book;
import com.soft1851.spring.web.entity.Topic;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JueJinBookSpider
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/28
 **/
public class JueJinBookSpider {
    private static  final  Integer SUCCESS=200;
    public static List<Book> getBooks(){
        List<Book> books=new ArrayList<>();
        //目标地址
        String url="https://xiaoce-timeline-api-ms.juejin.im/v1/getListByLastTime?uid=5e7e9e07e51d4546f70cfd23&client_id=1585356295780&token=eyJhY2Nlc3NfdG9rZW4iOiJiMzAwSjVralhydlU2MlBmIiwicmVmcmVzaF90b2tlbiI6IjRLQUJQa3hJWm9jcjh0dFMiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&alias=&pageNum=1";

        //创建HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建get请求
        HttpGet get=new HttpGet(url);
        //创建context请求
        HttpClientContext context=HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response=null;
        try{
            response=httpclient.execute(get,context);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //如果请求成功，则获取网页源码
        if (response.getStatusLine().getStatusCode()==SUCCESS){
            //获取相应对象实体，并转换成UTF—8字符串
            HttpEntity entity=response.getEntity();
            String res=null;
            try {
                res= EntityUtils.toString(entity,"UTF-8");
                System.out.println(res);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //res是字符串，先转换为json对象
            JSONObject jsonObject=JSONObject.parseObject(res);
            //System.out.println(jsonObject);
            //获取数组中的JSONObject
            JSONArray list=jsonObject.getJSONArray("d");
            System.out.println(list);
            list.forEach(o -> {
                JSONObject json=JSONObject.parseObject(o.toString());
                System.out.println(json);
                JSONObject jsonObject1 = json.getJSONObject("userData");
                System.out.println(jsonObject1);
                Book book=
                        Book.builder()
                                .title(json.getString("title"))
                                .userName(jsonObject1.getString("username"))
                                .desc(json.getString("desc"))
                                .profile(json.getString("profile"))
                                .price(json.getDouble("price"))
                                .img(json.getString("img")) .build();
                books.add(book);
                System.out.println(book);
            });
        }else {
            System.out.println("请求失败");

        }try{
            //关闭
            response.close();
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  books;
    }
    public static void main(String[] args) {
        getBooks();
    }
}
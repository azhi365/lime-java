import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.Charsets;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by YZhi on 2017/4/26.
 */
public class BaiduTestCase {
    @Test
    public void testName() throws Exception {
        String q= URLEncoder.encode("人民", Charsets.UTF_8.name());
        String jsoncallback="?";
        String start= "1";
        String urlStr="https://www.googleapis.com/customsearch/v1element?key=AIzaSyCVAXiUzRYsML1Pv6RwSG1gunmMikTzQqY&rsz=filtered_cse&num=10&hl=zh_CN&prettyPrint=false&source=gcsc&gss=.com&sig=432dd570d1a386253361f581254f9ca1&start="+start+"&cx=002888546953948157320:bahxnr-mq7i&q="+q+"&sort=&googlehost=www.google.com";
        URL url = new URL(urlStr);
        BufferedReader bufr = new BufferedReader(new InputStreamReader(new BufferedInputStream(url.openStream()),"utf-8"));
        String line;
        StringBuffer sb=new StringBuffer();
        while((line = bufr.readLine())!=null){
            sb.append(line);
        }
        bufr.close();
        JSONObject jsonObject=JSONObject.parseObject(sb.toString());
        JSONArray results=jsonObject.getJSONArray("results");
        JSONArray r=new JSONArray();
        for(int i=0;i<results.size();i++){
            JSONObject j=(JSONObject) results.get(i);
            JSONObject o=new JSONObject();
            o.put("title", j.get("title"));
            o.put("content", j.get("content"));
            o.put("unescapedUrl", j.get("unescapedUrl"));
            r.add(o);
        }
        try {

            PrintWriter out= new PrintWriter("./out.txt");
            out.println(jsoncallback+"("+r.toString()+")");
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

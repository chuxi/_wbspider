package cn.edu.zju.king.pageprocessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by king on 2015/4/7.
 */
public class LoginPageProcessor implements PageProcessor {

    String passwordname = null;
    Map<String, String> params = new HashMap<String, String>();
    String action = null;

    Site site = Site.me().setUserAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/39.0.2171.65 Chrome/39.0.2171.65 Safari/537.36");

    @Override
    public void process(Page page) {
        passwordname = page.getHtml().xpath("//[@type=password]/@name").toString();

        List<String> names = page.getHtml().xpath("//[@type=hidden]/@name").all();
        List<String> values = page.getHtml().xpath("//[@type=hidden]/@value").all();

        for (int i = 0; i < names.size(); i++) {
            params.put(names.get(i), values.get(i));
        }

        action = page.getHtml().xpath("//form/@action").toString();

    }

    @Override
    public Site getSite() {
        return site;
    }
}

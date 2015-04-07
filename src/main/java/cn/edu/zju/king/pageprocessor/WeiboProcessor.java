package cn.edu.zju.king.pageprocessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by king on 2015/4/7.
 */
public class WeiboProcessor implements PageProcessor {

    Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        System.out.println(page);
    }

    @Override
    public Site getSite() {
        return site;
    }
}

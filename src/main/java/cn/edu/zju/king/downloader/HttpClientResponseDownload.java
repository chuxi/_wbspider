package cn.edu.zju.king.downloader;

import org.apache.http.HttpResponse;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.selector.PlainText;

import java.io.IOException;

/**
 * Created by king on 2015/4/7.
 */
public class HttpClientResponseDownload extends HttpClientDownloader {
    HttpResponse response;

    @Override
    protected Page handleResponse(Request request, String charset, HttpResponse httpResponse, Task task) throws IOException {
        String content = getContent(charset, httpResponse);
        Page page = new Page();
        response = httpResponse;
        page.setRawText(content);
        page.setUrl(new PlainText(request.getUrl()));
        page.setRequest(request);
        page.setStatusCode(httpResponse.getStatusLine().getStatusCode());

        return page;
    }
}

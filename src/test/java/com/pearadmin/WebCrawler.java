package com.pearadmin;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    static String filename = String.format("web-crawler-result-%s.csv", new Date().getTime());
    static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write("Title,Time,Category,Link\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String url = "https://www.gznw.com/search/pcRender?sr=score+desc&pageId=51c6727c3d804001aa99cb0ae7e0ced1&ext=siteId%3A594934&pNo=1&q=%E9%A3%9F%E7%94%A8%E8%8F%8C";

        try {
            System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
            WebDriver driver = new ChromeDriver();

            driver.get(url);
            // 处理页面内容
            String content = null;
            // 获取下一页的链接并点击
            WebElement nextPageLink = null;

            for (; !driver.findElement(By.cssSelector(".next")).getAttribute("class").contains("disabled"); ) {
                // 处理页面内容
                content = driver.getPageSource();
                getResultToFile(content);

                // 获取下一页的链接
                nextPageLink = driver.findElement(By.cssSelector(".next a"));
                nextPageLink.click();
            }

            driver.quit();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     *
     * @param input HTML File
     */
    public static void getResultToFile(String input) throws IOException, InterruptedException {
        // 解析 HTML 文件
        Document doc = Jsoup.parse(input, "UTF-8");
        // 获取所有的新闻标签
        Elements news = doc.select(".default-result-list .searchMod .news-style1");
        StringBuilder result = new StringBuilder();

        // 遍历新闻标签并输出链接的 href 属性和文本内容
        for (Element item : news) {
            // 标题、发布时间、链接
            String category = getCategory(item.select("h3").get(0).text());
            Element link = item.select("h3 a").get(0);
            String time = item.select(".dates span").get(1).text();
            System.out.println("Title: " + link.text());
            System.out.println("Time: " + time);
            System.out.println("Category: " + category);
            System.out.println("Link: " + link.attr("href"));
            System.out.println();
            result.append(String.format("%s,%s,%s,%s\n", link.text(), time, category, link.attr("href")));
        }

        System.out.println("++result++");
        System.out.println(result);
        writer.write(result.toString());
    }

    public static String getCategory(String input) {
        Pattern pattern = Pattern.compile("【(.*?)】"); // 匹配括号内的内容
        Matcher matcher = pattern.matcher(input);
        String content = "";
        if (matcher.find()) {
            content = matcher.group(1); // 获取第一个括号内的内容
        }

        return content;
    }

    public static String getHtml(String url) throws IOException {
        // 创建 URL 对象
        URL obj = new URL(url);
        // 打开连接
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // 设置请求方法
        con.setRequestMethod("GET");
        // 获取响应码
        int responseCode = con.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        // 读取响应内容
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine + "\n");
        }
        in.close();
        // 输出响应内容
//        System.out.println(response);

        return response.toString();
    }
}

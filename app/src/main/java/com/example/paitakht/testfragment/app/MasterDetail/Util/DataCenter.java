package com.example.paitakht.testfragment.app.MasterDetail.Util;

import com.example.paitakht.testfragment.app.MasterDetail.Model.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fakher on 2/6/2017.
 */

public class DataCenter {

    public static List<News> getNews() {
        List<News> result = new ArrayList<>();
        result.add(new News(1, "Title 1", "Summary 1", "Content 1", new String[] {}));
        result.add(new News(2, "Title 2", "Summary 2", "Content 2", new String[] {}));
        result.add(new News(3, "Title 3", "Summary 3", "Content 3", new String[] {}));
        result.add(new News(4, "Title 4", "Summary 4", "Content 4", new String[] {}));
        result.add(new News(5, "Title 5", "Summary 5", "Content 5", new String[] {}));
        result.add(new News(6, "Title 6", "Summary 6", "Content 6", new String[] {}));
        result.add(new News(7, "Title 7", "Summary 7", "Content 7", new String[] {}));
        result.add(new News(8, "Title 8", "Summary 8", "Content 8", new String[] {}));
        result.add(new News(9, "Title 9", "Summary 9", "Content 9", new String[] {}));
        result.add(new News(10, "Title 10", "Summary 10", "Content 10", new String[] {}));
        result.add(new News(11, "Title 11", "Summary 11", "Content 11", new String[] {}));
        result.add(new News(12, "Title 12", "Summary 12", "Content 12", new String[] {}));
        result.add(new News(13, "Title 13", "Summary 13", "Content 13", new String[] {}));
        result.add(new News(14, "Title 14", "Summary 14", "Content 14", new String[] {}));
        result.add(new News(15, "Title 15", "Summary 15", "Content 15", new String[] {}));
//        result.add(new News(16, "", "", "", new String[] {}));
//        result.add(new News(17, "", "", "", new String[] {}));
//        result.add(new News(18, "", "", "", new String[] {}));
//        result.add(new News(19, "", "", "", new String[] {}));
//        result.add(new News(20, "", "", "", new String[] {}));
//        result.add(new News(21, "", "", "", new String[] {}));
//        result.add(new News(22, "", "", "", new String[] {}));
//        result.add(new News(23, "", "", "", new String[] {}));
//        result.add(new News(24, "", "", "", new String[] {}));
//        result.add(new News(25, "", "", "", new String[] {}));
//        result.add(new News(26, "", "", "", new String[] {}));
//        result.add(new News(27, "", "", "", new String[] {}));
//        result.add(new News(28, "", "", "", new String[] {}));
//        result.add(new News(29, "", "", "", new String[] {}));
//        result.add(new News(30, "", "", "", new String[] {}));


        return result;
    }

    public static News getNews(int id) {
        List<News> dataList = getNews();

//        for (int i=0; i<dataList.size(); i++) {
//            dataList.get(i)
//        }

        for (News mNews:dataList) {
            if (mNews.getId() == id) {
                return mNews;
            }
        }

        return null;
    }

}

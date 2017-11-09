package ua.somedomen.obcc.service;

import ua.somedomen.obcc.entity.News;

import java.util.List;

public interface NewsService {

    void addNews(News news);

//    void addNewsComment(News news);

    List<News> findALL();
}

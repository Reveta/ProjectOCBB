package ua.somedomen.obcc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.somedomen.obcc.dao.NewsDAO;
import ua.somedomen.obcc.entity.News;
import ua.somedomen.obcc.service.NewsService;

import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsDAO newsDAO;

    @Override
    public void addNews(News news) {
        newsDAO.save(news);
    }

    @Override
    public List<News> findALL() {
        return newsDAO.findAll();
    }
}

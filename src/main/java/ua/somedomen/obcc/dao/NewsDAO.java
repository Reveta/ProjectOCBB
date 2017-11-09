package ua.somedomen.obcc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.somedomen.obcc.entity.News;

public interface NewsDAO extends JpaRepository<News, Integer>{
}

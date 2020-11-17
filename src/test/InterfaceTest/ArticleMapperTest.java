package com.yskj.InterfaceTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.testng.annotations.Test;

import com.yskj.InterfaceTest.MMain.Application;
import com.yskj.dao.ApiMapper;
import com.yskj.domain.Api;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest


public class ArticleMapperTest {

    @Autowired
    private ApiMapper apimapper;

//    @Test
//    public void testInsert() {
//        Article article = new Article();
//        article.setTitle("测试标题2");
//        article.setSummary("测试摘要2");
//        article.setUserId(1L);
//        article.setStatus(1);
//        article.setCreateTime(new Date());
//        article.setUpdateTime(new Date());
//        article.setPublicTime(new Date());
//        mapper.insertArticle(article);
//    }

    @Test
    public void testMybatisQuery() {
        List list = this.queryContent();
        System.out.println(list);
    }


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Api> queryContent() {
        String sql = "select * from api";
        return jdbcTemplate.query(sql, new RowMapper<Api>() {

            public Api mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                Api api = new Api();
                api.setApiid(rs.getInt("apiid"));
                api.setApiurl(rs.getString("apiurl"));
                System.out.println(api);
                return api;
            }
        });
    }


//    @Test
//    public void testUpdate() {
//        Article article = mapper.queryById(1L);
//        article.setPublicTime(new Date());
//        article.setUpdateTime(new Date());
//        article.setStatus(2);
//        mapper.updateArticle(article);
//    }

//    @Test
//    public void testQueryByPage(){
//        Article article = new Article();
//        article.setUserId(1L);
//        List<Article> list = mapper.queryArticlesByPage(article,10,0);
//        assertTrue(list.size()>0);
//    }
}
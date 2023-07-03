package org.com.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DesignDAO {
    private SqlSession mybatis;
    public DesignDAO() {
        try {
            String resource = "org/com/mybatis/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            mybatis = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<DesignDTO> selectAll() {
        return mybatis.selectList("DesignMapper.selectAll");
    }

    public DesignDTO selectOne(DesignDTO dto) {
        return mybatis.selectOne("DesignMapper.selectOne", dto);
    }

    public void insert(DesignDTO dto) {
		System.out.println(dto);
        mybatis.insert("DesignMapper.insertDesign", dto);
        mybatis.commit();
    }

    public void update(DesignDTO dto) {
        mybatis.update("DesignMapper.updateDesign", dto);
        mybatis.commit();
    }

    public void delete(DesignDTO dto) {
        mybatis.delete("DesignMapper.deleteDesign", dto);
        mybatis.commit();
    }
    public void updateReadCnt(DesignDTO dto) {
        mybatis.update("DesignMapper.updateReadCnt", dto);
        mybatis.commit();
    }
}

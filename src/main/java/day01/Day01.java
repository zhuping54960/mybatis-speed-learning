package day01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * mybatis 接口式编程有着更强得类型检查   解耦
 */
public class Day01 {

    public static void main(String[] args) throws Exception{
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession=sqlSessionFactory.openSession()){
            Student student=new Student();
            student.setId(1);
            Student result=sqlSession.selectOne("day01.StudentMapper1.selectStudent","2");
            System.out.println(result);
        }
    }
}

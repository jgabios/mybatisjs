# mybatis lib

easy mybatis integration into your ringojs app.
there is 1 java class that provides the SqlSessionFactory based on an xml in the classpath.
to specify the xml file you should start ringo shell for example like this:
ringo -D SQL_MAP_RESOURCE_PATH=mybatis-main.xml
and the factory gets built based on the mybatis-main.xml file in your current directory.

here is a small example:
var sqlFactory = require('mybatis').SqlSessionFactory;
var sqlSession = sqlFactory.openSession();
try{
var id = 2;
var a = sqlSession.selectOne("selectBlogPost", id);
print(a.get('title'));
// for insert:
sqlSession.insert("insertPost", {'titlu': 'ringo','body': 'ringob','user_id': 3});                             
sqlSession.commit();
}
finally {
 sqlSession.close();
}

in order to rely less on java, i am not doing the POJO entities for the tables, but i am relying on resultMap as a java.util.Map
to be returned and the same for the parameterType.
this is the mapper used:

<mapper namespace="testmybatis" >
  <sql id="Base_Column_List" >
    id, title, body, view_number, user_id, creation_date
  </sql>
    <select id="selectBlogPost"
          parameterType="java.lang.Long"
          resultType="java.util.Map">
        SELECT
            <include refid="Base_Column_List" />
        FROM
            posts
        WHERE
            id = #{id,jdbcType=INTEGER}
    </select>
<insert id="insertPost" parameterType="java.util.HashMap">
insert into anunt (title,body,user_id) values (#{title},#{body},#{user_id})
</insert>
</mapper>


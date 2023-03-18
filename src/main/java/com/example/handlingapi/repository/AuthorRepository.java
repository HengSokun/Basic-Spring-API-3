package com.example.handlingapi.repository;

import com.example.handlingapi.model.Author;
import com.example.handlingapi.model.request.AuthorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthorRepository {

    @Select("SELECT * FROM authors")
    @Result(property = "authorId", column = "author_id")
    @Result(property = "authorName", column = "author_name")
    @Result(property = "gender", column = "gender")
    List<Author> getAllAuthor();

    @Select("SELECT * FROM authors WHERE author_id = #{authorId}")
    @Result(property = "authorId", column = "author_id")
    @Result(property = "authorName", column = "author_name")
    @Result(property = "gender", column = "gender")
    Author getAuthorById(@Param("authorId") Integer authorId);

    @Update("UPDATE authors " +
            "SET author_name = #{author.authorName} " +
            "gender = #{author.gender}" +
            "WHERE author_id = #{authorId}")
    @Result(property = "authorId", column = "author_id")
    @Result(property = "authorName", column = "author_name")
    @Result(property = "gender", column = "gender")
    Integer updateAuthorById(@Param("authorId") Integer authorId, @Param("author") AuthorRequest authorRequest);


    @Select("INSERT INTO authors(author_name, gender) " +
            "VALUES(#{author.authorName}, #{author.gender}) " +
            "RETURNING *")
    @Result(property = "authorName", column = "author_name")
    @Result(property = "gender", column = "gender")
    Author addNewAuthor(@Param("author") AuthorRequest authorRequest);

    @Delete("DELETE FROM authors WHERE author_id = #{authorId}")
    boolean deleteAuthorById(@Param("authorId") Integer authorId);
}

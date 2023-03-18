package com.example.handlingapi.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse{
    private Long bookId;

    private String title;

    private Timestamp publishedDate;

    private AuthorResponse author;

    private List<CategoryResponse> categories;
}

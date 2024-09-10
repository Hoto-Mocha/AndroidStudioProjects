package com.example.pj4;

import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;
import java.util.Map;

public interface ApiService {
    // 특정 게시물 하나를 가져오는 메서드
    @GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int id);
    // 모든 게시물을 가져오는 메서드
    @GET("posts")
    Call<List<Post>> getAllPosts();
    // 쿼리 파라미터를 사용하여 게시물 검색
    @GET("posts")
    Call<List<Post>> getPostsByUserId(@Query("userId") int userId);
    // 새로운 게시물을 생성하는 메서드
    @POST("posts")
    Call<Post> createPost(@Body Post post);
    // 게시물을 업데이트하는 메서드
    @PUT("posts/{id}")
    Call<Post> updatePost(@Path("id") int id, @Body Post post);
    // 부분 업데이트를 위한 메서드
    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Map<String, String> fields);
    // 게시물을 삭제하는 메서드
    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);

    // 다른 필요한 API 메서드들을 이곳에 추가할 수 있습니다.
}
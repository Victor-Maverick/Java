//package africa.semicolon.gistLover;
//
//import africa.semicolon.gistLover.dtos.CreatePostRequest;
//import africa.semicolon.gistLover.services.PostServices;
//import africa.semicolon.gistLover.services.PostServicesImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.jupiter.api.Test;
//import org.springframework.context.annotation.Configuration;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class PostServicesImplTest {
//    private PostServices postServices;
//
//    @BeforeEach
//    public void initialize(){
//        postServices = new PostServicesImpl();
//    }
//
//    @Test
// //   public void createPostListOfPostsIncreasesTest(){
//        CreatePostRequest postRequest = new CreatePostRequest();
//        postRequest.setTitle("title");
//        postRequest.setContent("full content");
//        postServices.createPostWith(postRequest);
//        assertEquals(1, postServices.findAllPosts().size());
//    }
//
//}

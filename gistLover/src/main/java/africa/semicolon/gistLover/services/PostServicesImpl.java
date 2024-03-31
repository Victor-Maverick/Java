package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.data.model.View;
import africa.semicolon.gistLover.data.repository.PostRepository;
import africa.semicolon.gistLover.data.repository.UserRepository;
import africa.semicolon.gistLover.data.repository.ViewRepository;
import africa.semicolon.gistLover.dtos.request.CreatePostRequest;
import africa.semicolon.gistLover.dtos.request.EditPostRequest;
import africa.semicolon.gistLover.dtos.request.ViewRequest;
import africa.semicolon.gistLover.dtos.response.CreatePostResponse;
import africa.semicolon.gistLover.dtos.response.ViewResponse;
import africa.semicolon.gistLover.exceptions.NonExistingPostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static africa.semicolon.gistLover.utils.Mapper.map;

@Service
public class PostServicesImpl implements PostServices{
    @Autowired
    private PostRepository posts;
    @Autowired
    UserRepository users;
    @Autowired
    ViewRepository views;

    public CreatePostResponse createPostWith(CreatePostRequest postRequest, String userName) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setAuthor(users.findUserByUserName(userName));
        var newPost = posts.save(post);
        return map(newPost);
    }

    public void deletePost(String title) {
        Optional<Post> post = posts.findByTitle(title);
        if (post.isPresent()) posts.deletePostByTitle(title);
        else throw new NonExistingPostException("nonexistent post");

    }

    public void editPost(String title, EditPostRequest editPostRequest) {
        Post post = posts.findPostByTitle(title);
        if(post == null)throw new NonExistingPostException("nonexistent post");
        post.setTitle(editPostRequest.getTitle());
        post.setContent(editPostRequest.getContent());
        posts.save(post);
    }

    public ViewResponse viewPost(ViewRequest viewRequest) {
        View view = new View();
        var user = users.findUserByUserName(viewRequest.getUsername());
        view.setViewer(user);
        views.save(view);
        view = addViewToPost(viewRequest);
        return map(view);
    }

    private View addViewToPost(ViewRequest viewRequest) {
        View view;
        view = views.findByViewer(users.findUserByUserName(viewRequest.getUsername()));
        Post post = posts.findPostByTitle(viewRequest.getTitle());
        if(post.getId() == null)throw new NonExistingPostException("nonexistent post");
        List<View> viewList = post.getViews();
        viewList.add(view);
        post.setViews(viewList);
        posts.save(post);
        return view;
    }


    public List<Post> findAllPosts() {
        return posts.findAll();
    }

    public void addView(Post post, View view) {
        List<View> views = post.getViews();
        views.add(view);
    }
}

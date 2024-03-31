package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Comment;
import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.data.model.View;
import africa.semicolon.gistLover.data.repository.CommentRepository;
import africa.semicolon.gistLover.data.repository.PostRepository;
import africa.semicolon.gistLover.data.repository.UserRepository;
import africa.semicolon.gistLover.data.repository.ViewRepository;
import africa.semicolon.gistLover.dtos.request.CommentRequest;
import africa.semicolon.gistLover.dtos.request.CreatePostRequest;
import africa.semicolon.gistLover.dtos.request.EditPostRequest;
import africa.semicolon.gistLover.dtos.request.ViewRequest;
import africa.semicolon.gistLover.dtos.response.CommentResponse;
import africa.semicolon.gistLover.dtos.response.CreatePostResponse;
import africa.semicolon.gistLover.dtos.response.ViewResponse;
import africa.semicolon.gistLover.exceptions.NonExistingPostException;
import africa.semicolon.gistLover.exceptions.NonExistingUserException;
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
    @Autowired
    CommentRepository comments;

    public CreatePostResponse createPostWith(CreatePostRequest postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setAuthor(users.findUserByUserName(postRequest.getUsername()));
        var newPost = posts.save(post);
        return map(newPost);
    }

    public void deletePost(String title) {
        Optional<Post> post = posts.findByTitle(title);
        Post post1 = posts.findPostByTitle(title);
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
        if(post == null)throw new NonExistingPostException("nonexistent post");
        List<View> viewList = post.getViews();
        viewList.add(view);
        post.setViews(viewList);
        posts.save(post);
        return view;
    }


    public List<Post> findAllPosts() {
        return posts.findAll();
    }

    public CommentResponse commentWith(CommentRequest commentRequest) {
        Comment comment = new Comment();
        var user = users.findUserByUserName(commentRequest.getCommenterName());
        if (user == null)throw new NonExistingUserException("register first");
        comment.setComment(commentRequest.getComment());
        comment.setCommenter(user);
        comments.save(comment);
        comment = addCommentToPost(commentRequest);
         return map(comment);
    }

    private Comment addCommentToPost(CommentRequest commentRequest) {
        Comment comment;
        comment = comments.findByCommenter(users.findUserByUserName(commentRequest.getCommenterName()));
        Post post = posts.findPostByTitle(commentRequest.getTitle());
        if(post == null)throw new NonExistingPostException("nonexistent post");
        List<Comment> commentList = post.getComments();
        commentList.add(comment);
        post.setComments(commentList);
        posts.save(post);
        return comment;
    }


}

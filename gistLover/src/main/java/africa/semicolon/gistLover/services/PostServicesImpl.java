package africa.semicolon.gistLover.services;

import africa.semicolon.gistLover.data.model.Comment;
import africa.semicolon.gistLover.data.model.Post;
import africa.semicolon.gistLover.data.model.View;
import africa.semicolon.gistLover.data.repository.CommentRepository;
import africa.semicolon.gistLover.data.repository.PostRepository;
import africa.semicolon.gistLover.data.repository.UserRepository;
import africa.semicolon.gistLover.data.repository.ViewRepository;
import africa.semicolon.gistLover.dtos.request.*;
import africa.semicolon.gistLover.dtos.response.CommentResponse;
import africa.semicolon.gistLover.dtos.response.CreatePostResponse;
import africa.semicolon.gistLover.dtos.response.ViewResponse;
import africa.semicolon.gistLover.exceptions.IncorrectPasswordException;
import africa.semicolon.gistLover.exceptions.NonExistingPostException;
import africa.semicolon.gistLover.exceptions.NonExistingUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semicolon.gistLover.utils.Mapper.map;

@Service
@RequiredArgsConstructor
public class PostServicesImpl implements PostServices{

    private final PostRepository posts;

    private final UserRepository users;

    private final ViewRepository views;

    private final CommentRepository comments;

    public CreatePostResponse createPostWith(CreatePostRequest postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setAuthor(users.findUserByUserName(postRequest.getUsername()));
        var newPost = posts.save(post);
        return map(newPost);
    }

    public void deletePost(DeletePostRequest deletePostRequest) {
        Post post = posts.findPostByTitle(deletePostRequest.getTitle());
        if (post ==null)throw new NonExistingPostException("nonexistent post");
        var user = users.findUserByUserName(deletePostRequest.getUsername());
        if (!user.getPassword().equalsIgnoreCase(deletePostRequest.getPassword()))
            throw new IncorrectPasswordException("not your post");
        posts.delete(post);
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

    public void deleteComment(DeleteCommentRequest deleteCommentRequest) {
        var user = users.findUserByUserName(deleteCommentRequest.getUserName());
        var post = posts.findPostByTitle(deleteCommentRequest.getTitle());
        Comment comment = comments.findByCommenter(user);
        List<Comment> commentList = post.getComments();
        commentList.remove(comment);
        post.setComments(commentList);
        comments.deleteById(comment.getId());
        posts.save(post);

    }

    private Comment addCommentToPost(CommentRequest commentRequest) {
        Comment comment = comments.findByCommenter(users.findUserByUserName(commentRequest.getCommenterName()));
        Post post = posts.findPostByTitle(commentRequest.getTitle());
        if(post == null)throw new NonExistingPostException("nonexistent post");
        List<Comment> commentList = post.getComments();
        commentList.add(comment);
        post.setComments(commentList);
        posts.save(post);
        return comment;
    }


}

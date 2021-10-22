package org.trustfuse.api_test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    private JsonPLaceHolder jsonPLaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt  = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://170.187.150.59:1337/api/v1/messages/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        Map<String,String> parameters = new HashMap<>();
//        parameters.put("postId","1");
//        parameters.put("_sort","id");
//        parameters.put("_desc","desc");
        jsonPLaceHolder = retrofit.create(JsonPLaceHolder.class);
        Call<List<Reply>> call = jsonPLaceHolder.getPosts("254790670635");
        call.enqueue(new Callback<List<Reply>>() {
            @Override
            public void onResponse(Call<List<Reply>> call, Response<List<Reply>> response) {
              if (!response.isSuccessful()){
                  txt.setText("Unsuccessful");
                  return;
              }
           List<Reply> messages = response.body();
                for (Reply reply : messages){
                    String content = "";
                    content += "Id: " + reply.getId() + "\n";
                    content += "Text: " + reply.getText() + "\n";
                    content += "Source: " + reply.getSource() + "\n";
                    content += "Destination: " + reply.getDestination() + "\n";
                    content += "Date_created: " + reply.getDate_created() + "\n\n";

                    txt.append(content);

                }

            }

            @Override
            public void onFailure(Call<List<Reply>> call, Throwable t) {
                txt.setText(t.getMessage().toString());
            }
        });


//        getPosts();
//        createPost();

    }

//    private void createPost() {
//        Post post = new Post(2,"yoh","trial","sammwangi069@gmail.com");
//        Call<Post> call = jsonPLaceHolder.createPost(post);
//        call.enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//                if (!response.isSuccessful()){
//                    txt.setText("code" + response.code());
//                    return;
//                }
//
//                Post responceB = response.body();
//
//                    String content = "";
//                    content += "Code: " + response.code() + "\n";
//                    content += "Post ID: " + responceB.getPostId() + "\n";
//                    content += "ID: " + responceB.getId() + "\n";
//                    content += "Name: " + responceB.getName() + "\n";
//                    content += "Email: " + responceB.getEmail() + "\n";
//                    content += "Body: " + responceB.getBody() + "\n\n";
//
//                    txt.setText(content);
//
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//                txt.setText(t.getMessage());
//            }
//        });
//    }

    private void getPosts() {

//        Call<List<Post>> call = jsonPLaceHolder.getPosts(para);
//        call.enqueue(new Callback<List<Post>>() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//
//                if (!response.isSuccessful()){
//                    txt.setText("code" + response.code());
//                    return;
//                }
//
//                List<Post> posts = response.body();
//
//                for (Post post : posts){
//                    String content = "";
//                    content += "Post ID: " + post.getPostId() + "\n";
//                    content += "ID: " + post.getId() + "\n";
//                    content += "Name: " + post.getName() + "\n";
//                    content += "Email: " + post.getEmail() + "\n";
//                    content += "Body: " + post.getBody() + "\n\n";
//
//                    txt.append(content);
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                txt.setText(t.getMessage());
//            }
//        });
    }
}
package thanhdnh.ueh.edu.article_app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ViewUserActivity extends AppCompatActivity {

  ImageView iv_detail;
  TextView tv_detail_name;
  TextView tv_detail_bio;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_view_article);

    getSupportActionBar().hide();

    iv_detail =
            findViewById(R.id.iv_detail);

    tv_detail_name =
            findViewById(R.id.tv_detail_title);

    tv_detail_bio =
            findViewById(R.id.tv_detail_description);

    int id =
            (int) getIntent().getLongExtra(
                    "id",
                    0);

    Users user =
            UsersData.getUserFromId(id);

    Picasso.get()
            .load(user.getUrl_profile())
            .resize(400, 500)
            .centerCrop()
            .into(iv_detail);

    tv_detail_name.setText(
            user.getUname());

    tv_detail_bio.setText(
            user.getShort_bio());
  }
}

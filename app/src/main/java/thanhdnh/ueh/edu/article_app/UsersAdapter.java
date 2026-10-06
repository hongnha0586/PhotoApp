package thanhdnh.ueh.edu.article_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UsersAdapter extends BaseAdapter {

  private ArrayList<Users> users_list;
  private Context context;

  public UsersAdapter(ArrayList<Users> users_list, Context context) {
    this.users_list = users_list;
    this.context = context;
  }

  @Override
  public int getCount() {
    return users_list.size();
  }

  @Override
  public Object getItem(int position) {
    return users_list.get(position);
  }

  @Override
  public long getItemId(int position) {
    return users_list.get(position).getId();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    final MyView dataitem;

    LayoutInflater inflater =
            (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

    if (convertView == null) {

      dataitem = new MyView();

      convertView = inflater.inflate(
              R.layout.article_disp_tpl, null);

      dataitem.iv_photo =
              convertView.findViewById(R.id.imv_photo);

      dataitem.tv_caption =
              convertView.findViewById(R.id.tv_title);

      convertView.setTag(dataitem);

    } else {

      dataitem = (MyView) convertView.getTag();
    }

    Picasso.get()
            .load(users_list.get(position).getUrl_profile())
            .resize(300, 400)
            .centerCrop()
            .into(dataitem.iv_photo);

    dataitem.tv_caption.setText(
            users_list.get(position).getUname());

    return convertView;
  }

  private static class MyView {
    ImageView iv_photo;
    TextView tv_caption;
  }
}

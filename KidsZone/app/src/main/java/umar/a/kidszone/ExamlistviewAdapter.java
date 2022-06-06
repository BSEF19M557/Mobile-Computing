package umar.a.kidszone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ExamlistviewAdapter extends BaseAdapter {
    Context context;
    Questions[] questions;
    LayoutInflater layoutInflater;

    public ExamlistviewAdapter(Context context,Questions[] questions){
        this.context=context;
        this.questions=questions;
        layoutInflater =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return questions.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.myquestionlist,null);
        ImageView imageView=convertView.findViewById(R.id.quesionsimageView);
        RadioButton opt1=convertView.findViewById(R.id.radio1);
        RadioButton opt2=convertView.findViewById(R.id.radio2);
        RadioButton opt3=convertView.findViewById(R.id.radio3);

        imageView.setImageResource(questions[position].question);
        opt1.setText(questions[position].opt1);
        opt2.setText(questions[position].opt2);
        opt3.setText(questions[position].opt3);
        return convertView;
    }
}

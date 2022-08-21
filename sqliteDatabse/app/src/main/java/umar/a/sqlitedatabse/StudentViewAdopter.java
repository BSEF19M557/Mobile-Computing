package umar.a.sqlitedatabse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentViewAdopter extends ArrayAdapter<Student> {

    public StudentViewAdopter(@NonNull Context context, ArrayList<Student> studentArray) {
        super(context,0, studentArray);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View currentItemView= convertView;

            currentItemView= LayoutInflater.from(getContext()).inflate(R.layout.mylistview,parent,false);

        Student currentStudent=getItem(position);

        TextView textView1=currentItemView.findViewById(R.id.SName);
        textView1.setText(currentStudent.getName());

        TextView textView2=currentItemView.findViewById(R.id.SRoll);
        textView2.setText(String.valueOf(currentStudent.getRollNmber()));

        TextView textView3=currentItemView.findViewById(R.id.SEnroll);
        textView3.setText(""+currentStudent.isEnroll());

        return currentItemView;
    }

}

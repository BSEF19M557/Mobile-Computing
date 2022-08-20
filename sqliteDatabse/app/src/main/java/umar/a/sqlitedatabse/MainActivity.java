package umar.a.sqlitedatabse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonViewAll;
    EditText editName, editRollNumber;
    Switch switchIsActive;
    ListView listViewStudent;
    List<Student> list;
    ArrayAdapter arrayAdapter;
    String UpdateName;
    int updateRollNumber;
    boolean UpdateEnroll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.AddButton);
        buttonViewAll=findViewById(R.id.allShowButton);
        editName = findViewById(R.id.StudentName);
        editRollNumber = findViewById(R.id.StudentRoll);
        switchIsActive = findViewById(R.id.IsEnrolled);
        listViewStudent = findViewById(R.id.studentList);




        buttonAdd.setOnClickListener(new View.OnClickListener() {
            Student studentModel;

            @Override
            public void onClick(View v) {
                try {
                    studentModel = new Student(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                    //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DBHandler dbHelper  = new DBHandler(MainActivity.this);
                dbHelper.addStudent(studentModel);
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler dbHelper = new DBHandler(MainActivity.this);
                list = dbHelper.getAllStudents();
                arrayAdapter = new ArrayAdapter<Student>
                        (MainActivity.this, android.R.layout.simple_list_item_1,list);
                listViewStudent.setAdapter(arrayAdapter);

            }
        });

        listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DBHandler dbHelper = new DBHandler(MainActivity.this);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Record Modifications")
                        .setMessage("Do you want to delete or Update this Student!")
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("Delete Record")
                                        .setCancelable(false)
                                        .setMessage("Do you really want to delete this Student named "+list.get(position).getName())
                                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dbHelper.deleteStudent(list.get(position));
                                                list.remove(position);
                                                arrayAdapter.notifyDataSetChanged();
                                            }                })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }                })
                                        .show();



                            }                })
                        .setNegativeButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlertDialog.Builder mydilog=new AlertDialog.Builder(MainActivity.this);
                                mydilog.setTitle("Update Record");

                                final  EditText nameUpdate=new EditText(MainActivity.this);

                                mydilog.setMessage("Enter Name to update");
                                mydilog.setView(nameUpdate);



                                mydilog.setPositiveButton("next", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                         UpdateName = nameUpdate.getText().toString();

                                         list.get(position).setName(UpdateName);

                                         ///rollNumber AlertBox

                                        AlertDialog.Builder mydilog=new AlertDialog.Builder(MainActivity.this);
                                        mydilog.setTitle("Update Record");

                                        final EditText rollNumber=new EditText(MainActivity.this);

                                        rollNumber.setInputType(InputType.TYPE_CLASS_NUMBER);

                                        mydilog.setMessage("Enter Roll Number to update");
                                        mydilog.setView(rollNumber);


                                        mydilog.setPositiveButton("next", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                updateRollNumber =Integer.parseInt(rollNumber.getText().toString());


                                                list.get(position).setRollNmber(updateRollNumber);

                                                ///Enrolled AlertBox
                                                AlertDialog.Builder mydilog=new AlertDialog.Builder(MainActivity.this);
                                                mydilog.setTitle("Update Record");

                                                final Switch Isenroll=new Switch(MainActivity.this);


                                                mydilog.setMessage("Enrolled or not ?");
                                                mydilog.setView(Isenroll);


                                                mydilog.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        UpdateEnroll =Boolean.parseBoolean(Isenroll.getText().toString());

                                                        list.get(position).setEnroll(UpdateEnroll);

                                                        ///
                                                        dbHelper.updateStudent(list.get(position));

                                                        ///



                                                    }
                                                });
                                                mydilog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                });
                                                mydilog.show();


                                                ///Enrolled AlertBox



                                            }
                                        });
                                        mydilog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });
                                        mydilog.show();



                                        ///rollNumber AlertBox



                                    }
                                });
                                mydilog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                mydilog.show();


                            }                })
                        .show();

            }
        });

    }




}
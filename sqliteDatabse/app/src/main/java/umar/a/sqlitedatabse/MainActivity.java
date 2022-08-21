package umar.a.sqlitedatabse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonViewAll;
    EditText editName, editRollNumber;
    Switch switchIsActive;
    ListView listViewStudent;
    ArrayList<Student> list;
    StudentViewAdopter StudentarrayAdapter;
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
                if(!(TextUtils.isEmpty(editName.getText().toString()) || TextUtils.isEmpty(editRollNumber.getText()))) {
                    try {
                        studentModel = new Student(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                        //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                    DBHandler dbHelper = new DBHandler(MainActivity.this);
                    dbHelper.addStudent(studentModel);
                    editName.getText().clear();
                    editRollNumber.getText().clear();
                    switchIsActive.setChecked(false);
                }
                else {
                    Toast.makeText(MainActivity.this, "Fields Can't be Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler dbHelper = new DBHandler(MainActivity.this);
                list = dbHelper.getAllStudents();
                StudentarrayAdapter = new StudentViewAdopter(MainActivity.this,list);

                listViewStudent.setAdapter(StudentarrayAdapter);

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
                                                StudentarrayAdapter.notifyDataSetChanged();
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
                                                if(!TextUtils.isEmpty(rollNumber.getText().toString())) {
                                                    updateRollNumber = Integer.parseInt(rollNumber.getText().toString());
                                                }



                                                ///Enrolled AlertBox
                                                AlertDialog.Builder mydilog=new AlertDialog.Builder(MainActivity.this);
                                                mydilog.setTitle("Update Record");

                                                final Switch Isenroll=new Switch(MainActivity.this);


                                                mydilog.setMessage("Enrolled or not ?");
                                                mydilog.setView(Isenroll);


                                                mydilog.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        UpdateEnroll =Isenroll.isChecked();



                                                        ///
                                                        if(!(TextUtils.isEmpty(nameUpdate.getText().toString()) || TextUtils.isEmpty(rollNumber.getText().toString()))) {
                                                            list.get(position).setName(UpdateName);
                                                            list.get(position).setRollNmber(updateRollNumber);
                                                            list.get(position).setEnroll(UpdateEnroll);

                                                            dbHelper.updateStudent(list.get(position));
                                                        }
                                                        else {
                                                            Toast.makeText(MainActivity.this, "Can't Update Some Fields are empty", Toast.LENGTH_SHORT).show();
                                                        }



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
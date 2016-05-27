package info.krushik.android.myapplication7;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DataBaseHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper = new DataBaseHelper(this); //объявляем наш DataBaseHelper
    }

    public void OnClick(View v) {

        switch (v.getId()) {
            case R.id.button://вставка
////                ContentValues cvNewGroup = new ContentValues();
////                cvNewGroup.put("Number", "1");
////
////                long groupId = db.insert("Groups", null, cvNewGroup);
//
//                ContentValues cvNewStudent = new ContentValues();//создаем новую строку в таблице
////                cvNewStudent.put("idGroup", groupId);
//                cvNewStudent.put("FirstName", "Ivan");//наполняем ее
//                cvNewStudent.put("LastName", "Ivanov");
//                cvNewStudent.put("Age", 20);

//                long id = db.insert("Students", null, cvNewStudent);//ложим наполнение в таблицу(создание и наполнение БД произойдет в момент вызова метода .insert)
                long id = DBHelper.insertStudent(new Student("Ivan", "Ivanov", 22));
                Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();//вывод IDшника строки в таблице
                break;
            case R.id.button2://обновление
//                ContentValues cvUpdStudent = new ContentValues();
////                cvUpdStudent.put("FirstName", "Petro");
////                cvUpdStudent.put("LastName", "Petrov");
//                cvUpdStudent.put("Age", 30);//то что будет обновлятся
//                //обновление принимает("название таблички", ContentValues, "условие", условие'масив')
//                int count = db.update("Students", cvUpdStudent, "_id  > 10", null);//метод .update возвращает int количество записей кот. обновились
                Student student = new Student("AAA", "BBB", 44);
                student.id = 1;
                boolean count = DBHelper.updateStudent(student);
                Toast.makeText(this, String.valueOf(count), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3://чтение всех студентов
//                Cursor studentsCursor = null;
//                ArrayList<Student> students = new ArrayList<Student>();
//
//                try {
//                    studentsCursor = db.query("Students", null, null, null, null, null, null);
//
//                    studentsCursor.moveToFirst();
//                    while (!studentsCursor.isAfterLast()) {//проверяем что в этом Cursor'е есть записи
//                        Student student = new Student();
//
//                        student.id = studentsCursor.getLong(studentsCursor.getColumnIndex("_id"));
//                        student.idGroup = studentsCursor.getLong(studentsCursor.getColumnIndex("idGroup"));
//                        student.FirstName = studentsCursor.getString(studentsCursor.getColumnIndex("FirstName"));
//                        student.LastName = studentsCursor.getString(studentsCursor.getColumnIndex("LastName"));
//                        student.Age = studentsCursor.getLong(studentsCursor.getColumnIndex("Age"));
//
//                        students.add(student);
//                        studentsCursor.moveToNext();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    if (studentsCursor != null) {
//                        studentsCursor.close();
//                    }
//                }
                break;
            case R.id.button4://чтение одного студента (всегда возвращает Cursor)
//                Cursor studentCursor = null;
//                Student student = null;
//                try {
//                    studentCursor = db.query("Students", new String[]{"_id", "idGroup", "Name", "Age"}, "_id=1", null, null, null, null);//.query - запрос
//
//                    if (studentCursor.moveToFirst()) {//while не нужен потому что ищем по конкретному id
//                        student = new Student();
//
//                        student.id = studentCursor.getLong(studentCursor.getColumnIndex("_id"));
//                        student.idGroup = studentCursor.getLong(studentCursor.getColumnIndex("idGroup"));
//                        student.FirstName = studentCursor.getString(studentCursor.getColumnIndex("FirstName"));
//                        student.LastName = studentCursor.getString(studentCursor.getColumnIndex("LastName"));
//                        student.Age = studentCursor.getLong(studentCursor.getColumnIndex("Age"));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    if (studentCursor != null) {
//                        studentCursor.close();
//                    }
//                }
                break;
            case R.id.button5:
//                db.delete("Students", "_id=1", null);
                break;
            case R.id.button6:
//                Cursor joinCursor = null;
//                ArrayList<Student> students2 = new ArrayList<Student>();
//
//                try {
//                    String tables = "Groups as g inner join Students as s on g._id = s.idGroup";
//                    String columns[] = { "s._id", "s.FirstName", "s.LastName", "s.Age" };
//                    String where = "g.Number = '1'";
//                    String orderBy = "s.FirstName";
//
//                    joinCursor = db.query(tables, columns, where, null, null, null, orderBy, null);
//
//                    joinCursor.moveToFirst();
//                    while (!joinCursor.isAfterLast()) {
//                        Student student1 = new Student();
//
//                        student1.id = joinCursor.getLong(joinCursor.getColumnIndex("_id"));
//                        student1.FirstName = joinCursor.getString(joinCursor.getColumnIndex("FirstName"));
//                        student1.LastName = joinCursor.getString(joinCursor.getColumnIndex("LastName"));
//                        student1.Age = joinCursor.getLong(joinCursor.getColumnIndex("Age"));
//
//                        students2.add(student1);
//                        joinCursor.moveToNext();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    if (joinCursor != null) {
//                        joinCursor.close();
//                    }
//                }
                break;
            case R.id.button7:
//                Intent intent = new Intent(this, Activity2.class);
//                startActivity(intent);
                break;
            case R.id.button8://чтение количества (всегда возвращает Cursor)
//                Cursor cursor = db.query("Students", null, null, null, null, null, null);
//                if (cursor.moveToFirst()) {// проверяем что в этом курсоре есть записи? хоть одна
//                    while (!cursor.isAfterLast()){
//                        String firstName = cursor.getString(cursor.getColumnIndex("FirstName"));
//                        Toast.makeText(this, firstName, Toast.LENGTH_SHORT).show();
//
//                        cursor.moveToNext();
//                    }
//                }
//                cursor.close();//Cursor'ы нужно обязательно закрывать
                ArrayList<Student> students = DBHelper.getStudents();
                Toast.makeText(this, String.format("Students: %s",students.size()), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button9://чтение 1го студента по id (всегда возвращает Cursor)
//                Cursor cursor9 = db.query("Students", null, "_id=1", null, null, null, null);
//                if (cursor9.moveToFirst()) {// проверяем что в этом курсоре есть записи? хоть одна
//                    String firstName = cursor9.getString(cursor9.getColumnIndex("FirstName"));
//                    Toast.makeText(this, firstName, Toast.LENGTH_SHORT).show();
//                }
//                cursor9.close();//Cursor'ы нужно обязательно закрывать
                Student student1 = DBHelper.getStudent(1);
                Toast.makeText(this, student1.FirstName, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

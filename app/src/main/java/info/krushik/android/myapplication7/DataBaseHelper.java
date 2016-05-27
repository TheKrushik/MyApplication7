package info.krushik.android.myapplication7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {//класс помошник по работе с БД

    public DataBaseHelper(Context context) {//Конструктор
        super(context, "MyDB.db", null, 1);//Создание БД(контекст, название БД, ... , версия БД)
    }

    public long insertStudent(Student student){//вставка
        long id = 0;
        SQLiteDatabase db = getWritableDatabase();

        try{
            ContentValues values = new ContentValues();

            values.put(Student.COLUMN_FIRST_NAME, student.FirstName);
            values.put(Student.COLUMN_LAST_NAME, student.LastName);
            values.put(Student.COLUMN_AGE, student.Age);

            id = db.insert(Student.TABLE_NAME, null, values);
        }catch (Exception e){
            e.printStackTrace();
        }

        return id;
    }

    public boolean updateStudent(Student student){//обновление
        int count = 0;
        SQLiteDatabase db = getWritableDatabase();

        try{
            ContentValues values = new ContentValues();

            values.put(Student.COLUMN_FIRST_NAME, student.FirstName);
            values.put(Student.COLUMN_LAST_NAME, student.LastName);
            values.put(Student.COLUMN_AGE, student.Age);
                                                        //update'тим id'шку которая к нам пришла
            count = db.update(Student.TABLE_NAME, values, Student.COLUMN_ID + "=" +student.id, null);
        }catch (Exception e){
            e.printStackTrace();
        }

        return count > 0;
    }

    public boolean deleteStudent(long id){//удаление
        int count = 0;
        SQLiteDatabase db = getWritableDatabase();

        try{
            count = db.delete(Student.TABLE_NAME, Student.COLUMN_ID + "=" + id, null);
        }catch (Exception e){
            e.printStackTrace();
        }

        return count > 0;
    }

    public ArrayList<Student> getStudents(){//чтение всех студентов
        ArrayList<Student> students = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.query(Student.TABLE_NAME, null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()){
                    Student student = new Student();

                    student.id = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_ID));
                    student.FirstName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_FIRST_NAME));
                    student.LastName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_LAST_NAME));
                    student.Age = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_AGE));

                    students.add(student);//добавляем нашего студента в массив students
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return  students;
    }

    public Student getStudent(long id){//чтение одного студента
        Student student = null;

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.query(Student.TABLE_NAME, null, Student.COLUMN_ID+ "=" + id, null, null, null, null);
            if (cursor.moveToFirst()) {
                    student = new Student();

                    student.id = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_ID));
                    student.FirstName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_FIRST_NAME));
                    student.LastName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_LAST_NAME));
                    student.Age = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_AGE));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return  student;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {//вызывается 1 раз при создании базы
        //Создание таблиц
//        db.execSQL("create table Groups ("
//                + "_id integer primary key autoincrement,"
//                + "Number integer not null);");

        db.execSQL("CREATE TABLE " + Student.TABLE_NAME + " ("
                + Student.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + "idGroup integer not null,"
                + Student.COLUMN_FIRST_NAME + " TEXT NOT NULL,"
                + Student.COLUMN_LAST_NAME + " TEXT NOT NULL,"
                + Student.COLUMN_AGE + " INTEGER NOT NULL);");
//                + "FOREIGN KEY(idGroup) REFERENCES Groups(id));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//Обновление БД(вызывается если отличается версия БД)

//        while (oldVersion < newVersion) {
//            switch (oldVersion) {
//                case 1:
//                    db.execSQL("PRAGMA foreign_keys=OFF;");
//
//                    db.execSQL("ALTER TABLE Students RENAME TO Students_old;");
//
//                    db.execSQL("create table Students ("
//                            + "id integer primary key autoincrement,"
//                            + "idGroup integer not null,"
//                            + "FirstName integer not null,"
//                            + "LastName integer not null,"
//                            + "Age integer not null,"
//                            + "Address text null,"
//                            + "FOREIGN KEY(idGroup) REFERENCES Groups(id));");
//
//                    db.execSQL("INSERT INTO Students(id, idGroup, FirstName, LastName) SELECT "
//                            + "id, idGroup, FirstName, LastName FROM Students_old;");
//
//                    db.execSQL("DROP TABLE Students_old;");
//
//                    db.execSQL("PRAGMA foreign_keys=ON;");
//                    break;
//            }
//
//            oldVersion++;
//        }
    }
}

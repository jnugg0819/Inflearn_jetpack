package org.techtown.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Todo.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract TodoDao todoDao();


}

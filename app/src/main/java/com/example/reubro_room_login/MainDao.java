package com.example.reubro_room_login;


import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDao {

    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);


    @Delete
    void reset(List<MainData> mainData);

    @Query("UPDATE table_name SET name = :sName, country= :sCountry, phno= :sPhno, password= :sPass  Where ID = :sID")
    void update(int sID, String sName,String sCountry,String sPhno, String sPass);

    @Query("SELECT * FROM table_name Where email = :sEmail and password= :sPass")
    List<MainData> login(String sEmail,String sPass);

}

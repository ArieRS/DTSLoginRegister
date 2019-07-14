package polinema.ac.id.dtsapp.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import polinema.ac.id.dtsapp.db.entities.User;

@Dao
public interface UserDao {
    @Query("Select * from User")
    List<User> allUser();

    @Query("Select * from User where username = :userName And  password = :password")
    User getUser(String userName,  String password);

    @Insert
    void insertAll(User... user);

    @Delete
    void delete(User user);
}

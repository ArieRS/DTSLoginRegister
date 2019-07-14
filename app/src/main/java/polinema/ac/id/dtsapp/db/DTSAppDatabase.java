package polinema.ac.id.dtsapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import polinema.ac.id.dtsapp.db.dao.UserDao;
import polinema.ac.id.dtsapp.db.entities.User;

@Database(entities = {User.class},version = 2)
public abstract class DTSAppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    private static final String DATABASE_NAME = "DtsDatabase";

    static DTSAppDatabase db;
    public static DTSAppDatabase getInstance(Context context)
    {
        db = Room.databaseBuilder(
                context,
                DTSAppDatabase.class,
                "DATABASE_NAME").build();
        return  db;
    }

    public  void insertUser(User mUser){
        new InsertUser().execute(mUser);
    }
    public  void getAllUser(){
        new GetUser().execute();
    }
    public  User getUserByUsername(String username, String password)  {
        try {
            return new GetUserByUsername().execute(username+" "+password).get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class InsertUser extends AsyncTask<User, Void, Void>{

        @Override
        protected Void doInBackground(User... users) {
            db.userDao().insertAll(users);
            return null;
        }
    }
    public static class GetUser extends AsyncTask<Void, Void, List<User>>{
        @Override
        protected List<User> doInBackground(Void... voids) {
            List<User> listUser =  db.userDao().allUser();
            return listUser;
        }
    }

    public static class GetUserByUsername extends AsyncTask<String, Void, User>{

        @Override
        protected User doInBackground(String... strings) {
            String[] param = strings[0].toString().split(" ");
            User mUser = db.userDao().getUser(param[0],param[1]);
            return mUser;
        }
    }

}

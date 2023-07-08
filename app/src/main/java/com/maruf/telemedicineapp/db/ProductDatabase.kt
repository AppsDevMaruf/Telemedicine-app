package com.maruf.telemedicineapp.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.maruf.telemedicineapp.data.local.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun itemDao(): ProductDao

    companion object {
        private var INSTANCE: ProductDatabase? = null

        fun getInstance(context: Context): ProductDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    ProductDatabase::class.java,
                    "pm_database"
                ).build()
                return INSTANCE as ProductDatabase
            }else{
                return INSTANCE as ProductDatabase
            }
        }
    }
}
/*@Provides
@Singleton
fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
    return Room.databaseBuilder(
        appContext,
        AppDatabase::class.java,
        "RssReader"
    ).build()
}*/
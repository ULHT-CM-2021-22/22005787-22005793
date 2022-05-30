package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import java.lang.System;

@androidx.room.Database(entities = {pt.ulusofona.deisi.cm2122.g22005787_22005793.FireRoom.class}, version = 1)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireDatabase;", "Landroidx/room/RoomDatabase;", "()V", "fireDao", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireDao;", "Companion", "app_debug"})
public abstract class FireDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final pt.ulusofona.deisi.cm2122.g22005787_22005793.FireDatabase.Companion Companion = null;
    private static pt.ulusofona.deisi.cm2122.g22005787_22005793.FireDatabase instance;
    
    public FireDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract pt.ulusofona.deisi.cm2122.g22005787_22005793.FireDao fireDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireDatabase$Companion;", "", "()V", "instance", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireDatabase;", "getInstance", "applicationContext", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final pt.ulusofona.deisi.cm2122.g22005787_22005793.FireDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context applicationContext) {
            return null;
        }
    }
}
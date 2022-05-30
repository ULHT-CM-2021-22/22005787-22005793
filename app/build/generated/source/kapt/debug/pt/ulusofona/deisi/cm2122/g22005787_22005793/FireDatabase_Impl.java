package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FireDatabase_Impl extends FireDatabase {
  private volatile FireDao _fireDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `fires` (`id` TEXT NOT NULL, `distrito` TEXT, `concelho` TEXT, `freguesia` TEXT, `meiosOperacionais` TEXT, `meiosVeiculos` TEXT, `meiosAereos` TEXT, `estado` TEXT, `data` TEXT, `fotos` TEXT, `obs` TEXT, `nomePessoa` TEXT, `ccPessoa` TEXT, `porConfirmar` INTEGER, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '826c041a3577578ef5d521dd10f3499e')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `fires`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsFires = new HashMap<String, TableInfo.Column>(14);
        _columnsFires.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("distrito", new TableInfo.Column("distrito", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("concelho", new TableInfo.Column("concelho", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("freguesia", new TableInfo.Column("freguesia", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("meiosOperacionais", new TableInfo.Column("meiosOperacionais", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("meiosVeiculos", new TableInfo.Column("meiosVeiculos", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("meiosAereos", new TableInfo.Column("meiosAereos", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("estado", new TableInfo.Column("estado", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("data", new TableInfo.Column("data", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("fotos", new TableInfo.Column("fotos", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("obs", new TableInfo.Column("obs", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("nomePessoa", new TableInfo.Column("nomePessoa", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("ccPessoa", new TableInfo.Column("ccPessoa", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFires.put("porConfirmar", new TableInfo.Column("porConfirmar", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFires = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFires = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFires = new TableInfo("fires", _columnsFires, _foreignKeysFires, _indicesFires);
        final TableInfo _existingFires = TableInfo.read(_db, "fires");
        if (! _infoFires.equals(_existingFires)) {
          return new RoomOpenHelper.ValidationResult(false, "fires(pt.ulusofona.deisi.cm2122.g22005787_22005793.FireRoom).\n"
                  + " Expected:\n" + _infoFires + "\n"
                  + " Found:\n" + _existingFires);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "826c041a3577578ef5d521dd10f3499e", "76b8df2fc5b122da27819d310f1f09fa");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "fires");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `fires`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(FireDao.class, FireDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public FireDao fireDao() {
    if (_fireDao != null) {
      return _fireDao;
    } else {
      synchronized(this) {
        if(_fireDao == null) {
          _fireDao = new FireDao_Impl(this);
        }
        return _fireDao;
      }
    }
  }
}

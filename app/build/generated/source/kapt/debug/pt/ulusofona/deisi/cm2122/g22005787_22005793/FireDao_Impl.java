package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FireDao_Impl implements FireDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FireRoom> __insertionAdapterOfFireRoom;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public FireDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFireRoom = new EntityInsertionAdapter<FireRoom>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `fires` (`id`,`distrito`,`concelho`,`freguesia`,`meiosOperacionais`,`meiosVeiculos`,`meiosAereos`,`estado`,`data`,`fotos`,`obs`,`nomePessoa`,`ccPessoa`,`porConfirmar`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FireRoom value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getDistrito() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDistrito());
        }
        if (value.getConcelho() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getConcelho());
        }
        if (value.getFreguesia() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFreguesia());
        }
        if (value.getMeiosOperacionais() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMeiosOperacionais());
        }
        if (value.getMeiosVeiculos() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMeiosVeiculos());
        }
        if (value.getMeiosAereos() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMeiosAereos());
        }
        if (value.getEstado() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEstado());
        }
        if (value.getData() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getData());
        }
        if (value.getFotos() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getFotos());
        }
        if (value.getObs() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getObs());
        }
        if (value.getNomePessoa() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getNomePessoa());
        }
        if (value.getCcPessoa() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCcPessoa());
        }
        final Integer _tmp = value.getPorConfirmar() == null ? null : (value.getPorConfirmar() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, _tmp);
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM fires WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM fires WHERE porConfirmar == 0";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final FireRoom fire, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFireRoom.insert(fire);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insertAll(final List<FireRoom> operations,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFireRoom.insert(operations);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final String id, final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
        int _argIndex = 1;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        __db.beginTransaction();
        try {
          final java.lang.Integer _result = _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDelete.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getAll(final Continuation<? super List<FireRoom>> continuation) {
    final String _sql = "SELECT * FROM fires ORDER BY data ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<FireRoom>>() {
      @Override
      public List<FireRoom> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDistrito = CursorUtil.getColumnIndexOrThrow(_cursor, "distrito");
          final int _cursorIndexOfConcelho = CursorUtil.getColumnIndexOrThrow(_cursor, "concelho");
          final int _cursorIndexOfFreguesia = CursorUtil.getColumnIndexOrThrow(_cursor, "freguesia");
          final int _cursorIndexOfMeiosOperacionais = CursorUtil.getColumnIndexOrThrow(_cursor, "meiosOperacionais");
          final int _cursorIndexOfMeiosVeiculos = CursorUtil.getColumnIndexOrThrow(_cursor, "meiosVeiculos");
          final int _cursorIndexOfMeiosAereos = CursorUtil.getColumnIndexOrThrow(_cursor, "meiosAereos");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfFotos = CursorUtil.getColumnIndexOrThrow(_cursor, "fotos");
          final int _cursorIndexOfObs = CursorUtil.getColumnIndexOrThrow(_cursor, "obs");
          final int _cursorIndexOfNomePessoa = CursorUtil.getColumnIndexOrThrow(_cursor, "nomePessoa");
          final int _cursorIndexOfCcPessoa = CursorUtil.getColumnIndexOrThrow(_cursor, "ccPessoa");
          final int _cursorIndexOfPorConfirmar = CursorUtil.getColumnIndexOrThrow(_cursor, "porConfirmar");
          final List<FireRoom> _result = new ArrayList<FireRoom>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FireRoom _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpDistrito;
            if (_cursor.isNull(_cursorIndexOfDistrito)) {
              _tmpDistrito = null;
            } else {
              _tmpDistrito = _cursor.getString(_cursorIndexOfDistrito);
            }
            final String _tmpConcelho;
            if (_cursor.isNull(_cursorIndexOfConcelho)) {
              _tmpConcelho = null;
            } else {
              _tmpConcelho = _cursor.getString(_cursorIndexOfConcelho);
            }
            final String _tmpFreguesia;
            if (_cursor.isNull(_cursorIndexOfFreguesia)) {
              _tmpFreguesia = null;
            } else {
              _tmpFreguesia = _cursor.getString(_cursorIndexOfFreguesia);
            }
            final String _tmpMeiosOperacionais;
            if (_cursor.isNull(_cursorIndexOfMeiosOperacionais)) {
              _tmpMeiosOperacionais = null;
            } else {
              _tmpMeiosOperacionais = _cursor.getString(_cursorIndexOfMeiosOperacionais);
            }
            final String _tmpMeiosVeiculos;
            if (_cursor.isNull(_cursorIndexOfMeiosVeiculos)) {
              _tmpMeiosVeiculos = null;
            } else {
              _tmpMeiosVeiculos = _cursor.getString(_cursorIndexOfMeiosVeiculos);
            }
            final String _tmpMeiosAereos;
            if (_cursor.isNull(_cursorIndexOfMeiosAereos)) {
              _tmpMeiosAereos = null;
            } else {
              _tmpMeiosAereos = _cursor.getString(_cursorIndexOfMeiosAereos);
            }
            final String _tmpEstado;
            if (_cursor.isNull(_cursorIndexOfEstado)) {
              _tmpEstado = null;
            } else {
              _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
            }
            final String _tmpData;
            if (_cursor.isNull(_cursorIndexOfData)) {
              _tmpData = null;
            } else {
              _tmpData = _cursor.getString(_cursorIndexOfData);
            }
            final String _tmpFotos;
            if (_cursor.isNull(_cursorIndexOfFotos)) {
              _tmpFotos = null;
            } else {
              _tmpFotos = _cursor.getString(_cursorIndexOfFotos);
            }
            final String _tmpObs;
            if (_cursor.isNull(_cursorIndexOfObs)) {
              _tmpObs = null;
            } else {
              _tmpObs = _cursor.getString(_cursorIndexOfObs);
            }
            final String _tmpNomePessoa;
            if (_cursor.isNull(_cursorIndexOfNomePessoa)) {
              _tmpNomePessoa = null;
            } else {
              _tmpNomePessoa = _cursor.getString(_cursorIndexOfNomePessoa);
            }
            final String _tmpCcPessoa;
            if (_cursor.isNull(_cursorIndexOfCcPessoa)) {
              _tmpCcPessoa = null;
            } else {
              _tmpCcPessoa = _cursor.getString(_cursorIndexOfCcPessoa);
            }
            final Boolean _tmpPorConfirmar;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfPorConfirmar)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfPorConfirmar);
            }
            _tmpPorConfirmar = _tmp == null ? null : _tmp != 0;
            _item = new FireRoom(_tmpId,_tmpDistrito,_tmpConcelho,_tmpFreguesia,_tmpMeiosOperacionais,_tmpMeiosVeiculos,_tmpMeiosAereos,_tmpEstado,_tmpData,_tmpFotos,_tmpObs,_tmpNomePessoa,_tmpCcPessoa,_tmpPorConfirmar);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getById(final String id, final Continuation<? super FireRoom> continuation) {
    final String _sql = "SELECT * FROM fires WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<FireRoom>() {
      @Override
      public FireRoom call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDistrito = CursorUtil.getColumnIndexOrThrow(_cursor, "distrito");
          final int _cursorIndexOfConcelho = CursorUtil.getColumnIndexOrThrow(_cursor, "concelho");
          final int _cursorIndexOfFreguesia = CursorUtil.getColumnIndexOrThrow(_cursor, "freguesia");
          final int _cursorIndexOfMeiosOperacionais = CursorUtil.getColumnIndexOrThrow(_cursor, "meiosOperacionais");
          final int _cursorIndexOfMeiosVeiculos = CursorUtil.getColumnIndexOrThrow(_cursor, "meiosVeiculos");
          final int _cursorIndexOfMeiosAereos = CursorUtil.getColumnIndexOrThrow(_cursor, "meiosAereos");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final int _cursorIndexOfFotos = CursorUtil.getColumnIndexOrThrow(_cursor, "fotos");
          final int _cursorIndexOfObs = CursorUtil.getColumnIndexOrThrow(_cursor, "obs");
          final int _cursorIndexOfNomePessoa = CursorUtil.getColumnIndexOrThrow(_cursor, "nomePessoa");
          final int _cursorIndexOfCcPessoa = CursorUtil.getColumnIndexOrThrow(_cursor, "ccPessoa");
          final int _cursorIndexOfPorConfirmar = CursorUtil.getColumnIndexOrThrow(_cursor, "porConfirmar");
          final FireRoom _result;
          if(_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpDistrito;
            if (_cursor.isNull(_cursorIndexOfDistrito)) {
              _tmpDistrito = null;
            } else {
              _tmpDistrito = _cursor.getString(_cursorIndexOfDistrito);
            }
            final String _tmpConcelho;
            if (_cursor.isNull(_cursorIndexOfConcelho)) {
              _tmpConcelho = null;
            } else {
              _tmpConcelho = _cursor.getString(_cursorIndexOfConcelho);
            }
            final String _tmpFreguesia;
            if (_cursor.isNull(_cursorIndexOfFreguesia)) {
              _tmpFreguesia = null;
            } else {
              _tmpFreguesia = _cursor.getString(_cursorIndexOfFreguesia);
            }
            final String _tmpMeiosOperacionais;
            if (_cursor.isNull(_cursorIndexOfMeiosOperacionais)) {
              _tmpMeiosOperacionais = null;
            } else {
              _tmpMeiosOperacionais = _cursor.getString(_cursorIndexOfMeiosOperacionais);
            }
            final String _tmpMeiosVeiculos;
            if (_cursor.isNull(_cursorIndexOfMeiosVeiculos)) {
              _tmpMeiosVeiculos = null;
            } else {
              _tmpMeiosVeiculos = _cursor.getString(_cursorIndexOfMeiosVeiculos);
            }
            final String _tmpMeiosAereos;
            if (_cursor.isNull(_cursorIndexOfMeiosAereos)) {
              _tmpMeiosAereos = null;
            } else {
              _tmpMeiosAereos = _cursor.getString(_cursorIndexOfMeiosAereos);
            }
            final String _tmpEstado;
            if (_cursor.isNull(_cursorIndexOfEstado)) {
              _tmpEstado = null;
            } else {
              _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
            }
            final String _tmpData;
            if (_cursor.isNull(_cursorIndexOfData)) {
              _tmpData = null;
            } else {
              _tmpData = _cursor.getString(_cursorIndexOfData);
            }
            final String _tmpFotos;
            if (_cursor.isNull(_cursorIndexOfFotos)) {
              _tmpFotos = null;
            } else {
              _tmpFotos = _cursor.getString(_cursorIndexOfFotos);
            }
            final String _tmpObs;
            if (_cursor.isNull(_cursorIndexOfObs)) {
              _tmpObs = null;
            } else {
              _tmpObs = _cursor.getString(_cursorIndexOfObs);
            }
            final String _tmpNomePessoa;
            if (_cursor.isNull(_cursorIndexOfNomePessoa)) {
              _tmpNomePessoa = null;
            } else {
              _tmpNomePessoa = _cursor.getString(_cursorIndexOfNomePessoa);
            }
            final String _tmpCcPessoa;
            if (_cursor.isNull(_cursorIndexOfCcPessoa)) {
              _tmpCcPessoa = null;
            } else {
              _tmpCcPessoa = _cursor.getString(_cursorIndexOfCcPessoa);
            }
            final Boolean _tmpPorConfirmar;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfPorConfirmar)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfPorConfirmar);
            }
            _tmpPorConfirmar = _tmp == null ? null : _tmp != 0;
            _result = new FireRoom(_tmpId,_tmpDistrito,_tmpConcelho,_tmpFreguesia,_tmpMeiosOperacionais,_tmpMeiosVeiculos,_tmpMeiosAereos,_tmpEstado,_tmpData,_tmpFotos,_tmpObs,_tmpNomePessoa,_tmpCcPessoa,_tmpPorConfirmar);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

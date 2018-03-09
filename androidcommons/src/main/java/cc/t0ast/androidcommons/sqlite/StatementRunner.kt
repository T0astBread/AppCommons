package cc.t0ast.androidcommons.sqlite

import android.database.sqlite.SQLiteDatabase
import android.util.Log
import cc.t0ast.appcommons.io.IOUtils
import java.io.InputStream
import java.util.regex.Pattern


/**
 * Created by T0astBread on 05.03.2018.
 */
class StatementRunner {

    companion object {
        fun runStmts(source: InputStream, db: SQLiteDatabase) {
            val stmts = IOUtils.readWholeStream(source)
            stmts.split(Pattern.compile(";\\s*$", Pattern.MULTILINE))
                    .filter { stmt -> !stmt.isBlank() }
                    .forEach { stmt ->
                        Log.v("aaah ", stmt)
                        db.execSQL(stmt)
                    }
        }
    }
}
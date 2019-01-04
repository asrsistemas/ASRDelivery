package asrdelivery.com.br.asrdelivery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BDSQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Base";
    private static final String TABELA_CARDAPIO = "produto";
    private static final String ID = "id";
    private static final String DESCRICAO = "descricao";
    private static final String INGREDIENTES = "ingredientes";
    private static final String PRECO = "preco";
    private static  final  String[] COLUNAS = {
            ID, DESCRICAO, INGREDIENTES, PRECO
    };

    public BDSQLiteHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE cardapio ("+
                "id           INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "descricao    TEXT,"+
                "ingredientes TEXT,"+
                "preco        INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS cardapio");
        this.onCreate(db);
    }

    public void addProduto(Produto produto){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DESCRICAO,produto.getDescricao());
        values.put(INGREDIENTES,produto.getIngredientes());
        values.put(PRECO, new Integer(produto.getPreco()));

        db.insert(TABELA_CARDAPIO,null,values);
        db.close();
    }
    public Produto getProduto(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABELA_CARDAPIO,
                COLUNAS,
                "id = ?",
                new String[]{
                        String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor == null){
            return null;
        }
        else{
            cursor.moveToFirst();
            Produto produto = cursorToProduto(cursor);
            return produto;
        }
    }
    private Produto cursorToProduto(Cursor cursor){
        Produto produto = new Produto();
        produto.setId(Integer.parseInt(cursor.getString(0)));
        produto.setDescricao(cursor.getString(1));
        produto.setIngredientes(cursor.getString(2));
        produto.setPreco(Integer.parseInt(cursor.getString(3)));
        return produto;
    }
    //lista todos os produtos da base
    public ArrayList<Produto> getAllProdutos(){
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

        String query = "SELECT * FROM " + TABELA_CARDAPIO;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                Produto produto = cursorToProduto(cursor);
                listaProdutos.add(produto);
            }while (cursor.moveToNext());
        }
        return listaProdutos;
    }
    public int updateProduto(Produto produto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put(DESCRICAO, produto.getDescricao());
        values.put(INGREDIENTES, produto.getIngredientes());
        values.put(PRECO, new Integer(produto.getPreco()));

        int i = db.update(TABELA_CARDAPIO, //tabela
                values, //valores
                ID+" = ?", //colunas para comparar
                new String[]{
                        String.valueOf(produto.getId()) //parametros
                });
        db.close();
        return i;//numero de linhas modificadas
    }
    public int deleteProduto(Produto produto){
        SQLiteDatabase db = this.getWritableDatabase();

        int i = db.delete(TABELA_CARDAPIO, //tabela
                ID+" = ?", //colunas para comparar
                new String[]{
                        String.valueOf(produto.getId())
                });
        db.close();
        return i; //numero de linhas excluidas
    }
}

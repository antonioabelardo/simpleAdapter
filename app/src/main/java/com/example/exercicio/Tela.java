package com.example.exercicio;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tela extends AppCompatActivity {

    EditText txtCliente;
    EditText txtData;
    EditText txtProduto;
    EditText txtValor;
    public long id = 0;
    public List<Produto> lista = new ArrayList<>();
    public ListView minhaLista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela);
    }

    public void adicionar(View view) {

        id++;
        //ENTRADA DE DADOS
        //Captura o componente EditText da VIEW
        txtCliente = findViewById(R.id.txtCliente);
        txtData = findViewById(R.id.txtData);
        txtProduto= findViewById(R.id.txtProduto);
        txtValor = findViewById(R.id.txtValor);

        String cliente, data, produto;

        cliente = txtCliente.getText().toString();
        data = txtData.getText().toString();
        produto = txtProduto.getText().toString();
        BigDecimal valor = new BigDecimal(txtValor.getText().toString());

        Produto produto1 = new Produto(id, cliente, data, produto, valor);

        lista.add(produto1);

        //PROCESSAMENTO
        //Convertendo a lista em um List<HashMap<String,String>
        //para o simpleAdapter

        List<String> colecaoArrayAdapter = new ArrayList<>();

        List<HashMap<String, String>> colecao = new ArrayList<>();
        //criando colecao para o adapter
        for (Produto p : lista) {
            HashMap<String, String> map = new HashMap<>();
            map.put("id", p.getId()+" ");
            map.put("cliente", p.getCliente());
            map.put("produto", p.getProduto());
            map.put("data", p.getData());
            map.put("valor",p.getValor().toString());

            colecao.add(map);
            colecaoArrayAdapter.add(p.getCliente());
        }

        //Fazer o mapeamento da colecao com o layout do item
        String[] de = {"id","cliente", "data", "produto", "valor"};
        int[] para = {R.id.txtItemId, R.id.txtItemCliente, R.id.txtItemData, R.id.txtItemProduto, R.id.txtItemValor};

        //SAIDA
        minhaLista = findViewById(R.id.minhaLista);

        //SIMPLE ADAPTER
        SimpleAdapter adapter =
                new SimpleAdapter(this,colecao,
                        R.layout.item,de,para);
        minhaLista.setAdapter(adapter);

        Toast toast = Toast.makeText(getApplicationContext(), "Pedido "+ id + " inserido!",Toast.LENGTH_SHORT);
        toast.show();
    }
}

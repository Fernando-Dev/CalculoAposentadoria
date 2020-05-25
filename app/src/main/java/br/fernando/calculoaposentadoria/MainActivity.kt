package br.fernando.calculoaposentadoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //acessando o spinner
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)

        //acessando a caixa de texto de idade
        val txt_idade = findViewById<TextView>(R.id.txt_idade)

        //acessando o botao
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)

        //acessando o texto de resultado
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        // criando as opcoes do spinner
        spn_sexo.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Feminino", "Masculino")
        )

        btn_calcular.setOnClickListener {

            //capturando a opcao selecionada no spinner
            val sexo = spn_sexo.selectedItem as String

            //capturando a idade digitada
            val idade = txt_idade.text.toString().toInt()

            //variavel responsael por guardar o resultado do calculo
            var resultado = 0

            //verificando o sexo da pessoa
            if (sexo.compareTo("Masculino") == 0) {
                resultado = 65- idade
            }else{
                resultado = 60 - idade
            }

            //atualiando a tela de acordo com o resultado do calculo
            txt_resultado.text = "Faltam $resultado anos para você se aposentar."

        }


    }
}

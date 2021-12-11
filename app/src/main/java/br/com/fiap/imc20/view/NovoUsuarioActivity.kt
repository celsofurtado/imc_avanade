package br.com.fiap.imc20.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.imc20.R
import br.com.fiap.imc20.databinding.ActivityNovoUsuarioBinding
import br.com.fiap.imc20.viewmodel.NovoUsuarioViewModel

class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var binding: ActivityNovoUsuarioBinding
    lateinit var mViewModel: NovoUsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNovoUsuarioBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        mViewModel = ViewModelProvider.NewInstanceFactory().create(NovoUsuarioViewModel::class.java)

        // Observer
        mViewModel.pesoString.observe(this, { novoValor: String ->
            binding.novoUsuarioPesoKg.text = novoValor
        })

        // Listener do Slider
        binding.novoUsuarioSliderPeso.addOnChangeListener { slider, value, fromUser ->
            mViewModel.peso.value = value.toInt()
            mViewModel.exibePeso()
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_novo_usuario, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        gravar()

        return true
    }

    private fun gravar() {
        // Abrir um arquivo para gravar
        // Se não existir o arquivo vai ser criado
        val dados = getSharedPreferences("usuario", MODE_PRIVATE)

        // Para alterar o conteúdo, precisamos criar um editor
        val editor = dados.edit()

        editor.putString("email", binding.novoUsuarioEditTextEmail.text.toString())
        editor.putString("senha", binding.novoUsuarioEditTextPassword.text.toString())
        editor.putFloat("altura", binding.novoUsuarioEditTextAltura.text.toString().toFloat())
        editor.commit()

    }
}